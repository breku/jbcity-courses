package pl.breku.dashboard;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.breku.menu.MenuNavigationBar;
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
	protected void init() {
		super.init();
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.setSizeFull();
		verticalLayout.setWidth("100%");
		verticalLayout.setMargin(false);
		verticalLayout.setSpacing(false);
		verticalLayout.addComponent(new Label("This is dashboard"));
		addComponent(verticalLayout);

	}
}
