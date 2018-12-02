package com.app.gui.menu.frames;

import java.util.Arrays;
import java.util.List;

import com.app.database.helper.DatabaseInsertHelper;
import com.app.database.tables.Table;

@SuppressWarnings("serial")
public class MusicFieldsFrame extends VerticalFieldsFrame {

	public enum MusicFields implements ProductFields {
		ALBUM_NAME("Name of Album"),
		YEAR("Year of Publication"),
		TRACK_NAME("Name of Track"),
		LANGUAGE("Language of lyrics"),
		DISK_TYPE("Type of Disk (C for CD, V for Vinyl)"),
		PRODUCER("Producer Name (Surname, first, middle)"),
		SINGER1("Singer 1 Name (Surname, first, middle)"),
		SINGER2("Singer 2 Name (Surname, first, middle)"),
		ARRANGER("Arranger Name (Surname, first, middle)"),
		COMPOSER("Composer Name (Surname, first, middle)"),
		SONG_WRITER("Song Writer Name (Surname, first, middle)");

		private String displayName;

		private MusicFields(String displayName) {
			this.displayName = displayName;
		}

		@Override
		public String getDisplayName() {
			return this.displayName;
		}
	}

	private static final int MIN_ELEMENTS = 2;

	public MusicFieldsFrame() {
		super(Table.MUSIC + " Fields", MusicFields.class.getEnumConstants());
	}

	@Override
	protected boolean submitAction() {
		String albumName = dataFields.get(MusicFields.ALBUM_NAME).getText();
		int year = dataFields.get(MusicFields.YEAR).getPositiveInt();
		String trackName = dataFields.get(MusicFields.TRACK_NAME).getText();
		String language = dataFields.get(MusicFields.LANGUAGE).getText();
		String diskType = dataFields.get(MusicFields.DISK_TYPE).getText();
		String[] producer = dataFields.get(MusicFields.PRODUCER).getParsedText(",", MIN_ELEMENTS);

		String[] singer1 = dataFields.get(MusicFields.SINGER1).getParsedText(",", MIN_ELEMENTS);
		String[] singer2 = dataFields.get(MusicFields.SINGER2).getParsedText(",", MIN_ELEMENTS);
		List<String[]> singers = Arrays.asList(singer1, singer2);

		String[] arranger = dataFields.get(MusicFields.ARRANGER).getParsedText(",", MIN_ELEMENTS);
		String[] composer = dataFields.get(MusicFields.COMPOSER).getParsedText(",", MIN_ELEMENTS);
		String[] songWriter = dataFields.get(MusicFields.SONG_WRITER).getParsedText(",", MIN_ELEMENTS);

		int insertMusic = -1;
		int insertSingers = -1;
		int insertMusicPeople = -1;
		if (isSingersValid(singers)) {
			insertMusic = insertMusic(albumName, year, trackName, language, diskType, producer);
			if (insertMusic > 0) {
				insertSingers = insertSingers(albumName, year, trackName, singers);
				insertMusicPeople = insertMusicPeople(albumName, year, trackName, arranger, composer, songWriter);
			}
		}

		boolean isSuccess = (insertMusic > -1 && insertSingers > -1 && insertMusicPeople > -1) ? true : false;
		return isSuccess;
	}

	private int insertMusic(String albumName, int year, String trackName, String language, String diskType,
			String[] producer) {

		if (producer == null) {
			return -1;
		}

		String producerFirstName = producer[1];
		String producerLastName = producer[0];
		int producerId = -1;
		if (producer.length == 2) {
			producerId = DatabaseInsertHelper.getOrAddPersonId(producerFirstName, producerLastName);
		} else {
			String producerMiddleName = producer[2];
			producerId = DatabaseInsertHelper.getOrAddPersonId(producerFirstName, producerLastName, producerMiddleName);
		}

		int result = -1;
		if (language.isEmpty() && diskType.isEmpty()) {
			result = DatabaseInsertHelper.insertMusic(albumName, year, trackName, producerId);
		} else if (language.isEmpty()) {
			result = DatabaseInsertHelper.insertMusic(albumName, year, trackName, diskType.charAt(0), producerId);
		} else if (diskType.isEmpty()) {
			result = DatabaseInsertHelper.insertMusic(albumName, year, trackName, language, producerId);
		} else {
			result = DatabaseInsertHelper.insertMusic(albumName, year, trackName, language, diskType.charAt(0),
					producerId);
		}

		return result;
	}

	private int insertSingers(String albumName, int year, String trackName, List<String[]> singers) {
		int result = -1;

		for (String[] singer : singers) {
			if (singer != null) {
				String firstName = singer[1];
				String lastName = singer[0];
				if (singer.length == 2) {
					result = DatabaseInsertHelper.insertMusicSinger(albumName, year, trackName, firstName, lastName);
				} else if (singer.length == 3) {
					String middleName = singer[2];
					result = DatabaseInsertHelper.insertMusicSinger(albumName, year, trackName, firstName, lastName,
							middleName);
				}
			}
		}

		return result;
	}

	private int insertMusicPeople(String albumName, int year, String trackName, String[] arranger, String[] composer,
			String[] songWriter) {
		boolean isArranger = true;
		boolean isComposer = true;
		boolean isSongWriter = true;
		if (arranger == null)
			isArranger = false;
		if (composer == null)
			isComposer = false;
		if (songWriter == null)
			isSongWriter = false;

		int result = -1;
		if (isArranger) {
			String firstName = arranger[1];
			String lastName = arranger[0];
			int personId;
			if (arranger.length == 2) {
				personId = DatabaseInsertHelper.getOrAddPersonId(firstName, lastName);
			} else {
				String middleName = arranger[2];
				personId = DatabaseInsertHelper.getOrAddPersonId(firstName, lastName, middleName);
			}
			result = DatabaseInsertHelper.insertPeopleInvolvedMusic(albumName, year, trackName, personId, 0, 0, 1);
		} 
		
		if (isComposer) {
			String firstName = composer[1];
			String lastName = composer[0];
			int personId;
			if (composer.length == 2) {
				personId = DatabaseInsertHelper.getOrAddPersonId(firstName, lastName);
			} else {
				String middleName = arranger[2];
				personId = DatabaseInsertHelper.getOrAddPersonId(firstName, lastName, middleName);
			}
			result = DatabaseInsertHelper.insertPeopleInvolvedMusic(albumName, year, trackName, personId, 0, 1, 0);
		} 
		
		if (isSongWriter) {
			String firstName = songWriter[1];
			String lastName = songWriter[0];
			int personId;
			if (songWriter.length == 2) {
				personId = DatabaseInsertHelper.getOrAddPersonId(firstName, lastName);
			} else {
				String middleName = songWriter[2];
				personId = DatabaseInsertHelper.getOrAddPersonId(firstName, lastName, middleName);
			}
			result = DatabaseInsertHelper.insertPeopleInvolvedMusic(albumName, year, trackName, personId, 1, 0, 0);
		}  

		return 1; //placebo
	}

	private boolean isSingersValid(List<String[]> singers) {
		boolean isValid = false;

		for (String[] singer : singers) {
			if (singer != null)
				isValid = true;
		}

		return isValid;
	}
}
