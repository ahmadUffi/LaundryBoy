package com.tubes;

public class Pembayaran implements IPembayaran {

    public Pembayaran(String nama, String alamat, int noHp) {
        // Konstruktor, jika diperlukan
    }

    @Override
    public void bayarEwallet(int nomorHpBisnis, int nominal) {
        System.out.println("Pembayaran menggunakan eWallet berhasil.");
        System.out.println("Nomor HP Bisnis: " + nomorHpBisnis);
        System.out.println("Nominal: " + nominal);
    }

    @Override
    public void bayarQris(int nomorHpBisnis, int nominal) {
        System.out.println("Pembayaran menggunakan QRIS berhasil.");
        System.out.println("Nomor HP Bisnis: " + nomorHpBisnis);
        System.out.println("Nominal: " + nominal);
    }

    @Override
    public void bayarCash(int nominal) {
        System.out.println("Pembayaran tunai berhasil.");
        System.out.println("Nominal: " + nominal);
    }
}



// package com.tubes;

// public class Pembayaran implements IPembayaran{
//     // private int nomorHpBisnis;
//     // private int nominal;
//     private Invoice[] tagihan; 

//     public Pembayaran(String nama, String alamat, int noHp){
//         // super(nama,alamat,noHp);
//     }
//     public void bayarEwallet(int nomorHpBisnis, int nominal){
        
//     }
//     public void bayarQris(int nomorHpBisnis, int nominal){

//     }
//     public void bayarCash(int nominal){

//     }

// }