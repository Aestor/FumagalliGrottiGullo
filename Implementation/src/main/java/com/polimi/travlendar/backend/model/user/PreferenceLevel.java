package com.polimi.travlendar.backend.model.user;

import java.util.ArrayList;
/**
 * 
 * @author Aestor
 */
public enum PreferenceLevel {

	HIGH("High", 3), MEDIUM("Medium", 2), LOW("Low", 1);
	
	private String preference;
	private int level;
	
	private PreferenceLevel(String preference, int i) {
		
		this.preference=preference;
		this.level=i;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

    public static ArrayList<String> getAsList(){
        ArrayList<String> temp = new ArrayList<>();
        temp.add(PreferenceLevel.HIGH.preference);
        temp.add(PreferenceLevel.MEDIUM.preference);
        temp.add(PreferenceLevel.LOW.preference);
        return temp;
    }
	
	

}
