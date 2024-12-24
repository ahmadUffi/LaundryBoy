package com.tubes;

public class Pembayaran implements IPembayaran {
    private Invoice invoice; // Referensi ke invoice yang akan dibayar

    public Pembayaran(Invoice invoice) {
        this.invoice = invoice; // Inisialisasi invoice
    }

    @Override
    public void bayarEwallet(int nomorHpBisnis, int nominal) {
        if (nominal >= invoice.getBiayaTagihan()) {
            System.out.println("Pembayaran menggunakan eWallet berhasil.");
            System.out.println("Nomor HP Bisnis: " + nomorHpBisnis);
            System.out.println("Nominal: " + nominal);
            invoice.setStatusLaundry("selesai"); // Mengubah status invoice menjadi selesai
            System.out.println("Status invoice telah diubah menjadi 'selesai'.");
        } else {
            System.out.println("Pembayaran gagal. Nominal tidak cukup.");
        }
    }

    @Override
    public void bayarQris(int nomorHpBisnis, int nominal) {
        if (nominal >= invoice.getBiayaTagihan()) {
            System.out.println("Pembayaran menggunakan QRIS berhasil.");
            System.out.println("Nomor HP Bisnis: " + nomorHpBisnis);
            System.out.println("Nominal: " + nominal);
            invoice.setStatusLaundry("selesai"); // Mengubah status invoice menjadi selesai
            System.out.println("Status invoice telah diubah menjadi 'selesai'.");
        } else {
            System.out.println("Pembayaran gagal. Nominal tidak cukup.");
        }
    }

    @Override
    public void bayarCash(int nominal) {
        if (nominal >= invoice.getBiayaTagihan()) {
            System.out.println("Pembayaran tunai berhasil.");
            System.out.println("Nominal: " + nominal);
            invoice.setStatusLaundry("selesai"); // Mengubah status invoice menjadi selesai
            System.out.println("Status invoice telah diubah menjadi 'selesai'.");
        } else {
            System.out.println("Pembayaran gagal. Nominal tidak cukup.");
        }
    }
}
