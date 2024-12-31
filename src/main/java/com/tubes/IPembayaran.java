package com.tubes;

public interface IPembayaran{
    public void bayarEwallet(String nomorHpBisnis, double nominal);
    public void bayarQris(double nominal);
    public void bayarCash(double nominal);
}

