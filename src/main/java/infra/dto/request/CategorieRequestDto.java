package infra.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.NoRepositoryBean;

@Data
@NoArgsConstructor
public class CategorieRequestDto {
    private String nom;
}
