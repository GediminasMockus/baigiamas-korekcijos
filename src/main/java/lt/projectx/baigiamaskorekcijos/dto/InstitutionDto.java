package lt.projectx.baigiamaskorekcijos.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InstitutionDto {
    private Long id;
    @NotBlank(message = "Institution name can't be blank")
    private String name;
    @Email(message = "Illegal email format")
    private String email;
    @Size(max = 255, message = "Website address too long")
    private String website;
    @NotNull(message = "Country required")
    private Long countryId;
}
