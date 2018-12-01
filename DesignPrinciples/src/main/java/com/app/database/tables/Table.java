package com.app.database.tables;

public enum Table {
	BOOK("Book"),
	BOOK_AUTHOR("BookAuthor"),
	BOOK_KEYWORD("BookKeyword"),
	CREW_MEMBER("CrewMember"),
	KEYWORD("Keyword"),
	MOVIE("Movie"),
	MUSIC("Music"),
	MUSIC_SINGER("MusicSinger"),
	PEOPLE_INVOLVED("PeopleInvolved"),
	PEOPLE_INVOLVED_MUSIC("PeopleInvolvedMusic"),
	ROLE("Role");	
	
	private final String tableName;
	
	private Table(String name) {
		this.tableName = name;
	}
	
	public String getTableName() {
		return this.tableName;
	}
	
}
