# microservice
# Ce Branch main aperçu du Serveur de Configuration Principal (Config Server)

Dans ce branch, nous avons utilisé **Spring Cloud Config Server** pour gérer de manière centralisée les configurations de tous les microservices. Le Config Server, en tant que service indépendant, est responsable de lire les informations de configuration de chaque microservice depuis un dépôt central et de les distribuer dynamiquement aux microservices. Cela permet d'assurer la cohérence des configurations entre les microservices, tout en permettant des mises à jour sans redémarrage des services.

## Fonctionnalités principales :
- **Gestion centralisée des configurations** : Tous les fichiers de configuration des microservices sont stockés dans le Config Server, garantissant leur cohérence et leur maintenabilité.
- **Mise à jour dynamique des configurations** : Lorsqu'un fichier de configuration est modifié, les microservices peuvent obtenir instantanément la nouvelle configuration sans nécessiter un redémarrage des services.
- **Prise en charge de configurations pour plusieurs environnements** : Le serveur de configuration permet de gérer des configurations spécifiques à différents environnements (par exemple, développement, production, test).

## Structure des fichiers de configuration

Tous les fichiers de configuration sont stockés dans le répositoir
