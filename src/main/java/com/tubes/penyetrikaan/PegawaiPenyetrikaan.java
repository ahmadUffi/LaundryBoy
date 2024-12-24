package com.tubes.penyetrikaan;

import com.tubes.Iperson;
import com.tubes.admin.PegawaiAdmin;

public class PegawaiPenyetrikaan extends Penyetrikaan implements Iperson {
    private String nama;
    private String alamat;
    private int noHp;
    private PegawaiAdmin pegawaiAdmin;

    public PegawaiPenyetrikaan(String nama, String alamat, int noHp, PegawaiAdmin pegawaiAdmin) {
        super(pegawaiAdmin);
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
        this.pegawaiAdmin = pegawaiAdmin; // Menyimpan referensi PegawaiAdmin
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

    // Metode untuk mencetak invoice
    @Override
    public void cetakInvoice(int idInvoice) {
        pegawaiAdmin.cetakInvoice(idInvoice);
    }
}
