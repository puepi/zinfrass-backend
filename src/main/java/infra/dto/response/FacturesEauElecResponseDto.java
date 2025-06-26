package infra.dto.response;

import infra.enums.TypeFacture;
import infra.model.Batiment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturesEauElecResponseDto {
    private Long id;
    private TypeFacture type;
    private String numeroFacture;
    private String numéroCompteur;
    private LocalDate debut;
    private LocalDate fin;
    private BigDecimal consommation;
    private BigDecimal montant;
    private Long ancienIndex;
    private Long nouvelIndex;
    private String unites;
    private String batimentName;
    private String subdivisionName;
}
