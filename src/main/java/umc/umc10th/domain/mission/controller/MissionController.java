package umc.umc10th.domain.mission.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.umc10th.domain.member.enums.Status;
import umc.umc10th.domain.member.service.MemberMissionService;
import umc.umc10th.domain.mission.dto.MissionResDTO;
import umc.umc10th.global.apiPayload.ApiResponse;
import umc.umc10th.global.apiPayload.code.GeneralSuccessCode;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MemberMissionService memberMissionService;

    //내 미션 조회
    @GetMapping
    public ApiResponse<MissionResDTO.MissionList> getMissions(
            @RequestParam Long memberId, //TODO 수정예정
            @RequestParam Status status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK,
                memberMissionService.getMyMissions(memberId, status, page, size));
    }

    //미션 도전 누르기
    @PostMapping("/{missionId}/challenge")
    public ApiResponse<Void> challengeMission(
            @PathVariable Long missionId,
            @RequestParam Long memberId
    ) {
        memberMissionService.challengeMission(memberId, missionId);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, null);
    }

    //미션 성공 누르기
    @PostMapping("/{missionId}/complete")
    public ApiResponse<Void> completeMission(
            @PathVariable Long missionId,
            @RequestParam Long memberId

    ) {
        memberMissionService.completeMission(memberId, missionId);
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, null);
    }
}
