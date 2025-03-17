package com.example.hastanedemo2;
import java.util.ArrayList;

public abstract class Calisanlar {
    public String isim,soyisim;
    private long TC;
    public Calisanlar(String isim, String soyisim, long TC) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.TC = TC;
    }

    public long getTC() {

        return TC;
    }

    public void setTC(int TC) {
        this.TC = TC;
    }


    public abstract void BilgiGoster();







}
