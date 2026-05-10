package umc.umc10th.domain.mission.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class MissionReqDTO {
    public record MissionInProgressReqDTO(
            Long memberId,

            @Min(0)
            Integer page,

            @Min(1) @Max(100)
            Integer size
    ) {
        public int getPage() { return page != null ? page : 0; }
        public int getSize() { return size != null ? size : 10; }
    }
}
