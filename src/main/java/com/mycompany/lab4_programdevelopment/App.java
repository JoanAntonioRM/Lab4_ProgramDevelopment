package com.mycompany.lab4_programdevelopment;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
        
        Double amountSaved = 0.0;
        if(excessExpenses < 0){
            amountSaved = excessExpenses * -1;
            excessExpenses = 0.0;
        }
        
        Label daysLabel = new Label("Enter Number of days on the trip:");
        Label airFareLabel = new Label("Enter Amount of airfare, if any:");
        Label carFeesLabel = new Label("Enter Amount of car rental fees, if any:");
        Label milesDrivenLabel = new Label("Enter Number of miles driven, if a private vehicle was used:");
        Label parkingFeesLabel = new Label("Enter Amount of parking fees, if any:");
        Label taxiFeesLabel = new Label("Enter Amount of taxi charges, if any:");
        Label registrationFeesLabel = new Label("Enter Conference or seminar registration fees, if any:");
        Label lodgingChargesLabel = new Label("Enter Lodging charges, per night:");
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        Scene scene = new Scene(gridPane, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}