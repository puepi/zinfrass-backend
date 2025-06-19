package infra.dto.request;

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
@NoArgsConstructor
@AllArgsConstructor
public class StructureRequestDto {
    private String nom;
    private String abreviation;
    private String type;
    private Long subdivisionId;
    private Long parentId;
}
