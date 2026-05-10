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

    @GetMapping("/reviews")
    public ApiResponse<ReviewResDTO.ReviewListWithCursor> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam(required = false) Long cursorId,
            @RequestParam(required = false) Float cursorScore,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK,
                reviewService.getMyReviews(memberId, cursorId, cursorScore, sortBy, size));
    }
}
