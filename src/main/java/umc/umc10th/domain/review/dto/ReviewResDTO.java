package umc.umc10th.domain.review.dto;

import umc.umc10th.domain.review.entity.Review;

public class ReviewResDTO {

    public record CreateReview(
            Long reviewId,
            String content,
            Float score
    ) {
        public static CreateReview from(Review review) {
            return new CreateReview(review.getId(), review.getContent(), review.getScore());
        }
    }
}