package lt.projectx.baigiamaskorekcijos.converter;

import lt.projectx.baigiamaskorekcijos.dto.CorrectionDto;
import lt.projectx.baigiamaskorekcijos.entity.Correction;
import lt.projectx.baigiamaskorekcijos.entity.Institution;

public class CorrectionConverter {
    public static CorrectionDto toDto(Correction correction) {
        if (correction == null) return null;
        CorrectionDto dto = new CorrectionDto();
        dto.setId(correction.getId());
        dto.setType(correction.getType());
        dto.setAction(correction.getAction());
        dto.setCoordinations(correction.getCoordinations());
        dto.setExpiration(correction.getExpiration());
        dto.setUpdatedAt(correction.getUpdatedAt());
        if (correction.getInstitution() != null)
            dto.setInstitutionId(correction.getInstitution().getId());
        return dto;
    }

    public static Correction toEntity(CorrectionDto dto, Institution institution) {
        if (dto == null) return null;
        Correction correction = new Correction();
        correction.setId(dto.getId());
        correction.setType(dto.getType());
        correction.setAction(dto.getAction());
        correction.setCoordinations(dto.getCoordinations());
        correction.setExpiration(dto.getExpiration());
        correction.setUpdatedAt(dto.getUpdatedAt());
        correction.setInstitution(institution);
        return correction;
    }
}

