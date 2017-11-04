package pl.breku.admin;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.security.access.annotation.Secured;
import pl.breku.backend.course.task.AdminOperationService;
import pl.breku.backend.database.entity.User;
import pl.breku.backend.user.UserService;
import pl.breku.page.AbstractPage;

/**
 * Created by breku on 25.10.17.
 */
@Secured("ROLE_ADMIN")
@SpringView(name = AdminPage.VIEW_NAME)
public class AdminPage extends AbstractPage {

	public static final String VIEW_NAME = "admin";

	private static final long serialVersionUID = -5086761959060339003L;

	private final UserService userService;
	private final AdminOperationService adminOperationService;

	public AdminPage(UserService userService, AdminOperationService adminOperationService) {
		this.userService = userService;
		this.adminOperationService = adminOperationService;
	}

	@Override
	protected void createComponent(VerticalLayout wrapper) {
		wrapper.addComponent(createDashboardImage());
		wrapper.addComponent(new Label("This is admin page"));
		final User currentUser = userService.getCurrentUser();
		wrapper.addComponent(new Label("You are " + currentUser.getUsername()));
		wrapper.addComponent(createButtonToMoveDataToDatabase());
	}

	private Component createButtonToMoveDataToDatabase() {
		final Button button = new Button("Move questions to database");
		button.addClickListener(x-> adminOperationService.moveSailorTasksToDatabase());
		return button;

	}
}
