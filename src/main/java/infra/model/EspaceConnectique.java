package infra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EspaceConnectique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int qte;
    private String decrire_position;

    @ManyToOne
    @JoinColumn(name = "connectique_id")
    private Connectique connectique;

    @ManyToOne
    @JoinColumn(name = "espace_id")
    private Espace espace;
}
