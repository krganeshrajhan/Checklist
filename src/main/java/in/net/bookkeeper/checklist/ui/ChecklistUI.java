package in.net.bookkeeper.checklist.ui;


import com.vaadin.event.ShortcutAction;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import in.net.bookkeeper.checklist.ui.layout.ChecklistLayout;
import in.net.bookkeeper.checklist.ui.view.LoginView;
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

//        setUpLoginLayout();
        setupMainLayout();
        addHeader();
        addForm();
        addChecklistLayout();
    }

    private void setUpLoginLayout() {
        rootLayout = new VerticalLayout();

//        addHeader();
        Label header = new Label("Checklist");
        header.setStyleName(ValoTheme.LABEL_H1);
        Label header1 = new Label("Checklist");
        header1.setStyleName(ValoTheme.LABEL_H1);

        LoginView loginView = new LoginView();

        rootLayout.setMargin(true);
        rootLayout.setCaption("Cap");
        rootLayout.setHeight(50, Unit.PERCENTAGE);
        rootLayout.addComponents(loginView);

        rootLayout.setSizeFull();

//        rootLayout.setComponentAlignment(loginView, Alignment.TOP_CENTER);

        setContent(rootLayout);
    }

    public void setupMainLayout() {
        rootLayout = new VerticalLayout();
        rootLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(rootLayout);
    }

    public void addHeader() {
        Label header = new Label("Checklist");
        header.setStyleName(ValoTheme.LABEL_H1);
        rootLayout.addComponent(header);
    }

    public void addForm() {
        HorizontalLayout addLayout = new HorizontalLayout();
//        addLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        final TextField task = new TextField();
        task.setStyleName(ValoTheme.TEXTFIELD_ALIGN_CENTER);
        final Button add = new Button("Add");
        add.setStyleName(ValoTheme.BUTTON_PRIMARY);
        //        add.setIcon(VaadinIcons.PLUS);
        addLayout.addComponents(task, add);
        rootLayout.addComponent(addLayout);

        add.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {

                checklistLayout.add(task.getValue());
                Notification.show(task.getValue(),"Added", Notification.Type.TRAY_NOTIFICATION);
                task.clear();
                task.focus();
            }
        });
        task.focus();
        add.setClickShortcut(ShortcutAction.KeyCode.ENTER);
    }

    public void addChecklistLayout() {
        rootLayout.addComponent(checklistLayout);
    }
}

