package pl.breku.register;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.breku.backend.security.RegisterService;
import pl.breku.page.AbstractPage;

/**
 * Created by breku on 04.11.17.
 */
@SpringView(name = RegisterPage.VIEW_NAME)
public class RegisterPage extends AbstractPage {

	public static final String VIEW_NAME = "register";

	private static final long serialVersionUID = 7632236470341607901L;


	private final RegisterService registerService;
	private final SpringNavigator springNavigator;


	@Autowired
	public RegisterPage(RegisterService registerService, SpringNavigator springNavigator) {
		this.registerService = registerService;
		this.springNavigator = springNavigator;
	}

	@Override
	protected void init() {

		final RegisterForm registerForm = new RegisterForm(registerService,springNavigator);
		VerticalLayout rootLayout = new VerticalLayout(registerForm);
		rootLayout.setSizeFull();
		rootLayout.setComponentAlignment(registerForm, Alignment.MIDDLE_CENTER);
		addComponent(rootLayout);
		setSizeFull();
	}

	@Override
	protected void createComponent(VerticalLayout wrapper) {
		// intentionally left blank.
	}
}
