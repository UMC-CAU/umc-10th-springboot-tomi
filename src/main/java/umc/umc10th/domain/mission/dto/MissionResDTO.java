package umc.umc10th.domain.mission.dto;

import java.util.List;

public class MissionResDTO {

    public record MissionInfo(
            Long missionId,
            String title,
            Integer reward,
            String status
    ) {}

    public record MissionList(
            List<MissionInfo> missions,
            int totalPage,
            int currentPage
    ) {}
}
