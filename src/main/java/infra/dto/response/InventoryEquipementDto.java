package infra.dto.response;

import infra.model.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryEquipementDto {
    private Long id;
    private String numeroSerie;
    private String numeroUnique;
    private String nroLot;
    private String currentPosition;
    private String lieu;
    private Long lastLotId;
    private String caracteristiques;
    private String marque;
    private String modele;
    private String typeEquipement;
    private String couleur;
    private LocalDate dateReception;
    private String etatObjet;

//    private String etat_recent;
    private List<IncidentResponseDto> incidents=new ArrayList<>();
    private List<InterventionResponseDto> interventions=new ArrayList<>();
    private Set<Image> photos=new HashSet<>();
}
