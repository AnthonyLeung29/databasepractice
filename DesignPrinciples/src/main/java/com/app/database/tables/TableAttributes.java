package com.app.database.tables;

/**
 * A class to contain all the attribute names for each table that exists in the database. <br>
 * Note that even for weak entities, they have their own independent attribute name since 
 * the actual key name could differ slightly in the tables. 
 * 
 * @author antho
 *
 */
public class TableAttributes {

	// Accurate as of Dec 1st, 2018
	// Note, the tables here are ordered exactly like how it is in the script
	
	public class BookAttributes {
		public static final String ISBN = "ISBN";
		public static final String TITLE = "Title";
		public static final String PUBLISHER = "Publisher";
		public static final String NUMBER_OF_PAGES = "NumberOfPages";
		public static final String YEAR_OF_PUBLICATION = "YearOfPublication";
		public static final String EDITION_NUMBER = "EditionNumber";
		public static final String ABSTRACT = "Abstract";
	}
	
	public class PeopleInvolvedAttributes {
		public static final String ID = "ID";
		public static final String FIRST_NAME = "FirstName";
		public static final String MIDDLE_NAME = "MiddleName";
		public static final String FAMILY_NAME = "FamilyName";
		public static final String GENDER = "Gender";
	}
	
	public class BookAuthorAttributes {
		public static final String ISBN = "ISBN";
		public static final String AUTHOR_ID = "Author_id";
	}
	
	public class KeywordAttributes {
		public static final String ID = "ID";
		public static final String TAG = "Tag";
	}
	
	public class BookKeywordAttributes {
		public static final String ISBN = "ISBN";
		public static final String KEYWORD_ID = "Keyword_ID";
	}
	
	public class MovieAttributes {
		public static final String MOVIE_NAME = "MovieName";
		public static final String YEAR = "Year";
	}

	public class MusicAttributes {
		public static final String ALBUM_NAME = "AlbumName";
		public static final String YEAR = "Year";
		public static final String MUSIC_NAME = "MusicName";
		public static final String LANGUAGE = "Language";
		public static final String DISK_TYPE = "DiskType";
		public static final String PRODUCER_ID = "Producer_ID";
	}
	
	public class MusicSingerAttributes {
		public static final String ALBUM_NAME = "AlbumName";
		public static final String YEAR = "Year";
		public static final String MUSIC_NAME = "MusicName";
		public static final String PEOPLE_INVOLVED_ID = "PeopleInvolved_ID";
	}
	
	public class PeopleInvolvedMusicAttributes {
		public static final String ALBUM_NAME = "AlbumName";
		public static final String YEAR = "Year";
		public static final String MUSIC_NAME = "MusicName";
		public static final String PEOPLE_INVOLVED_ID = "PeopleInvolved_ID";
		public static final String IS_SONGWRITER = "IsSongwriter";
		public static final String IS_COMPOSER = "IsComposer";
		public static final String IS_ARRANGER = "IsArranger";
	}

	public class RoleAttributes {
		public static final String ROLE_ID = "ID";
		public static final String DESCRIPTION = "Description";
	}
	
	public class CrewMemberAttributes {
		public static final String PEOPLE_INVOLVED_ID = "PeopleInvolved_ID";
		public static final String MOVIE_NAME = "MovieName";
		public static final String RELEASE_YEAR = "ReleaseYear";
		public static final String ROLE_ID = "Role_ID";
	}
	
	public class AwardAttributes {
		public static final String PEOPLE_INVOLVED_ID = "PeopleInvolved_ID";
		public static final String MOVIE_NAME = "MovieName";
		public static final String YEAR = "Year";
		public static final String AWARE = "Award";
	}
}
