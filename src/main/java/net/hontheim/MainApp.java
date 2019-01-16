package net.hontheim;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private final GridPane pane = new GridPane();
    private Label lblTitle, lblRuntimeMax, lblRuntimeFree, lblRuntimeTotal;
    private Label descRuntimeMax, descRuntimeFree, descRuntimeTotal;
    private Label valRuntimeMax, valRuntimeFree, valRuntimeTotal;
    private Button btnUpdate;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Java Memory");
        this.initializeComponents();
        this.placeComponents(stage);
        this.registerListener();
        stage.show();
        this.updateValues();
    }

    private void initializeComponents() {
        lblTitle = new Label("Java Memory");
        lblTitle.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        lblRuntimeMax = new Label("Runtime max memory:");
        lblRuntimeFree = new Label("Runtime free memory:");
        lblRuntimeTotal = new Label("Runtime total memory:");

        descRuntimeMax = new Label("Runtime.getRuntime().maxMemory();");
        descRuntimeMax.setStyle("-fx-font-family: monospace");
        descRuntimeFree = new Label("Runtime.getRuntime().freeMemory();");
        descRuntimeFree.setStyle("-fx-font-family: monospace");
        descRuntimeTotal = new Label("Runtime.getRuntime().totalMemory();");
        descRuntimeTotal.setStyle("-fx-font-family: monospace");

        valRuntimeMax = new Label();
        valRuntimeFree = new Label();
        valRuntimeTotal = new Label();

        btnUpdate = new Button("Update");
        btnUpdate.setDefaultButton(true);
    }

    private void placeComponents(Stage stage) {
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(15, 25, 15, 25));

        pane.add(lblTitle, 0, 0, 2, 1);

        pane.add(lblRuntimeMax, 0, 2);
        pane.add(lblRuntimeFree, 0, 3);
        pane.add(lblRuntimeTotal, 0, 4);

        pane.add(descRuntimeMax, 1, 2);
        pane.add(descRuntimeFree, 1, 3);
        pane.add(descRuntimeTotal, 1, 4);

        pane.add(valRuntimeMax, 2, 2);
        pane.add(valRuntimeFree, 2, 3);
        pane.add(valRuntimeTotal, 2, 4);

        pane.add(btnUpdate, 0, 6);

        pane.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(pane, 600, 300));
    }

    private void registerListener() {
        btnUpdate.setOnAction(event -> updateValues());
    }

    private void updateValues() {
        this.valRuntimeMax.setText("" + Runtime.getRuntime().maxMemory());
        this.valRuntimeFree.setText("" + Runtime.getRuntime().freeMemory());
        this.valRuntimeTotal.setText("" + Runtime.getRuntime().totalMemory());
    }
}
