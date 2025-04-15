package lt.projectx.baigiamaskorekcijos.controller;

import lombok.AllArgsConstructor;
import lt.projectx.baigiamaskorekcijos.dto.CountryDto;
import lt.projectx.baigiamaskorekcijos.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/countries")
public class CountryController {
    @Autowired

    private final CountryService countryService;

    @GetMapping
    public List<CountryDto> getAllCountries(@RequestParam(required = false)String name) {
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public CountryDto getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @PostMapping
    public CountryDto createCountry(@RequestBody CountryDto countryDto) {
        return countryService.createCountry(countryDto);
    }

    @PutMapping("/{id}")
    public CountryDto updateCountryById(@PathVariable Long id, @RequestBody CountryDto countryDto) {
        return countryService.updateCountryById(id, countryDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCountryById(@PathVariable Long id) {
        countryService.deleteCountryById(id);
    }
}