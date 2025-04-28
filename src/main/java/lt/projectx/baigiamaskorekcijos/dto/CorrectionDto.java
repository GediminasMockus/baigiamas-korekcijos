package lt.projectx.baigiamaskorekcijos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class CorrectionDto {
    Long id;
    @NotBlank(message = "Correction type can't be blank")
    String type;
    @NotBlank(message = "Correction action can't be blank")
    String action;
    @NotBlank(message = "Correction coordinations can't be blank")
    String coordinations;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime expiration;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime updatedAt;
    @NotBlank(message = "Id can't be blank")
    Long institutionId;
}
