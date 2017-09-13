package pl.breku.login;

import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.*;

/**
 * Created by breku on 10.09.17.
 */
public class LoginPage extends VerticalLayout implements View {

	public static final String NAME = "login";

	private static final long serialVersionUID = -6225705701434144822L;

	public LoginPage() {

		Panel panel = new Panel("Login");
		panel.setSizeUndefined();
		addComponent(panel);


		FormLayout content = new FormLayout();
		TextField username = new TextField("Username");
		content.addComponent(username);
		PasswordField password = new PasswordField("Password");
		content.addComponent(password);


		Button send = new Button("Enter");
		send.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(Button.ClickEvent clickEvent) {
				if (username.getValue().equals("jbrek") && password.getValue().equals("q1w2e3r4")) {
					VaadinSession.getCurrent().setAttribute("user", username.getValue());
					getUI().getNavigator().addView(SecurePage.NAME, SecurePage.class);
					getUI().getNavigator().addView(OtherSecurePage.NAME, OtherSecurePage.class);
					Page.getCurrent().setUriFragment("!" + SecurePage.NAME);
				} else {
					Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE);
				}
			}


		});

		content.addComponent(send);
		content.setSizeUndefined();
		content.setMargin(true);
		panel.setContent(content);
		setComponentAlignment(panel, Alignment.MIDDLE_CENTER);


	}
}
