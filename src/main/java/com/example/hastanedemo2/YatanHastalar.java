package com.example.hastanedemo2;

import java.util.ArrayList;

public class YatanHastalar extends Hastalar {
    private int odaNumarasi;
    public boolean yatmaDurumu = true;
    protected static ArrayList<YatanHastalar> yatanhastalar = new ArrayList();
    private static int yhastaNo=0;

    public YatanHastalar(String isim, String soyisim, long TC, int odaNumarasi) {
        super(isim, soyisim, TC);
        this.odaNumarasi = odaNumarasi;
        yhastaNo++;
        yatanhastalar.add(this);

    }

    public static ArrayList<YatanHastalar> getYatanhastalar() {
        return yatanhastalar;
    }

    public static void setYatanhastalar(ArrayList<YatanHastalar> yatanhastalar) {
        YatanHastalar.yatanhastalar = yatanhastalar;
    }
    public static int getYhastaNo(){
        return yhastaNo;
    }

    public int getOdaNumarasi() {
        return this.odaNumarasi;
    }

    public void setOdaNumarasi(int odaNumarasi) {
        this.odaNumarasi = odaNumarasi;
    }

    public void BilgiGoster(){
        System.out.println("Hasta Adı: "+isim+" "+soyisim);
        System.out.println("Hasta TC kimlik no: "+getTC());
        System.out.println("Tanı: "+ tani);
        System.out.println("Reçete: "+recete);
        System.out.println("Oda No: "+odaNumarasi);

    }
}

