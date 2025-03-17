
package com.example.hastanedemo2;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Doktorlar d1=new Doktorlar("Bade", "Yıldırım", 123456789, "123BB6", "Kardiyoloji");
        Doktorlar d2=new Doktorlar("Ali", "Buldu", 1254, "1254", "Göz Doktoru");
        Doktorlar d3=new Doktorlar("Sinem", "Yıl", 12378, "12378", "Cerrah");
        Hastalar h1=new Hastalar("Mehmet", "Deniz", 123888923);
        Hastalar h2=new Hastalar("Ayse", "Yılmaz", 12456789);
        YatanHastalar yh1=new YatanHastalar("Derya","Solmaz",1001222,124);

        d1.BilgiGoster();
        d1.HastaEkle(yh1);
        d1.HastaEkle(h1);
        d1.ilacYaz(h1,"parol");
        d1.ilacYaz(yh1,"majezik","1");
        d1.taniKoy(h1,"grip");
        h1.receteGoruntule();
        yh1.receteGoruntule();
        h1.taniGoruntule();
        ArrayList<Doktorlar> doktorlar=Doktorlar.getDoktorlar();
        ArrayList<Hastalar> d1Hastastalari =d1.getHastalari();
        ArrayList<Hastalar> HastalarHepsi=Hastalar.getHastalar();
        System.out.println("Hastanede Çalışan Doktorlar");
        for(Doktorlar d: doktorlar){
            System.out.println(d);
        }
        System.out.println(d1+" Hastaları:");
        for(Hastalar h: d1Hastastalari){
            h.BilgiGoster();
        }
        System.out.println("Kaydı Bulunan Bütün Hastalar");
        for(Hastalar h: HastalarHepsi){
            System.out.println(h);
        }
        System.out.println("Toplam hasta sayısı: "+ Hastalar.getHastaNo());
        System.out.println(Hastalar.getHastaNo()+" hasta içindeki yatan hasta sayısı: "+ YatanHastalar.getYhastaNo());

        try{
            d1.taburcuEt(yh1);
        } catch (TaburcuException e) {
            e.printStackTrace();
        }

    }  }
