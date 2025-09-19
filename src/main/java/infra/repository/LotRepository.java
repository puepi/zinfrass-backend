package infra.repository;

import infra.model.Fournisseur;
import infra.model.Lot;
import infra.model.TypeEquipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface LotRepository extends JpaRepository<Lot,Long> {
    List<Lot> findByProviderAndTypeEquipementAndMarqueAndDateLivraison(Fournisseur provider, TypeEquipement typeEquipement, String marque, LocalDate dateLivraison);
}
