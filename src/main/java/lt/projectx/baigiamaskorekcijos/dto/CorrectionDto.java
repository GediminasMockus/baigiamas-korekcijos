package lt.projectx.baigiamaskorekcijos.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CorrectionDto {
    Long id;
    String type;
    String action;
    String coordinations;
    LocalDateTime expiration;
    LocalDateTime updated;
    Long institutionId;
}
