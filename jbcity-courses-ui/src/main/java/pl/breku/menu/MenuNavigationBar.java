package pl.breku.menu;

import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import pl.breku.course.CoursesListPage;
import pl.breku.dashboard.DashboardPage;

/**
 * Created by breku on 13.09.17.
 */
public class MenuNavigationBar extends VerticalLayout {

	private static final long serialVersionUID = 4397313600991304778L;

	private final SpringNavigator springNavigator;

	public MenuNavigationBar(SpringNavigator springNavigator) {
		this.springNavigator = springNavigator;
		addComponent(createNavigationBar());
		addStyleName("jb-menubar-wrapper");
		setSizeFull();
		setSpacing(false);
		setMargin(false);
	}

	private MenuBar createNavigationBar() {
		final MenuBar menuBar = new MenuBar();
		menuBar.addStyleName("jb-menubar");
		menuBar.addItem("Home", selectedItem -> springNavigator.navigateTo(DashboardPage.VIEW_NAME));
		menuBar.addItem("Courses", selectedItem -> springNavigator.navigateTo(CoursesListPage.VIEW_NAME));
		return menuBar;
	}
}
