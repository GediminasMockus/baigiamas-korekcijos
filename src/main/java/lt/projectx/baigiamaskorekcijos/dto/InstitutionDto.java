package lt.projectx.baigiamaskorekcijos.dto;

import lombok.Data;

@Data
public class InstitutionDto {
    private Long id;
    private String name;
    private String email;
    private String website;
    private Long countryId;
}
