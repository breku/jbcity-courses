package pl.breku.backend.course.task;

import org.springframework.data.repository.CrudRepository;
import pl.breku.backend.database.entity.Task;

/**
 * Created by breku on 04.11.17.
 */
public interface TaskRepository extends CrudRepository<Task, Long> {
}
