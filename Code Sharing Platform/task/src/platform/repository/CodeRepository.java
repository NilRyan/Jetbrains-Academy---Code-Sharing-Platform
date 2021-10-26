package platform.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import platform.model.CodeEntity;

import java.util.UUID;

@Repository
public interface CodeRepository extends PagingAndSortingRepository<CodeEntity, UUID> {
    Page<CodeEntity> findByViewsLessThanAndTimeLessThan(long views, long time, Pageable pageable);
}
