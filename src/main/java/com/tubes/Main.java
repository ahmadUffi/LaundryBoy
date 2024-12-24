package com.tubes;

import com.tubes.admin.PegawaiAdmin;
import com.tubes.pencucian.PegawaiPencucian;

public class Main {
    public static void main(String[] args) {
        PegawaiAdmin pegawaiAdmin = new PegawaiAdmin("John Doe", "Jl. Contoh No. 1", 123456789);
        
        // Membuat PegawaiPencucian dengan PegawaiAdmin yang sudah ada
        PegawaiPencucian pegawaiPencucian = new PegawaiPencucian("Alice", "Jl. Cuci No. 1", 987654321, pegawaiAdmin);
        
        // Membuat invoice
        pegawaiAdmin.createInvoice("Jane Smith", "Jl. Contoh No. 2", 987654321, 1, "2024-12-23", "Pesanan Reguler", 10000, false, "dalam antrian");
        
        // Mencetak invoice menggunakan PegawaiPencucian

        // pegawaiPencucian
        
        // Mengganti status laundry
        
        // Menampilkan invoice setelah status diubah

        // Pelanggan
         // Set invoice ke pelanggan
        Pelanggan pelanggan = new Pelanggan("Salman", "Jl. Contoh No. 2", 987654321);
        pelanggan.setInvoice(pegawaiAdmin.getInvoice(1));

        // Cetak informasi tagihan
        Invoice invoice = pelanggan.getInvoice();
        System.out.println("Tagihan untuk: " + invoice.getNama());
        System.out.println("Biaya Tagihan: " + invoice.getBiayaTagihan());

        // Pelanggan membayar tagihan
        pelanggan.bayarTagihan("ewallet", 10000, 123456789);

        // coba
        pegawaiAdmin.cetakInvoice(1);
    }
}
