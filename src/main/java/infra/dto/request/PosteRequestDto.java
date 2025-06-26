package infra.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosteRequestDto {
    private String nom;
    private String abreviation;
    private String rang;
}
