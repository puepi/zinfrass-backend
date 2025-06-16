package infra.dto.response;

import infra.model.Categorie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeEquipementResponseDto {
    private Long id;
    private String nom;
    private String caracteristiques;
    private String categorieNom;
    private List<String> nrosLot;
}
