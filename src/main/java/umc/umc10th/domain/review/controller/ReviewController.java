package umc.umc10th.domain.review.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.umc10th.domain.review.dto.ReviewReqDTO;
import umc.umc10th.domain.review.dto.ReviewResDTO;
import umc.umc10th.global.apiPayload.ApiResponse;
import umc.umc10th.global.apiPayload.code.GeneralSuccessCode;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    @PostMapping("/stores/{storeId}/reviews")
    public ApiResponse<ReviewResDTO.CreateReview> createReview(
            @PathVariable Long storeId,
            @RequestBody @Valid ReviewReqDTO.CreateReview request
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, null);
    }
}
