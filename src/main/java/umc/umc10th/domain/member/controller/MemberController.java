package umc.umc10th.domain.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.umc10th.domain.member.dto.AuthReqDTO;
import umc.umc10th.domain.member.dto.AuthResDTO;
import umc.umc10th.domain.member.dto.MemberReqDTO;
import umc.umc10th.domain.member.dto.MemberResDTO;
import umc.umc10th.domain.member.service.MemberService;
import umc.umc10th.global.apiPayload.ApiResponse;
import umc.umc10th.global.apiPayload.code.GeneralSuccessCode;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/signup")
    public ApiResponse<AuthResDTO.SignUp> signUp(
            @RequestBody @Valid AuthReqDTO.SignUp request
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, null);
    }

    @PostMapping("/members/me")
    public ApiResponse<MemberResDTO.GetInfo> getInfo(
            @RequestBody MemberReqDTO.GetInfo req
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, memberService.getInfo(req));
    }
}
