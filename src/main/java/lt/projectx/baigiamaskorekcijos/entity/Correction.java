package lt.projectx.baigiamaskorekcijos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Correction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @Column(insertable = false, updatable = false)
    private Long institution_id;
    private String action;
    private LocalDateTime expiration;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private String coordinations;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "institution_id")
    private Institution institution;

}
