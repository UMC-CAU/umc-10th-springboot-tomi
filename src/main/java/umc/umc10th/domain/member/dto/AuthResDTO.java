package umc.umc10th.domain.member.dto;

public class AuthResDTO {

    public record SignUp(
            Long memberId,
            String name,
            String email
    ) {
        public static SignUp of(Long memberId, String name, String email) {
            return new SignUp(memberId, name, email);
        }
    }
}