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

import java.io.IOException;
import java.nio.ByteBuffer;

public class MainApp extends Application {

    private GridPane pane = new GridPane();
    private Label lblTitle, lblDirectAllocation, lblNativeUsed, lblmaxMemory;
    private Label valDirectAllocation, valNativeUsed, valmaxMemory;
    private Button btnUpdate, btnReopen;

    private static ByteBuffer humonguosBuffer = ByteBuffer.allocateDirect(1024*1024*1024);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Java Memory");
        this.initializeComponents();
        this.updateValues();
        this.placeComponents(stage);
        this.registerListener();
        stage.setResizable(false);
        stage.show();
    }

    private void initializeComponents() {
        lblTitle = new Label("Java Memory");
        lblTitle.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        lblDirectAllocation = new Label("Direct allocation:");
        lblNativeUsed = new Label("Native memory used:");
        lblmaxMemory = new Label("Max direct memory:");

        valDirectAllocation = new Label();
        valNativeUsed = new Label();
        valmaxMemory = new Label();

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
        pane.add(lblmaxMemory, 0, 4);

        pane.add(valDirectAllocation, 1, 2);
        pane.add(valNativeUsed, 1, 3);
        pane.add(valmaxMemory, 1, 4);

        pane.add(btnUpdate, 0, 6);

        pane.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(pane, 300, 250));
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
        this.valDirectAllocation.setText("" + humonguosBuffer.capacity());
        this.valNativeUsed.setText("" + sun.misc.SharedSecrets.getJavaNioAccess().getDirectBufferPool().getMemoryUsed());
        this.valmaxMemory.setText("" + sun.misc.VM.maxDirectMemory());
    }
}
