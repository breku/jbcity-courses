package pl.breku.course;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import pl.breku.page.AbstractPage;

/**
 * Created by breku on 14.09.17.
 */
@SpringView(name = CourseOverviewPage.VIEW_NAME)
public class CourseOverviewPage extends AbstractPage {

	public static final String VIEW_NAME = "course";

	private static final long serialVersionUID = 7282156315507653255L;

	@Override
	protected void createComponent(VerticalLayout wrapper) {
		wrapper.addComponent(new Label("aa"));

	}
}
