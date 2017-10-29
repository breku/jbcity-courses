package pl.breku.backend.course.sailor;

/**
 * Created by breku on 29.10.17.
 */
public enum SailorCourseType {
	CONSTRUCTION_OF_THE_YACHT(1, "1.budowa_jachtu.txt"),
	WEATHER(2, "2.pogoda.txt"),
	LAWS(3, "3.przepisy.txt"),
	RESCUE(4, "4.ratownictwo.txt"),
	WINDS(5, "5.wiatry.txt");

	private final long id;

	private final String filename;

	SailorCourseType(long id, String filename) {
		this.id = id;
		this.filename = filename;
	}

	public long getId() {
		return id;
	}

	public String getFilename() {
		return filename;
	}
}
