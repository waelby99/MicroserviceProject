const express = require('express');
const db = require('../config/db');
const User = require('../models/User');
const Sequelize = require('sequelize');
const Op = Sequelize.Op;
const bcrypt = require('bcrypt');
const { randomString } = require("../utils/random");


const getAllUsers = async (req , res) =>{

    try {
    const users = await User.findAll()

    if(!users.length){
      return res.status(400).json({ error: 'there is no DATA' });
    }

    res.status(200).json(users);

  } catch (error){
    console.error("there is an error while getting data", error);
    res.status(400).json({ error: error.message });
  }

  }

const getUserById = async (req, res) => {
  try {
    const user = await User.findByPk(req.params.id);
    if (!user) {
      return res.status(404).json({ message: 'Utilisateur non trouvé' });
    }
    res.json(user);
  } catch (err) {
    console.error(err);
    res.status(500).json({ message: "Erreur lors de la récupération de l'utilisateur" });
  }
};



const updateProfile = async (req, res) => {
  try {
    const {username, email,phone,cin } = req.body;
    const {userId} = req.params;

    const [updatedRowCount, updatedUsers] = await User.update(
      { username, email,phone,cin },
      {
        where: { id: userId },
        returning: true, 
      }
    );

    if (updatedRowCount === 0) {
      return res.status(404).json({ message: "Utilisateur non trouvé" });
    }
    const updatedUser = updatedUsers[0]; 
    res.status(200).json(updatedUser);
  } catch (error) {
    console.error(error);
    res.status(500).json({ message: "Erreur lors de la mise à jour de l'utilisateur" });
  }
};


const changePassword = async (req, res) => {
  const { userId, oldPassword, newPassword } = req.body;
  try {
    const user = await User.findByPk(userId);
    if (!user) {
      return res.status(404).json({ message: 'Utilisateur non trouvé' });
    }
    const match = await bcrypt.compare(oldPassword, user.password);
    if (!match) {
      return res.status(401).json({ message: 'L\'ancien mot de passe est incorrect' });
    }
    user.password = await bcrypt.hash(newPassword, 10);
    await user.save(); 

    res.status(200).json({ message: 'Mot de passe mis à jour avec succès' });
  } catch (err) {
    console.error(err);
    res.status(500).json({ message: 'Erreur lors de la mise à jour du mot de passe' });
  }
};


const createUser = async (req, res) => {
  const { username, phone , cin, email, password,role } = req.body;
  if (!username || !cin || !email || !password) {
    return res.status(400).json({ message: "Tous les champs sont requis" });
  }

  try {
    const foundUser = await User.findOne({ where: { email } });
    if (foundUser) {
      return res.status(401).json({ message: "L'email de l'utilisateur existe déjà" });
    }
    const hashedPassword = await bcrypt.hash(password, 10);
    const codeVerification = randomString(20);
    const user = await User.create({
      username,
      cin,
      phone,
      email,
      password: hashedPassword,
      role,
      verificationCode: codeVerification,
    });

    const link = `http://localhost:5000/auth/verify?code=${codeVerification}`;
    res.status(201).json(user);
  } catch (err) {
    console.error(err);
    res.status(400).json({
      message: err.message || "Une erreur s'est produite lors de la création de l'utilisateur",
    });
  }
};

const deleteUser = async (req, res) => {
  try {
    const userId = req.params.id;
    const deleted = await User.destroy({ where: { id: userId } });

    if (!deleted) {
      return res.status(404).json({ message: "Utilisateur non trouvé" });
    }

    res.json({ message: 'Utilisateur supprimé' });
  } catch (err) {
    console.error(err);
    res.status(500).json({ message: "Impossible de supprimer l'utilisateur avec l'id=" + req.params.id });
  }
};

const getUserByRole = async (req, res) => {
  try {
    const { role } = req.params;
    const users = await User.findAll({ where: { role } });

    if (users.length === 0) {
      return res.status(404).json({ message: "Aucun utilisateur trouvé pour ce rôle" });
    }
    res.status(200).json(users);
  } catch (err) {
    console.error(err);
    res.status(500).json({ message: "Erreur lors de la récupération des utilisateurs par rôle" });
  }
};

const getUsersByIds = async (req, res) => {
  try {
    const userIds = req.params.ids.split(',');
    const users = await User.findAll({
      where: {
        id: userIds
      }
    });

    if (users.length === 0) {
      return res.status(404).json({ message: 'Aucun utilisateur trouvé' });
    }

    res.json(users);
  } catch (error) {
    console.error(error);
    res.status(500).json({ message: 'Erreur lors de la récupération des utilisateurs' });
  }
};

const getUserCount = async (req, res) => {
  try {
    const count = await User.count();
    res.json({ count });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

const getRoleDistribution = async (req, res) => {
  try {
    const roles = await User.findAll({
      attributes: [
        'role', 
        [Sequelize.fn('COUNT', Sequelize.col('role')), 'count'] 
      ],
      group: ['role'], 
    });
    res.json(roles);
  } catch (error) {
    console.error('Error fetching user roles:', error);
    res.status(500).send('Internal Server Error');
  }
};
const getRegistrationStats = async (req, res) => {
  try {
    const stats = await User.findAll({
      attributes: [
        
        [Sequelize.fn('TO_CHAR', Sequelize.col('createdAt'), 'YYYY-MM'), 'month'], 
        [Sequelize.fn('COUNT', Sequelize.col('id')), 'count'] 
      ],
      group: [Sequelize.fn('TO_CHAR', Sequelize.col('createdAt'), 'YYYY-MM')], 
      order: [[Sequelize.fn('TO_CHAR', Sequelize.col('createdAt'), 'YYYY-MM'), 'ASC']] 
    });
    res.json(stats);
  } catch (error) {
    console.error('Error fetching registration stats:', error);
    res.status(500).send('Internal Server Error');
  }
};


  module.exports ={
  getAllUsers,
  updateProfile,
  getUserById,
  changePassword,
  createUser,
  deleteUser,
  getUserByRole,
  getUsersByIds,
  getUserCount,
  getRoleDistribution,
  getRegistrationStats
  }