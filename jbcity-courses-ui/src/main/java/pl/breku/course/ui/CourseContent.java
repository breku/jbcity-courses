package pl.breku.course.ui;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import pl.breku.backend.database.entity.Course;
import pl.breku.backend.database.entity.Answer;
import pl.breku.backend.database.entity.Task;

/**
 * Created by breku on 25.10.17.
 */
public class CourseContent extends VerticalLayout {

	private static final long serialVersionUID = 2442725932630601483L;


	private final Course course;

	public CourseContent(Course course) {
		this.course = course;
		createContent();
	}

	private void createContent() {
		VerticalLayout wrapper = new VerticalLayout();
		wrapper.setCaption(course.getName());
		addComponent(wrapper);
		for (Task task : course.getTasks()) {
			wrapper.addComponent(createItem(task));
		}
	}

	private Component createItem(Task task) {
		final VerticalLayout result = new VerticalLayout();
		result.addComponent(new Label(task.getQuestion()));
		for (Answer answer : task.getAnswers()) {
			result.addComponent(new Label(answer.getText()));
		}
		return result;
	}
}
