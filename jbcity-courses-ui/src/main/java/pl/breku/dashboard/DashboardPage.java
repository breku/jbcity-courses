package pl.breku.dashboard;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import pl.breku.page.AbstractPage;

/**
 * Created by breku on 13.09.17.
 */
@SpringView(name = DashboardPage.VIEW_NAME)
public class DashboardPage extends AbstractPage {

	public static final String VIEW_NAME = "dashboard";

	private static final long serialVersionUID = 2111328748647906890L;


	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		Notification.show("Welcome to the Animal Farm");

	}


	@Override
	protected void createComponent(VerticalLayout wrapper) {
		wrapper.addComponent(createDashboardImage());
		wrapper.addComponent(new Label("This is dashboard"));
	}

	private Component createDashboardImage() {
		final VerticalLayout result = new VerticalLayout();
		result.addStyleName("jb-dashboard-image");
		result.setSpacing(false);
		result.setSizeFull();
		return result;
	}


}
