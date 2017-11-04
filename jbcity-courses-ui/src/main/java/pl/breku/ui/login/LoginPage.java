package pl.breku.ui.login;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.security.shared.VaadinSharedSecurity;
import pl.breku.page.AbstractPage;

/**
 * Created by breku on 25.10.17.
 */
@SpringView(name = LoginPage.VIEW_NAME)
public class LoginPage extends AbstractPage {

	public static final String VIEW_NAME = "login";

	private static final long serialVersionUID = -1275813301618495176L;

	@Autowired
	private VaadinSharedSecurity vaadinSecurity;


	@Override
	protected void init() {

	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {

		final LoginForm loginForm = createLoginForm(event);
		VerticalLayout rootLayout = new VerticalLayout(loginForm);
		rootLayout.setSizeFull();
		rootLayout.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
		addComponent(rootLayout);
		setSizeFull();
	}

	private LoginForm createLoginForm(ViewChangeListener.ViewChangeEvent event) {
		if ("logout".equals(event.getParameters())) {
			return new LoginForm(vaadinSecurity, true);
		}
		return new LoginForm(vaadinSecurity, false);
	}

	@Override
	protected void createComponent(VerticalLayout wrapper) {
		// intentionally left blank.
	}
}
