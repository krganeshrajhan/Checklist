package in.net.bookkeeper.checklist.service;

import in.net.bookkeeper.checklist.model.Checklist;
import in.net.bookkeeper.checklist.repository.ChecklistRepository;
import org.hibernate.annotations.Check;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ChecklistServiceTest {

    @TestConfiguration
    static class ChecklistServiceImplTestContextConfiguration {

        @Bean
        public ChecklistService checklistService() {
            return new ChecklistService();
        }
    }

    @Autowired
    private ChecklistService checklistService;

    @MockBean
    private ChecklistRepository checklistRepository;

    private Checklist checklist = new Checklist();

    @Before
    public void setup() {
        checklist.setText("Ganesh");
        Checklist savedChecklist = new Checklist();
        savedChecklist.setText("Ganesh");
        savedChecklist.setId(1);
        when(checklistRepository.save(checklist)).thenReturn(savedChecklist);
    }

    @Test
    public void testCreate() {
        Checklist savedChecklist = checklistService.save(checklist);
        assertNotNull(savedChecklist);
        assertEquals(1, savedChecklist.getId());

    }

    @Test
    public void testComplete() {

    }

}
