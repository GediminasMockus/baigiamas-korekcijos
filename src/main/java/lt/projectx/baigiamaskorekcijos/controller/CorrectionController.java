package lt.projectx.baigiamaskorekcijos.controller;

import lombok.AllArgsConstructor;
import lt.projectx.baigiamaskorekcijos.dto.CorrectionDto;
import lt.projectx.baigiamaskorekcijos.service.CorrectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/corrections")
public class CorrectionController {

    private final CorrectionService correctionService;

    @GetMapping
    public List<CorrectionDto> getAllCorrections(@RequestParam(required = false) String name) {
        return correctionService.getAllCorrections();
    }

    @GetMapping("/{id}")
    public CorrectionDto getCorrectionById(@PathVariable Long id) {
        return correctionService.getCorrectionById(id);
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