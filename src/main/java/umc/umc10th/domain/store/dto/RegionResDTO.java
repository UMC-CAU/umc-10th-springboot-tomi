package umc.umc10th.domain.store.dto;

import java.util.List;

public class RegionResDTO {

    public record MissionInfo(
            Long missionId,
            String storeName,
            String title,
            Integer reward
    ) {}

    public record MissionList(
            List<MissionInfo> missions,
            String regionName
    ) {}
}