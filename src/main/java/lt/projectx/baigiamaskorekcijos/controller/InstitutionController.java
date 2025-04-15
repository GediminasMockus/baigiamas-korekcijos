package lt.projectx.baigiamaskorekcijos.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lt.projectx.baigiamaskorekcijos.dto.InstitutionDto;
import lt.projectx.baigiamaskorekcijos.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/institutions")
public class InstitutionController {

    @Autowired
    private  final InstitutionService institutionService;

    @GetMapping
    public List<InstitutionDto> getAllInstitutions(@RequestParam(required = false)String name) {
        return institutionService.getAllInstitutions();
    }

    @GetMapping("/{id}")
    public InstitutionDto getInstitutionById(@PathVariable Long id) {
        return institutionService.getInstitutionById(id);
    }

    @PostMapping
    public InstitutionDto createInstitution(@Valid @RequestBody InstitutionDto dto) {
        return institutionService.createInstitution(dto);
    }

    @PutMapping("/{id}")
    public InstitutionDto updateInstitutionById(@PathVariable Long id, @Valid @RequestBody InstitutionDto dto) {
        return institutionService.updateInstitution(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteInstitutionById(@PathVariable Long id) {
        institutionService.deleteInstitution(id);
    }
}