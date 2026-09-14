package com.mycompany.lab4_programdevelopment2026;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
        
        //TEXTFIELDS
        TextField numDays = new TextField();
        TextField amountAirfare = new TextField();
        TextField amountCarFees = new TextField();
        TextField numMilesDriven = new TextField();
        TextField amountParkingFees = new TextField();
        TextField amountTaxiFees = new TextField();
        TextField amountRegistrationFees = new TextField();
        TextField amountLodgingCharges = new TextField();
        
        //LABELS
        Label daysLabel = new Label("Enter Number of days on the trip:");
        Label airFareLabel = new Label("Enter Amount of airfare, if any:");
        Label carFeesLabel = new Label("Enter Amount of car rental fees, if any:");
        Label milesDrivenLabel = new Label("Enter Number of miles driven, if a private vehicle was used:");
        Label parkingFeesLabel = new Label("Enter Amount of parking fees, if any:");
        Label taxiFeesLabel = new Label("Enter Amount of taxi charges, if any:");
        Label registrationFeesLabel = new Label("Enter Conference or seminar registration fees, if any:");
        Label lodgingChargesLabel = new Label("Enter Lodging charges, per night:");
        Button btnCalculate = new Button("Calculate");
        Label resultLabel = new Label();
        
        //BUTTON CALCULATE EVENT HANDLER
        btnCalculate.setOnAction(e -> {
            try {
                //PARSE NUMBERS
                Double days = Double.valueOf(numDays.getText());
                Double airfare = Double.valueOf(amountAirfare.getText());
                Double carFees = Double.valueOf(amountCarFees.getText());
                Double milesDriven = Double.valueOf(numMilesDriven.getText());
                Double parkingFees = Double.valueOf(amountParkingFees.getText());
                Double taxiFees = Double.valueOf(amountTaxiFees.getText());
                Double registrationFees = Double.valueOf(amountRegistrationFees.getText());
                Double lodgingCharges = Double.valueOf(amountLodgingCharges.getText());
                
                //CALCULATE REIMBURSEMENT
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
                
                if(totalExpenses == 0){
                    totalReimburse = 0.0;
                    amountSaved = 0.0;
                }
                
                resultLabel.setText(String.format("Total Reimbursement: $%.2f%nExcess Expenses: $%.2f%nAmount Saved: $%.2f", totalReimburse, excessExpenses, amountSaved));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers in all fields.");
            }
        });
        
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));
        
        //CONFIGURE PANE
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        
        grid.add(daysLabel, 0, 0);
        grid.add(numDays, 1, 0);
        
        grid.add(airFareLabel, 0, 1);
        grid.add(amountAirfare, 1, 1);
        
        grid.add(carFeesLabel, 0, 2);
        grid.add(amountCarFees, 1, 2);
        
        grid.add(milesDrivenLabel, 0, 3);
        grid.add(numMilesDriven, 1, 3);
        
        grid.add(parkingFeesLabel, 0, 4);
        grid.add(amountParkingFees, 1, 4);
        
        grid.add(taxiFeesLabel, 0, 5);
        grid.add(amountTaxiFees, 1, 5);
        
        grid.add(registrationFeesLabel, 0, 6);
        grid.add(amountRegistrationFees, 1, 6);
        
        grid.add(lodgingChargesLabel, 0, 7);
        grid.add(amountLodgingCharges, 1, 7);
        
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(btnCalculate);
        
        grid.add(buttonBox, 0, 8);
        
        grid.add(resultLabel, 0, 9);
        GridPane.setColumnSpan(resultLabel, 2);
        
        root.setCenter(grid);
        
        //SET STAGE
        Scene scene = new Scene(root, 640, 480);
        stage.setTitle("Business Expense Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}