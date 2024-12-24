package com.tubes.pengeringan;

import com.tubes.Invoice;
import com.tubes.Iperson;
import com.tubes.admin.PegawaiAdmin;

public class PegawaiPengeringan extends Pengeringan implements Iperson {
    private String nama;
    private String alamat;
    private int noHp;
    private PegawaiAdmin pegawaiAdmin;

    public PegawaiPengeringan(String nama, String alamat, int noHp, PegawaiAdmin pegawaiAdmin) {
        super(pegawaiAdmin);
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
        this.pegawaiAdmin = pegawaiAdmin; // Menyimpan referensi PegawaiAdmin
    }

    public void cetakInvoice(int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice);
        if (invoice != null) {
            System.out.println("Invoice ID: " + invoice.getIdInvoice());
            System.out.println("Nama: " + invoice.getNamaPelanggan());
            System.out.println("Alamat: " + invoice.getAlamatPelanggan());
            System.out.println("No HP: " + invoice.getNoHpPelanggan());
            System.out.println("Tanggal: " + invoice.getTanggal());
            System.out.println("Tipe Pesanan: " + invoice.getTipePesanan());
            System.out.println("Biaya Tagihan: " + invoice.getBiayaTagihan());
            System.out.println("Status Pembayaran: " + (invoice.getStatusPembayaran() ? "Sudah Dibayar" : "Belum Dibayar"));
            System.out.println("Status Laundry: " + invoice.getStatusLaundry());
        } else {
            System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
        }
    }

    public void mulaiPengeringan(int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice);
        if (invoice != null) {
            invoice.setStatusLaundry("Sedang Pengeringan"); // Mengubah status laundry
            System.out.println("Status laundry untuk Invoice ID " + idInvoice + " telah diubah menjadi 'Sedang Pengeringan'.");
        } else {
            System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
        }
    }

    @Override
    public String getNama() {
        return this.nama;
    }

    @Override
    public String getAlamat() {
        return this.alamat;
    }

    @Override
    public int getNoHp() {
        return this.noHp;
    }
}
