# Branche : Utilisation de RESTful API

Cette branche se concentre sur l'implémentation d'APIs RESTful. Les services RESTful exploitent les méthodes HTTP (GET, POST, PUT, DELETE) pour effectuer des opérations sur des ressources. Les données échangées sont souvent au format JSON, ce qui permet de garantir une plus grande légèreté et une meilleure performance, en particulier pour les applications modernes.

## Fonctionnalités principales des APIs RESTful :

### 1. Gestion des missions (GestionMission)
Le service **GestionMission** expose des endpoints REST pour la gestion des missions. Les principales opérations sont :
- **GET** `/mission` : Récupérer toutes les missions.
- **GET** `/mission/{id}` : Récupérer un mission.
- **POST** `/mission/add` : Créer une nouvelle mission.
- **PUT** `/mission/{id}/valide ou refuse ou setAvis` : Mettre à jour une mission existante.
- **DELETE** `/mission/{id}` : Supprimer une mission.

Chaque mission est représentée par un objet JSON, qui contient des informations sur la mission, telles que le state, le id, le demandeur, et la score, le commentaire.

### 2. Gestion des personnes (GestionPersonne)
Le service **GestionPersonne** expose des endpoints REST pour la gestion des utilisateurs. Les principales opérations sont :
- **GET** `/personne` : Récupérer toutes les personnes inscrites.
- **GET** `/personne/{id}` : Récupérer un personne.
- **POST** `/personne/demandeur ou Valideur ou benevole` : Ajouter une nouvelle personne (demandeur, bénévole, validateur).
- **DELETE** `/personne/{id}` : Supprimer une personne de la base de données.

Les utilisateurs sont également représentés par des objets JSON, comprenant des informations telles que l'identifiant, le nom, prenom,et d'age.
