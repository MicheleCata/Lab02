package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private Map <String, Word> mappaParole;
	
	public AlienDictionary () {
		mappaParole = new HashMap<>();
	}
	
	public void addWord (String alienWord, String translation) {
		Word w= null;
		if (mappaParole.get(alienWord)==null) {
			w= new Word (alienWord, translation);
			mappaParole.put(alienWord, w);
		} else {
			mappaParole.get(alienWord).setTranslation(translation);
		}
		
	}
	
	public String translateWord (String alienWord) {
		
		Word w = mappaParole.get(alienWord);
		if (w==null) 
			return null;
		
		return w.getTranslation();
	}
	
	public void rimuoviTutto() {
		mappaParole.clear();
	}
	
	

}
