package infra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubdivisionResponseDto {
    private Long id;
    private String nom;
    private Set<String> subdivisions=new HashSet<>();
    private String parent;
    private String type;
}
