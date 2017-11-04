package pl.breku.backend.course.task;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.breku.backend.AbstractSpringIntegrationTest;
import pl.breku.backend.course.sailor.SailorCourseType;
import pl.breku.backend.database.entity.Task;

import java.util.List;

/**
 * Created by breku on 25.10.17.
 */
public class TaskProviderTestIT extends AbstractSpringIntegrationTest {


	@Autowired
	private TaskProvider uut;

	@Test
	public void shouldGetTasks() {
		// given

		// when
		final List<Task> tasks = uut.getSailorTasks(SailorCourseType.CONSTRUCTION_OF_THE_YACHT);

		// then
		Assertions.assertThat(tasks).isNotEmpty();
	}

}