package umc.umc10th.domain.review.dto;

public class ReviewResDTO {

    public record CreateReview(
            Long reviewId,
            String content,
            Integer score
    ) {
        public static CreateReview of(Long reviewId, String content, Integer score) {
            return new CreateReview(reviewId, content, score);
        }
    }
}