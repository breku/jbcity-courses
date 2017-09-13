package pl.breku.page;

import com.vaadin.navigator.View;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * Created by breku on 13.09.17.
 */
public abstract class AbstractPage extends VerticalLayout implements View {


	private static final long serialVersionUID = 4603458569679095452L;

	@PostConstruct
	protected abstract void init();
}
