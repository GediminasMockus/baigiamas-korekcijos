package lt.projectx.baigiamaskorekcijos.service;

import jakarta.persistence.EntityNotFoundException;
import lt.projectx.baigiamaskorekcijos.converter.CountryConverter;
import lt.projectx.baigiamaskorekcijos.dto.CountryDto;
import lt.projectx.baigiamaskorekcijos.entity.Country;
import lt.projectx.baigiamaskorekcijos.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<CountryDto> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(CountryConverter::toDto)
                .toList();
    }

    public CountryDto getCountryById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Country with ID " + id + " not found"));
        return CountryConverter.toDto(country);
    }


    public CountryDto createCountry(CountryDto countryDto) {
        Country country = CountryConverter.toEntity(countryDto);
        return CountryConverter.toDto(countryRepository.save(country));
    }

    public CountryDto updateCountryById(Long id, CountryDto countryDto) {
        Optional<Country> countryOpt = countryRepository.findById(id);
        if (countryOpt.isEmpty()) return null;
        Country country = countryOpt.get();
        country.setName(countryDto.getName());
        country.setCode(countryDto.getCode());
        return CountryConverter.toDto(countryRepository.save(country));
    }

    public boolean deleteCountryById(Long id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
