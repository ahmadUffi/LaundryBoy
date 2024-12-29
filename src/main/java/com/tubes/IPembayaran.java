package com.tubes;

public interface IPembayaran{
    public void bayarEwallet(String nomorHpBisnis, int nominal);
    public void bayarQris(int nominal);
    public void bayarCash(int nominal);
}

