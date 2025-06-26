package infra.repository;

import infra.model.Logiciel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogicielRepository extends JpaRepository<Logiciel,Long> {
}
