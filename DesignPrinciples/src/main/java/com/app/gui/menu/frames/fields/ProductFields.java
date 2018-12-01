package com.app.gui.menu.frames.fields;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public interface ProductFields {

	public String getDisplayName();
	
	// Unused atm
	public static <E extends Enum<E>> List<String> getDisplayNames(Class<E> dbAttributes) {
		List<String> names = new ArrayList<String>();
		for (E dataEnum : EnumSet.allOf(dbAttributes)) {
			names.add(dataEnum.name());
		}
		
		return names;
	}
}
