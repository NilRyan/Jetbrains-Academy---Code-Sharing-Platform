package platform.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import platform.model.CodeEntity;
@Repository
public interface CodeRepository extends PagingAndSortingRepository<CodeEntity, Long> {}
