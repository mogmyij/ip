package mab.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import mab.Mab;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        try{
            FXMLLoader loader = new FXMLLoader(Gui.class.getResource("/view/MainWindow.fxml"));
            AnchorPane root = loader.load();
            Scene s = new Scene(root);
            stage.setScene(s);
            loader.<MainWindow>getController().setMab(new Mab());
            assert stage != null: "javafx stage is null";
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
