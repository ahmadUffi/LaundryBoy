package com.tubes;

public class Invoice extends Pelanggan{
  private int idInvoice;
  private Pelanggan[] pelanggan;
  private String tanggal;
  private String tipePesanan;
  private double biayaTagihan;
  private boolean statusPembayaran;
  private String statusLaundry;

  public Invoice(String nama, String alamat, int noHp, int idInvoice, String tanggal, String tipePesanan, double biayaTagihan, boolean statusPembayaran, String statusLaundry) {
    super(nama, alamat, noHp);
    this.idInvoice = idInvoice;
    this.tanggal = tanggal;
    this.tipePesanan = tipePesanan;
    this.biayaTagihan = biayaTagihan;
    this.statusPembayaran = statusPembayaran;
    this.statusLaundry = statusLaundry;
  }

  public void setStatusLaundry(String statusLaundry) {
    this.statusLaundry = statusLaundry;
  }

  public int getIdInvoice(){
    return idInvoice;
  }  
  
  public String getTanggal(){
    return tanggal;
  }

  public String getTipePesanan(){
    return tipePesanan;
  }

  public double getBiayaTagihan(){
    return biayaTagihan;
  }

  public boolean getStatusPembayaran(){
    return statusPembayaran;
  }

  public String getStatusLaundry(){
    return statusLaundry;
  }

  public void cetakTagihan() {
    System.out.println("Tagihan sebesar 10000");
  }
}

