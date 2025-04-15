package lt.projectx.baigiamaskorekcijos.service;

import lt.projectx.baigiamaskorekcijos.converter.InstitutionCoverter;
import lt.projectx.baigiamaskorekcijos.dto.InstitutionDto;
import lt.projectx.baigiamaskorekcijos.entity.Country;
import lt.projectx.baigiamaskorekcijos.entity.Institution;
import lt.projectx.baigiamaskorekcijos.repository.CountryRepository;
import lt.projectx.baigiamaskorekcijos.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitutionService {
    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private CountryRepository countryRepository;

    public List<InstitutionDto> getAllInstitutions() {
        return institutionRepository.findAll().stream()
                .map(InstitutionCoverter::toDto)
                .toList();
    }

    public InstitutionDto getInstitutionById(Long id) {
        Optional<Institution> institution = institutionRepository.findById(id);
        return institution.map(InstitutionCoverter::toDto).orElse(null);
    }

    public InstitutionDto createInstitution(InstitutionDto institutionDto) {
        Country country = countryRepository.findById(institutionDto.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));
        Institution institution = InstitutionCoverter.toEntity(institutionDto, country);
        return InstitutionCoverter.toDto(institutionRepository.save(institution));
    }

    public InstitutionDto updateInstitution(Long id, InstitutionDto institutionDto) {
        Optional<Institution> institutionOpt = institutionRepository.findById(id);
        if (institutionOpt.isEmpty()) return null;
        Institution institution = institutionOpt.get();
        institution.setName(institutionDto.getName());
        institution.setEmail(institutionDto.getEmail());
        institution.setWebsite(institutionDto.getWebsite());
        Country country = countryRepository.findById(institutionDto.getCountryId())
                .orElseThrow(() -> new RuntimeException("Country not found"));
        institution.setCountry(country);
        return InstitutionCoverter.toDto(institutionRepository.save(institution));
    }

    public boolean deleteInstitution(Long id) {
        if (institutionRepository.existsById(id)) {
            institutionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
