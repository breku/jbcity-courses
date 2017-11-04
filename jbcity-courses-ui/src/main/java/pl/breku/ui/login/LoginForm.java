package pl.breku.ui.login;

import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.vaadin.spring.security.shared.VaadinSharedSecurity;

/**
 * Created by breku on 04.11.17.
 */
public class LoginForm extends VerticalLayout {
	private static final long serialVersionUID = 8235020821933607035L;

	private final VaadinSharedSecurity vaadinSharedSecurity;

	private final boolean logout;


	private TextField userName;

	private PasswordField passwordField;

	private CheckBox rememberMe;

	private Button login;

	private Label loginFailedLabel;

	private Label loggedOutLabel;


	public LoginForm(VaadinSharedSecurity vaadinSharedSecurity, boolean logout) {
		this.vaadinSharedSecurity = vaadinSharedSecurity;
		this.logout = logout;
		init();
	}

	private void init() {


		setSpacing(true);
		setSizeUndefined();

		if (logout) {
			loggedOutLabel = new Label("You have been logged out!");
			loggedOutLabel.addStyleName(ValoTheme.LABEL_SUCCESS);
			loggedOutLabel.setSizeUndefined();
			addComponent(loggedOutLabel);
			setComponentAlignment(loggedOutLabel, Alignment.BOTTOM_CENTER);
		}

		addComponent(loginFailedLabel = new Label());
		setComponentAlignment(loginFailedLabel, Alignment.BOTTOM_CENTER);
		loginFailedLabel.setSizeUndefined();
		loginFailedLabel.addStyleName(ValoTheme.LABEL_FAILURE);
		loginFailedLabel.setVisible(false);

		final FormLayout loginForm = createLoginForm();
		addComponent(loginForm);
		setComponentAlignment(loginForm, Alignment.TOP_CENTER);
	}

	private FormLayout createLoginForm() {
		FormLayout loginForm = new FormLayout();
		loginForm.setSizeUndefined();

		userName = new TextField("Username");
		passwordField = new PasswordField("Password");
		rememberMe = new CheckBox("Remember me");
		login = new Button("Login");
		loginForm.addComponent(userName);
		loginForm.addComponent(passwordField);
		loginForm.addComponent(rememberMe);
		loginForm.addComponent(login);
		login.addStyleName(ValoTheme.BUTTON_PRIMARY);
		login.setDisableOnClick(true);
		login.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		login.addClickListener(e -> login());
		return loginForm;
	}

	private void login() {
		try {
			vaadinSharedSecurity.login(userName.getValue(), passwordField.getValue(), rememberMe.getValue());
		} catch (AuthenticationException ex) {
			userName.focus();
			userName.selectAll();
			passwordField.setValue("");
			loginFailedLabel.setValue(String.format("Login failed: %s", ex.getMessage()));
			loginFailedLabel.setVisible(true);
			if (loggedOutLabel != null) {
				loggedOutLabel.setVisible(false);
			}
		} catch (Exception ex) {
			Notification.show("An unexpected error occurred", ex.getMessage(), Notification.Type.ERROR_MESSAGE);
			LoggerFactory.getLogger(getClass()).error("Unexpected error while logging in", ex);
		} finally {
			login.setEnabled(true);
		}
	}
}
