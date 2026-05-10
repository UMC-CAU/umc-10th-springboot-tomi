package umc.umc10th.domain.review.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.umc10th.domain.review.dto.ReviewReqDTO;
import umc.umc10th.domain.review.dto.ReviewResDTO;
import umc.umc10th.domain.review.service.ReviewService;
import umc.umc10th.global.apiPayload.ApiResponse;
import umc.umc10th.global.apiPayload.code.GeneralSuccessCode;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResDTO.CreateReview> createReview(
            @PathVariable Long storeId,
            @RequestParam Long memberId, //TODO 수정 예정
            @RequestBody @Valid ReviewReqDTO.CreateReview request
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED,
                ReviewResDTO.CreateReview.from(reviewService.createReview(memberId, storeId, request)));
    }
}
