package umc.umc10th.domain.store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.umc10th.domain.store.dto.RegionResDTO;
import umc.umc10th.global.apiPayload.ApiResponse;
import umc.umc10th.global.apiPayload.code.GeneralSuccessCode;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionController {

    @GetMapping("/{regionId}/missions")
    public ApiResponse<RegionResDTO.MissionList> getMissions(
            @PathVariable Long regionId,
            @RequestParam(defaultValue = "available") String status
    ) {
        return ApiResponse.onSuccess(GeneralSuccessCode.OK, null);
    }
}
