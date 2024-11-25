# Station Ski - Application Microservices

## Description
Ce projet est une application de gestion pour une station de ski. Elle repose sur une architecture microservices permettant une meilleure modularité et une évolutivité accrue. Chaque microservice gère une entité spécifique (Pistes, Équipements, Cours, Réclamations, Abonnements, et Utilisateurs), tandis qu'un frontend en Angular regroupe et présente ces données aux utilisateurs. **Keycloak** est utilisé pour sécuriser les endpoints et gérer l'authentification et l'autorisation des utilisateurs.

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
- **Authentification et sécurité :** Keycloak
- **Conteneurisation :** Docker et Docker Compose

---

## Sécurisation avec Keycloak

Pour garantir la sécurité, **Keycloak** a été intégré dans le projet pour gérer :
1. **L'authentification** : Les utilisateurs doivent se connecter pour accéder à l'application.
2. **L'autorisation** : Les rôles utilisateur (par exemple : administrateur, client) déterminent les permissions d'accès aux ressources.
3. **Protection des endpoints** : Chaque microservice est sécurisé par des jetons d'accès générés par Keycloak.

Pour tester les fonctionnalités de sécurité, configurez un **realm Keycloak** avec les clients et les rôles nécessaires. Plus d'informations sont disponibles dans la documentation officielle de [Keycloak](https://www.keycloak.org/).

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
| **Pistes**                 | Vous        | Spring Boot       | H2              | 8075  |
| **Équipements**            | Teymour     | Spring Boot       | MySQL           | 8074  |
| **Cours**                  | Yasmine     | Spring Boot       | H2              | 8077  |
| **Réclamations**           | Haithem     | Spring Boot       | MySQL           | 8076  |
| **Abonnements**            | Sarra       | Spring Boot       | MySQL           | 8082  |
| **Utilisateurs (MSCommon)**| Équipe      | Node.js           | PostgreSQL      | 5000  |
| **Frontend**               | Équipe      | Angular           | -               | 4200  |
| **API Gateway**            | Équipe      | Spring Boot       | -               | 8090  |

---

## Installation et exécution

### Étape 1 : Cloner le projet
```bash
git clone https://github.com/waelby99/MicroserviceProject.git
cd station-ski
```
### Étape 2 : Lancer les services avec Docker Compose
```bash
docker-compose up --build
```
### Étape 3 : Configurer Keycloak (vous pouvez me contacter pour plus d'informations)
1. Accéder à l'interface d'administration Keycloak : http://localhost:8080
2. Créer un realm.
3. Ajouter un client pour l'application.
4. Configurer les rôles et les utilisateurs
   
### Étape 4 : Accéder aux services
Frontend Angular : http://localhost:4200
Eureka Server : http://localhost:8761
API Gateway : http://localhost:8090

---
## Fichiers et Dossiers Importants

- **/MicroServiceProject** : Microservice pour la gestion des pistes.
- **/Teymour/MicroServiceteymour** : Microservice pour la gestion des équipements.
- **/Yasmine/MicroServiceProject** : Microservice pour la gestion des cours.
- **/Haithem/MicroServiceProject** : Microservice pour la gestion des réclamations.
- **/Sarra/MicroserviceSubscription** : Microservice pour la gestion des abonnements.
- **/MSCommon** : Microservice commun pour les utilisateurs.
- **/AngularMS** : Application frontend Angular.


