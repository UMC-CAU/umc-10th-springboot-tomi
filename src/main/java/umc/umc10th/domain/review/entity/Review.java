package umc.umc10th.domain.review.entity;

import jakarta.persistence.*;
import lombok.*;
import umc.umc10th.domain.member.entity.Member;
import umc.umc10th.domain.store.entity.Store;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="content", nullable=false)
    private String content;

    @Column(name="score", nullable=false)
    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable=false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable=false)
    private Store store;

    public static Review create(Member member, Store store, String content, Float score) {
        return Review.builder()
                .member(member)
                .store(store)
                .content(content)
                .score(score)
                .build();
    }
}
