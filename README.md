# Branche : FeedbackMS (Feedback Management Service)

Cette branche est dédiée à la gestion des feedbacks et des évaluations dans le système. Il permet de soumettre des évaluations, de récupérer les évaluations existantes et de gérer les commentaires associés aux missions.

- **put** `/feedback/valide/{id}` : valider une mission
- **put** `/feedback/refuse/{id}/{commentaire}` : refuser une mission en rajoutant le commentaire
- **put** `/feedback/setAvis/{id}/{avis}` : donnez une avis pour une mission
- **get** `/feedback/{id}` : obtenir tous les feedback


