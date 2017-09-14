package pl.breku.course.list;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.breku.backend.course.Course;
import pl.breku.backend.course.CourseListService;
import pl.breku.course.CourseElement;
import pl.breku.page.AbstractPage;

/**
 * Created by breku on 13.09.17.
 */
@SpringView(name = CoursesListPage.VIEW_NAME)
public class CoursesListPage extends AbstractPage {


	public static final String VIEW_NAME = "courses";

	private static final long serialVersionUID = -5867976681717716832L;

	@Autowired
	private CourseListService courseListService;

	@Override
	protected void createComponent(VerticalLayout wrapper) {
		wrapper.addComponent(new Label("This is CoursesListPage"));
		wrapper.addComponent(createCoursesComponent());
	}

	private Component createCoursesComponent() {
		final VerticalLayout verticalLayout = new VerticalLayout();
		for (Course course : courseListService.getCourseList()) {
			verticalLayout.addComponent(new CourseElement(springNavigator, course));
		}
		return verticalLayout;
	}
}
