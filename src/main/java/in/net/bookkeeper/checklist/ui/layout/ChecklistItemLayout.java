package in.net.bookkeeper.checklist.ui.layout;

import com.vaadin.data.Binder;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import in.net.bookkeeper.checklist.model.Checklist;
import lombok.Getter;
import lombok.Setter;

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
        done.setHeight(25, Unit.PIXELS);
        text = new TextField();
        text.setStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        text.setHeight(25, Unit.PIXELS);
        addComponents(done, text);
        bindData(checklist);
    }

    private void bindData(Checklist checklist) {
        Binder<Checklist> binder = new Binder<>(Checklist.class);
        binder.bindInstanceFields(this);
        binder.setBean(checklist);
    }
}
