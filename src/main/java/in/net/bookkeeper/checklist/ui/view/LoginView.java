package in.net.bookkeeper.checklist.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.shared.ui.orderedlayout.FormLayoutState;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;

/**
 * Created by krganeshrajhan on 5/12/17.
 */
@SpringView(name = LoginView.VIEW_NAME)
public class LoginView extends CustomComponent implements View {

    public static final String VIEW_NAME = "login";

    public LoginView() {

        Panel loginPanel = new Panel("Login");

        final FormLayout loginLayout = new FormLayout();
        TextField userName = new TextField("username");
        TextField password = new TextField("password");
        Button login = new Button("Login");
        loginLayout.addComponent(userName);
        loginLayout.addComponent(password);
        loginLayout.addComponent(login);

        setSizeUndefined();
        // Have some margin around it.
        loginLayout.setMargin(true);

        // set required indicator for text fields
        userName.setRequiredIndicatorVisible(true);
        password.setRequiredIndicatorVisible(true);

        loginPanel.setContent(loginLayout);

        setCompositionRoot(loginPanel);

    }

}
