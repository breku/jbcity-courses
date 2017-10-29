package pl.breku.course.sailor;

import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import pl.breku.backend.course.Course;
import pl.breku.backend.course.CourseProvider;
import pl.breku.page.AbstractPage;

import java.util.List;

/**
 * Created by breku on 25.10.17.
 */
@Secured("ROLE_USER")
@SpringView(name = SailorCoursePage.VIEW_NAME)
public class SailorCoursePage extends AbstractPage {

	public static final String VIEW_NAME = "sailor";

	private static final long serialVersionUID = -7957941300897228420L;

	@Autowired
	private CourseProvider courseProvider;

	@Override
	protected void createComponent(VerticalLayout wrapper) {
		wrapper.addComponent(createDashboardImage());
		wrapper.addComponent(new Label("This is sailor course"));

		final List<Course> sailorCourses = courseProvider.getSailorCourses();
		for (Course course : sailorCourses) {
			wrapper.addComponent(new SailorCourseType(springNavigator, course));
		}
	}
}
