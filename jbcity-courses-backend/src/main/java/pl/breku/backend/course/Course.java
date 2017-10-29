package pl.breku.backend.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.breku.backend.course.task.Task;

import java.util.List;

/**
 * Created by breku on 14.09.17.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {

	private String name;

	private long id;

	private List<Task> tasks;
}
