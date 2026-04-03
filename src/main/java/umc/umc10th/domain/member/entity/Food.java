package umc.umc10th.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.umc10th.domain.member.enums.FoodCategory;
import umc.umc10th.domain.member.enums.TermsType;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable=false)
    @Enumerated(EnumType.STRING)
    private FoodCategory name;
}
