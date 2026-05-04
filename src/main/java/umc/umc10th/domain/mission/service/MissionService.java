package umc.umc10th.domain.mission.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umc10th.domain.mission.entity.Mission;
import umc.umc10th.domain.mission.repository.MissionRepository;
import umc.umc10th.domain.store.dto.RegionResDTO;
import umc.umc10th.domain.store.entity.Region;
import umc.umc10th.domain.store.repository.RegionRepository;
import umc.umc10th.global.apiPayload.code.GeneralErrorCode;
import umc.umc10th.global.apiPayload.exception.GeneralException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionService {

    private final MissionRepository missionRepository;
    private final RegionRepository regionRepository;

    public RegionResDTO.MissionList getHomeMissions(Long memberId, Long regionId, int page, int size) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        Page<Mission> result = missionRepository.findAvailableMissionsByRegion(
                regionId, memberId, PageRequest.of(page, size)
        );

        return RegionResDTO.MissionList.from(result, region.getName());
    }
}
