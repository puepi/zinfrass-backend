package infra.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosteResponseDto {
    private Long id;
    private String nom;
    private String abreviation;
    private String rang;
    private List<String> occupants=new ArrayList<>();
}
