package lt.projectx.baigiamaskorekcijos.converter;

import lt.projectx.baigiamaskorekcijos.dto.CountryDto;
import lt.projectx.baigiamaskorekcijos.entity.Country;

public class CountryConverter {
    public static CountryDto toDto(Country country) {
        if (country == null) return null;
        CountryDto dto = new CountryDto();
        dto.setId(country.getId());
        dto.setName(country.getName());
        dto.setCode(country.getCode());
        return dto;
    }

    public static Country toEntity(CountryDto dto) {
        if (dto == null) return null;
        Country country = new Country();
        country.setId(dto.getId());
        country.setName(dto.getName());
        country.setCode(dto.getCode());
        return country;
    }
}

