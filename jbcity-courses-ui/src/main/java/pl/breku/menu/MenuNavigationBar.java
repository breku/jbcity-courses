package pl.breku.menu;

import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.spring.security.VaadinSecurity;
import pl.breku.course.sailor.SailorCoursePage;
import pl.breku.dashboard.DashboardPage;
import pl.breku.ui.login.LoginPage;
import pl.breku.user.UserPage;

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
		addComponent(createLeftNavigationBar());
		addComponent(createRightNavigationBar());
	}


	private void initializeNavigationBarProperties() {
		addStyleName("jb-menubar-wrapper");
		setSizeFull();
		setSpacing(false);
		setMargin(false);
	}

	private MenuBar createLeftNavigationBar() {
		final MenuBar menuBar = new MenuBar();
		menuBar.addStyleName("jb-menubar-left");
		menuBar.addItem("Home", selectedItem -> springNavigator.navigateTo(DashboardPage.VIEW_NAME));
		menuBar.addItem("Kurs żeglarza", selectedItem -> springNavigator.navigateTo(SailorCoursePage.VIEW_NAME));
		return menuBar;
	}

	private MenuBar createRightNavigationBar() {
		final MenuBar menuBar = new MenuBar();
		menuBar.addStyleName("jb-menubar-right");
		menuBar.addItem("Użytkownik", selectedItem -> springNavigator.navigateTo(UserPage.VIEW_NAME));
		menuBar.addItem("Wyloguj", selectedItem -> vaadinSecurity.logout());
		return menuBar;
	}
}
