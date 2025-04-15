package lt.projectx.baigiamaskorekcijos.service;

import lt.projectx.baigiamaskorekcijos.converter.CorrectionCoverter;
import lt.projectx.baigiamaskorekcijos.dto.CorrectionDto;
import lt.projectx.baigiamaskorekcijos.entity.Correction;
import lt.projectx.baigiamaskorekcijos.entity.Institution;
import lt.projectx.baigiamaskorekcijos.repository.CorrectionRepository;
import lt.projectx.baigiamaskorekcijos.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .map(CorrectionCoverter::toDto)
                .toList();
    }

    public CorrectionDto getCorrectionById(Long id) {
        Optional<Correction> correction = correctionRepository.findById(id);
        return correction.map(CorrectionCoverter::toDto).orElse(null);
    }

    public CorrectionDto createCorrection(CorrectionDto correctionDto) {
        Institution institution = institutionRepository.findById(correctionDto.getInstitutionId())
                .orElseThrow(() -> new RuntimeException("Institution not found"));
        Correction correction = CorrectionCoverter.toEntity(correctionDto, institution);
        return CorrectionCoverter.toDto(correctionRepository.save(correction));
    }

    public CorrectionDto updateCorrectionById(Long id, CorrectionDto correctionDto) {
        Optional<Correction> correctionOpt = correctionRepository.findById(id);
        if (correctionOpt.isEmpty()) return null;
        Correction correction = correctionOpt.get();
        correction.setType(correctionDto.getType());
        correction.setAction(correctionDto.getAction());
        correction.setCoordinations(correctionDto.getCoordinations());
        correction.setExpiration(correctionDto.getExpiration());
        correction.setUpdated(correctionDto.getUpdated());
        Institution institution = institutionRepository.findById(correctionDto.getInstitutionId())
                .orElseThrow(() -> new RuntimeException("Institution not found"));
        correction.setInstitution(institution);
        return CorrectionCoverter.toDto(correctionRepository.save(correction));
    }

    public boolean deleteCorrectionById(Long id) {
        if (correctionRepository.existsById(id)) {
            correctionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
