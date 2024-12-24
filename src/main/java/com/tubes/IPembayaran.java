package com.tubes;

public interface IPembayaran{
    public void bayarEwallet(int nomorHpBisnis, int nominal);
    public void bayarQris(int nomorHpBisnis, int nominal);
    public void bayarCash(int nominal);
}

