package pl.breku.backend.course.task;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by breku on 25.10.17.
 */
public class FileToTaskConverterTest {

	private FileToTaskConverter uut = new FileToTaskConverter();

	@Test
	public void shouldConvertLines() {
		// given
		final List<String> input = Arrays.asList("Question?", "a)aaa", "b)bbb", "C)ccc", "d)ddd");

		// when
		final List<Task> result = uut.convertLinesToTasks(input);

		// then
		assertThat(result).hasSize(1);
		assertThat(result.get(0).getAnswers()).hasSize(4);
		final List<Answer> correctQuestions = result.get(0).getAnswers().stream().filter(Answer::isCorrect).collect(Collectors.toList());
		assertThat(correctQuestions).hasSize(1);
		assertThat(correctQuestions.get(0).getText()).contains("ccc");
	}


}