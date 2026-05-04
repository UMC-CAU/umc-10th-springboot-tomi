package umc.umc10th.domain.mission.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.umc10th.domain.member.enums.Status;
import umc.umc10th.domain.mission.dto.MissionResDTO;
import umc.umc10th.global.apiPayload.ApiResponse;
import umc.umc10th.global.apiPayload.code.GeneralSuccessCode;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {


    @GetMapping
    public ApiResponse<MissionResDTO.MissionList> getMissions(
            @RequestParam Status status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, null);
    }

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<Void> challengeMission(
            @PathVariable Long missionId
    ) {

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, null);
    }

    @PostMapping("/{missionId}/complete")
    public ApiResponse<Void> completeMission(
            @PathVariable Long missionId
    ) {

        return ApiResponse.onSuccess(GeneralSuccessCode.OK, null);
    }
}
