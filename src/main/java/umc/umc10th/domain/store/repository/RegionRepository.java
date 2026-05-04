package umc.umc10th.domain.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc10th.domain.store.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
