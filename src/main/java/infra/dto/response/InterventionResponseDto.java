package infra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterventionResponseDto {
    private Long id;
    private String nature;
    private String raison;
    private String nomsIntervenant;
    private LocalDate dateIntervention;
    private String poste;
    private String service;
    private String objet;
    private String identifiant;
    private String observations;
    private String lieu;
    private String diagnostic;
    private String solution;
    private String etat_objet;
    private String position_equipement;
    private String ref_autorisation;
    private String poste_affecte;
    private String structure_affecte;
    private String personne_affecte;
    private String nroIncident;
    private boolean resolu;

    public InterventionResponseDto(Long id, LocalDate dateIntervention, String objet, String etatObjet, String positionEquipement) {
        this.id=id;
        this.dateIntervention=dateIntervention;
        this.objet=objet;
        this.etat_objet=etatObjet;
        this.position_equipement=positionEquipement;
    }
}
