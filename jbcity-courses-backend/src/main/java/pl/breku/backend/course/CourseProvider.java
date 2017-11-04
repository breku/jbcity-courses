package pl.breku.backend.course;

import org.springframework.stereotype.Component;
import pl.breku.backend.course.sailor.SailorCourseType;
import pl.breku.backend.course.task.TaskProvider;
import pl.breku.backend.database.entity.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by breku on 29.10.17.
 */
@Component
public class CourseProvider {

	private final TaskProvider taskProvider;

	public CourseProvider(TaskProvider taskProvider) {
		this.taskProvider = taskProvider;
	}

	public List<Course> getSailorCourses() {
		final List<Course> result = new ArrayList<>();
		for (SailorCourseType sailorCourseType : SailorCourseType.values()) {
			result.add(createCourse(sailorCourseType));
		}
		return result;
	}

	public Course getSailorCourse(long id) {
		return getSailorCourses().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	}

	private Course createCourse(SailorCourseType sailorCourseType) {
		final Course course = new Course();
		course.setTasks(taskProvider.getSailorTasks(sailorCourseType));
		course.setName(sailorCourseType.name());
		course.setId(sailorCourseType.getId());
		return course;
	}
}
