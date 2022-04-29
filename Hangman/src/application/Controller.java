package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Controller implements Initializable{


	public final static ArrayList<String> words = new ArrayList<String>(Arrays.asList("popcorn"));
	public String wordToFind;

	@FXML
	private Line body;

	@FXML
	private Button btnChar;

	@FXML
	private Label charFive;

	@FXML
	private Label charFour;

	@FXML
	private Label charOne;

	@FXML
	private Label charSix;

	@FXML
	private Label charThree;

	@FXML
	private Label charTwo;

	@FXML
	private Label charZero;

	@FXML
	private Circle circleHead;

	@FXML
	private Line lArm;

	@FXML
	private Label lEye;

	@FXML
	private Line lLeg;

	@FXML
	private Label lblChar;

	@FXML
	private Label mouth;

	@FXML
	private Line rArm;

	@FXML
	private Label rEye;

	@FXML
	private Line rLeg;

	@FXML
	private TextField textFieldChar;


	private ArrayList<Label> labels = new ArrayList<Label>();
	
	public static int targetSizeCounter = 0;
	
	@FXML
	void enteredChar(ActionEvent event) {
		boolean correct = false;

		String input = this.textFieldChar.getText();

		correct = checkInput(input);

		if(correct) {
			matchAndExpose(input.charAt(0));
			System.out.println(":)");
		}
		else {
			System.out.println(":(");
			
		}
		this.textFieldChar.clear();
		if(targetSizeCounter == wordToFind.length()) {
			System.out.println("win");
		}
	}

	private void matchAndExpose(char ch) {
		for (int i = 0; i < wordToFind.length(); i++) {
			if(wordToFind.charAt(i) == ch) {
				labels.get(i).setText(String.valueOf(ch));
				targetSizeCounter++;
			}
		}
	}

	private boolean checkInput(String input) {
		final int maxSize = 1;
		input.toLowerCase();
		char ch = input.charAt(0);
		if(input.length() > maxSize) {
			System.out.println("too long");
			return false;
		}
		if(ch < 'a' || ch > 'z') {
			System.out.println("not character");
			return false;
		}
		return true;		
	}
	public void newWord() {
		Random rand = new Random();
		wordToFind = words.get(rand.nextInt(words.size()));
	}
	private void setVisibleHangMan(boolean choice) {
		this.body.setVisible(choice);
		this.circleHead.setVisible(choice);
		this.rEye.setVisible(choice);
		this.lEye.setVisible(choice);
		this.rArm.setVisible(choice);
		this.lArm.setVisible(choice);
		this.rLeg.setVisible(choice);
		this.lLeg.setVisible(choice);
		this.mouth.setVisible(choice);
	}
	private void addLabels() {
		labels.add(charZero);
		labels.add(charOne);
		labels.add(charTwo);
		labels.add(charThree);
		labels.add(charFour);
		labels.add(charFive);
		labels.add(charSix);
	}
//	private void addHangman() {
//		labels.add(charZero);
//		labels.add(charOne);
//		labels.add(charTwo);
//		labels.add(charThree);
//		labels.add(charFour);
//		labels.add(charFive);
//		labels.add(charSix);
//	}
	private void setVisibleLabel(boolean choice) {

		for (Label label : labels) {
			label.setVisible(choice);
		}
	}
	private void setStart(String underScore) {
		for(int i = 0; i < underScore.length(); i ++) {
			this.labels.get(i).setText("_");
			this.labels.get(i).setVisible(true);
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		addLabels();
		setVisibleHangMan(false);
		setVisibleLabel(false);
		this.textFieldChar.clear();
		newWord();
		setStart(wordToFind);
		
	}




}
