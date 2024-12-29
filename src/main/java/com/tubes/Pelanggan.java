package com.tubes;

import com.tubes.admin.PegawaiAdmin;

public class Pelanggan {
    private String nama;
    private String alamat;
    private int noHp;

    public Pelanggan(String nama, String alamat, int noHp) {
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getNoHp() {
        return noHp;
    }

    public void bayarTagihan(Invoice invoice, int nominal, String metodePembayaran) {
        Pembayaran pembayaran = new Pembayaran(invoice); // Membuat objek Pembayaran dengan invoice yang akan dibayar

<<<<<<< HEAD
        switch (metodePembayaran.toLowerCase()) {   
=======
        switch (metodePembayaran.toLowerCase()) {
>>>>>>> c5455a806402356649f0c20e93671706ebbb857e
            case "ewallet":
                pembayaran.bayarEwallet(noHp, nominal);
                break;
            case "qris":
                pembayaran.bayarQris(noHp, nominal);
                break;
            case "cash":
                pembayaran.bayarCash(nominal);
                break;
            default:
                System.out.println("Metode pembayaran tidak valid.");
                break;
        }
    }

    // Metode untuk mengecek status pencucian
    public void cekStatusPencucian(PegawaiAdmin pegawaiAdmin, int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice); // Mengambil invoice berdasarkan ID
        if (invoice != null) {
            System.out.println("Status Pencucian untuk Invoice ID " + idInvoice + ": " + invoice.getStatusLaundry());
        } else {
            System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
        }
    }
}
