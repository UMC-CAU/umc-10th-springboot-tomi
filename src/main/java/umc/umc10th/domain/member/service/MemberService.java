package umc.umc10th.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umc10th.domain.member.dto.AuthReqDTO;
import umc.umc10th.domain.member.dto.AuthResDTO;
import umc.umc10th.domain.member.dto.MemberResDTO;
import umc.umc10th.domain.member.entity.Member;
import umc.umc10th.domain.member.enums.Gender;
import umc.umc10th.domain.member.enums.Role;
import umc.umc10th.domain.member.enums.SocialType;
import umc.umc10th.domain.member.repository.MemberRepository;
import umc.umc10th.global.apiPayload.code.GeneralErrorCode;
import umc.umc10th.global.apiPayload.exception.GeneralException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberResDTO.GetInfo getInfo(Long memberId) {
        return memberRepository.findById(memberId)
                .map(MemberResDTO.GetInfo::from)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));
    }

    @Transactional
    public AuthResDTO.SignUp signUp(AuthReqDTO.SignUp request) {
        if (memberRepository.existsByEmail(request.email())) {
            throw new GeneralException(GeneralErrorCode.BAD_REQUEST);
        }

        Member member = Member.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .gender(Gender.valueOf(request.gender()))
                .birthDate(request.birth())
                .address(request.address())
                .role(Role.ROLE_USER)
                .socialType(SocialType.LOCAL)
                .socialId(request.email())
                .url("")
                .build();

        memberRepository.save(member);
        return AuthResDTO.SignUp.of(member.getId(), member.getName(), member.getEmail());
    }
}
