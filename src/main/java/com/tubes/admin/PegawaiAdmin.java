package com.tubes.admin;

import java.util.HashMap;

import com.tubes.Invoice;
import com.tubes.Pelanggan;

public class PegawaiAdmin {
    private HashMap<Integer, Invoice> invoices; // Menggunakan Integer untuk idInvoice
    private HashMap<Integer, Pelanggan> pelanggans; // Menyimpan pelanggan

    public PegawaiAdmin() {
        this.invoices = new HashMap<>();
        this.pelanggans = new HashMap<>(); // Inisialisasi HashMap untuk pelanggan
    }

    // Ubah tipe pengembalian menjadi Pelanggan
    public Pelanggan createInvoice(String nama, String alamat, int noHp, int idInvoice, String tanggal, String tipePesanan, double biayaTagihan, boolean statusPembayaran, String statusLaundry) {
        // Membuat objek pelanggan dan menyimpannya
        Pelanggan pelanggan = new Pelanggan(nama, alamat, noHp);
        pelanggans.put(noHp, pelanggan); // Menyimpan pelanggan berdasarkan noHp

        // Membuat invoice
        Invoice invoice = new Invoice(nama, alamat, noHp, idInvoice, tanggal, tipePesanan, biayaTagihan, statusPembayaran, statusLaundry);
        invoices.put(idInvoice, invoice);

        return pelanggan; // Mengembalikan objek pelanggan yang baru dibuat
    }

    public void cetakInvoice(int idInvoice) {
        Invoice invoice = invoices.get(idInvoice);
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

    public Invoice getInvoice(int idInvoice) {
        return invoices.get(idInvoice);
    }
}
