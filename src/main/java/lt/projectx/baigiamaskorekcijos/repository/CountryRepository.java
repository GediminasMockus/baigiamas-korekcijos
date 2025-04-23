package lt.projectx.baigiamaskorekcijos.repository;

import lt.projectx.baigiamaskorekcijos.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
