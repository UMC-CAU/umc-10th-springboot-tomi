package umc.umc10th.domain.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umc10th.domain.member.dto.AuthReqDTO;
import umc.umc10th.domain.member.dto.AuthResDTO;
import umc.umc10th.global.apiPayload.ApiResponse;
import umc.umc10th.global.apiPayload.code.GeneralSuccessCode;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/signup")
    public ApiResponse<AuthResDTO.SignUp> signUp(
            @RequestBody @Valid AuthReqDTO.SignUp request
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.CREATED, null);
    }
}
