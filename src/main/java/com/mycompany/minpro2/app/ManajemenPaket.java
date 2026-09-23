package com.mycompany.minpro2.app;

import com.mycompany.minpro2.model.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManajemenPaket {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        PengelolaPaket pengelola = new PengelolaPaket(1, "Admin Ekspedisi", "08123456789");

        // DATA DUMMY
        Ekspedisi ekspedisi = new Ekspedisi(1, "JNE", "Reguler");
        Penerima penerima = new Penerima(1, "Arham", "08123456789", "Sangatta");
        Kurir kurir = new Kurir(1, "Budi", "08129876543");
        Paket paket = new Paket(1, "RESI001", "Doni", "23-09-2026", "Dalam Proses", ekspedisi, penerima, kurir);
        pengelola.tambahPaket(paket);

        int pilihan;
        do {
            tampilkanMenu();
            pilihan = inputInt("Pilih menu: ");
            switch (pilihan) {
                case 1: tambahPaket(pengelola); break;
                case 2: tampilkanSemuaPaket(pengelola); break;
                case 3: cariPaket(pengelola); break;
                case 4: updatePaket(pengelola); break;
                case 5: hapusPaket(pengelola); break;
                case 6: System.out.println("\nProgram selesai."); break;
                default: System.out.println("\nPilihan menu tidak tersedia!");
            }
        } while (pilihan != 6);
        input.close();
    }

    // MENU NYA
    public static void tampilkanMenu() {
        System.out.println("\n========================================");
        System.out.println("     SISTEM MANAJEMEN PAKET EKSPEDISI");
        System.out.println("========================================");
        System.out.println("1. Tambah Paket");
        System.out.println("2. Tampilkan Semua Paket");
        System.out.println("3. Cari Paket");
        System.out.println("4. Update Paket");
        System.out.println("5. Hapus Paket");
        System.out.println("6. Keluar");
        System.out.println("========================================");
    }

    // VALIDSI INPUT
    public static int inputInt(String pesan) {
        while (true) {
            System.out.print(pesan);
            String data = input.nextLine().trim();
            if (data.matches("\\d+")) {
                return Integer.parseInt(data);
            } else {
                System.out.println("Input harus berupa angka! Coba lagi.");
            }
        }
    }

    public static String inputString(String pesan) {
        System.out.print(pesan);
        return input.nextLine();
    }

    public static String inputTanggal(String pesan) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        while (true) {
            try {
                System.out.print(pesan);
                String data = input.nextLine().trim();
                Date date = sdf.parse(data);
                return sdf.format(date);
            } catch (Exception e) {
                System.out.println("Format salah! Gunakan DD-MM-YYYY");
            }
        }
    }

    // CREATE
    public static void tambahPaket(PengelolaPaket pengelola) {
        System.out.println("\n--- TAMBAH PAKET ---");
        int idPaket = inputInt("ID Paket: ");
        String noResi = inputString("Nomor Resi: ");
        String namaPengirim = inputString("Nama Pengirim: ");
        String tanggalMasuk = inputTanggal("Tanggal Masuk (DD-MM-YYYY): ");

        int idPenerima = inputInt("ID Penerima: ");
        String namaPenerima = inputString("Nama Penerima: ");
        String alamat = inputString("Alamat: ");
        String nomorHp = inputString("Nomor HP: ");
        Penerima penerima = new Penerima(idPenerima, namaPenerima, nomorHp, alamat);

        int idEkspedisi = inputInt("ID Ekspedisi: ");
        String namaEkspedisi = inputString("Nama Ekspedisi: ");
        String jenisLayanan = inputString("Jenis Layanan: ");
        Ekspedisi ekspedisi = new Ekspedisi(idEkspedisi, namaEkspedisi, jenisLayanan);

        int idKurir = inputInt("ID Kurir: ");
        String namaKurir = inputString("Nama Kurir: ");
        String nomorKurir = inputString("Nomor HP Kurir: ");
        Kurir kurir = new Kurir(idKurir, namaKurir, nomorKurir);

        String status = inputString("Status Paket: ");
        Paket paket = new Paket(idPaket, noResi, namaPengirim, tanggalMasuk, status, ekspedisi, penerima, kurir);

        pengelola.tambahPaket(paket);
        System.out.println("\nPaket berhasil ditambahkan!");
    }

    // READ
    public static void tampilkanSemuaPaket(PengelolaPaket pengelola) {
        System.out.println("\n--- DAFTAR PAKET ---");
        if (pengelola.getDaftarPaket().isEmpty()) {
            System.out.println("Belum ada data paket.");
            return;
        }
        for (Paket paket : pengelola.getDaftarPaket()) {
            tampilkanDetailPaket(paket);
        }
    }

    // CARI PAKET
    public static void cariPaket(PengelolaPaket pengelola) {
        System.out.println("\n--- CARI PAKET ---");
        System.out.println("1. Berdasarkan ID");
        System.out.println("2. Berdasarkan Nomor Resi");

        int pilihan = inputInt("Pilih metode pencarian: ");
        Paket paket = null;

        if (pilihan == 1) {
            int id = inputInt("Masukkan ID Paket: ");
            paket = pengelola.cariBerdasarkanId(id);
        } else if (pilihan == 2) {
            String resi = inputString("Masukkan Nomor Resi: ");
            paket = pengelola.cariBerdasarkanResi(resi);
        }

        if (paket == null) {
            System.out.println("Paket tidak ditemukan!");
        } else {
            tampilkanDetailPaket(paket);
        }
    }

    // DETAIL
    public static void tampilkanDetailPaket(Paket paket) {
        System.out.println("----------------------------------------");
        System.out.println("ID Paket      : " + paket.getIdPaket());
        System.out.println("No. Resi      : " + paket.getNoResi());
        System.out.println("Pengirim      : " + paket.getNamaPengirim());
        System.out.println("Tanggal Masuk : " + paket.getTanggalMasuk());
        System.out.println("Status        : " + paket.getStatus());
        System.out.println("Penerima      : " + paket.getPenerima().getNama() + " - " + paket.getPenerima().getAlamat());
        System.out.println("Ekspedisi     : " + paket.getEkspedisi().getNamaEkspedisi() + " (" + paket.getEkspedisi().getJenisLayanan() + ")");
        System.out.println("Kurir         : " + paket.getKurir().getNama() + " - " + paket.getKurir().getNomorHp());
    }

    // UPDATE
    public static void updatePaket(PengelolaPaket pengelola) {
        System.out.println("\n--- UPDATE PAKET ---");
        String resi = inputString("Masukkan Nomor Resi: ");
        Paket paket = pengelola.cariBerdasarkanResi(resi);

        if (paket == null) {
            System.out.println("Paket tidak ditemukan!");
            return;
        }

        System.out.println("\n1. Ubah Status");
        System.out.println("2. Ubah Data Penerima");
        System.out.println("3. Ubah Kurir");
        System.out.println("4. Keluar");

        int pilihan = inputInt("Pilih data yang ingin diubah: ");
        switch (pilihan) {
            case 1:
                String statusBaru = inputString("Status baru: ");
                paket.setStatus(statusBaru);
                System.out.println("Status berhasil diubah.");
                break;
            case 2:
                String namaBaru = inputString("Nama Penerima baru: ");
                String alamatBaru = inputString("Alamat baru: ");
                String hpBaru = inputString("Nomor HP baru: ");
                paket.setPenerima(new Penerima(paket.getPenerima().getId(), namaBaru, hpBaru, alamatBaru));
                System.out.println("Data penerima berhasil diubah.");
                break;
            case 3:
                String namaKurirBaru = inputString("Nama Kurir baru: ");
                String hpKurirBaru = inputString("Nomor HP Kurir baru: ");
                paket.setKurir(new Kurir(paket.getKurir().getId(), namaKurirBaru, hpKurirBaru));
                System.out.println("Data kurir berhasil diubah.");
                break;
            case 4:
                System.out.println("Update dibatalkan.");
                break;
            default:
                System.out.println("Pilihan tidak tersedia.");
        }
    }

    // DELETE
    public static void hapusPaket(PengelolaPaket pengelola) {
        System.out.println("\n--- HAPUS PAKET ---");
        int id = inputInt("Masukkan ID Paket: ");
        if (pengelola.hapusPaket(id)) {
            System.out.println("Paket berhasil dihapus.");
        } else {
            System.out.println("Paket tidak ditemukan.");
        }
    }
}