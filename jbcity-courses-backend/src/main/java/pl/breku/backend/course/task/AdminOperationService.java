package pl.breku.backend.course.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.breku.backend.course.CourseProvider;
import pl.breku.backend.course.CourseRepository;
import pl.breku.backend.course.sailor.SailorCourseType;
import pl.breku.backend.database.entity.Course;

import java.util.List;

/**
 * Created by breku on 04.11.17.
 */
@Service
@Slf4j
public class AdminOperationService {

	private final CourseProvider courseProvider;

	private final CourseRepository courseRepository;

	public AdminOperationService(CourseProvider courseProvider, CourseRepository courseRepository) {
		this.courseProvider = courseProvider;
		this.courseRepository = courseRepository;
	}


	public void moveSailorTasksToDatabase() {
		final Course course = courseRepository.findByName(SailorCourseType.CONSTRUCTION_OF_THE_YACHT.name());
		if (course == null) {
			log.info("Moving courses to database.");
			final List<Course> sailorCourses = courseProvider.getSailorCourses();
			courseRepository.save(sailorCourses);
			log.info("Finished.");
		} else {
			log.warn("The courses are already in database. Skip moving them");
		}

	}
}
