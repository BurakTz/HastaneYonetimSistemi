package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HastaReceteGoruntule {

    @FXML
    private Label recetelb;

    @FXML
    private Label tanilb;

    @FXML
    private Label taburlb;

    @FXML
    private Button ReceteBt;

    @FXML
    private Button TaniBt;

    @FXML
    private Button TaburBt;

    public Hastalar hasta;

    @FXML
    private void ReceteBt() {
        if(hasta.recete!=null)
        {
            recetelb.setText(hasta.recete);
        }
        else
        {
            recetelb.setText("Receteniz yazılmamış!");
        }
    }

    @FXML
    private void TaniBt() {
        if(hasta.tani!=null)
        {
            tanilb.setText(hasta.tani);
        }
        else
        {
            tanilb.setText("Tani koyulmamıs!");
        }

    }
    @FXML
    private void TaburBt() {
        if(hasta instanceof YatanHastalar)
        {
            if(((YatanHastalar) hasta).yatmaDurumu==true)
            {
                taburlb.setText("Hastamiz "+ ((YatanHastalar) hasta).getOdaNumarasi() +"numarali odada yatmaya devam ediyor.");
            }
            else
            {
                taburlb.setText("Hastamiz taburcu olmuştur.");
            }
        }
        else
        {
            taburlb.setText("Hastamiz yatan bir hasta degildir!");
        }
    }
}
