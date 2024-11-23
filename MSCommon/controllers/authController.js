const User = require("../models/User");
require('dotenv').config();
const axios = require('axios'); // Ajoutez cette ligne pour importer axios
const bcrypt = require('bcrypt'); // Assurez-vous d'utiliser bcrypt pou
const jwt = require("jsonwebtoken");
const { randomString } = require("../utils/random");

const { getKeycloakToken, verifyJwtToken } = require("../middelwares/keycloakAdapter"); 

  const login = async (req, res) => {
    const { email, password } = req.body;
    if (!email || !password) {
        return res.status(400).json({ message: "All fields are required" });
    }
    try {
        const foundUser = await User.findOne({ where: { email: email } });
        if (!foundUser) {
            return res.status(401).json({ message: "User does not exist" });
        }
        const matchPassword = await bcrypt.compare(password, foundUser.password);
        if (!matchPassword) {
            return res.status(401).json({ message: "Wrong Password" });
        }
        const keycloakToken = await getKeycloakToken(email,password);
        const response ={
          accessToken: keycloakToken, 
          email: foundUser.email,
          id :foundUser.id,
          role:foundUser.role
        }
        res.status(200).json(response);
    } catch (error) {
        console.error("Login error:", error);
        res.status(500).json({ message: "Internal server error : Login Error" });
    }
};
  
const refresh = (req, res) => {
    const cookies = req.cookies;
    if (!cookies || !cookies.jwt) {
      return res.status(401).json({ message: "Unauthorized" });
    }
    const refreshToken = cookies.jwt;
    jwt.verify(
      refreshToken,
      process.env.REFRESH_TOKEN_SECRET,
      async (err, decoded) => {
        if (err) {
          return res.status(403).json({ message: "Forbidden" });
        }
        try {
          const foundUser = await User.findById(decoded.UserInfo.id).exec();
          if (!foundUser) {
            return res.status(401).json({ message: "Unauthorized" });
          }
          const accessToken = jwt.sign(
            {
              UserInfo: {
                id: foundUser.id,
                role : foundUser.role
              },
            },
            process.env.ACCESS_TOKEN_SECRET,
            { expiresIn: "15m" } 
          );
          return res.json({ accessToken });
        } catch (error) {
          console.error("Error fetching user:", error);
          return res.status(500).json({ message: "Internal Server Error" });
        }
      }
    );
  };

  const logout = (req, res) => {
    const cookies = req.cookies;
    if (!cookies?.jwt) return res.sendStatus(204); 
    res.clearCookie("jwt", {
      httpOnly: true,
      sameSite: "None",
      secure: true,
    });
    res.json({ message: "Logged out" });
  };



  module.exports = {
    login,
    refresh,
    logout,
  };