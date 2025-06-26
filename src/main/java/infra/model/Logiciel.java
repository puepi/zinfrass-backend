package infra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import infra.enums.TypeLicence;
import infra.enums.TypeLogiciel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Logiciel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeLogiciel typeLogiciel;
    private String nom;
    private String version;
    private String licence;
    @Enumerated(EnumType.STRING)
    private TypeLicence typeLicence;
    private LocalDate expiration;

    @JsonIgnore
    @OneToMany(mappedBy = "logiciel", fetch = FetchType.LAZY)
    private Set<InstallationLogicielle> installations = new HashSet<>();

}
