package lt.projectx.baigiamaskorekcijos.repository;

import lt.projectx.baigiamaskorekcijos.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    List<Institution> findByCountryId(Long countryId);

}
