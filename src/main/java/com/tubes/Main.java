package com.tubes;

import java.util.ArrayList;
import java.util.Scanner;

import com.tubes.admin.PegawaiAdmin;
import com.tubes.pencucian.PegawaiPencucian;
import com.tubes.pengantaran.PegawaiPengantaran;
import com.tubes.pengeringan.PegawaiPengeringan;
import com.tubes.penyetrikaan.PegawaiPenyetrikaan;

public class Main {
    // Deklarasi pelangganList sebagai anggota kelas
    public static ArrayList<Pelanggan> pelangganList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PegawaiAdmin pegawaiAdmin = new PegawaiAdmin();
        
        // Membuat pegawai
        PegawaiPencucian pegawaiPencucian = new PegawaiPencucian("Satria", "Jl. Aston No. 1", 123456789, pegawaiAdmin);
        PegawaiPengeringan pegawaiPengeringan = new PegawaiPengeringan("Rifki", "Jl. Purwokerto Kidul No. 2", 987654321, pegawaiAdmin);
        PegawaiPenyetrikaan pegawaiPenyetrikaan = new PegawaiPenyetrikaan("Ramadhan", "Jl. Andhang No. 3", 456456456, pegawaiAdmin);
        PegawaiPengantaran pegawaiPengantaran = new PegawaiPengantaran("Lestari", "Jl. Brawijaya No. 4", 789789789, pegawaiAdmin);

        int pilihan;

        do { 
            printMainMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (pilihan) {
                case 1: // Kariyawan
                    printPekerjaanPegawai();
                    pilihan = scanner.nextInt();
                    scanner.nextLine(); // Clear the buffer
                    handlePegawaiOptions(pilihan, pegawaiAdmin, pegawaiPencucian, pegawaiPengeringan, pegawaiPenyetrikaan, pegawaiPengantaran, scanner);
                    break;
                case 2: // Pelanggan
                    handlePelangganOptions(scanner, pegawaiAdmin);
                    break;
                case 3: // Keluar
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (true);
    }

    public static void printMainMenu(){
        System.out.println("================================================================");
        System.out.println("1. Kariyawan ");
        System.out.println("2. Pelanggan");
        System.out.println("3. Keluar Program");
        System.out.print("Pilih opsi: ");
    }

    public static void printPekerjaanPegawai(){
        System.out.println("================================================================");
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

    public static void handlePegawaiOptions(int pilihan, PegawaiAdmin pegawaiAdmin, PegawaiPencucian pegawaiPencucian, PegawaiPengeringan pegawaiPengeringan, PegawaiPenyetrikaan pegawaiPenyetrikaan, PegawaiPengantaran pegawaiPengantaran, Scanner scanner) {
        int idInvoice;
        switch (pilihan) {
            case 1 -> {
                System.out.println("=== Buat Invoice ===");
                System.out.print("Nama Pelanggan: ");
                String namaPelanggan = scanner.nextLine();
                System.out.print("Alamat Pelanggan: ");
                String alamatPelanggan = scanner.nextLine();
                System.out.print("No HP Pelanggan: ");
                int noHpPelanggan = scanner.nextInt();
                System.out.print("ID Invoice: ");
                idInvoice = scanner.nextInt();
                System.out.print("Tanggal (YYYY-MM-DD): ");
                String tanggal = scanner.next();
                System.out.print("Tipe Pesanan: ");
                String tipePesanan = scanner.next();
                System.out.print("Biaya Tagihan: ");
                double beratLaundry = scanner.nextDouble();
                System.out.print("Status Pembayaran (true/false): ");
                boolean statusPembayaran = scanner.nextBoolean();
                scanner.nextLine(); // Clear the buffer
                // Membuat invoice dan menambahkannya ke pelangganList
                Pelanggan pelanggan = pegawaiAdmin.createInvoice(namaPelanggan, alamatPelanggan, noHpPelanggan, idInvoice, tanggal, tipePesanan, beratLaundry, statusPembayaran, "dalam antrian");
                pelangganList.add(pelanggan);
                System.out.println("Invoice berhasil dibuat.");
            }
            case 2 -> {
                System.out.println("=== Mulai Pencucian ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = scanner.nextInt();
                pegawaiPencucian.mulaiCuci(idInvoice);
            }
            case 3 -> {
                System.out.println("=== Selesai Pencucian ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = scanner.nextInt();
                pegawaiPencucian.SelesaiCuci(idInvoice);
            }
            case 4 -> {
                System.out.println("=== Mulai Pengeringan ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = scanner.nextInt();
                pegawaiPengeringan.mulaiPengeringan(idInvoice);
            }
            case 5 -> {
                System.out.println("=== Selesai Pengeringan ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = scanner.nextInt();
                pegawaiPengeringan.SelesaiPengeringan(idInvoice);
            }
            case 6 -> {
                System.out.println("=== Mulai Penyetrikaan ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = scanner.nextInt();
                pegawaiPenyetrikaan.mulaiSetrika(idInvoice);
            }
            case 7 -> {
                System.out.println("=== Selesai Penyetrikaan ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = scanner.nextInt();
                pegawaiPenyetrikaan.SelesaiSetrika(idInvoice);
            }
            case 8 -> {
                System.out.println("=== Mulai Pengantaran ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = scanner.nextInt();
                pegawaiPengantaran.mulaiPengantaran(idInvoice);
            }
            case 9 -> {
                System.out.println("=== Selesai Pengantaran ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = scanner.nextInt();
                pegawaiPengantaran.selesaiPengantaran(idInvoice);
            }
            case 10 -> {
                System.out.println("=== Cetak Invoice ===");
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = scanner.nextInt();
                pegawaiAdmin.cetakInvoice(idInvoice);
            }
            case 11 -> {
                System.out.println("=== Cetak Semua Invoice ===");
                pegawaiAdmin.cekSemuaStatusLaundry();
            }
            case 12 -> {
                System.out.println("=== Report Keuangan ===");
                pegawaiAdmin.reportKeuangan();
            }
            case 13 -> System.out.println("Kembali ke menu utama.");
            default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }

    public static void handlePelangganOptions(Scanner scanner, PegawaiAdmin pegawaiAdmin) {
        System.out.println("=== Menu Pelanggan ===");
        System.out.println("1. Lihat Status Laundry");
        System.out.println("2. Bayar Laundry");
        System.out.print("Pilih opsi: ");
        int pilihan = scanner.nextInt();
        String nama;
        int idInvoice;
        scanner.nextLine(); // Clear the buffer

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Nama Pelanggan: ");
                nama = MissionUtil.getStringInput();
                System.out.print("Masukkan ID Invoice: ");
                idInvoice = scanner.nextInt();
                for(Pelanggan pelanggan : pelangganList){
                    if(pelanggan.getNama().equalsIgnoreCase(nama)){
                        System.out.print("Status Laundry: ");
                        pelanggan.cekStatusPencucian(pegawaiAdmin, idInvoice);
                        break;
                    }
                }
                break;
            case 2:
            System.out.print("Masukkan Nama Pelanggan: ");
            nama = MissionUtil.getStringInput();
            System.out.print("Masukkan ID Invoice: ");
            idInvoice = scanner.nextInt();
            for(Pelanggan pelanggan : pelangganList){
                if(pelanggan.getNama().equalsIgnoreCase(nama)){
                    System.out.print("Status Laundry: ");
                    pelanggan.cekStatusPencucian(pegawaiAdmin, idInvoice);
                    break;
                }
            }
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }
}
