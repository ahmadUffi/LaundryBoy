package com.tubes.admin;

import java.util.HashMap;

import com.tubes.Invoice;
import com.tubes.Iperson;
import com.tubes.Pelanggan;

public class PegawaiAdmin extends Report implements Iperson {
    private HashMap<Integer, Invoice> invoices; // Menggunakan Integer untuk idInvoice
    private String nama;
    private String alamat;
    private int noHp;


    public PegawaiAdmin(String nama, String alamat, int noHp) {
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
        this.invoices = new HashMap<>();
    }

    public void createInvoice(String nama, String alamat, int noHp, int idInvoice, String tanggal, String tipePesanan, double biayaTagihan, boolean statusPembayaran, String statusLaundry) {
        Invoice invoice = new Invoice(nama, alamat, noHp, idInvoice, tanggal, tipePesanan, biayaTagihan, statusPembayaran, statusLaundry);
        invoices.put(idInvoice, invoice);
        Pelanggan[] pelanggans = {
            new Pelanggan(nama, alamat, noHp),
        };
    }

    public void cetakInvoice(int idinvoice){
        Invoice invoice = invoices.get(idinvoice);
        System.out.println("Invoice ID: " + invoice.getIdInvoice());
        System.out.println("Nama: " + invoice.getNama());
        System.out.println("Alamat: " + invoice.getAlamat());
        System.out.println("No HP: " + invoice.getNoHp());
        System.out.println("Tanggal: " + invoice.getTanggal());
        System.out.println("Tipe Pesanan: " + invoice.getTipePesanan());
        System.out.println("Biaya Tagihan: " + invoice.getBiayaTagihan());
        System.out.println("Status Pembayaran: " + (invoice.getStatusPembayaran() ? "Sudah Dibayar" : "Belum Dibayar"));
        System.out.println("Status Laundry: " + invoice.getStatusLaundry());
    }

    public Invoice getInvoice(int idinvoice){
        Invoice invoice = invoices.get(idinvoice);
        return invoice;
    }

    public void statusAll(){
        if(invoices.isEmpty()){
            System.out.println("Tidak ada invoice yang tersedia");
        }

        for(Invoice invoice : invoices.values()){
            System.out.println("Invoice ID: " + invoice.getIdInvoice());
            System.out.println("Nama: " + invoice.getNama());
            System.out.println("Alamat: " + invoice.getAlamat());
            System.out.println("No HP: " + invoice.getNoHp());
            System.out.println("Tanggal: " + invoice.getTanggal());
            System.out.println("Tipe Pesanan: " + invoice.getTipePesanan());
            System.out.println("Biaya Tagihan: " + invoice.getBiayaTagihan());
            System.out.println("Status Pembayaran: " + (invoice.getStatusPembayaran() ? "Sudah Dibayar" : "Belum Dibayar"));
            System.out.println("Status Laundry: " + invoice.getStatusLaundry());
            System.out.println("----------------------------------");
        }
    }

    public void laporanKeuangan() {
        double totalTagihan = 0;
    
        for (Invoice invoice : invoices.values()) {
            if (invoice.getStatusLaundry().equals("selesai")) { 
                System.out.println("Invoice ID: " + invoice.getIdInvoice());
                System.out.println("Nama: " + invoice.getNama());
                System.out.println("Alamat: " + invoice.getAlamat());
                System.out.println("No HP: " + invoice.getNoHp());
                System.out.println("Tanggal: " + invoice.getTanggal());
                System.out.println("Tipe Pesanan: " + invoice.getTipePesanan());
                System.out.println("Biaya Tagihan: " + invoice.getBiayaTagihan());
                System.out.println("----------------------------------------------------------------");
                totalTagihan += invoice.getBiayaTagihan(); 
            }
        }
    
        System.out.println("Total Tagihan: " + totalTagihan);
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
