package com.tubes.pengeringan;

import com.tubes.Invoice;
import com.tubes.MissionUtil;
import com.tubes.admin.PegawaiAdmin;

public class Pengeringan {
  protected PegawaiAdmin pegawaiAdmin;
  
  public Pengeringan(PegawaiAdmin pegawaiAdmin) {
        this.pegawaiAdmin = pegawaiAdmin;
    }

  public void mulaiPengeringan(int idInvoice) {
    Invoice invoice = pegawaiAdmin.getInvoice(idInvoice);
    if (invoice != null) {
        invoice.setStatusLaundry("Laundry sedang di keringkan"); // Mengubah status laundry
        System.out.println("Status laundry untuk Invoice ID " + idInvoice + "'Sedang di keringkan'.");
    } else {
        System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
    }
  }

  public void SelesaiPengeringan(int idInvoice) {
        Invoice invoice = pegawaiAdmin.getInvoice(idInvoice);
        if (invoice != null) {
            invoice.setStatusLaundry("Antrian penyetrikaan"); // Mengubah status laundry
            System.out.println("Status laundry untuk Invoice ID " + idInvoice + "'Sedang di keringkan'.");
        } else {
            System.out.println("Invoice tidak ditemukan untuk ID: " + idInvoice);
        }
    }

    // ||  fungsi invoice.nama, alamat, noHp ditambahin Pelanggan. contoh getNamaPelanggan()
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
