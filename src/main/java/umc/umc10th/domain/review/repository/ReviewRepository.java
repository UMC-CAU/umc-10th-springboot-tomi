package umc.umc10th.domain.review.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.umc10th.domain.review.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT r FROM Review r WHERE r.member.id = :memberId " +
            "AND (:cursorId IS NULL OR r.id > :cursorId) " +
            "ORDER BY r.id ASC")
    List<Review> findByMemberIdOrderById(
            @Param("memberId") Long memberId,
            @Param("cursorId") Long cursorId,
            Pageable pageable
    );

    @Query("SELECT r FROM Review r WHERE r.member.id = :memberId " +
            "AND (:cursorScore IS NULL OR r.score < :cursorScore " +
            "     OR (r.score = :cursorScore AND r.id > :cursorId)) " +
            "ORDER BY r.score DESC, r.id ASC")
    List<Review> findByMemberIdOrderByScore(
            @Param("memberId") Long memberId,
            @Param("cursorScore") Float cursorScore,
            @Param("cursorId") Long cursorId,
            Pageable pageable
    );
}
