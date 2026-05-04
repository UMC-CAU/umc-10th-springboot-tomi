package umc.umc10th.domain.member.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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



    @GetMapping("/members/{memberId}/me")
    public ApiResponse<MemberResDTO.GetInfo> getInfo(
            @PathVariable Long memberId
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, memberService.getInfo(memberId));
    }
}
