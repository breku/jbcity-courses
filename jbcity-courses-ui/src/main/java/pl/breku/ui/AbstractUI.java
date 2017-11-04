package pl.breku.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.breku.dashboard.DashboardPage;
import pl.breku.error.AccessDeniedPage;
import pl.breku.error.ErrorPage;
import pl.breku.ui.login.LoginPage;

import java.util.Collection;

/**
 * Created by breku on 04.11.17.
 */
public abstract class AbstractUI extends UI {


	@Autowired
	protected SpringNavigator springNavigator;

	@Autowired
	protected SpringViewProvider springViewProvider;


	protected void initializeViews() {
		springNavigator.init(this, this);
		springNavigator.setErrorView(ErrorPage.class);
		springViewProvider.setAccessDeniedViewClass(AccessDeniedPage.class);
		getNavigator().addProvider(springViewProvider);
	}

	protected void navigateToCurrentRequest(VaadinRequest request) {
		final Collection<String> viewNames = springViewProvider.getViewNamesForCurrentUI();
		if (StringUtils.isNotBlank(springNavigator.getState()) && viewNames.contains(getFirstPartOfState())) {
			springNavigator.navigateTo(springNavigator.getState());
		} else if (request.getParameter("logout") != null) {
			springNavigator.navigateTo(LoginPage.VIEW_NAME);
		} else {
			springNavigator.navigateTo(DashboardPage.VIEW_NAME);
		}
	}

	private String getFirstPartOfState() {
		String state = springNavigator.getState();
		state = trimParameters(state);
		if (state.contains("/")) {
			return state.substring(0, state.indexOf("/"));
		}
		return state;
	}

	private String trimParameters(String state) {
		if (state.contains("?")) {
			return state.substring(0, state.indexOf("?"));
		}
		return state;
	}
}
