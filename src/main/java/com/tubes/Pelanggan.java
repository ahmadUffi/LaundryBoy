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


    public void bayarQris(Invoice invoice, double nominal){
        Pembayaran pembayaran = new Pembayaran(invoice);
        pembayaran.bayarQris(nominal);

    }

    public void bayarCash(Invoice invoice, double nominal){
        Pembayaran pembayaran = new Pembayaran(invoice);
        pembayaran.bayarCash(nominal);

    }
    public void bayarEwallet(Invoice invoice, double nominal, String nohp){
    // public void bayarEwallet(Invoice invoice, double nominal, String nohp){
        System.out.println("bayarEwallet");
        Pembayaran pembayaran = new Pembayaran(invoice);
        pembayaran.bayarEwallet(nohp, nominal);
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
    public boolean getLaundry(PegawaiAdmin pegawaiAdmin, int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice); // Mengambil invoice berdasarkan ID
        if (invoice != null) {
            return true;
        } else {
            return false;
        }
    }
}
