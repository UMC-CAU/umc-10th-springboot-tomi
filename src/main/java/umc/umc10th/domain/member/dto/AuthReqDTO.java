package umc.umc10th.domain.member.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public class AuthReqDTO {

    public record SignUp(
            @NotBlank(message = "이름은 필수입니다")
            @Size(max = 10)
            String name,

            @NotBlank(message = "성별은 필수입니다")
            String gender,

            @NotNull(message = "생년월일은 필수입니다")
            LocalDate birth,

            @NotBlank(message = "주소는 필수입니다")
            String address,

            @NotBlank(message = "이메일은 필수입니다")
            @Email
            String email,

            @NotBlank(message = "비밀번호는 필수입니다")
            String password,

            List<Long> preferredFoodIds,  // 선호 음식 목록

            @NotEmpty(message = "약관 동의는 필수입니다")
            List<Long> termsIds           // 동의 약관 목록
    ) {}
}

