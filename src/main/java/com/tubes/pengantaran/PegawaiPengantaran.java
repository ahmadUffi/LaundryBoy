package com.tubes.pengantaran;

import com.tubes.Iperson;
import com.tubes.admin.PegawaiAdmin;

public class PegawaiPengantaran extends Pengantaran implements Iperson {
    private String nama;
    private String alamat;
    private int noHp;

    public PegawaiPengantaran(String nama, String alamat, int noHp, PegawaiAdmin pegawaiAdmin) {
        super(pegawaiAdmin);
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
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

    // Metode untuk memulai pengantaran
    @Override
    public void mulaiPengantaran(int idInvoice) {
        super.mulaiPengantaran(idInvoice); // Memanggil metode dari kelas induk
    }

    // Metode untuk menyelesaikan pengantaran
    @Override
    public void selesaiPengantaran(int idInvoice) {
        super.selesaiPengantaran(idInvoice); // Memanggil metode dari kelas induk
    }

    // Metode untuk mencetak invoice
    @Override
    public void cetakInvoice(int idInvoice) {
        super.cetakInvoice(idInvoice); // Memanggil metode dari kelas induk
    }
}
