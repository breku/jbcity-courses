package pl.breku.page;

import com.vaadin.navigator.View;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.breku.menu.MenuNavigationBar;

import javax.annotation.PostConstruct;

/**
 * Created by breku on 13.09.17.
 */
public abstract class AbstractPage extends VerticalLayout implements View {


	@Autowired
	private SpringNavigator springNavigator;

	private static final long serialVersionUID = 4603458569679095452L;

	@PostConstruct
	protected void init() {
		setSizeFull();
		setSpacing(false);
		setMargin(false);
		addComponent(new MenuNavigationBar(springNavigator));
	}
}
