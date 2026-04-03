package umc.umc10th.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.umc10th.domain.member.enums.Gender;
import umc.umc10th.domain.member.enums.Role;
import umc.umc10th.global.entity.BaseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "member")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length=10, nullable=false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name="social_id", length=50, nullable=true)
    private String social_id;

    @Column(name="social_type", nullable=true)
    private String social_type;

    @Column(nullable = false)
    private String password;

    @Column(name = "email", length=50, nullable=false, unique=true)
    private String email;

    @Column(name = "gender", nullable=false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Gender gender = Gender.NONE;

    @Column(name = "birth_date", nullable=false)
    private LocalDateTime birth_date;

    @Column(name = "address", length = 50, nullable=false)
    private String address;

    @Column(name = "phone_number", length=20)
    private String phone_number;

    @Column(name = "point", nullable=false)
    @Builder.Default
    int point = 0;

    @Column(name="url", nullable=false)
    private String url;

    @OneToMany(mappedBy = "member")
    private List<MemberFood> memberFoods = new ArrayList<>();
}
