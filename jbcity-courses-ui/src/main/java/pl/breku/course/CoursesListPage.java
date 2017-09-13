package pl.breku.course;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import pl.breku.page.AbstractPage;

/**
 * Created by breku on 13.09.17.
 */
@SpringView(name = CoursesListPage.VIEW_NAME)
public class CoursesListPage extends AbstractPage {

	public static final String VIEW_NAME = "courses";

	private static final long serialVersionUID = -5867976681717716832L;

	@Override
	protected void init() {
		super.init();
		VerticalLayout verticalLayout = new VerticalLayout();
		verticalLayout.addComponent(new Label("This is CoursesListPage"));
		addComponent(verticalLayout);

	}
}
