package infra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateReception;
    private String  observations;
    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private Technicien technicien;
    @ManyToOne
    @JoinColumn(name = "lot_id")
    private Lot lot;
}
