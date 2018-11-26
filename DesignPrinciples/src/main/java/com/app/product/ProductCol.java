package com.app.product;

public enum ProductCol {
	BOOK("Book", BookCol.class),
	MUSIC("Music", MusicCol.class);
	
	private String name;
	private Class<?> enumClass;
	
	private <E extends Enum<E>> ProductCol(String name, Class<E> enumClass) {
		this.name = name;
		this.enumClass = enumClass;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Class<?> getEnum() {
		return enumClass;
	}
}
