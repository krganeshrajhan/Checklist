package in.net.bookkeeper.checklist.ui.layout;

import com.vaadin.data.Binder;
import com.vaadin.data.HasValue;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import in.net.bookkeeper.checklist.model.Checklist;
import in.net.bookkeeper.checklist.repository.ChecklistRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by krganeshrajhan on 30/11/17.
 */
@Getter
@Setter
public class ChecklistItemLayout extends HorizontalLayout {

    private final CheckBox done;
    private final TextField text;

    public ChecklistItemLayout(final Checklist checklist) {
        done = new CheckBox();
        done.setStyleName(ValoTheme.CHECKBOX_LARGE);
        text = new TextField();
        text.setStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        text.setHeight(50, Unit.PIXELS);
        addComponents(done, text);
        bindData(checklist);
    }

    private void bindData(Checklist checklist) {
        Binder<Checklist> binder = new Binder<>(Checklist.class);
        binder.bindInstanceFields(this);
        binder.setBean(checklist);
    }
}
