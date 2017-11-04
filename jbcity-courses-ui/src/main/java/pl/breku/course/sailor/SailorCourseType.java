package pl.breku.course.sailor;

import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import pl.breku.backend.database.entity.Course;
import pl.breku.course.CoursePage;

/**
 * Created by breku on 29.10.17.
 */
public class SailorCourseType extends VerticalLayout {
	private static final long serialVersionUID = 4652695424268780426L;

	private final SpringNavigator springNavigator;

	private final Course course;


	public SailorCourseType(SpringNavigator springNavigator, Course course) {
		this.springNavigator = springNavigator;
		this.course = course;
		init();
	}

	private void init() {
		final Button button = new Button(course.getName());
		button.addClickListener(x -> springNavigator.navigateTo(CoursePage.VIEW_NAME + "/" + course.getId()));
		addComponent(button);
	}
}
