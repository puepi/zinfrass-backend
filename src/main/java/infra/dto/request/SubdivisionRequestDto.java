package infra.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubdivisionRequestDto {
    private String nom;
    private String type;
    private Long parentId;
}
