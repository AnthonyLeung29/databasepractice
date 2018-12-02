package com.app.database.helper;

import java.util.Arrays;
import java.util.List;

import com.app.database.DatabaseInserter;
import com.app.database.tables.Table;
import com.app.database.tables.TableAttributes.AwardAttributes;
import com.app.database.tables.TableAttributes.BookAttributes;
import com.app.database.tables.TableAttributes.BookAuthorAttributes;
import com.app.database.tables.TableAttributes.BookKeywordAttributes;
import com.app.database.tables.TableAttributes.CrewMemberAttributes;
import com.app.database.tables.TableAttributes.KeywordAttributes;
import com.app.database.tables.TableAttributes.MovieAttributes;
import com.app.database.tables.TableAttributes.MusicAttributes;
import com.app.database.tables.TableAttributes.MusicSingerAttributes;
import com.app.database.tables.TableAttributes.PeopleInvolvedAttributes;
import com.app.database.tables.TableAttributes.PeopleInvolvedMusicAttributes;
import com.app.database.tables.TableAttributes.RoleAttributes;

/**
 * Helps to manage inserts into the database. <br>
 * Error checking is done here. and it's built around the business rules of the database 
 * and lets you insert to each table individually. <br> 
 * There are overridden methods for those tables that have mandatory fields (one for mandatory, one for all) <br>
 * <br>
 * Updated to the database as of Dec 1st, 2018
 * 
 * @author antho
 *
 */
public class DatabaseInsertHelper {
	
	// Note: When making new methods, make sure the number of attributes has to match with the data fields.
	
	// ===== INSERT BOOK =====
	
	public static int insertBook(String isbn, String title, String publisher, int numPages, int year) {
		if (numPages < 0 || year < 0) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				BookAttributes.ISBN,
				BookAttributes.TITLE,
				BookAttributes.PUBLISHER,
				BookAttributes.NUMBER_OF_PAGES,
				BookAttributes.YEAR_OF_PUBLICATION);
		List<Object> data = Arrays.asList(isbn, title, publisher, numPages, year);
		
		return DatabaseInserter.insert(Table.BOOK, attributes, data);
	}
	
	public static int insertBook(String isbn, String title, String publisher, int numPages, int year, int editionNum) {
		if (numPages < 0 || year < 0 || editionNum < 0) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				BookAttributes.ISBN,
				BookAttributes.TITLE,
				BookAttributes.PUBLISHER,
				BookAttributes.NUMBER_OF_PAGES,
				BookAttributes.YEAR_OF_PUBLICATION,
				BookAttributes.EDITION_NUMBER);
		List<Object> data = Arrays.asList(isbn, title, publisher, numPages, year, editionNum);
		
		return DatabaseInserter.insert(Table.BOOK, attributes, data);
	}
	
	public static int insertBook(String isbn, String title, String publisher, int numPages, int year, String description) {
		if (numPages < 0 || year < 0) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				BookAttributes.ISBN,
				BookAttributes.TITLE,
				BookAttributes.PUBLISHER,
				BookAttributes.NUMBER_OF_PAGES,
				BookAttributes.YEAR_OF_PUBLICATION,
				BookAttributes.ABSTRACT);
		List<Object> data = Arrays.asList(isbn, title, publisher, numPages, year, description);
		
		return DatabaseInserter.insert(Table.BOOK, attributes, data);
	}
	
	public static int insertBook(String isbn, String title, String publisher, int numPages, int year, int editionNum, String description) {
		if (numPages < 0 || year < 0 || editionNum < 0) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				BookAttributes.ISBN,
				BookAttributes.TITLE,
				BookAttributes.PUBLISHER,
				BookAttributes.NUMBER_OF_PAGES,
				BookAttributes.YEAR_OF_PUBLICATION,
				BookAttributes.EDITION_NUMBER,
				BookAttributes.ABSTRACT);
		List<Object> data = Arrays.asList(isbn, title, publisher, numPages, year, editionNum, description);
		
		return DatabaseInserter.insert(Table.BOOK, attributes, data);
	}
	
	public static int insertBookAuthor(String isbn, String firstName, String lastName) {
		int authorId = getOrAddPersonId(firstName, lastName);
		
		return insertBookAuthor(isbn, authorId);
	}
	
	public static int insertBookAuthor(String isbn, String firstName, String lastName, String middleName) {
		int authorId = getOrAddPersonId(firstName, lastName, middleName);
		
		return insertBookAuthor(isbn, authorId);
	}
	
	public static int insertBookAuthor(String isbn, int authorId) {
		List<String> attributes = Arrays.asList(
				BookAuthorAttributes.ISBN,
				BookAuthorAttributes.AUTHOR_ID);
		List<Object> data = Arrays.asList(isbn, authorId);
		
		return DatabaseInserter.insert(Table.BOOK_AUTHOR, attributes, data);
	}
	
	public static int insertBookKeyword(String isbn, String keyword) {
		int keywordId = DatabaseSelectHelper.getKeywordId(keyword);
		if (keywordId < 0) {
			insertKeyword(keyword);
			keywordId = DatabaseSelectHelper.getKeywordId(keyword);
		}
		
		return insertBookKeyword(isbn, keywordId);
	}
	
	public static int insertBookKeyword(String isbn, int keywordId) {
		List<String> attributes = Arrays.asList(
				BookKeywordAttributes.ISBN,
				BookKeywordAttributes.KEYWORD_ID);
		List<Object> data = Arrays.asList(isbn, keywordId);
		
		return DatabaseInserter.insert(Table.BOOK_KEYWORD, attributes, data);
	}
	
	public static int insertKeyword(String keyword) {
		List<String> attributes = Arrays.asList(KeywordAttributes.TAG);
		List<Object> data = Arrays.asList(keyword);
		
		return DatabaseInserter.insert(Table.KEYWORD, attributes, data);
	}
	
	
	// ===== INSERTING PEOPLE =====
	
	public static int insertPeopleInvolved(String firstName, String lastName) {
		List<String> attributes = Arrays.asList(
				PeopleInvolvedAttributes.FIRST_NAME,
				PeopleInvolvedAttributes.FAMILY_NAME);
		List<Object> data = Arrays.asList(firstName, lastName);
		
		return DatabaseInserter.insert(Table.PEOPLE_INVOLVED, attributes, data);
	}
	
	public static int insertPeopleInvolved(String firstName, String middleName, String lastName) {
		List<String> attributes = Arrays.asList(
				PeopleInvolvedAttributes.FIRST_NAME,
				PeopleInvolvedAttributes.MIDDLE_NAME,
				PeopleInvolvedAttributes.FAMILY_NAME);
		List<Object> data = Arrays.asList(firstName, middleName, lastName);
		
		return DatabaseInserter.insert(Table.PEOPLE_INVOLVED, attributes, data);
	}
	
	public static int insertPeopleInvolved(String firstName, String middleName, String lastName, int gender) {
		if (gender < 0 ) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				PeopleInvolvedAttributes.FIRST_NAME,
				PeopleInvolvedAttributes.MIDDLE_NAME,
				PeopleInvolvedAttributes.FAMILY_NAME,
				PeopleInvolvedAttributes.GENDER);
		List<Object> data = Arrays.asList(firstName, middleName, lastName, gender);
		
		return DatabaseInserter.insert(Table.PEOPLE_INVOLVED, attributes, data);
	}
	
	public static int insertPeopleInvolvedMusic(String albumName, int year, String musicName, String firstName, String lastName) {
		int personId = getOrAddPersonId(firstName, lastName);
		
		return insertPeopleInvolvedMusic(albumName, year, musicName, personId);
	}
	
	public static int insertPeopleInvolvedMusic(String albumName, int year, String musicName, int personId) {
		if ( year < 0 ) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				PeopleInvolvedMusicAttributes.ALBUM_NAME,
				PeopleInvolvedMusicAttributes.YEAR,
				PeopleInvolvedMusicAttributes.MUSIC_NAME,
				PeopleInvolvedMusicAttributes.PEOPLE_INVOLVED_ID);
		
		List<Object> data = Arrays.asList(albumName, year, musicName, personId);
		
		return DatabaseInserter.insert(Table.PEOPLE_INVOLVED_MUSIC, attributes, data);
	}
	
	public static int insertPeopleInvolvedMusic(String albumName, int year, String musicName, String firstName, String lastName, int isSongWriter, int isComposer, int isArranger) {
		int personId = getOrAddPersonId(firstName, lastName);
		
		return insertPeopleInvolvedMusic(albumName, year, musicName, personId, isSongWriter, isComposer, isArranger);
	}
	
	public static int insertPeopleInvolvedMusic(String albumName, int year, String musicName, int personId, int isSongWriter, int isComposer, int isArranger) {
		if (isSongWriter < 0 || year < 0 || isComposer < 0 || isArranger < 0) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				PeopleInvolvedMusicAttributes.ALBUM_NAME,
				PeopleInvolvedMusicAttributes.YEAR,
				PeopleInvolvedMusicAttributes.MUSIC_NAME,
				PeopleInvolvedMusicAttributes.PEOPLE_INVOLVED_ID,
				PeopleInvolvedMusicAttributes.IS_SONGWRITER,
				PeopleInvolvedMusicAttributes.IS_COMPOSER,
				PeopleInvolvedMusicAttributes.IS_ARRANGER);
		
		List<Object> data = Arrays.asList(albumName, year, musicName, personId, isSongWriter, isComposer, isArranger);
		
		return DatabaseInserter.insert(Table.PEOPLE_INVOLVED_MUSIC, attributes, data);
	}
		
	// ===== INSERT MOVIE =====
	
	public static int insertMovie(String movieName, int year) {
		if ( year < 0 ) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(MovieAttributes.MOVIE_NAME, MovieAttributes.YEAR);
		List<Object> data = Arrays.asList(movieName, year);
		
		return DatabaseInserter.insert(Table.MOVIE, attributes, data);
	}
	
	public static int insertCrewMember(String firstName, String lastName, String movieName, int year) {
		int personId = getOrAddPersonId(firstName, lastName);
		
		return insertCrewMember(personId, movieName, year);
	}
	
	public static int insertCrewMember(int personId, String movieName, int year) {
		if ( year < 0 ) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				CrewMemberAttributes.PEOPLE_INVOLVED_ID,
				CrewMemberAttributes.MOVIE_NAME,
				CrewMemberAttributes.RELEASE_YEAR,
				CrewMemberAttributes.ROLE_ID);
		
		List<Object> data = Arrays.asList(personId, movieName, year, personId);
		return DatabaseInserter.insert(Table.CREW_MEMBER, attributes, data);
	}
	
	public static int insertAward(String firstName, String lastName, String movieName, int year, int award) {	
		int personId = getOrAddPersonId(firstName, lastName);
		
		return insertAward(personId, movieName, year, award);
	}
	
	public static int insertAward(int personId, String movieName, int year, int award) {
		if ( year < 0 || award < 0) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				AwardAttributes.PEOPLE_INVOLVED_ID,
				AwardAttributes.MOVIE_NAME,
				AwardAttributes.YEAR);
		
		List<Object> data = Arrays.asList(personId, movieName, year, award);
		return DatabaseInserter.insert(Table.AWARD, attributes, data);
	}
	
	public static int insertRole(String description) {
		List<String> attributes = Arrays.asList(RoleAttributes.DESCRIPTION);
		List<Object> data = Arrays.asList(description);
		
		return DatabaseInserter.insert(Table.ROLE, attributes, data);
	}
	
	// ===== INSERT MUSIC =====
	
	public static int insertMusic(String albumName, int year, String musicName, String producerFirstName, String producerLastName) {
		int producerId = getOrAddPersonId(producerFirstName, producerLastName);
		
		return insertMusic(albumName, year, musicName, producerId);
	}
	
	public static int insertMusic(String albumName, int year, String musicName, int producerId) {
		if ( year < 0 ) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				MusicAttributes.ALBUM_NAME,
				MusicAttributes.YEAR,
				MusicAttributes.MUSIC_NAME,
				MusicAttributes.PRODUCER_ID);
		
		List<Object> data = Arrays.asList(albumName, year, musicName, producerId);
		return DatabaseInserter.insert(Table.MUSIC, attributes, data);
	}
	
	public static int insertMusic(String albumName, int year, String musicName, String language, 
			String producerFirstName, String producerLastName) {
		
		int producerId = getOrAddPersonId(producerFirstName, producerLastName);
		
		return insertMusic(albumName, year, musicName, language, producerId);
	}
	
	public static int insertMusic(String albumName, int year, String musicName, String language, int producerId) {
		if ( year < 0 ) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				MusicAttributes.ALBUM_NAME,
				MusicAttributes.YEAR,
				MusicAttributes.MUSIC_NAME,
				MusicAttributes.LANGUAGE,
				MusicAttributes.PRODUCER_ID);
		
		List<Object> data = Arrays.asList(albumName, year, musicName, language, producerId);
		return DatabaseInserter.insert(Table.MUSIC, attributes, data);
	}
	
	public static int insertMusic(String albumName, int year, String musicName, char diskType, int producerId) {
		if ( year < 0 ) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				MusicAttributes.ALBUM_NAME,
				MusicAttributes.YEAR,
				MusicAttributes.MUSIC_NAME,
				MusicAttributes.DISK_TYPE,
				MusicAttributes.PRODUCER_ID);
		
		int diskNum = 0;
		if (diskType == 'v') {
			diskNum = 1;
		}
		
		List<Object> data = Arrays.asList(albumName, year, musicName, diskNum, producerId);
		return DatabaseInserter.insert(Table.MUSIC, attributes, data);
	}
	
	public static int insertMusic(String albumName, int year, String musicName, String language, char diskType, 
			String producerFirstName, String producerLastName) {
		
		int producerId = getOrAddPersonId(producerFirstName, producerLastName);
		
		return insertMusic(albumName, year, musicName, language, diskType, producerId);
	}
	
	public static int insertMusic(String albumName, int year, String musicName, String language, char diskType, int producerId) {
		if ( year < 0 ) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				MusicAttributes.ALBUM_NAME,
				MusicAttributes.YEAR,
				MusicAttributes.MUSIC_NAME,
				MusicAttributes.LANGUAGE,
				MusicAttributes.DISK_TYPE,
				MusicAttributes.PRODUCER_ID);
		
		int diskNum = 0;
		if (diskType == 'v') {
			diskNum = 1;
		}
		
		List<Object> data = Arrays.asList(albumName, year, musicName, language, diskNum, producerId);
		return DatabaseInserter.insert(Table.MUSIC, attributes, data);
	}
	
	public static int insertMusicSinger(String albumName, int year, String musicName, String firstName, String lastName) {
		int personId = getOrAddPersonId(firstName, lastName);
		
		return insertMusicSinger(albumName, year, musicName, personId);
	}
	
	public static int insertMusicSinger(String albumName, int year, String musicName, String firstName, String lastName, String middleName) {
		int personId = getOrAddPersonId(firstName, lastName, middleName);
		
		return insertMusicSinger(albumName, year, musicName, personId);
	}
	
	public static int insertMusicSinger(String albumName, int year, String musicName, int personId) {
		if ( year < 0 ) {
			return -1;
		}
		
		List<String> attributes = Arrays.asList(
				MusicSingerAttributes.ALBUM_NAME,
				MusicSingerAttributes.YEAR,
				MusicSingerAttributes.MUSIC_NAME,
				MusicSingerAttributes.PEOPLE_INVOLVED_ID);
		
		List<Object> data = Arrays.asList(albumName, year, musicName, personId);
		return DatabaseInserter.insert(Table.MUSIC_SINGER, attributes, data);
	}
	
	/**
	 * Gets the id of the person with the given first name and last name.
	 * If the person does not exist, it will add the person.
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public static int getOrAddPersonId(String firstName, String lastName) {
		int personId = DatabaseSelectHelper.getPersonInvolvedId(firstName, lastName);
		if (personId < 0) {
			insertPeopleInvolved(firstName, lastName);
			personId = DatabaseSelectHelper.getPersonInvolvedId(firstName, lastName);
		}
		
		return personId;
	}
	
	public static int getOrAddPersonId(String firstName, String lastName, String middleName) {
		int personId = DatabaseSelectHelper.getPersonInvolvedId(firstName, lastName);
		if (personId < 0) {
			insertPeopleInvolved(firstName, lastName, middleName);
			personId = DatabaseSelectHelper.getPersonInvolvedId(firstName, lastName);
		}
		
		return personId;
	}
}
