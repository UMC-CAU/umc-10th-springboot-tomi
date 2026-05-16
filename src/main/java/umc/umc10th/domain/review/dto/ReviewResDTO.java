package umc.umc10th.domain.review.dto;

import umc.umc10th.domain.review.entity.Review;

import java.util.List;

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

    public record ReviewItem(
            Long reviewId,
            String content,
            Float score
    ) {
        public static ReviewItem from(Review review) {
            return new ReviewItem(review.getId(), review.getContent(), review.getScore());
        }
    }

    public record ReviewListWithCursor(
            List<ReviewItem> reviews,
            Long nextCursorId,
            Float nextCursorScore,
            boolean hasNext
    ) {
        public static ReviewListWithCursor from(List<Review> reviews, int size, String sortBy) {
            boolean hasNext = reviews.size() > size;
            List<Review> content = hasNext ? reviews.subList(0, size) : reviews;

            Long nextCursorId = hasNext ? content.get(content.size() - 1).getId() : null;
            Float nextCursorScore = hasNext ? content.get(content.size() - 1).getScore() : null;

            return new ReviewListWithCursor(
                    content.stream().map(ReviewItem::from).toList(),
                    nextCursorId,
                    nextCursorScore,
                    hasNext
            );
        }
    }
}