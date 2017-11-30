package in.net.bookkeeper.checklist.repository;

import in.net.bookkeeper.checklist.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by krganeshrajhan on 30/11/17.
 */
@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
}
