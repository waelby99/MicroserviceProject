# Station Ski - Application Microservices

## Description
Ce projet est une application de gestion pour une station de ski. Elle repose sur une architecture microservices permettant une meilleure modularité et une évolutivité accrue. Chaque microservice gère une entité spécifique (Pistes, Équipements, Cours, Réclamations, Abonnements, et Utilisateurs), tandis qu'un frontend en Angular regroupe et présente ces données aux utilisateurs.

---

## Fonctionnalités
- **Gestion des pistes** : Ajouter, modifier, afficher et supprimer des pistes.
- **Gestion des équipements** : Gérer les équipements de ski et snowboard.
- **Gestion des cours** : Planifier et gérer les cours collectifs ou particuliers.
- **Gestion des réclamations** : Centraliser les réclamations des utilisateurs.
- **Gestion des abonnements** : Configurer et gérer différents types d'abonnements.
- **Gestion des utilisateurs** : Créer et gérer les utilisateurs via MSCommon.

---

## Architecture

### Technologies utilisées
- **Backend :**
  - Spring Boot (Microservices principaux)
  - Node.js (Microservice commun `MSCommon`)
- **Frontend :**
  - Angular
- **Base de données :**
  - MySQL (Pistes, Réclamations, Abonnements, Équipements)
  - PostgreSQL (Utilisateurs)
  - H2 (Pistes et Cours en mode embarqué pour tests)
- **Découverte de services :** Eureka Server
- **API Gateway :** Spring Cloud Gateway
- **Authentification :** Keycloak
- **Conteneurisation :** Docker et Docker Compose

---

## Diagramme UML

![Diagramme UML](./image.png)

---

## Prérequis

### Outils nécessaires :
- Docker et Docker Compose
- JDK 17+
- Node.js et npm
- Angular CLI

---

## Structure des Microservices

| Microservice               | Responsable | Langage/Framework | Base de données | Port  |
|----------------------------|-------------|-------------------|-----------------|-------|
| **Pistes**                 | Wael        | Spring Boot       | H2              | 8075  |
| **Équipements**            | Teymour     | Spring Boot       | MySQL           | 8074  |
| **Cours**                  | Yasmine     | Spring Boot       | H2              | 8077  |
| **Réclamations**           | Haithem     | Spring Boot       | MySQL           | 8076  |
| **Abonnements**            | Sarra       | Spring Boot       | MySQL           | 8082  |
| **Utilisateurs (MSCommon)**| Équipe      | Node.js           | PostgreSQL      | 5000  |
| **Frontend**               | Équipe      | Angular           | -               | 4200  |
| **API Gateway**            | Équipe      | Spring Boot       | -               | 8090  |




