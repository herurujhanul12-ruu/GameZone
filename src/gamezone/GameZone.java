
package gamezone;

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class GameZone {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String ulang;

        do {
            prosesTransaksi();

            System.out.print("\nTransaksi Baru (Y/T): ");
            ulang = input.nextLine().trim();

            while (!ulang.equalsIgnoreCase("Y")
                    && !ulang.equalsIgnoreCase("T")) {
                System.out.print("Masukkan Y atau T: ");
                ulang = input.nextLine().trim();
            }

        } while (ulang.equalsIgnoreCase("Y"));

        System.out.println("Terima kasih telah menggunakan GameZone!");
        input.close();
    }

    // Method untuk memproses satu transaksi
    public static void prosesTransaksi() {
        String nama;
        String konsol;
        int pilihan;
        int durasi;
        int harga;
        int biayaSewa;
        int diskon;
        int biayaMinuman;
        int totalBayar;
        String minuman;

        System.out.println("\n====================================");
        System.out.println("          GAMEZONE RENTAL PS");
        System.out.println("====================================");

        System.out.print("Nama Pelanggan : ");
        nama = input.nextLine().trim();

        while (nama.isEmpty()) {
            System.out.print("Nama tidak boleh kosong. Masukkan nama: ");
            nama = input.nextLine().trim();
        }

        System.out.println("1. PlayStation 4 - Rp8000/jam");
        System.out.println("2. PlayStation 5 - Rp12000/jam");

        System.out.print("Pilihan         : ");
        pilihan = bacaBilangan();

        while (pilihan != 1 && pilihan != 2) {
            System.out.print("Pilih 1 untuk PS4 atau 2 untuk PS5: ");
            pilihan = bacaBilangan();
        }

        if (pilihan == 1) {
            konsol = "PlayStation 4";
            harga = 8000;
        } else {
            konsol = "PlayStation 5";
            harga = 12000;
        }

        System.out.print("Lama Bermain (jam): ");
        durasi = bacaBilangan();

        while (durasi <= 0) {
            System.out.print("Durasi harus bilangan positif: ");
            durasi = bacaBilangan();
        }

        biayaSewa = harga * durasi;

        if (durasi >= 3) {
            diskon = biayaSewa * 10 / 100;
        } else {
            diskon = 0;
        }

        System.out.print("Tambah Minuman (Y/T): ");
        minuman = input.nextLine().trim();

        while (!minuman.equalsIgnoreCase("Y")
                && !minuman.equalsIgnoreCase("T")) {
            System.out.print("Masukkan Y atau T: ");
            minuman = input.nextLine().trim();
        }

        if (minuman.equalsIgnoreCase("Y")) {
            biayaMinuman = 5000;
        } else {
            biayaMinuman = 0;
        }

        totalBayar = biayaSewa - diskon + biayaMinuman;

        System.out.println("------------------------------------");
        System.out.println("            STRUK GAMEZONE");
        System.out.println("------------------------------------");
        System.out.println("Pelanggan     : " + nama);
        System.out.println("Konsol        : " + konsol);
        System.out.println("Durasi        : " + durasi + " jam");
        System.out.println("Biaya Sewa    : " + rupiah(biayaSewa));
        System.out.println("Diskon (10%)  : " + rupiah(diskon));
        System.out.println("Minuman       : " + rupiah(biayaMinuman));
        System.out.println("------------------------------------");
        System.out.println("TOTAL BAYAR   : " + rupiah(totalBayar));
        System.out.println("====================================");
    }

    // Method untuk membaca bilangan bulat
    public static int bacaBilangan() {
        while (true) {
            String teks = input.nextLine().trim();

            try {
                return Integer.parseInt(teks);
            } catch (NumberFormatException e) {
                System.out.print("Masukkan bilangan bulat yang benar: ");
            }
        }
    }

    // Method untuk menampilkan format mata uang Rupiah
    public static String rupiah(int jumlah) {
        NumberFormat format =
                NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        format.setMaximumFractionDigits(0);
        format.setMinimumFractionDigits(0);

        return format.format(jumlah);
    }
}
