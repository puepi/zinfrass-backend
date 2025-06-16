package infra.dto.request;

import infra.model.Categorie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeEquipementRequestDto {
    private String nom;
    private String caracteristiques;
    private Long categoryId;
}
