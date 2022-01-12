# TP de Programmation orientée objet
LA2 - Quentin Delmarre
___

Il s'agit du dépôt Git contenant le code réalisé lors des TPs de POO.

___
## Historique des bugs rencontrés

> L'incrémentation de l'id se fait bien mais la ligne n'est pas ajouté à la database

Solution :
- Ne plus faire plusieurs appels à EntityManager.getSession(), cela engendre plusieurs connexions ne permettant ainsi pas le flush de l'opération précédente. Dans ce but, mise en place d'un Singleton sur la session.