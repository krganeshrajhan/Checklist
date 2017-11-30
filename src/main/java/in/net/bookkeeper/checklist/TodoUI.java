package in.net.bookkeeper.checklist;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by krganeshrajhan on 29/11/17.
 */
//@SpringUI
public class TodoUI extends UI {


    private VerticalLayout rootLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        rootLayout = new VerticalLayout();
        setContent(rootLayout);
        rootLayout.addComponent(new Label("Checklist"));
    }
}

