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
show create table zinfrass.equipement ;

ALTER TABLE equipement
DROP FOREIGN KEY FKdiflj9h91vdevrq5g0ei7a4nw;

ALTER TABLE equipement
ADD CONSTRAINT FK_equipement_lot
FOREIGN KEY (lot_id) REFERENCES lot(id)
ON DELETE CASCADE;

alter table zinfrass.poste drop constraint poste_chk_1;

alter table zinfrass.responsabilisation alter column noms_prenoms set default 'Poste vacant' ;