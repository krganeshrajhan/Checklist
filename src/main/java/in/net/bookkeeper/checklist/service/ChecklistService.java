package in.net.bookkeeper.checklist.service;

import in.net.bookkeeper.checklist.model.Checklist;
import in.net.bookkeeper.checklist.repository.ChecklistRepository;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by krganeshrajhan on 30/11/17.
 */
@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    public Checklist save(Checklist checklist) {
        return checklistRepository.save(checklist);
    }



}
