package pl.breku.backend.course;

import org.springframework.data.repository.CrudRepository;
import pl.breku.backend.database.entity.Course;

/**
 * Created by breku on 04.11.17.
 */
public interface CourseRepository extends CrudRepository<Course, Long> {

	Course findByName(String name);
}
