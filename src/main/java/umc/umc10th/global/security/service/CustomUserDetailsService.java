package umc.umc10th.global.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import umc.umc10th.domain.member.entity.Member;
import umc.umc10th.domain.member.repository.MemberRepository;
import umc.umc10th.global.apiPayload.code.GeneralErrorCode;
import umc.umc10th.global.apiPayload.exception.GeneralException;
import umc.umc10th.global.security.entity.AuthMember;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        return new AuthMember(member);
    }
}
