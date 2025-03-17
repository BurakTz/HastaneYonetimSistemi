
package com.example.hastanedemo2;

import java.util.ArrayList;

public class Hastalar {
    String isim;
    String soyisim;
    private long TC;
    String tani="tanımlanmadı";
    String recete="tanımlanmadı";
    Doktorlar doktor;
    private static int hastaNo = 0;
    public String randevu;
    public String randevuSaati;
    protected static ArrayList<Hastalar> hastalar = new ArrayList();

    public Hastalar(String isim, String soyisim, long TC) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.TC = TC;
        ++hastaNo;
        hastalar.add(this);
    }

    public static ArrayList<Hastalar> getHastalar() {
        return hastalar;
    }

    public String getIsim() {return isim;}

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getRandevuSaati() {
        return randevuSaati;
    }

    public void setRandevuSaati(String randevuSaati) {
        this.randevuSaati = randevuSaati;
    }

    public Long getTC() {
        return this.TC;
    }

    public static void setHastalar(ArrayList<Hastalar> hastalar) {
        Hastalar.hastalar = hastalar;
    }

    public static int getHastaNo() {
        return hastaNo;
    }

    public void receteGoruntule() {
        System.out.println(" "+this.recete);
    }

    public void taniGoruntule() {
        System.out.println(" "+this.tani);
    }
    public void BilgiGoster(){
        System.out.println("Hasta Adı: "+isim+" "+soyisim);
        System.out.println("Hasta TC kimlik no: "+TC);
        System.out.println("Tanı: "+ tani);
        System.out.println("Reçete: "+recete);

    }
    public String toString() {
        return this.isim + " " + this.soyisim + " " ;
    }
}
