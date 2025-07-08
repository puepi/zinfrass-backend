package infra.repository;

import infra.dto.request.BatimentResponseDto;
import infra.model.Batiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BatimentRepository extends JpaRepository<Batiment,Long> {
    List<Batiment> findBySubdivisionId(Long id);
}
