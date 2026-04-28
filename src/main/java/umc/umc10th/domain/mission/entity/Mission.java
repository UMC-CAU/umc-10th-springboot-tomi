package umc.umc10th.domain.mission.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.umc10th.domain.store.entity.Store;

import java.time.LocalDate;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="content", nullable=false)
    private String content;

    @Column(name="deadline", nullable=false)
    private LocalDate deadline;

    @Column(name="score", nullable=false)
    private Float score;

    @Column(name = "name", length=10, nullable=false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable=false)
    private Store store;
}
