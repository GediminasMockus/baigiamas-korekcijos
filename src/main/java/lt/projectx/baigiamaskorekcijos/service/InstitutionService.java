package lt.projectx.baigiamaskorekcijos.service;

import jakarta.persistence.EntityNotFoundException;
import lt.projectx.baigiamaskorekcijos.converter.InstitutionConverter;
import lt.projectx.baigiamaskorekcijos.dto.InstitutionDto;
import lt.projectx.baigiamaskorekcijos.entity.Country;
import lt.projectx.baigiamaskorekcijos.entity.Institution;
import lt.projectx.baigiamaskorekcijos.repository.CountryRepository;
import lt.projectx.baigiamaskorekcijos.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private CountryRepository countryRepository;

    public List<InstitutionDto> getAllInstitutions() {
        return institutionRepository.findAll().stream()
                .map(InstitutionConverter::toDto)
                .toList();
    }

    public InstitutionDto getInstitutionById(Long id) {
        Institution institution = institutionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Institution with ID " + id + " not found"));
        return InstitutionConverter.toDto(institution);
    }

    public InstitutionDto createInstitution(InstitutionDto institutionDto) {
        Country country = countryRepository.findById(institutionDto.getCountryId())
                .orElseThrow(() -> new EntityNotFoundException("Country with ID " + institutionDto.getCountryId() + " not found"));
        Institution institution = InstitutionConverter.toEntity(institutionDto, country);
        Institution saved = institutionRepository.save(institution);
        return InstitutionConverter.toDto(saved);
    }

    public InstitutionDto updateInstitution(Long id, InstitutionDto institutionDto) {
        Institution institution = institutionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Institution with ID " + id + " not found"));

        Country country = countryRepository.findById(institutionDto.getCountryId())
                .orElseThrow(() -> new EntityNotFoundException("Country with ID " + institutionDto.getCountryId() + " not found"));

        institution.setName(institutionDto.getName());
        institution.setEmail(institutionDto.getEmail());
        institution.setWebsite(institutionDto.getWebsite());
        institution.setCountry(country);

        return InstitutionConverter.toDto(institutionRepository.save(institution));
    }

    public void deleteInstitution(Long id) {
        if (!institutionRepository.existsById(id)) {
            throw new EntityNotFoundException("Institution with ID " + id + " not found");
        }
        institutionRepository.deleteById(id);
    }

    public List<InstitutionDto> getInstitutionsByCountryId(Long countryId) {
        List<Institution> institutions = institutionRepository.findByCountryId(countryId);
        if (institutions.isEmpty()) {
            throw new EntityNotFoundException("No institutions found for country with ID: " + countryId);
        }
        return institutions.stream().map(InstitutionConverter::toDto).toList();
    }

}
