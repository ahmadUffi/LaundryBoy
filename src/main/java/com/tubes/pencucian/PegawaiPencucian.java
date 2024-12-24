package com.tubes.pencucian;

import com.tubes.Iperson;
import com.tubes.admin.PegawaiAdmin;

public class PegawaiPencucian extends Pencucian implements Iperson {
    private String nama;
    private String alamat;
    private int noHp;

    // Konstruktor yang menerima PegawaiAdmin sebagai parameter
    public PegawaiPencucian(String nama, String alamat, int noHp, PegawaiAdmin pegawaiAdmin) {
        super(pegawaiAdmin); // Memanggil konstruktor Pencucian
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
}
