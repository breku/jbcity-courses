package pl.breku.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;

/**
 * Created by basakpie on 2017. 5. 11..
 */
@SpringUI(path = "/login")
@Theme("mytheme")
public class LoginUI extends AbstractUI {

	private static final long serialVersionUID = -4512721193230304655L;


	@Override
	protected void init(VaadinRequest request) {
		createLoginForm(request);
		initializeViews();
		navigateToCurrentRequest(request);
	}

	private void createLoginForm(VaadinRequest request) {
		getPage().setTitle("Login");

	}


}
