package umc.umc10th.domain.mission.dto;

import org.springframework.data.domain.Page;
import umc.umc10th.domain.member.entity.MemberMission;

import java.util.List;

public class MissionResDTO {

    public record MissionInfo(
            Long missionId,
            String title,
            Float score,
            String status
    ) {}

    public record MissionList(
            List<MissionInfo> missions,
            int totalPage,
            int currentPage
    ) {
        public static MissionList from(Page<MemberMission> page) {
            List<MissionInfo> missions = page.getContent().stream()
                    .map(mm -> new MissionInfo(
                            mm.getMission().getId(),
                            mm.getMission().getName(),
                            mm.getMission().getScore(),
                            mm.getStatus().name()
                    ))
                    .toList();
            return new MissionList(missions, page.getTotalPages(), page.getNumber());
        }
    }
}