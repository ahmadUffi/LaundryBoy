package com.tubes;


public class Pembayaran implements IPembayaran {
    private Invoice invoice; 
    private String nomorBisnis = "082234709831" ;

    public Pembayaran(Invoice invoice) {
        this.invoice = invoice; // Inisialisasi invoice
    }

    @Override
    public void bayarEwallet( String nomorHpBisnis, double nominal) {
        if(nomorHpBisnis.equals(this.nomorBisnis)){
            if (nominal >= invoice.getBiayaTagihan()) {
                System.out.println("Pembayaran menggunakan eWallet berhasil.");
                System.out.println("Nomor HP Bisnis : " + nomorHpBisnis);
                System.out.println("Nominal: " + nominal);
                System.out.println("Biaya Laundry : " + MissionUtil.moneyFormat(invoice.getBiayaTagihan()));
                System.out.println("kembalian Rp." + (nominal - invoice.getBiayaTagihan()));
                invoice.setStatusLaundry("Laundry telah selesai");
                System.out.println("Status invoice telah diubah menjadi 'selesai'.");
            } else {
                System.out.println("Pembayaran gagal. Nominal tidak cukup.");
            }
        }else{
            System.out.println("Salin Nomor HP Bisnis ini untuk bayar: " + this.nomorBisnis);
        }
    }

    @Override
    public void bayarQris( double nominal) {
        if (nominal >= invoice.getBiayaTagihan()) {
            System.out.println("Pembayaran menggunakan QRIS berhasil.");
            System.out.println("Nominal: " + MissionUtil.moneyFormat(invoice.getBiayaTagihan()));
            System.out.println("Biaya Laundry : " + MissionUtil.moneyFormat(invoice.getBiayaTagihan()));
            System.out.println("kembalian Rp." + (nominal - invoice.getBiayaTagihan()));
            invoice.setStatusLaundry("Laundry telah selesai");
            System.out.println("Status invoice telah diubah menjadi 'selesai'.");
        } else {
            System.out.println("Pembayaran gagal. Nominal tidak cukup.");
        }
    }

    @Override
    public void bayarCash( double nominal) {
        if (nominal >= invoice.getBiayaTagihan()) {
            System.out.println("Pembayaran tunai berhasil.");
            System.out.println("Nominal: " + nominal);
            System.out.println("Biaya Laundry : " + MissionUtil.moneyFormat(invoice.getBiayaTagihan()));
            System.out.println("kembalian Rp." + (nominal - invoice.getBiayaTagihan()));
            invoice.setStatusLaundry("Laundry telah selesai");
            System.out.println("Status invoice telah diubah menjadi 'selesai'.");
        } else {
            System.out.println("Pembayaran gagal. Nominal tidak cukup.");
        }
    }
}
