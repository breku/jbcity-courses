package pl.breku.user;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.security.access.annotation.Secured;
import pl.breku.backend.database.entity.User;
import pl.breku.backend.user.UserService;
import pl.breku.page.AbstractPage;

/**
 * Created by breku on 25.10.17.
 */
@Secured("ROLE_USER")
@SpringView(name = UserPage.VIEW_NAME)
public class UserPage extends AbstractPage {

	public static final String VIEW_NAME = "user";

	private static final long serialVersionUID = -5086761959060339003L;

	private final UserService userService;

	public UserPage(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected void createComponent(VerticalLayout wrapper) {
		wrapper.addComponent(createDashboardImage());
		wrapper.addComponent(new Label("This is user page"));
		final User currentUser = userService.getCurrentUser();
		wrapper.addComponent(new Label("You are " + currentUser.getUsername()));
	}
}
