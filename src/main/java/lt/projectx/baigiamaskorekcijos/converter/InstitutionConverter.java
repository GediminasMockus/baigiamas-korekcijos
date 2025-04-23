package lt.projectx.baigiamaskorekcijos.converter;

import lt.projectx.baigiamaskorekcijos.dto.InstitutionDto;
import lt.projectx.baigiamaskorekcijos.entity.Country;
import lt.projectx.baigiamaskorekcijos.entity.Institution;

public class InstitutionConverter {
    public static InstitutionDto toDto(Institution institution) {
        if (institution == null) return null;
        InstitutionDto dto = new InstitutionDto();
        dto.setId(institution.getId());
        dto.setName(institution.getName());
        dto.setEmail(institution.getEmail());
        dto.setWebsite(institution.getWebsite());
        if (institution.getCountry() != null)
            dto.setCountryId(institution.getCountry().getId());
        return dto;
    }

    public static Institution toEntity(InstitutionDto dto, Country country) {
        if (dto == null) return null;
        Institution institution = new Institution();
        institution.setId(dto.getId());
        institution.setName(dto.getName());
        institution.setEmail(dto.getEmail());
        institution.setWebsite(dto.getWebsite());
        institution.setCountry(country);
        return institution;
    }
}

