package com.tubes;

public class Invoice {
    private int idInvoice;
    private String namaPelanggan;
    private String alamatPelanggan;
    private int noHpPelanggan;
    private String tanggal;
    private String tipePesanan;
    private double biayaTagihan;
    private double beratLaundry;
    private boolean statusPembayaran;
    private String statusLaundry;
    private double instan = 11000;
    private double ekspress = 7000;
    private double reguler = 4000;

    public Invoice(String namaPelanggan, String alamatPelanggan, int noHpPelanggan, int idInvoice, String tanggal, String tipePesanan, double beratLaundry, boolean statusPembayaran, String statusLaundry) {
        this.namaPelanggan = namaPelanggan;
        this.alamatPelanggan = alamatPelanggan;
        this.noHpPelanggan = noHpPelanggan;
        this.idInvoice = idInvoice;
        this.tanggal = tanggal;
        this.tipePesanan = tipePesanan;
        this.beratLaundry = beratLaundry;
        this.statusPembayaran = statusPembayaran;
        this.statusLaundry = statusLaundry;
        if(this.tipePesanan.equals("instan")){
            this.biayaTagihan =  this.instan * beratLaundry;
        }else if(this.tipePesanan.equals("ekspress")){
            this.biayaTagihan =  this.ekspress * beratLaundry;
        }else if(this.tipePesanan.equals("reguler")){
            this.biayaTagihan = this.ekspress * beratLaundry;
        }
    }

    public void setStatusLaundry(String statusLaundry) {
        this.statusLaundry = statusLaundry;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getTipePesanan() {
        return tipePesanan;
    }

    public double getBiayaTagihan() {
        return biayaTagihan;
    }

    public boolean getStatusPembayaran() {
        return statusPembayaran;
    }

    public String getStatusLaundry() {
        return statusLaundry;
    }

    public void cetakTagihan() {
        System.out.println("Tagihan untuk " + namaPelanggan + ": " + biayaTagihan);
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public String getAlamatPelanggan() {
        return alamatPelanggan;
    }

    public int getNoHpPelanggan() {
        return noHpPelanggan;
    }
}
