package umc.umc10th.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.umc10th.domain.member.enums.TermsType;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "term")
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable=false)
    @Enumerated(EnumType.STRING)
    private TermsType name;

    @Column(name = "description")
    private String description;
}
