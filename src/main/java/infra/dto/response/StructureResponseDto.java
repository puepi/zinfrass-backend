package infra.dto.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import infra.enums.TypeStructure;
import infra.model.Structure;
import infra.model.Subdivision;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StructureResponseDto {
    private Long id;
    private String nom;
    private String abreviation;
    private String type;
    private SubdivisionResponseDto subdivision;
    private Set<String> structures=new HashSet<>();
    private String parent;
}
