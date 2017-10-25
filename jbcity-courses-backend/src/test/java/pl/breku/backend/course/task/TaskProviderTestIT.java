package pl.breku.backend.course.task;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.breku.backend.AbstractSpringIntegrationTest;

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
		final List<Task> tasks = uut.getTasks();

		// then
		Assertions.assertThat(tasks).isNotEmpty();
	}

}