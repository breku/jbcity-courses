package pl.breku.error;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.context.annotation.Scope;
import pl.breku.page.AbstractPage;

/**
 * Created by breku on 28.10.17.
 */
@Scope("prototype")
@SpringView(name = AccessDeniedPage.VIEW_NAME)
public class AccessDeniedPage extends AbstractPage {

	public static final String VIEW_NAME = "access-denied";

	private static final long serialVersionUID = 3700601137073074947L;


	@Override
	protected void init() {
		setMargin(false);
		setSpacing(false);
		final VerticalLayout wrapper = createWrapper();
		addComponent(wrapper);
		createComponent(wrapper);
	}

	@Override
	protected void createComponent(VerticalLayout wrapper) {
		wrapper.addComponent(new Label("Access denied page"));
	}
}
