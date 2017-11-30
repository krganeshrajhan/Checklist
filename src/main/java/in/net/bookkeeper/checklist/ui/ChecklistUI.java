package in.net.bookkeeper.checklist.ui;


import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import in.net.bookkeeper.checklist.model.Checklist;
import in.net.bookkeeper.checklist.ui.layout.ChecklistLayout;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by krganeshrajhan on 29/11/17.
 */
@SpringUI
public class ChecklistUI extends UI {


    private VerticalLayout rootLayout;

    @Autowired
    private ChecklistLayout checklistLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        setupMainLayout();
        addHeader();
        addForm();
        addChecklistLayout();
    }

    public void setupMainLayout() {
        rootLayout = new VerticalLayout();
        setContent(rootLayout);
    }

    public void addHeader() {
        rootLayout.addComponent(new Label("Checklist"));
    }

    public void addForm() {
        HorizontalLayout addLayout = new HorizontalLayout();
        final TextField newItem = new TextField();
        newItem.setStyleName(ValoTheme.TEXTFIELD_ALIGN_CENTER);
        final Button add = new Button("Add");
        add.setStyleName(ValoTheme.BUTTON_PRIMARY);
//        add.setIcon(VaadinIcons.PLUS);
        addLayout.addComponents(newItem, add);
        rootLayout.addComponent(addLayout);

        add.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {

                checklistLayout.add(newItem.getValue());
                newItem.clear();
                newItem.focus();
                Notification.show("Item Added");
            }
        });
    }

    public void addChecklistLayout() {
        rootLayout.addComponent(checklistLayout);
    }
}

