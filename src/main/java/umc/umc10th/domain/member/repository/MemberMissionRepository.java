package umc.umc10th.domain.member.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.umc10th.domain.member.entity.MemberMission;
import umc.umc10th.domain.member.enums.Status;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    @Query("SELECT mm FROM MemberMission mm " +
            "JOIN FETCH mm.mission m " +
            "WHERE mm.member.id = :memberId AND mm.status = :status " +
            "ORDER BY mm.id DESC")
    Page<MemberMission> findByMemberIdAndStatus(
            @Param("memberId") Long memberId,
            @Param("status") Status status,
            Pageable pageable
    );

    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);

}
