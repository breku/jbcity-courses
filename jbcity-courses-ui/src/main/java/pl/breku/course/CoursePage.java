package pl.breku.course;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.VerticalLayout;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import pl.breku.backend.course.Course;
import pl.breku.backend.course.CourseProvider;
import pl.breku.course.sailor.SailorCoursePage;
import pl.breku.course.ui.CourseContent;
import pl.breku.page.AbstractPage;

/**
 * Created by breku on 25.10.17.
 */
@Secured("ROLE_USER")
@SpringView(name = CoursePage.VIEW_NAME)
public class CoursePage extends AbstractPage {

	public static final String VIEW_NAME = "course";

	private static final long serialVersionUID = -7957941300897228420L;

	@Autowired
	private CourseProvider courseProvider;

	@Override
	protected void createComponent(VerticalLayout wrapper) {
		wrapper.addComponent(createDashboardImage());

	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		final String courseId = event.getParameters();
		if (StringUtils.isNotBlank(courseId) && NumberUtils.isDigits(courseId)) {
			final Course course = courseProvider.getSailorCourse(Long.parseLong(courseId));
			if (course != null) {
				addComponent(new CourseContent(course));
			} else {
				springNavigator.navigateTo(SailorCoursePage.VIEW_NAME);
			}
		} else {
			springNavigator.navigateTo(SailorCoursePage.VIEW_NAME);
		}


	}
}
