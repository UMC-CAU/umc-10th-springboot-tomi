package umc.umc10th.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc10th.domain.member.dto.MemberReqDTO;
import umc.umc10th.domain.member.dto.MemberResDTO;
import umc.umc10th.domain.member.entity.Member;
import umc.umc10th.domain.member.repository.MemberRepository;
import umc.umc10th.global.apiPayload.code.GeneralErrorCode;
import umc.umc10th.global.apiPayload.exception.GeneralException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResDTO.GetInfo getInfo(MemberReqDTO.GetInfo req) {
        Long memberId = req.id();
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()-> new GeneralException(GeneralErrorCode.NOT_FOUND));

        return MemberResDTO.from(member);
    }
}
