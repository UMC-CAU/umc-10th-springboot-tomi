package umc.umc10th.domain.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc10th.domain.review.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
