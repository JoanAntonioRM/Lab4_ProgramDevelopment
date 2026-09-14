package com.mycompany.lab4_programdevelopment;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        TextField numDays = new TextField();
        TextField amountAirfare = new TextField();
        TextField amountCarFees = new TextField();
        TextField numMilesDriven = new TextField();
        TextField amountParkingFees = new TextField();
        TextField amountTaxiFees = new TextField();
        TextField registrationFees = new TextField();
        TextField lodgingCharges = new TextField();
    }

    public static void main(String[] args) {
        launch();
    }

}