package infra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String fileType;
    private LocalDateTime datePrise;

    @Lob
    private Blob image;
    private String downloadUrl;
    @OneToOne
    private FacturesEauElec facture;

    @ManyToOne
    @JoinColumn(name="lot_id")
    private Lot lot;

    @ManyToOne
    @JoinColumn(name="espace_id")
    private Espace espace;

    @ManyToOne
    @JoinColumn(name="incident_id")
    private Incident incident;
}
