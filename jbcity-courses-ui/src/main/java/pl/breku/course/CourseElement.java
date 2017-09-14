package pl.breku.course;

import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import pl.breku.backend.course.Course;

/**
 * Created by breku on 14.09.17.
 */
public class CourseElement extends VerticalLayout {


	private static final long serialVersionUID = -3422266139435191326L;

	private final SpringNavigator springNavigator;

	private final Course course;

	public CourseElement(SpringNavigator springNavigator, Course course) {
		this.springNavigator = springNavigator;
		this.course = course;
		addComponent(new Label(course.getName()));
		addComponent(new Button("Start", (Button.ClickListener) event -> {
			springNavigator.navigateTo(String.format("%s/%s", CourseOverviewPage.VIEW_NAME, course.getId()));
		}));
	}


}