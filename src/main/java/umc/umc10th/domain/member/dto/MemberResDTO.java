package umc.umc10th.domain.member.dto;

import umc.umc10th.domain.member.entity.Member;

public class MemberResDTO {

    public record GetInfo(
            Long id,
            String email,
            String phoneNumber,
            Integer point
    ){
        public static GetInfo from(Member member) {
            return new GetInfo(
                    member.getId(),
                    member.getEmail(),
                    member.getPhoneNumber(),
                    member.getPoint()
            );
        }
    }
}
