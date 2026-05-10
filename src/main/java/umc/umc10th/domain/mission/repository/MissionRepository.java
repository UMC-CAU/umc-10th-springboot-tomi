package umc.umc10th.domain.mission.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.umc10th.domain.mission.entity.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    @Query("SELECT m FROM Mission m " +
            "WHERE m.store.region.id = :regionId " +
            "AND m.id NOT IN (" +
            "SELECT mm.mission.id FROM MemberMission mm " +
            "WHERE mm.member.id = :memberId" +
            ") " +
            "ORDER BY m.id DESC")
    Page<Mission> findAvailableMissionsByRegion(
            @Param("regionId") Long regionId,
            @Param("memberId") Long memberId,
            Pageable pageable
    );
}
