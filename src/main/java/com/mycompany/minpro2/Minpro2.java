/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.minpro2;

/**
 *
 * @author LENOVO
 */
import com.mycompany.minpro2.app.ManajemenPaket;
import com.mycompany.minpro2.model.*;

public class Minpro2 {
    public static void main(String[] args) {
        // Buat dummy data awal
        PengelolaPaket pengelola = new PengelolaPaket(1, "Admin Ekspedisi", "08123456789");

        Ekspedisi ekspedisi = new Ekspedisi(1, "JNE", "Reguler");
        Penerima penerima = new Penerima(1, "Arham", "08123456789", "Sangatta");
        Kurir kurir = new Kurir(1, "Budi", "08129876543");

        Paket paket = new Paket(1, "RESI001", "Doni", "23-09-2026", "Dalam Proses",
                                ekspedisi, penerima, kurir);

        pengelola.tambahPaket(paket);

        // Jalankan menu utama
        ManajemenPaket.main(args);
    }
}

