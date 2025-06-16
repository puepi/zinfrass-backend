package infra.repository;

import infra.model.TypeEquipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TypeEquipementRepository extends JpaRepository<TypeEquipement,Long> {
    public String findByCaracteristiques(String car);
}
