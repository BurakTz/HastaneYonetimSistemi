package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.List;

public class RandevuEkrani {

    @FXML
    private ComboBox<Doktorlar> doktorComboBox;

    @FXML
    private ComboBox<String> saatComboBox;

    @FXML
    private TextArea randevuAl;

    @FXML
    private TextArea randevuGoruntule;

    public Hastalar hasta;

    public Doktorlar doktor;

    @FXML
    public void initialize() {

        doktorComboBox.getItems().addAll(Doktorlar.getDoktorlar());
        doktorComboBox.setOnAction(e -> doktorSecildi());
    }

    private void doktorSecildi() {

        saatComboBox.getItems().clear();


        Doktorlar secilenDoktor = doktorComboBox.getSelectionModel().getSelectedItem();
        if (secilenDoktor != null) {
            List<String> uygunSaatler = secilenDoktor.getUygunSaatler();
            saatComboBox.getItems().addAll(uygunSaatler);
        }
    }

    @FXML
    private void RandevuAlBt() {

        if (hasta.randevu != null && !hasta.randevu.isEmpty()) {
            randevuAl.setText("Hata: Daha önce randevu alındı.");
            return;
        }

        Doktorlar secilenDoktor = doktorComboBox.getSelectionModel().getSelectedItem();
        String secilenSaat = saatComboBox.getSelectionModel().getSelectedItem();

        if (secilenDoktor == null) {
            randevuAl.setText("Lütfen bir doktor seçin!");
            return;
        }

        if (secilenSaat == null) {
            randevuAl.setText("Lütfen bir saat seçin!");
            return;
        }


        boolean randevuAlindi = secilenDoktor.randevuKontrol(secilenSaat);
        if (randevuAlindi) {

            hasta.randevu = "Doktor: " + secilenDoktor ;
            hasta.randevuSaati=" Saat: " + secilenSaat ;
            randevuAl.setText("Randevu alındı: " + hasta.randevu);
            hasta.doktor=secilenDoktor;
            hasta.doktor.HastaEkle(hasta);


            if (doktor.getHastalari().contains(hasta)) {
                System.out.println("Hasta başarıyla eklendi: " + hasta.getIsim() + " " + hasta.getSoyisim());
            } else {
                System.out.println("Hata: Hasta listeye eklenemedi!");
            }


        } else {
            randevuAl.setText("Seçilen saat dolu. Lütfen başka bir saat seçin.");
        }
    }
    @FXML
    private void onrandevuGoruntuleBt() {
        if(hasta.randevu!=null){
            randevuGoruntule.setText(hasta.randevu+" "+hasta.randevuSaati);
        }
        else{
            randevuGoruntule.setText("Randevu alınmamış");
        }
        for (Hastalar hasta : doktor.getHastalari()) {
            System.out.println(hasta.getIsim() + " " + hasta.getSoyisim());
        }

    }

}