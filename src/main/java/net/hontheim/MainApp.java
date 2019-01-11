package net.hontheim;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.nio.ByteBuffer;

public class MainApp extends Application {

    private GridPane pane = new GridPane();
    private Label lblTitle, lblDirectAllocation, lblNativeUsed, lblMaxMemory, lblRuntimeMax, lblRuntimeFree, lblRuntimeTotal;
    private Label descDirectAllocation, descNativeUsed, descMaxMemory, descRuntimeMax, descRuntimeFree, descRuntimeTotal;
    private Label valDirectAllocation, valNativeUsed, valMaxMemory, valRuntimeMax, valRuntimeFree, valRuntimeTotal;
    private Button btnUpdate;

    private static ByteBuffer buffer = ByteBuffer.allocateDirect(1024*1024*1024);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
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

        lblDirectAllocation = new Label("Direct allocation:");
        lblNativeUsed = new Label("Native memory used:");
        lblMaxMemory = new Label("Max direct memory:");

        descDirectAllocation = new Label("ByteBuffer.capacity();");
        descDirectAllocation.setStyle("-fx-font-family: monospace");
        descNativeUsed = new Label("sun.misc.SharedSecrets.getJavaNioAccess().getDirectBufferPool().getMemoryUsed();");
        descNativeUsed.setStyle("-fx-font-family: monospace");
        descMaxMemory = new Label("sun.misc.VM.maxDirectMemory();");
        descMaxMemory.setStyle("-fx-font-family: monospace");

        valDirectAllocation = new Label();
        valNativeUsed = new Label();
        valMaxMemory = new Label();

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

        pane.add(lblDirectAllocation, 0, 2);
        pane.add(lblNativeUsed, 0, 3);
        pane.add(lblMaxMemory, 0, 4);

        pane.add(descDirectAllocation, 1, 2);
        pane.add(descNativeUsed, 1, 3);
        pane.add(descMaxMemory, 1, 4);

        pane.add(valDirectAllocation, 2, 2);
        pane.add(valNativeUsed, 2, 3);
        pane.add(valMaxMemory, 2, 4);

        pane.add(lblRuntimeMax, 0, 6);
        pane.add(lblRuntimeFree, 0, 7);
        pane.add(lblRuntimeTotal, 0, 8);

        pane.add(descRuntimeMax, 1, 6);
        pane.add(descRuntimeFree, 1, 7);
        pane.add(descRuntimeTotal, 1, 8);

        pane.add(valRuntimeMax, 2, 6);
        pane.add(valRuntimeFree, 2, 7);
        pane.add(valRuntimeTotal, 2, 8);

        pane.add(btnUpdate, 0, 10);

        pane.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(pane, 900, 375));
    }

    private void registerListener() {
        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateValues();
            }
        });
    }

    private void updateValues() {
        this.valDirectAllocation.setText("" + buffer.capacity());
        this.valNativeUsed.setText("" + sun.misc.SharedSecrets.getJavaNioAccess().getDirectBufferPool().getMemoryUsed());
        this.valMaxMemory.setText("" + sun.misc.VM.maxDirectMemory());

        this.valRuntimeMax.setText("" + Runtime.getRuntime().maxMemory());
        this.valRuntimeFree.setText("" + Runtime.getRuntime().freeMemory());
        this.valRuntimeTotal.setText("" + Runtime.getRuntime().totalMemory());
    }
}
