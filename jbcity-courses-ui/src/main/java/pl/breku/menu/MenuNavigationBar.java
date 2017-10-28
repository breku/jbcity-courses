package pl.breku.menu;

import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.spring.security.VaadinSecurity;
import pl.breku.course.sailor.SailorCoursePage;
import pl.breku.dashboard.DashboardPage;

/**
 * Created by breku on 13.09.17.
 */
public class MenuNavigationBar extends VerticalLayout {

	private static final long serialVersionUID = 4397313600991304778L;

	private final SpringNavigator springNavigator;

	private final VaadinSecurity vaadinSecurity;

	public MenuNavigationBar(SpringNavigator springNavigator, VaadinSecurity vaadinSecurity) {
		this.springNavigator = springNavigator;
		this.vaadinSecurity = vaadinSecurity;
		initializeNavigationBarProperties();
		addComponent(createNavigationBar());
	}


	private void initializeNavigationBarProperties() {
		addStyleName("jb-menubar-wrapper");
		setSizeFull();
		setSpacing(false);
		setMargin(false);
	}

	private MenuBar createNavigationBar() {
		final MenuBar menuBar = new MenuBar();
		menuBar.addStyleName("jb-menubar");
		menuBar.addItem("Home", selectedItem -> springNavigator.navigateTo(DashboardPage.VIEW_NAME));
		menuBar.addItem("Kurs żeglarza", selectedItem -> springNavigator.navigateTo(SailorCoursePage.VIEW_NAME));
		menuBar.addItem("Logout", selectedItem -> vaadinSecurity.logout());
		return menuBar;
	}
}
