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
    public static double MEALS_REIMBURSE = 37.00;
    public static double PARKING_REIMBURSE = 10.00;
    public static double TAXI_REIMBURSE = 20.00;
    public static double LODGING_REIMBURSE = 95.00;
    public static double MILES_REIMBURSE = 0.27;

    @Override
    public void start(Stage stage) {
        TextField numDays = new TextField();
        TextField amountAirfare = new TextField();
        TextField amountCarFees = new TextField();
        TextField numMilesDriven = new TextField();
        TextField amountParkingFees = new TextField();
        TextField amountTaxiFees = new TextField();
        TextField amountRegistrationFees = new TextField();
        TextField amountLodgingCharges = new TextField();
        
        Double days = Double.valueOf(numDays.getText());
        Double airfare = Double.valueOf(amountAirfare.getText());
        Double carFees = Double.valueOf(amountCarFees.getText());
        Double milesDriven = Double.valueOf(numMilesDriven.getText());
        Double parkingFees = Double.valueOf(amountParkingFees.getText());
        Double taxiFees = Double.valueOf(amountTaxiFees.getText());
        Double registrationFees = Double.valueOf(amountRegistrationFees.getText());
        Double lodgingCharges = Double.valueOf(amountLodgingCharges.getText());
        
        Double parkingFeesReimburse = (parkingFees < PARKING_REIMBURSE)? PARKING_REIMBURSE - parkingFees : PARKING_REIMBURSE;
        Double taxiFeesReimburse = (taxiFees < TAXI_REIMBURSE)? TAXI_REIMBURSE - taxiFees : TAXI_REIMBURSE;
        Double lodgingChargesReimburse = (lodgingCharges < LODGING_REIMBURSE)? LODGING_REIMBURSE - lodgingCharges : LODGING_REIMBURSE;
        Double totalReimburse = (MEALS_REIMBURSE * days) + (MILES_REIMBURSE * milesDriven) + lodgingChargesReimburse + taxiFeesReimburse + parkingFeesReimburse;
        
        Double totalExpenses = airfare + carFees + parkingFees + taxiFees + registrationFees + (lodgingCharges * days);
        
        Double excessExpenses = totalExpenses - totalReimburse;
    }

    public static void main(String[] args) {
        launch();
    }

}