package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Controller implements Initializable{


	private Model model = new Model();

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private Line body;

	@FXML
	private Button btnChar;

	@FXML
	private Label charA;

	@FXML
	private Label charB;

	@FXML
	private Label charC;

	@FXML
	private Label charD;

	@FXML
	private Label charE;

	@FXML
	private Label charF;

	@FXML
	private Label charG;

	@FXML
	private Label charH;

	@FXML
	private Label charI;

	@FXML
	private Label charJ;

	@FXML
	private Label charK;

	@FXML
	private Label charL;

	@FXML
	private Label charM;

	@FXML
	private Label charN;

	@FXML
	private Label charO;

	@FXML
	private Label charP;

	@FXML
	private Label charQ;

	@FXML
	private Label charR;

	@FXML
	private Label charS;

	@FXML
	private Label charT;


	@FXML
	private Label charU;

	@FXML
	private Label charV;

	@FXML
	private Label charW;

	@FXML
	private Label charX;

	@FXML
	private Label charY;

	@FXML
	private Label charZ;

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
	
	private ArrayList<Label> letterLbl = new ArrayList<Label>();

	private ArrayList<Line> manLbl = new ArrayList<Line>();

	private ArrayList<Label> faceLbl = new ArrayList<Label>();

	public static int targetSizeCounter = 0;

	public static int manSizeCounter = 1;

	public static int faceCounter = 1;
	
	public static char alphabet = 'a';

	@FXML
	void enteredChar(ActionEvent event) {

		boolean correct = false;

		String input = this.textFieldChar.getText();
		correct = checkInput(input);

		if(correct) {
			model.addToLetters(input.charAt(0));
			matchAndExpose(input.charAt(0));	
			letterUsed(input);
		}
		this.textFieldChar.clear();
		if(targetSizeCounter == model.getWordToFind().length()) {
			msg("You won !! :)");
			retry();
		}
	}

	private void letterUsed(String input) {
		int count = 0;
		while(alphabet <= 'z') {
			if(alphabet == input.charAt(0)) {
				letterLbl.get(count).setText("✘");
			}
			count++;
			alphabet++;
		}
		alphabet = 'a';
	}


	private void matchAndExpose(char ch) {
		boolean found = false;
		for (int i = 0; i < model.getWordToFind().length(); i++) {
			if(model.getWordToFind().charAt(i) == ch) {
				labels.get(i).setText(String.valueOf(ch));
				targetSizeCounter++;
				found = true;
			}
		}
		if(!found) {
			if(!circleHead.isVisible())
				circleHead.setVisible(true);
			else if(!lLeg.isVisible()){
				for(int i = 0; i < manSizeCounter; i++) {
					manLbl.get(i).setVisible(true);
				}
				manSizeCounter++;
			}
			else if(!mouth.isVisible()) {
				for(int i = 0; i < faceCounter; i++) {
					faceLbl.get(i).setVisible(true);
				}
				faceCounter++;
			}
			if(mouth.isVisible()) {
				msg("You lost !! :(");
				retry();	
			}	
		}
	}

	private void retry() {
		Alert exit = new Alert(AlertType.CONFIRMATION);
		exit.setTitle(" ");
		exit.setHeaderText("Do you wanna play again ?");
		exit.getButtonTypes().set(0, new ButtonType("YES"));
		exit.getButtonTypes().set(1, new ButtonType("NO"));
		Optional<ButtonType> action = exit.showAndWait();
		if(action.get().getText().equals("YES"))
			newGame();
		else {
			Stage stage = (Stage) anchorPane.getScene().getWindow();
			stage.close();				
		}
	}
	
	public void msg(String str) {
		Alert lost = new Alert(AlertType.INFORMATION);
		lost.setTitle(" ");
		lost.setHeaderText(str);
		lost.showAndWait();
	}

	
	public boolean checkInput(String input) {
		final int maxSize = 1;
		input.toLowerCase();
		char ch = input.charAt(0);
		if(input.length() > maxSize) {
			msg("too long");
			return false;
		}
		if(ch < 'a' || ch > 'z') {
			msg("not character");
			return false;
		}
		return true;		
	}

	private void newGame() {
		labels = new ArrayList<Label>();
		manLbl = new ArrayList<Line>();
		faceLbl = new ArrayList<Label>();
		letterLbl = new ArrayList<Label>();
		targetSizeCounter = 0;
		manSizeCounter = 1;
		faceCounter = 1;
		initialize(null, null); 	
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
	private void addHangman() {
		manLbl.add(body);
		manLbl.add(rArm);
		manLbl.add(lArm);
		manLbl.add(rLeg);
		manLbl.add(lLeg);
	}

	private void addFace() {
		faceLbl.add(rEye);
		faceLbl.add(lEye);
		faceLbl.add(mouth);
	}
	private void addLettersLabels() {
		letterLbl.add(charA);
		letterLbl.add(charB);
		letterLbl.add(charC);
		letterLbl.add(charD);
		letterLbl.add(charE);
		letterLbl.add(charF);
		letterLbl.add(charG);
		letterLbl.add(charH);
		letterLbl.add(charI);
		letterLbl.add(charJ);
		letterLbl.add(charK);
		letterLbl.add(charL);
		letterLbl.add(charM);
		letterLbl.add(charN);
		letterLbl.add(charO);
		letterLbl.add(charP);
		letterLbl.add(charQ);
		letterLbl.add(charR);
		letterLbl.add(charS);
		letterLbl.add(charT);
		letterLbl.add(charU);
		letterLbl.add(charV);
		letterLbl.add(charW);
		letterLbl.add(charX);
		letterLbl.add(charY);
		letterLbl.add(charZ);
	}

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
		addHangman();
		addFace();
		addLettersLabels();
		setVisibleHangMan(false);
		setVisibleLabel(false);
		this.textFieldChar.clear();
		model.newWord();
		setStart(model.getWordToFind());
	}

}