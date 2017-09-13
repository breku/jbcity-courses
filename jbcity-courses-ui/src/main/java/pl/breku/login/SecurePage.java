package pl.breku.login;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by breku on 10.09.17.
 */
public class SecurePage extends VerticalLayout implements View {

	public static final String NAME = "Secure";

	private static final long serialVersionUID = 7992243698356950580L;

	private Label secure;

	private Label currentUser;

	private Button otherSecure;

	private Button logout;

	public SecurePage() {

		otherSecure = new Button("OtherSecure");
		otherSecure.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(Button.ClickEvent event) {
				Page.getCurrent().setUriFragment("!" + OtherSecurePage.NAME);
			}
		});

		logout = new Button("Logout");
		logout.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(Button.ClickEvent event) {
				getUI().getNavigator().removeView(SecurePage.NAME);
				getUI().getNavigator().removeView(OtherSecurePage.NAME);
				VaadinSession.getCurrent().setAttribute("user", null);
				Page.getCurrent().setUriFragment("");
			}
		});

		secure = new Label("secure");
		currentUser = new Label("Current User");
		addComponent(secure);
		addComponent(currentUser);
		addComponent(otherSecure);
		addComponent(logout);
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		currentUser.setCaption("Current user : " + VaadinSession.getCurrent().getAttribute("user").toString());

	}
}
