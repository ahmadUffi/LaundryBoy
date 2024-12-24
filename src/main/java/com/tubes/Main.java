package com.tubes;

import com.tubes.admin.PegawaiAdmin;
import com.tubes.pencucian.PegawaiPencucian;
import com.tubes.pengantaran.PegawaiPengantaran;
import com.tubes.pengeringan.PegawaiPengeringan;
import com.tubes.penyetrikaan.PegawaiPenyetrikaan;

public class Main {
    public static void main(String[] args) {
        PegawaiAdmin pegawaiAdmin = new PegawaiAdmin();
        
        // Membuat 3 pelanggan dan invoice mereka
        Pelanggan pelanggan1 = pegawaiAdmin.createInvoice("Ahmad Uffi", "Jl. Krangklesem No. 2", 987654321, 1, "2024-12-23", "Pesanan Reguler", 10000, false, "dalam antrian");
        Pelanggan pelanggan2 = pegawaiAdmin.createInvoice("salman alfarisi", "puri hijau", 123123123, 2, "2024-12-24", "Pesanan Ekspres", 15000, false, "dalam antrian");
        Pelanggan pelanggan3 = pegawaiAdmin.createInvoice("Gilang", "Kobon dalmen", 456456456, 3, "2024-12-25", "Pesanan Khusus", 20000, false, "dalam antrian");
        
        // Membuat pegawai
        PegawaiPencucian pegawaiPencucian = new PegawaiPencucian("satria", "Jl. aston No. 1", 123456789, pegawaiAdmin);
        PegawaiPengeringan pegawaiPengeringan = new PegawaiPengeringan("Rifki", "Jl. pureokerto kidul No. 2", 987654321, pegawaiAdmin);
        PegawaiPenyetrikaan pegawaiPenyetrikaan = new PegawaiPenyetrikaan("Ramadhan", "Jl. andhang No. 3", 456456456, pegawaiAdmin);
        PegawaiPengantaran pegawaiPengantaran = new PegawaiPengantaran("Lestari", "Jl. Brawijaya No. 4", 789789789, pegawaiAdmin);
        
        // Proses untuk pelanggan 1
        System.out.println("=== Proses Pelanggan 1 ===");
        pegawaiPencucian.cetakInvoice(1);
        pegawaiPengeringan.mulaiPengeringan(1);
        pelanggan1.cekStatusPencucian(pegawaiAdmin, 1);
        pelanggan1.bayarTagihan(pegawaiAdmin.getInvoice(1), 10000, "ewallet");
        pegawaiPengantaran.mulaiPengantaran(1);
        pegawaiPengantaran.selesaiPengantaran(1);
        pegawaiPengantaran.cetakInvoice(1);
        
        // Proses untuk pelanggan 2
        System.out.println("\n=== Proses Pelanggan 2 ===");
        pegawaiPencucian.cetakInvoice(2);
        pegawaiPengeringan.mulaiPengeringan(2);
        pelanggan2.cekStatusPencucian(pegawaiAdmin, 2);
        pelanggan2.bayarTagihan(pegawaiAdmin.getInvoice(2), 15000, "cash");
        pegawaiPengantaran.mulaiPengantaran(2);
        pegawaiPengantaran.selesaiPengantaran(2);
        pegawaiPengantaran.cetakInvoice(2);
        
        // Proses untuk pelanggan 3
        System.out.println("\n=== Proses Pelanggan 3 ===");
        pegawaiPencucian.cetakInvoice(3);
        pegawaiPengeringan.mulaiPengeringan(3);
        pelanggan3.cekStatusPencucian(pegawaiAdmin, 3);
        pelanggan3.bayarTagihan(pegawaiAdmin.getInvoice(3), 20000, "qris");
        pegawaiPengantaran.mulaiPengantaran(3);
        pegawaiPengantaran.selesaiPengantaran(3);
        pegawaiPengantaran.cetakInvoice(3);
    }
}
