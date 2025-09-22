describe zinfrass.poste;
ALTER TABLE zinfrass.poste
MODIFY COLUMN rang ENUM(
    'CHEF_BUREAU',
    'CHEF_SERVICE',
    'CHEF_SERVICE_ADJOINT',
    'DIRECTEUR',
    'DIRECTEUR_ADJOINT',
    'INSPECTEUR_GENERAL',
    'MINISTRE',
    'SECRETAIRE_GENERAL',
    'SECRETAIRE_GENERAL_ADJOINT',
    'SOUS_DIRECTEUR',
    'NA'
);

git rebase -i <numéro du log>~1
