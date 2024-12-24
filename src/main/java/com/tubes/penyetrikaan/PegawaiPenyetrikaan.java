package com.tubes.penyetrikaan;

import com.tubes.Iperson;
import com.tubes.admin.PegawaiAdmin;

public class PegawaiPenyetrikaan extends Penyetrikaan implements Iperson{
    private String nama;
    private String alamat;
    private int noHp;

    public PegawaiPenyetrikaan(String nama, String alamat, int noHp, PegawaiAdmin pegawaiAdmin) {
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
}
