package lt.projectx.baigiamaskorekcijos.service;

import jakarta.persistence.EntityNotFoundException;
import lt.projectx.baigiamaskorekcijos.converter.CorrectionConverter;
import lt.projectx.baigiamaskorekcijos.dto.CorrectionDto;
import lt.projectx.baigiamaskorekcijos.entity.Correction;
import lt.projectx.baigiamaskorekcijos.entity.Institution;
import lt.projectx.baigiamaskorekcijos.repository.CorrectionRepository;
import lt.projectx.baigiamaskorekcijos.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CorrectionService {
    @Autowired
    private CorrectionRepository correctionRepository;

    @Autowired
    private InstitutionRepository institutionRepository;

    public List<CorrectionDto> getAllCorrections() {
        return correctionRepository.findAll().stream()
                .map(CorrectionConverter::toDto)
                .toList();
    }

    public CorrectionDto getCorrectionById(Long id) {
        Correction correction = correctionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Correction not found with id: " + id));
        return CorrectionConverter.toDto(correction);
    }

    public List<CorrectionDto> getCorrectionsByType(String type) {
        return correctionRepository.findByType(type).stream()
                .map(CorrectionConverter::toDto)
                .toList();
    }

    public List<CorrectionDto> getCorrectionsExpiringBefore(LocalDateTime date) {
        return correctionRepository.findByExpirationBefore(date).stream()
                .map(CorrectionConverter::toDto)
                .toList();
    }

    public List<CorrectionDto> getCorrectionsByTypeAndExpirationBefore(String type, LocalDateTime expirationBefore) {
        return correctionRepository.findByTypeAndExpirationBefore(type, expirationBefore).stream()
                .map(CorrectionConverter::toDto)
                .toList();
    }

    public List<CorrectionDto> getCorrectionsByCountryId(Long countryId) {
        return correctionRepository.findByInstitution_Country_Id(countryId).stream()
                .map(CorrectionConverter::toDto)
                .toList();
    }

    public CorrectionDto createCorrection(CorrectionDto correctionDto) {
        Institution institution = institutionRepository.findById(correctionDto.getInstitutionId())
                .orElseThrow(() -> new RuntimeException("Institution not found"));
        Correction correction = CorrectionConverter.toEntity(correctionDto, institution);
        return CorrectionConverter.toDto(correctionRepository.save(correction));
    }

    public CorrectionDto updateCorrectionById(Long id, CorrectionDto correctionDto) {
        Correction correction = correctionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Correction with ID " + id + " not found"));

        correction.setType(correctionDto.getType());
        correction.setAction(correctionDto.getAction());
        correction.setCoordinations(correctionDto.getCoordinations());
        correction.setExpiration(correctionDto.getExpiration());
        correction.setUpdatedAt(LocalDateTime.now());

        Institution institution = institutionRepository.findById(correctionDto.getInstitutionId())
                .orElseThrow(() -> new EntityNotFoundException("Institution with ID " + correctionDto.getInstitutionId() + " not found"));
        correction.setInstitution(institution);

        return CorrectionConverter.toDto(correctionRepository.save(correction));
    }


    public boolean deleteCorrectionById(Long id) {
        if (correctionRepository.existsById(id)) {
            correctionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
