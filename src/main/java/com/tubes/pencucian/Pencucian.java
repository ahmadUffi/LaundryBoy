package com.tubes.pencucian;

import com.tubes.Invoice;
import com.tubes.admin.PegawaiAdmin;

public class Pencucian {
    protected PegawaiAdmin pegawaiAdmin;

    public Pencucian(PegawaiAdmin pegawaiAdmin) {
        this.pegawaiAdmin = pegawaiAdmin;
    }
    
    // Metode untuk mengganti status laundry
    public void mulaiCuci(int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice);
        if (invoice != null) {
            invoice.setStatusLaundry("Sedang di Cuci"); // Mengubah status laundry
            System.out.println("Status laundry untuk Invoice ID " + idInvoice + "'Sedang di Cuci'.");
        } else {
            System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
        }
    }
    public void SelesaiCuci(int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice);
        if (invoice != null) {
            invoice.setStatusLaundry("Antrian Pengeringan"); // Mengubah status laundry
            System.out.println("Status laundry untuk Invoice ID " + idInvoice + "'Selesai di Cuci'.");
        } else {
            System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
        }
    }

    // Metode untuk mencetak invoice
    public void cetakInvoice(int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice);
        if (invoice != null) {
            System.out.println("Invoice ID: " + invoice.getIdInvoice());
            System.out.println("Nama: " + invoice.getNama());
            System.out.println("Alamat: " + invoice.getAlamat());
            System.out.println("No HP: " + invoice.getNoHp());
            System.out.println("Tanggal: " + invoice.getTanggal());
            System.out.println("Tipe Pesanan: " + invoice.getTipePesanan());
            System.out.println("Biaya Tagihan: " + invoice.getBiayaTagihan());
            System.out.println("Status Pembayaran: " + (invoice.getStatusPembayaran() ? "Sudah Dibayar" : "Belum Dibayar"));
            System.out.println("Status Laundry: " + invoice.getStatusLaundry());
        } else {
            System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
        }
    }
}
