package com.tubes;

public interface IPembayaran{
<<<<<<< HEAD
    public void bayarEwallet(String nomorHpBisnis, int nominal);
    public void bayarQris(int nominal);
=======
    public void bayarEwallet(int nomorHpBisnis, int nominal);
    public void bayarQris(int nomorHpBisnis, int nominal);
>>>>>>> c5455a806402356649f0c20e93671706ebbb857e
    public void bayarCash(int nominal);
}

