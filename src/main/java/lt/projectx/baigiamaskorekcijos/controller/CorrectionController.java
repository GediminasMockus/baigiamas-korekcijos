package lt.projectx.baigiamaskorekcijos.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lt.projectx.baigiamaskorekcijos.dto.CorrectionDto;
import lt.projectx.baigiamaskorekcijos.service.CorrectionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/corrections")
public class CorrectionController {

    private final CorrectionService correctionService;

    @GetMapping
    public List<CorrectionDto> getCorrections(
            @RequestParam(required = false) String type,
            @RequestParam(required = false)
            @Valid @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime expirationBefore
    ) {
        if (type != null && expirationBefore != null) {
            return correctionService.getCorrectionsByTypeAndExpirationBefore(type, expirationBefore);
        } else if (type != null) {
            return correctionService.getCorrectionsByType(type);
        } else if (expirationBefore != null) {
            return correctionService.getCorrectionsExpiringBefore(expirationBefore);
        } else {
            return correctionService.getAllCorrections();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CorrectionDto> getCorrectionById(@PathVariable Long id) {
        CorrectionDto correction = correctionService.getCorrectionById(id);
        return ResponseEntity.ok(correction);
    }

    @GetMapping("/filter")
    public List<CorrectionDto> getCorrectionsByCountry(@RequestParam(required = false) Long countryId) {
        if (countryId != null) {
            return correctionService.getCorrectionsByCountryId(countryId);
        }
        return correctionService.getAllCorrections();
    }

    @PostMapping
    public CorrectionDto createCorrection(@RequestBody CorrectionDto dto) {
        return correctionService.createCorrection(dto);
    }

    @PutMapping("/{id}")
    public CorrectionDto updateCorrectionById(@PathVariable Long id, @RequestBody CorrectionDto dto) {
        return correctionService.updateCorrectionById(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCorrectionById(@PathVariable Long id) {
        correctionService.deleteCorrectionById(id);
    }

}