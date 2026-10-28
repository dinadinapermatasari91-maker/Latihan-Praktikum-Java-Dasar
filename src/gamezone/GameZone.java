
package gamezone;

import java.util.Scanner;

public class GameZone {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String transaksi;

        do {
            tampilkanJudul();

            System.out.print("Nama Pelanggan : ");
            String nama = input.nextLine();

            System.out.println("1. PlayStation 4 - Rp8000/jam");
            System.out.println("2. PlayStation 5 - Rp12000/jam");

            int pilihan;
            do {
                pilihan = bacaInteger("Pilihan         : ");

                if (pilihan != 1 && pilihan != 2) {
                    System.out.println("Pilih angka 1 atau 2!");
                }
            } while (pilihan != 1 && pilihan != 2);

            String konsol;
            int harga;

            if (pilihan == 1) {
                konsol = "PlayStation 4";
                harga = 8000;
            } else {
                konsol = "PlayStation 5";
                harga = 12000;
            }

            int durasi;
            do {
                durasi = bacaInteger("Lama Bermain    : ");

                if (durasi <= 0) {
                    System.out.println("Durasi harus lebih dari 0!");
                }
            } while (durasi <= 0);

            int biayaSewa = harga * durasi;
            int diskon = 0;

            if (durasi >= 3) {
                diskon = biayaSewa * 10 / 100;
            }

            System.out.print("Tambah Minuman (Y/T): ");
            String jawaban = input.nextLine().trim();

            while (!jawaban.equalsIgnoreCase("Y")
                    && !jawaban.equalsIgnoreCase("T")) {
                System.out.print("Masukkan Y atau T: ");
                jawaban = input.nextLine().trim();
            }

            int minuman = 0;

            if (jawaban.equalsIgnoreCase("Y")) {
                minuman = 5000;
            }

            int total = biayaSewa - diskon + minuman;

            cetakStruk(nama, konsol, durasi,
                    biayaSewa, diskon, minuman, total);

            System.out.print("Transaksi Baru (Y/T): ");
            transaksi = input.nextLine().trim();

            while (!transaksi.equalsIgnoreCase("Y")
                    && !transaksi.equalsIgnoreCase("T")) {
                System.out.print("Masukkan Y atau T: ");
                transaksi = input.nextLine().trim();
            }

        } while (transaksi.equalsIgnoreCase("Y"));

        System.out.println("Terima kasih!");
        input.close();
    }

    static void tampilkanJudul() {
        System.out.println("====================================");
        System.out.println("         GAMEZONE RENTAL PS");
        System.out.println("====================================");
    }

    static int bacaInteger(String pesan) {
        while (true) {
            System.out.print(pesan);

            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka bulat yang benar!");
            }
        }
    }

    static void cetakStruk(String nama, String konsol, int durasi,
            int biayaSewa, int diskon, int minuman, int total) {

        System.out.println("------------------------------------");
        System.out.println("           STRUK GAMEZONE");
        System.out.println("Pelanggan       : " + nama);
        System.out.println("Konsol          : " + konsol);
        System.out.println("Durasi          : " + durasi + " jam");
        System.out.println("Biaya Sewa      : Rp" + biayaSewa);
        System.out.println("Diskon (10%)    : Rp" + diskon);
        System.out.println("Minuman         : Rp" + minuman);
        System.out.println("TOTAL BAYAR     : Rp" + total);
        System.out.println("====================================");
    }
}
