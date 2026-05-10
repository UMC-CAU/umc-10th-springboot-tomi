package umc.umc10th.domain.review.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ReviewReqDTO {

    public record CreateReview(
            @NotBlank(message = "내용은 필수입니다")
            String content,

            @NotNull
            @Min(value = 1, message = "최소 1점입니다")
            @Max(value = 5, message = "최대 5점입니다")
            Float score,

            List<String> pictureUrl   // 사진 URL 목록 (선택)
    ) {}
}
