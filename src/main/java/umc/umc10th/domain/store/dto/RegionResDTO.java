package umc.umc10th.domain.store.dto;

import org.springframework.data.domain.Page;
import umc.umc10th.domain.mission.entity.Mission;

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
    ) {
        public static MissionList from(Page<Mission> page, String regionName) {
            List<MissionInfo> missions = page.getContent().stream()
                    .map(m -> new MissionInfo(
                            m.getId(),
                            m.getStore().getName(),
                            m.getName(),
                            m.getScore().intValue()
                    ))
                    .toList();
            return new MissionList(missions, regionName);
        }
    }
}