package in.net.bookkeeper.checklist.repository;

import in.net.bookkeeper.checklist.model.Checklist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ChecklistRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ChecklistRepository checklistRepository;

    @Test
    public void testCreate() {
        Checklist checklist = saveChecklist("Ganesh");
        assertNotNull(checklist.getId());
        assertNotNull(checklist.getCreatedDate());
        assertNotNull(checklist.getUpdatedDate());
        assertNull(checklist.getCompletedDate());
    }

    public Checklist saveChecklist(String text) {
        Checklist checklist = new Checklist();
        checklist.setText(text);
        checklist = checklistRepository.save(checklist);
        return checklist;
    }

    @Test
    public void testComplete() {

        Checklist checklist = saveChecklist("Ganesh");
        checklist.setDone(true);
        checklist.setCompletedDate(new Date());
        checklistRepository.save(checklist);
        assertTrue(checklist.isDone());
        assertNotNull(checklist.getUpdatedDate());
        assertNotNull(checklist.getCompletedDate());
    }
}
