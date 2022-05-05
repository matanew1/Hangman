package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Model {
	
	private static ArrayList<String> words;
	private static ArrayList<Character> letters;
	private String wordToFind;	
	
	public Model() {
		this.setWordToFind(null);
		Model.setLetters(new ArrayList<>());
		Model.setWords(new ArrayList<>(Arrays.asList("popcorn", "abal", "manman", "elden", "talsha", "talmel","elal","leah")));
		newWord();
	}
	

	public void addToLetters(char ch) {
		boolean exist = false;
		for (Character letter : Model.getLetters()) {
			if(letter.equals(ch)) {
				exist = true;
				System.out.println("already entered");
			}
		}
		if (!exist) {
			Model.getLetters().add(ch);	
		}
	}

	
	public void newWord() {
		Random rand = new Random();
		wordToFind = words.get(rand.nextInt(words.size()));
	}

	public static ArrayList<Character> getLetters() {
		return letters;
	}

	public static void setLetters(ArrayList<Character> letters) {
		Model.letters = letters;
	}

	public static ArrayList<String> getWords() {
		return words;
	}

	public static void setWords(ArrayList<String> words) {
		Model.words = words;
	}

	public String getWordToFind() {
		return wordToFind;
	}

	public void setWordToFind(String wordToFind) {
		this.wordToFind = wordToFind;
	}
	
	
	
	

}
