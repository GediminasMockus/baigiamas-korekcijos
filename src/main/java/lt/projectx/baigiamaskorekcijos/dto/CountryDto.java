package lt.projectx.baigiamaskorekcijos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CountryDto {
    private Long id;
    @NotBlank(message = "Country name can't be blank")
    private String name;
    @NotBlank(message = "Country code can't be blank")
    private String code;
}
