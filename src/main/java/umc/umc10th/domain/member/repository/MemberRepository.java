package umc.umc10th.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc10th.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
