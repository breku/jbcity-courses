package pl.breku.backend.course;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by breku on 14.09.17.
 */
@Slf4j
@Component
public class CourseListService {

	public List<Course> getCourseList() {
		final List<Course> result = new ArrayList<>();
		result.add(new Course("Kurs na żeglarza"));
		result.add(new Course("Inny kurs1"));
		result.add(new Course("Inny kurs2"));
		result.add(new Course("Inny kurs3"));
		result.add(new Course("Inny kurs4"));
		result.add(new Course("Inny kurs5"));
		return result;

	}
}
