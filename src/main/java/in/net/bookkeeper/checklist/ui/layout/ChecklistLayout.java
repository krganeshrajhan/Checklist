package in.net.bookkeeper.checklist.ui.layout;

import com.vaadin.data.HasValue;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import in.net.bookkeeper.checklist.model.Checklist;
import in.net.bookkeeper.checklist.repository.ChecklistRepository;
import in.net.bookkeeper.checklist.ui.layout.ChecklistItemLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by krganeshrajhan on 30/11/17.
 */
@SpringComponent
public class ChecklistLayout extends VerticalLayout {

    @Autowired
    ChecklistRepository checklistRepository;

    @PostConstruct
    public void init() {
        update();
    }

    private void update() {
        removeAllComponents();
        List<Checklist> checklistList = checklistRepository.findAll();
        updateChecklist(checklistList);
    }

    private void updateChecklist(List<Checklist> checklistList) {
        for(final Checklist checklist : checklistList) {

            final ChecklistItemLayout itemLayout = new ChecklistItemLayout(checklist);
            addComponent(itemLayout);
            itemLayout.getDone().addValueChangeListener(new HasValue.ValueChangeListener<Boolean>() {
                @Override
                public void valueChange(HasValue.ValueChangeEvent<Boolean> valueChangeEvent) {

                    checklistRepository.delete(checklist);
                    Notification.show(itemLayout.getText().getValue()+" completed",
                            Notification.Type.TRAY_NOTIFICATION);
                    update();
                }
            });
            
        }
    }

    public void add(String text) {

        Checklist checklist = new Checklist();
        checklist.setText(text);
        checklistRepository.save(checklist);
        init();
    }
}
