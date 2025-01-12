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
			w.addTraduzione(translation);
			mappaParole.put(alienWord, w);
		} else {
			mappaParole.get(alienWord).addTraduzione(translation);
			
		}
		
	}
	
	public String translateWord (String alienWord) {
		
		Word w = mappaParole.get(alienWord);
		if (w==null) 
			return null;
		
		String risultato= "";
		for (String p: w.getTraduzioni()) 
			risultato+= p+"\n";
		
		return risultato;
	}
	
	public String translateWordWildCard (String alienWord) {
		
		alienWord = alienWord.replaceAll("\\?", ".");
		int cont=0;
		String risultato= "";
		for (Word w: mappaParole.values()) {
			if (w.compareWild(alienWord)) {
				cont++;
				for (String p: w.getTraduzioni()) 
					risultato+= p+"\n";
			}
		}
		if (cont!=0)
			return risultato;
		else
			return null;
			
	}
	
	
	public void rimuoviTutto() {
		mappaParole.clear();
	}
	
	

}
