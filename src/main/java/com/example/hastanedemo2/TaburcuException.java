package com.example.hastanedemo2;

public class TaburcuException extends Exception{
    public TaburcuException(String message) {
        super("Hasta Taburcu Edilemedi\n"+message);
    }
}
