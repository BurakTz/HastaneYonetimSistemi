
package com.example.hastanedemo2;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    public HelloApplication() {
    }

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Doktorlar d1=new Doktorlar("Bade", "Yıldırım", 123456789, "123BB6", "Kardiyoloji");
        Doktorlar d2=new Doktorlar("Ali", "Buldu", 1254, "1254", "Göz Doktoru");
        Doktorlar d3=new Doktorlar("Sinem", "Yıl", 12378, "12378", "Cerrah");
        Hastalar h1=new Hastalar("Mehmet", "Deniz", 123888923);
        Hastalar h2=new Hastalar("Ayse", "Yılmaz", 12456789);
        YatanHastalar yh1=new YatanHastalar("Derya","Solmaz",1001222,124);



        Scene scene = new Scene((Parent)fxmlLoader.load(), 350.0, 300.0);
        stage.setTitle("Hastane Yönetim Sistemi");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}
