package pl.breku.backend.course.task;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by breku on 25.10.17.
 */
@Component
public class FileToTaskConverter {

	private static final int CORRECT_LIST_SIZE = 5;

	public List<Task> convertLinesToTasks(final List<String> lines) {
		if (lines.size() % CORRECT_LIST_SIZE != 0) {
			throw new IllegalStateException("Number of questions + answers must be divided by 5");
		}
		final List<Task> result = new ArrayList<>();
		final List<List<String>> partition = Lists.partition(lines, CORRECT_LIST_SIZE);
		for (List<String> questionAndAnswers : partition) {
			final Task task = new Task();
			task.setQuestion(questionAndAnswers.get(0));
			final List<String> questions = questionAndAnswers.subList(1, questionAndAnswers.size());
			task.setAnswers(convertAnswerLines(questions));
			result.add(task);
		}
		return result;
	}

	private List<Answer> convertAnswerLines(List<String> answers) {
		final List<Answer> result = new ArrayList<>();
		for (String answerText : answers) {
			final Answer answer = new Answer();
			if (Character.isUpperCase(answerText.charAt(0))) {
				answer.setCorrect(true);
			}
			answer.setText(answerText.substring(0, 1).toLowerCase() + answerText.substring(1, answerText.length()));
			result.add(answer);
		}
		return result;
	}
}
