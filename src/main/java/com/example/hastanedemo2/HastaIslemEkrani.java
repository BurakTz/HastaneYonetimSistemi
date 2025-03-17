package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HastaIslemEkrani {

    @FXML
    private Button HastaRandevubt;

    @FXML
    private Button HastaReçetebt;

    private Hastalar girisyapanhasta;

    public void setHasta(Hastalar hasta) {
        this.girisyapanhasta = hasta;
    }



    private void hataGoster(AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    protected void onHastaRandevubt() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("randevu.fxml"));
        Pane root;
        try {
            root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Randevu Ekranı");
            stage.setScene(new Scene(root, 450, 400));
            RandevuEkrani controller = loader.getController();
            controller.hasta = girisyapanhasta;
            stage.show();
        } catch (IOException e) {
            hataGoster(AlertType.ERROR, "Hata!", "HATA!", "Randevu ekranı yüklenemedi.");
        }
    }
    @FXML
    protected void onHastaRecetebt() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("taniverecetegoruntule.fxml"));
        Pane root;
        try {
            root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Recete ve Tani Ekrani");
            stage.setScene(new Scene(root, 450, 350));
            HastaReceteGoruntule controller = loader.getController();
            controller.hasta = girisyapanhasta;
            stage.show();
        } catch (IOException e) {
            hataGoster(AlertType.ERROR, "Hata!", "HATA!", "Randevu ekranı yüklenemedi.");
        }
    }
}
