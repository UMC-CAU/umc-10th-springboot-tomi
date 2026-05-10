package umc.umc10th.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umc10th.domain.member.entity.Member;
import umc.umc10th.domain.member.entity.MemberMission;
import umc.umc10th.domain.member.enums.Status;
import umc.umc10th.domain.member.repository.MemberMissionRepository;
import umc.umc10th.domain.member.repository.MemberRepository;
import umc.umc10th.domain.mission.dto.MissionResDTO;
import umc.umc10th.domain.mission.entity.Mission;
import umc.umc10th.domain.mission.repository.MissionRepository;
import umc.umc10th.global.apiPayload.code.GeneralErrorCode;
import umc.umc10th.global.apiPayload.exception.GeneralException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    public MissionResDTO.MissionList getMyMissions(Long memberId, Status status, int page, int size) {
        memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        Page<MemberMission> result = memberMissionRepository.findByMemberIdAndStatus(
                memberId, status, PageRequest.of(page, size)
        );

        return MissionResDTO.MissionList.from(result);
    }

    //미션도전
    @Transactional
    public void challengeMission(Long memberId, Long missionId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        memberMissionRepository.save(MemberMission.create(member, mission));
    }

    //미션 성공 누르기
    @Transactional
    public void completeMission(Long memberId, Long missionId) {
        MemberMission memberMission = memberMissionRepository
                .findByMemberIdAndMissionId(memberId, missionId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        memberMission.updateStatus(Status.COMPLETE);
    }
}
