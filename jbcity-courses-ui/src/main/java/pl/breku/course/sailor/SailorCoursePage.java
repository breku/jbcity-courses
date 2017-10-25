package pl.breku.course.sailor;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.breku.backend.course.task.TaskProvider;
import pl.breku.course.ui.CourseContent;
import pl.breku.page.AbstractPage;

/**
 * Created by breku on 25.10.17.
 */
@SpringView(name = SailorCoursePage.VIEW_NAME)
public class SailorCoursePage extends AbstractPage {

	public static final String VIEW_NAME = "sailor";

	private static final long serialVersionUID = -7957941300897228420L;

	@Autowired
	private TaskProvider taskProvider;

	@Override
	protected void createComponent(VerticalLayout wrapper) {
		wrapper.addComponent(createDashboardImage());
		wrapper.addComponent(new Label("This is sailor course"));

		wrapper.addComponent(new CourseContent(taskProvider.getTasks()));

	}
}
