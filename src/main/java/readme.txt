présenter le cycle de vie des infrastructures // gestion des infrastructures couplée à l'assistance utilisateur
- commande
- réception
(à la réception, quels sont les critères de recherche d'un lot si le lot existe)
(sinon,afficher le formulaire de création d'un lot)
(simuler la réception d'un lot de véhicules)

[permettre d'ajouter des équipements ou de les modifier même après la réception]
[générer automatiquement les numéros de série si besoin]
[générer automatiquement un identifiant unique pour chaque bâtiment, équipement ou espace]
[[
    EQ-UC-LEN-Think001
    EQ-EC-HP-Pavillon2012
    EQ-OND-APC-Scanovi98-51
    BAT-A-Centraux BAT-B-MFOU
    ESP-BUR-R3
    ESP-TOI-R1
]]
[consulter la liste des équipements affectés à un poste de travail]
[ajouter la situation géographique des structures]
[ajouter un document qui indique ou non une autorisation d'intervention]
[ajouter les caractéristiques propres à un équipement]
[différencier le fait qu'une structure est incluse dans une autre et qu'une
 structure est rattachée à une autre:c'est 2 chose différentes
]
[une structure est répartie sur plusieurs bureaux et un bureau appartient à une structure]
[un bureau abrite plusieurs postes de travail et un poste de travail est logé dans un seul bureau]
[[  -uploader les photos,
    -faire la pagination,
    -terminer le tableau de bord
    -mettre à jour, supprimer
    -comment se fait l'installation de logiciels?
    -aperçu de la fiche d'équipement:catégorie, type d'équipement,
        caractéristiques complètes,poste d'affectation,état,incidents,interventions,
        historique d'attributions
]]
[BUR R5 BAT-A/CENTRAUX][]
[Nke vient de dépanner 3 imprimantes]
[Quand tu finis une intervention, tu mets à jour l'état de l'objet de l'intervention]
[On vient d'installer en urgence un nouvel onduleur dans le bureau du Ministre  ]
[pouvoir afficher en temps réel le stock en magasin ou octroyé]
[on peut installer rapidement un onduleur neuf chez le Ministre]
[Nke a procédé au dépannage de 3 imprimantes ce matin]
[identifier de manière unique un objet tel qu'un bâtiment, un lieu, un équipement, un logicielc avec une nomenclature qui permet d'en reconnaitre le type]
[on voudrait aussi réceptionner les bâtiments avec tous les équipements];
 créer des espaces et affecter des équipements à ces espaces ou
 octroyer des équipements à un poste de travail
]
[   faire un diagramme de classes,
    (structures,postes, responsabilisations,batiments,factures,équipements,
    fournisseur,catégorie,type d'équipement,demandes,espaces,personnel,octroi,affectation
    incident,intervention, connectique
    )
]
[faire un diagramme de cas d'utilisation,]
[faire un diagramme de séquence,]

[token for git pushing on 16th of september 2025: ]
- tests et appréciation + pv
- demandes de matériels
- octroi
- installations + observations
- appréciations par l'utilisateur
- incidents + description de l'incident
- simulation de l'enregistrement d'un incident sur le réseau internet dans un bureau
(quels sont les équipements et les connectiques installés dans bureau: les câbles, les prises)
(disposition des équipements grâce à une photo d'intérieur)
- une connectique est installée dans plusieurs espaces et un espace possède plusieurs types de connectiques
-
(un incident se fait sur un seul équipement)
(un incident se fait sur un seul batiment)
(un technicien fait plusieurs interventions et une intervention est faite par un seul technicien)
(un équipement ou batiment peut faire l'objet de plusieurs interventions) ou incidents
(un personnel peut apprécier l'intervention par un technicien), celà servirait à avoir un retour des utilisateurs;
- interventions + ou simples appréciations de l'état, rapports
- lister les appréciations des utilisateurs selon les interventions
- délais de réponses aux incidents
(simuler la déclaration d'un incident)
(les techniciens la reçoivent)
(les responsables approuvent les interventions des techniciens)
(apprécier le délai de réponse)
- différents états produits
- pouvoir observer la progression de la qualité des équipements livrés au personnel jusque là et leur productivité, d'où les demandes de matériels
- un personnel fait une ou plusieurs demandes
- exemple: le Ministre travaille avec quel équipement? quelle est la dernière intervention faite à son bureau? quels sont les incidents signalés à son poste? quel est le rapport qui en a été fait?
- chaque nouvel équipement doit avoir une fiche descriptive détaillée précisant son utilité et ses caractéristiques.
- sécurité: s'assurer qu'un utilisateur ne peut pas déclarer un incident sur un matériel dont il n'est pas détenteur
            s'assurer qu'un utilisateur authentifié ne peut pas faire une appréciation de l'état du matériel en lieu et place d'un autre
            s'assuer que l'intervention d'un technicien est validée par son supérieur et aussi par un utilisateur
            s'assurer que tout utilisateur peut faire des observations pour son propre compte afin qu'elles soient visibles plus tard par les autres
- quels sont les espaces alloués au Cabinet du Ministre
- le NIU doit avoir 14 chiffres et les numéros de téléphone doivent sae mettre au format 695 12 45 78
- lors d'une action qui a des effets sur la base de données, je dois afficher un popup "Effectué avec succès" ou "Erreur" qui apparait et disparait après 4s
- test logiciels
- déploiement
- extension grâce à un agent intelligent permettant d'aider le technicien à résoudre rapidement les pannes au regard du matériel, des logiciels et de l'historique d'incidents et interventions

---------------------------------------------------------------------------------
https://www.youtube.com/watch?v=29eDuMjsEF8
https://www.youtube.com/watch?v=M9O5AjEFzKw&t=70191s
https://www.youtube.com/watch?v=joHUPyb3ZwY&t=40s
https://www.youtube.com/watch?v=Qyid0FxEn6k
----------------------------------------------------------------
(
  une recherche inclut les ressources suivantes: un type d'équipement, un équipement,
  un bâtiment, un espace, un technicien, un incident, une intervention, une structure,
  un poste de responsabilité

)
- rechercher les types d'équipement d'une catégorie
- rechercher les bâtiments selon la subdivision administrative
- rechercher une subdivision administrative selon le type et selon la subdivision à laquelle est rattachée
- rechercher les équipements d'un certain type dans le stock
- rechercher un équipement octroyé ou en stock
- rechercher les équipements d'une certaine catégorie dans le stock
- rechercher un équipement selon l'espace
- rechercher un équipement selon le détenteur ou le poste de travail
- rechercher un personnel par son nom pour avoir son poste et son service)
- rechercher l'objet d'un incident selon la nature matériel, batiment, espace
- rechercher l'objet d'une intervention selon la nature matériel, batiment, espace
- rechercher un bâtiment selon la subdivision

[
    les différents rôles sont: administrateur, technicien et utilisateur
    USER -> send incidents and give appreciations
    TECH -> update incidents and register interventions
    ADMIN -> manage users, assign technicians, manage equipement
    donner la possibilité au Chef de noter chaque intervention par des observations
    et une couleur satisfait/pas satisfait
    donner la possibilité ç tout le monde de voir les incidents à l'accueil avec des
    couleurs pour classer du plus récent au plus ancien
]
