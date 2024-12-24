package com.tubes;

public class Pelanggan extends Pembayaran {

    private String nama;
    private String alamat;
    private int noHp;
    private Invoice invoice; 

    public Pelanggan(String nama, String alamat, int noHp) {
        super(nama, alamat, noHp); 
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getNoHp() {
        return noHp;
    }

    // Set invoice pelanggan

    // Dapatkan invoice pelanggan

    // Bayar tagihan
    public void bayarTagihan(String metode, int nominal, int nomorHpBisnis) {
        if (invoice == null) {
            System.out.println("Tidak ada tagihan yang harus dibayar.");
            return;
        }

        if (nominal < invoice.getBiayaTagihan()) {
            System.out.println("Pembayaran gagal. Nominal kurang dari biaya tagihan.");
            return;
        }

        switch (metode.toLowerCase()) {
            case "ewallet":
                bayarEwallet(nomorHpBisnis, nominal);
                break;
            case "qris":
                bayarQris(nomorHpBisnis, nominal);
                break;
            case "cash":
                bayarCash(nominal);
                break;
            default:
                System.out.println("Metode pembayaran tidak valid.");
        }

        // Setelah pembayaran sukses, tandai tagihan sebagai sudah dibayar
        // invoice.setStatusPembayaran(true);
        System.out.println("Tagihan telah dibayar. Terima kasih!");
        
        

    }
}



// package com.tubes;

// public class Pelanggan extends Pembayaran implements Iperson{

//     private String nama;
//     private String alamat;
//     private int noHp;

//     public Pelanggan(String nama, String alamat, int noHp){
//         this.nama = nama;
//         this.alamat = alamat;
//         this.noHp = noHp;
//     }

//     public String getNama(){
//         return nama;
//     }

//     public String getAlamat(){
//         return alamat;
//     }

//     public int getNoHp(){
//         return noHp;
//     }
// }