package pl.breku.course;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.breku.backend.course.Course;
import pl.breku.backend.course.CourseListService;
import pl.breku.dashboard.DashboardPage;
import pl.breku.page.AbstractPage;

/**
 * Created by breku on 14.09.17.
 */
@SpringView(name = CourseOverviewPage.VIEW_NAME)
@Slf4j
public class CourseOverviewPage extends AbstractPage {

	public static final String VIEW_NAME = "course";

	private static final long serialVersionUID = 7282156315507653255L;

	private long courseId;

	@Autowired
	private CourseListService courseListService;

	private VerticalLayout wrapper;

	@Override
	protected void createComponent(VerticalLayout wrapper) {
		this.wrapper = wrapper;
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		String[] parameters = event.getParameters().split("/");
		if (parameters.length > 0 && StringUtils.isNotBlank(parameters[0])) {
			try {
				courseId = Long.parseLong(parameters[0]);
			} catch (NumberFormatException e) {
				log.debug("> User entered suffix={}", parameters[0], e);
				springNavigator.navigateTo(DashboardPage.VIEW_NAME);
			}
			Course course = courseListService.getCourse(courseId);
			wrapper.addComponent(new Label(course.getName()));

		} else {
			log.debug("> User entered wrong url without specifing courseId");
			springNavigator.navigateTo(DashboardPage.VIEW_NAME);
		}
	}
}
