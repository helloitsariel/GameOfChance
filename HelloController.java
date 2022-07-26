package com.example.gameofchance;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class HelloController {
    public Label welcomeMessage;
    public Label title;
    public TextField nameTextBox;
    public Button firstEnter;
    public Label welcomeNameMessage;
    public String name;
    public Label cuteMessage;
    public Tab gameTab;
    public Button startGameButton;
    public TextField playerGuess;
    public Button guessButton;
    public Label ruleTitle;
    public Label ruleLine1;
    public Label ruleLine2;
    public Label ruleLine3;
    public Label score;
    public Label ruleLine4;
    public Label gameIntro;
    public Label gameName;
    public Label disclaimer;
    public Tab introTab;
    public Label firstNumber;
    public Label indicator;
    public Label error;
    String playerChoice;
    int playerScore;
    int gameScore;
    int firstNum;


    public void printName(ActionEvent actionEvent) {
        name = nameTextBox.getText();
        String message = "<player " + name + "> ready up your luck and switch to the game tab to start!";
        welcomeNameMessage.setText(message);
        cuteMessage.setText("have fun <3");
        nameTextBox.clear();
        gameTab.setDisable(false);
        nameTextBox.setDisable(true);
        firstEnter.setDisable(true);
    }

    public void startGame(ActionEvent actionEvent){
        playerGuess.setDisable(false);
        guessButton.setDisable(false);
        indicator.setText("");
        error.setText("");
        disclaimer.setText("note: type \"high\" for higher and \"low\" for lower");
        ruleTitle.setText("");
        ruleLine1.setText("");
        ruleLine2.setText("");
        ruleLine3.setText("");
        ruleLine4.setText("");
        gameName.setText("");
        gameIntro.setText("the first number is...");
        score.setText("LUCK: "+gameScore+"   "+name+": "+playerScore+"   ");
        int random = (int) (Math.random() * 100);
        int computerChoice;
        if (random >= 88) {
            computerChoice = 9;
        } else if(random >= 77){
            computerChoice = 8;
        } else if(random >= 66){
            computerChoice = 7;
        }else if(random >= 55){
            computerChoice = 6;
        }else if(random >= 44){
            computerChoice = 5;
        }else if(random >= 33){
            computerChoice = 4;
        }else if(random >= 22){
            computerChoice = 3;
        }else if(random >= 11){
            computerChoice = 2;
        } else {
            computerChoice = 1;
        }
        firstNumber.setText(String.valueOf(computerChoice));
        firstNum = computerChoice;
        startGameButton.setDisable(true);
    }

    public void enterGuess(ActionEvent actionEvent){
        indicator.setText("");
        error.setText("");
        playerChoice = playerGuess.getText();
        int random = (int) (Math.random() * 100);
        int computerChoice;
        if (random >= 90) {
            computerChoice = 9;
        } else if(random >= 80){
            computerChoice = 8;
        } else if(random >= 70){
            computerChoice = 7;
        }else if(random >= 60){
            computerChoice = 6;
        }else if(random >= 50){
            computerChoice = 5;
        }else if(random >= 40){
            computerChoice = 4;
        }else if(random >= 30){
            computerChoice = 3;
        }else if(random >= 20){
            computerChoice = 2;
        } else if(random >= 10){
            computerChoice = 1;
        } else {
            computerChoice = 0;
        }
        if (firstNum > computerChoice){
            if (playerChoice.equals("high")){
                gameScore++;
                indicator.setText("LOSE! The number was "+computerChoice+" :D");
                startGameButton.setDisable(false);
                playerGuess.setDisable(true);
                guessButton.setDisable(true);
            } else if (playerChoice.equals("low")){
                playerScore++;
                indicator.setText("win... The number was "+computerChoice+" :(");
                startGameButton.setDisable(false);
                playerGuess.setDisable(true);
                guessButton.setDisable(true);
            } else{
                error.setText("I didn't get that, please retype your guess");
            }
        } else if(firstNum < computerChoice){
            if (playerChoice.equals("high")){
                playerScore++;
                indicator.setText("win... The number was "+computerChoice+"  :(");
                startGameButton.setDisable(false);
                playerGuess.setDisable(true);
                guessButton.setDisable(true);
            } else if (playerChoice.equals("low")){
                gameScore++;
                indicator.setText("LOSE! The number was "+computerChoice+"  :D");
                startGameButton.setDisable(false);
                playerGuess.setDisable(true);
                guessButton.setDisable(true);
            } else{
                error.setText("I didn't get that, please retype your guess");
            }
        }
        score.setText("LUCK: "+gameScore+"   "+name+": "+playerScore+"   ");
        playerGuess.clear();
    }
}