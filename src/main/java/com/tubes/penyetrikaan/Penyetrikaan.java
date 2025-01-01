package com.tubes.penyetrikaan;
import com.tubes.Invoice;
import com.tubes.MissionUtil;
import com.tubes.admin.PegawaiAdmin;

public class Penyetrikaan {
    protected PegawaiAdmin pegawaiAdmin;

    public Penyetrikaan(PegawaiAdmin pegawaiAdmin) {
        this.pegawaiAdmin = pegawaiAdmin;
    }

    // Metode untuk mengganti status laundry
    public void mulaiSetrika(int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice);
        if (invoice != null) {
            invoice.setStatusLaundry("Sedang di Setrika"); // Mengubah status laundry
            System.out.println("Status laundry untuk Invoice ID " + idInvoice + "'Sedang di Setrika'.");
        } else {
            System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
        }
    }

    public void SelesaiSetrika(int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice);
        if (invoice != null) {
            invoice.setStatusLaundry("Antrian Pengantaran"); // Mengubah status laundry
            System.out.println("Status laundry untuk Invoice ID " + idInvoice + "'Sedang di antar'.");
        } else {
            System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
        }
    }

    // Metode untuk mencetak invoice ||  fungsi invoice.nama, alamat, noHp ditambahin Pelanggan. contoh getNamaPelanggan()
    public void cetakInvoice(int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice);
        if (invoice != null) {
            System.out.println("Invoice ID: " + invoice.getIdInvoice());
            System.out.println("Nama: " + invoice.getNamaPelanggan());
            System.out.println("Alamat: " + invoice.getAlamatPelanggan());
            System.out.println("No HP: " + invoice.getNoHpPelanggan());
            System.out.println("Tanggal: " + invoice.getTanggal());
            System.out.println("Tipe Pesanan: " + invoice.getTipePesanan());
            System.out.println("Biaya Tagihan: " + MissionUtil.moneyFormat(invoice.getBiayaTagihan()));
            System.out.println("Status Pembayaran: " + (invoice.getStatusPembayaran() ? "Sudah Dibayar" : "Belum Dibayar"));
            System.out.println("Status Laundry: " + invoice.getStatusLaundry());
        } else {
            System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
        }
    }
}
