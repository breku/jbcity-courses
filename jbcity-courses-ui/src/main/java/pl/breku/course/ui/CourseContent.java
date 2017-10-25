package pl.breku.course.ui;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import pl.breku.backend.course.task.Answer;
import pl.breku.backend.course.task.Task;

import java.util.List;

/**
 * Created by breku on 25.10.17.
 */
public class CourseContent extends VerticalLayout{

	private final List<Task> tasks;

	public CourseContent(List<Task> tasks) {
		this.tasks = tasks;
		createContent();
	}

	private void createContent() {
		VerticalLayout wrapper = new VerticalLayout();
		addComponent(wrapper);
		for (Task task : tasks) {
			wrapper.addComponent(createItem(task));
		}
	}

	private Component createItem(Task task) {
		final VerticalLayout result = new VerticalLayout();
		result.addComponent(new Label(task.getQuestion()));
		for (Answer answer: task.getAnswers()) {
			result.addComponent(new Label(answer.getText()));
		}
		return result;
	}
}
