package lt.projectx.baigiamaskorekcijos.repository;

import lt.projectx.baigiamaskorekcijos.entity.Correction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrectionRepository extends JpaRepository<Correction, Long> {
}
