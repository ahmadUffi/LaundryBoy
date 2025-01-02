package com.tubes;

import java.util.ArrayList;

import com.tubes.admin.PegawaiAdmin;
import com.tubes.pencucian.PegawaiPencucian;
import com.tubes.pengantaran.PegawaiPengantaran;
import com.tubes.pengeringan.PegawaiPengeringan;
import com.tubes.penyetrikaan.PegawaiPenyetrikaan;

public class Main {
    // Deklarasi pelangganList sebagai anggota kelas
    public static ArrayList<Pelanggan> pelangganList = new ArrayList<>();

    public static void main(String[] args) {
        PegawaiAdmin pegawaiAdmin = new PegawaiAdmin();
        
        // Membuat pegawai
        PegawaiPencucian pegawaiPencucian = new PegawaiPencucian("Satria", "Jl. Aston No. 1", 123456789, pegawaiAdmin);
        PegawaiPengeringan pegawaiPengeringan = new PegawaiPengeringan("Rifki", "Jl. Purwokerto Kidul No. 2", 987654321, pegawaiAdmin);
        PegawaiPenyetrikaan pegawaiPenyetrikaan = new PegawaiPenyetrikaan("Ramadhan", "Jl. Andhang No. 3", 456456456, pegawaiAdmin);
        PegawaiPengantaran pegawaiPengantaran = new PegawaiPengantaran("Lestari", "Jl. Brawijaya No. 4", 789789789, pegawaiAdmin);

        int pilihan;

        do { 
            printMainMenu();
            pilihan = MissionUtil.getIntInput();

            switch (pilihan) {
                case 1: // Kariyawan
                    printPekerjaanPegawai();
                    pilihan = MissionUtil.getIntInput();
                    handlePegawaiOptions(pilihan, pegawaiAdmin, pegawaiPencucian, pegawaiPengeringan, pegawaiPenyetrikaan, pegawaiPengantaran);
                    break;
                case 2: // Pelanggan
                    handlePelangganOptions(pegawaiAdmin);
                    break;
                case 3: // Keluar
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (true);
    }

    public static void printMainMenu(){
        System.out.println("========================== Login Sebagai ======================================");
        System.out.println("1. Kariyawan ");
        System.out.println("2. Pelanggan");
        System.out.println("3. Keluar Program");
        System.out.print("Pilih opsi: ");
    }

    public static void printPekerjaanPegawai(){
        System.out.println("================================ Pilihan Menu ================================");
        System.out.println("1. Buat Invoice");
        System.out.println("2. Mulai Pencucian");
        System.out.println("3. Selesai Pencucian");
        System.out.println("4. Mulai Pengeringan");
        System.out.println("5. Selesai Pengeringan");
        System.out.println("6. Mulai Penyetrikaan");
        System.out.println("7. Selesai Penyetrikaan");
        System.out.println("8. Mulai Pengantaran");
        System.out.println("9. Selesai Pengantaran");
        System.out.println("10. Cetak Invoice");
        System.out.println("11. Cetak Semua Invoice");
        System.out.println("12. Report Keuangan");
        System.out.println("13. Kembali");
        System.out.print("Pilih opsi: ");
    }

    public static void handlePegawaiOptions(int pilihan, PegawaiAdmin pegawaiAdmin, PegawaiPencucian pegawaiPencucian, PegawaiPengeringan pegawaiPengeringan, PegawaiPenyetrikaan pegawaiPenyetrikaan, PegawaiPengantaran pegawaiPengantaran) {
        int idInvoice;
        switch (pilihan) {
            case 1:
            System.out.println("=== Buat Invoice ===");
            System.out.print("Nama Pelanggan: ");
            String namaPelanggan = MissionUtil.getStringInput();
            System.out.print("Alamat Pelanggan: ");
            String alamatPelanggan = MissionUtil.getStringInput();
            System.out.print("No HP Pelanggan: ");
            int noHpPelanggan = MissionUtil.getIntInput();
            System.out.print("ID Invoice: ");
            idInvoice = MissionUtil.getIntInput();
            System.out.print("Tanggal (YYYY-MM-DD): ");
            String tanggal = MissionUtil.getStringInput();

            // Input validation for Tipe Pesanan
            String tipePesanan;
            while (true) {
                System.out.print("Tipe Pesanan (ekspress/reguler/instan): ");
                tipePesanan = MissionUtil.getStringInput().toLowerCase(); // Convert to lowercase for easier comparison
                if (tipePesanan.equals("ekspress") || tipePesanan.equals("reguler") || tipePesanan.equals("instan")) {
                    break; // Valid input, exit the loop
                } else {
                    System.out.println("Input tidak valid. Silakan masukkan 'ekspress', 'reguler', atau 'instan'.");
                }
            }

            System.out.print("Berat Laundry: ");
            double biayaTagihan = MissionUtil.getDoubleInput();
            System.out.print("Status Pembayaran (true/false): ");
            boolean statusPembayaran = MissionUtil.getIntInput() == 1; // Menganggap 1 sebagai true, 0 sebagai false

            Pelanggan pelanggan = pegawaiAdmin.createInvoice(namaPelanggan, alamatPelanggan, noHpPelanggan, idInvoice, tanggal, tipePesanan, biayaTagihan, statusPembayaran, "dalam antrian");
            pelangganList.add(pelanggan);
            System.out.println("Invoice berhasil dibuat.");
            break;
            case 2:
                System.out.println("=== Mulai Pencucian ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = MissionUtil.getIntInput();
                pegawaiPencucian.mulaiCuci(idInvoice);
                break;
            case 3:
                System.out.println("=== Selesai Pencucian ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = MissionUtil.getIntInput();
                pegawaiPencucian.SelesaiCuci(idInvoice);
                break;
            case 4:
                System.out.println("=== Mulai Pengeringan ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = MissionUtil.getIntInput();
                pegawaiPengeringan.mulaiPengeringan(idInvoice);
                break;
            case 5:
                System.out.println("=== Selesai Pengeringan ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = MissionUtil.getIntInput();
                pegawaiPengeringan.SelesaiPengeringan(idInvoice);
                break;
            case 6:
                System.out.println("=== Mulai Penyetrikaan ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = MissionUtil.getIntInput();
                pegawaiPenyetrikaan.mulaiSetrika(idInvoice);
                break;
            case 7:
                System.out.println("=== Selesai Penyetrikaan ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = MissionUtil.getIntInput();
                pegawaiPenyetrikaan.SelesaiSetrika(idInvoice);
                break;
            case 8:
                System.out.println("=== Mulai Pengantaran ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = MissionUtil.getIntInput();
                pegawaiPengantaran.mulaiPengantaran(idInvoice);
                break;
            case 9:
                System.out.println("=== Selesai Pengantaran ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = MissionUtil.getIntInput();
                pegawaiPengantaran.selesaiPengantaran(idInvoice);
                break;
            case 10:
                System.out.println("=== Cetak Invoice ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = MissionUtil.getIntInput();
                pegawaiAdmin.cetakInvoice(idInvoice);
                break;
            case 11:
                System.out.println("=== Cetak Semua Invoice ===");
                pegawaiAdmin.cekSemuaStatusLaundry();
                break;
            case 12:
                System.out.println("=== Report Keuangan ===");
                pegawaiAdmin.reportKeuangan();
                break;
            case 13:
                System.out.println("Kembali ke menu utama.");
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }

    public static void handlePelangganOptions(PegawaiAdmin pegawaiAdmin) {
        System.out.println("=== Menu Pelanggan ===");
        System.out.println("1. Lihat Status Laundry");
        System.out.println("2. Bayar Laundry");
        System.out.print("Pilih opsi: ");
        int pilihan = MissionUtil.getIntInput();
        String nama;
        int idInvoice;

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Nama Pelanggan: ");
                nama = MissionUtil.getStringInput();
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = MissionUtil.getIntInput();
                for (Pelanggan pelanggan : pelangganList) {
                    if (pelanggan.getNama().equalsIgnoreCase(nama)) {
                        System.out.print("Status Laundry: ");
                        pelanggan.cekStatusPencucian(pegawaiAdmin, idInvoice); 
                        break;
                    } else {
                        System.out.println("Pelanggan dengan nama " + nama + " tidak ditemukan");
                    }
                }
                // System.out.println("Pelanggan dengan nama " + nama + " tidak ditemukan");
                break;
            case 2:
                System.out.print("Masukkan Nama Pelanggan: ");
                nama = MissionUtil.getStringInput();
               
                for (Pelanggan pelanggan : pelangganList) {
                    if (pelanggan.getNama().equalsIgnoreCase(nama)) {
                        double nominal;
                        System.out.print("Masukkan ID Invoice: ");
                        idInvoice = MissionUtil.getIntInput();
                        if(pelanggan.getLaundry(pegawaiAdmin, idInvoice) == true){
                            while (true) {
                                System.out.print("Metode pembayaran (ewallet/cash/qris): ");
                                String  metodePembayaran = MissionUtil.getStringInput();
                                switch (metodePembayaran) {
                                    case "ewallet":
                                         System.out.print("Masukkan jumlah pembayaran: ");
                                         nominal = MissionUtil.getDoubleInput();
                                         System.out.print("Salin Nomor HP Bisnis ini (082234709831): ");
                                         String noHp = MissionUtil.getStringNoHpBisnisInput();
                                        //  String noHp = MissionUtil.getStringInput();
                                         pelanggan.bayarEwallet(pegawaiAdmin.getInvoice(idInvoice), nominal, noHp);
                                         return;
                                    case "cash":
                                         System.out.print("Masukkan jumlah pembayaran: ");
                                         nominal = MissionUtil.getDoubleInput();
                                         pelanggan.bayarCash(pegawaiAdmin.getInvoice(idInvoice), nominal);
                                        
                                        return;
                                    case "qris":
                                        System.out.print("Masukkan jumlah pembayaran: ");
                                        nominal = MissionUtil.getDoubleInput();
                                        pelanggan.bayarQris(pegawaiAdmin.getInvoice(idInvoice), nominal);
                                        return;
                                    default:
                                        System.out.println("Input tidak valid. silahkan masukan 'ewallet', 'cash', 'qris' ");
                                }
                            }
                        }
                    
                    }
                    
                    // Implementasi pembayaran
                    // Misalnya: pegawaiAdmin.bayarTagihan(idInvoice, jumlahBayar, metodePembayaran);
                    System.out.println("Pembayaran berhasil.");
                    break;
                    }
                System.out.println("Pelanggan dengan nama " + nama + " tidak ditemukan");
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
              
        }
    }

