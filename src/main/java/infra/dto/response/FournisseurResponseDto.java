package infra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FournisseurResponseDto {
    private Long id;
    private String nom;
    private String representant;
    private String type;
    private String adresse;
    private String contact;
    private String email;
    private String NIU;
    private Set<String> typesEquipement=new HashSet<>();
}
