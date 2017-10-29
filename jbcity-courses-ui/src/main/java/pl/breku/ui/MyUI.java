package pl.breku.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.spring.server.SpringVaadinServletRequest;
import com.vaadin.ui.UI;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.breku.dashboard.DashboardPage;
import pl.breku.error.AccessDeniedPage;
import pl.breku.error.ErrorPage;

import java.util.Collection;


/**
 *
 */
@SpringUI
@Theme("mytheme")
@Slf4j
@Component
public class MyUI extends UI {

	private static final long serialVersionUID = 1000504781843211331L;

	@Autowired
	private SpringViewProvider viewProvider;

	@Autowired
	private SpringNavigator springNavigator;

	@Autowired
	private SpringViewProvider springViewProvider;


	@Override
	protected void init(VaadinRequest vaadinRequest) {
		log.info("Request to url={}", ((SpringVaadinServletRequest) vaadinRequest).getRequestURI());
		springNavigator.init(this, this);
		springNavigator.setErrorView(ErrorPage.class);
		springViewProvider.setAccessDeniedViewClass(AccessDeniedPage.class);
		getNavigator().addProvider(viewProvider);
		navigateToCurrentRequest();

	}

	private void navigateToCurrentRequest() {
		final Collection<String> viewNames = springViewProvider.getViewNamesForCurrentUI();


		if (StringUtils.isNotBlank(springNavigator.getState()) && viewNames.contains(getFirstPartOfState())) {
			springNavigator.navigateTo(springNavigator.getState());
		} else {
			springNavigator.navigateTo(DashboardPage.VIEW_NAME);
		}
	}

	private String getFirstPartOfState() {
		final String state = springNavigator.getState();
		if (state.contains("/")) {
			return state.substring(0, state.indexOf("/"));
		}
		return state;
	}


}
