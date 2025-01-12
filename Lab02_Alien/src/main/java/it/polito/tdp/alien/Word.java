package it.polito.tdp.alien;

import java.util.*;

public class Word {
	
	private String alienWord;
	private String translation;
	
	private List<String> traduzioni;
	
	public Word(String alienWord, String translation) {
		
		this.alienWord = alienWord;
		this.translation = translation;
		
		traduzioni = new LinkedList<>();
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	
	public String toString() {
		return "La parola aliena e' "+ this.alienWord + " con traduzione "+ this.translation;
	}
	
	public void addTraduzione (String translation) {
		if (!traduzioni.contains(translation))
			traduzioni.add(translation);
	}

	public List<String> getTraduzioni() {
		return traduzioni;
	}

	public boolean compareWild(String alienWord2) {
			if (alienWord.matches(alienWord2))
				return true;
		return false;
	}
	
	

}
