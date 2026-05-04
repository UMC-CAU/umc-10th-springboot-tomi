package umc.umc10th.domain.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc10th.domain.store.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
