package lt.projectx.baigiamaskorekcijos.repository;

import lt.projectx.baigiamaskorekcijos.entity.Correction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CorrectionRepository extends JpaRepository<Correction, Long> {
    List<Correction> findByType(String type);
    List<Correction> findByExpirationBefore(LocalDateTime date);
    List<Correction> findByTypeAndExpirationBefore(String type, LocalDateTime dateTime);
}
