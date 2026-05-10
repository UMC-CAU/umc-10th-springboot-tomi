package umc.umc10th.domain.review.service;

import ch.qos.logback.core.spi.ErrorCodes;
import ch.qos.logback.core.status.ErrorStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umc10th.domain.member.entity.Member;
import umc.umc10th.domain.member.repository.MemberRepository;
import umc.umc10th.domain.review.dto.ReviewReqDTO;
import umc.umc10th.domain.review.dto.ReviewResDTO;
import umc.umc10th.domain.review.entity.Review;
import umc.umc10th.domain.review.repository.ReviewRepository;
import umc.umc10th.domain.store.entity.Store;
import umc.umc10th.domain.store.repository.StoreRepository;
import umc.umc10th.global.apiPayload.code.GeneralErrorCode;
import umc.umc10th.global.apiPayload.exception.GeneralException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    public Review createReview(Long memberId, Long storeId, ReviewReqDTO.@Valid CreateReview request) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        return reviewRepository.save(Review.create(member,store,request.content(), request.score()));
    }
}
