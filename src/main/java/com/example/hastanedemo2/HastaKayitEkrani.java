package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class HastaKayitEkrani {

    @FXML
    private TextField isimEntry;

    @FXML
    private TextField soyisimEntry;

    @FXML
    private TextField TCEntry;

    @FXML
    private TextField yatakNoEntry;

    @FXML
    private TextField TC2Entry;

    @FXML
    private Button HastaEkleBt;

    @FXML
    private Button HastaSilBt;

    @FXML
    private Button HastaListeleBt;


    @FXML
    private void HastaEkleBt() {
        try {
            String isim = isimEntry.getText();
            String soyisim = soyisimEntry.getText();
            long TC = Long.parseLong(TCEntry.getText());
            String yatakNo = yatakNoEntry.getText();


            if (yatakNo != null && !yatakNo.isEmpty()) {

                YatanHastalar yeniHasta = new YatanHastalar(isim, soyisim, TC, Integer.parseInt(yatakNo));
                hataGoster(AlertType.INFORMATION, "Yatan Hasta Kayıt", "Yatan hasta başarıyla eklendi!", "Hasta: " + isim + " " + soyisim + ", Yatak No: " + yatakNo);
            } else {

                Hastalar yeniHasta = new Hastalar(isim, soyisim, TC);
                hataGoster(AlertType.INFORMATION, "Hasta Kayıt", "Hasta başarıyla eklendi!", "Hasta: " + isim + " " + soyisim);
            }


            alanlariTemizle();
        } catch (NumberFormatException e) {
            hataGoster(AlertType.ERROR, "Hata", "Geçersiz TC veya Yatak No", "Lütfen TC ve Yatak No alanlarına sadece sayı giriniz.");
        }
    }


    @FXML
    private void HastaSilBt() {
        try {
            long TC = Long.parseLong(TC2Entry.getText());
            boolean bulundu = false;
            for (int i = 0; i < Hastalar.hastalar.size(); i++) {
                if (Hastalar.hastalar.get(i).getTC() == TC) {
                    Hastalar.hastalar.remove(i);
                    bulundu = true;
                    hataGoster(AlertType.INFORMATION, "Hasta Silme", "Hasta başarıyla silindi!", "TC: " + TC);
                    break;
                }
            }
            if (!bulundu) {
                hataGoster(AlertType.ERROR, "Hata", "Hasta bulunamadı", "Bu TC ile kayıtlı hasta yok.");
            }
            TC2Entry.clear();
        } catch (NumberFormatException e) {
            hataGoster(AlertType.ERROR, "Hata", "Geçersiz TC", "Lütfen TC alanına sadece sayı giriniz.");
        }
    }


    @FXML
    private void HastaListeleBt() {
        String liste = "Kayıtlı Hastalar:\n";
        for (Hastalar h : Hastalar.getHastalar())
            if (h instanceof YatanHastalar) {
                liste += "Isim: " + h.isim + " " + h.soyisim + ", TC: " + h.getTC() + ", Oda No: " + ((YatanHastalar) h).getOdaNumarasi() + "\n";
            } else {
                liste += "Isim: " + h.isim + " " + h.soyisim + ", TC: " + h.getTC() + "\n";
            }
        hataGoster(AlertType.INFORMATION, "Hasta Listesi", "Hastalar", liste);
    }


    private void hataGoster(AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }


    private void alanlariTemizle() {
        isimEntry.clear();
        soyisimEntry.clear();
        TCEntry.clear();
        yatakNoEntry.clear();
    }
}