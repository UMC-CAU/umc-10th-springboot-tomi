package umc.umc10th.domain.store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.umc10th.domain.mission.service.MissionService;
import umc.umc10th.domain.store.dto.RegionResDTO;
import umc.umc10th.global.apiPayload.ApiResponse;
import umc.umc10th.global.apiPayload.code.GeneralSuccessCode;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionController {

    private final MissionService missionService;

    //특정 지역에서 가능한 미션
    @GetMapping("/{regionId}/missions")
    public ApiResponse<RegionResDTO.MissionList> getMissions(
            @PathVariable Long regionId,
            @RequestParam Long memberId, //TODO 수정예정
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK,
                missionService.getHomeMissions(memberId, regionId, page, size));
    }
}
