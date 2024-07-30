import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------- PROGRAMMING TEST ----------");
        System.out.println();
        fibonnaci();
    }

    public static void fibonnaci(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- SOAL 3 ----------");

        System.out.print("Masukkan angka: ");
        int n = scanner.nextInt();



        // Inisialisasi variabel untuk urutan Fibonacci
        ArrayList<Integer> fibonacciNumbers = new ArrayList<>();
        int a = 1;
        int b = 1;

        // Menambahkan angka pertama dan kedua ke dalam daftar
        if (n >= 1) {
            fibonacciNumbers.add(a);
        }
        if (n >= 1) {
            fibonacciNumbers.add(b);
        }

        // Menghitung dan menambahkan angka Fibonacci berikutnya
        while (true) {
            int c = a + b;
            if (c > n) {
                break;
            }
            fibonacciNumbers.add(c);
            a = b;
            b = c;
        }

        // Menampilkan hasil
        for (int number : fibonacciNumbers) {
            System.out.print(number + " ");

        }
        System.out.println();



        rightPyramid();
    }

    public static void rightPyramid(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- SOAL 4 ----------");

        System.out.print("Masukkan angka: ");
        int n = scanner.nextInt();



        // Menghasilkan pola bintang
        for (int i = 1; i <= n; i++) {
            int stars = 2 * i - 1; // Jumlah bintang pada baris ke-i
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            System.out.println(); // Pindah ke baris berikutnya setelah mencetak bintang


        }
        System.out.println();

        digitAndAddition();


    }

    public static void digitAndAddition(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- SOAL 5 ----------");

        System.out.print("Masukkan angka: ");
        int number = scanner.nextInt();

        System.out.print("Masukkan panjang total output: ");
        int totalLength = scanner.nextInt();


        // Menghitung panjang angka saat ini
        int currentLength = String.valueOf(number).length();

        // Menghitung jumlah nol yang diperlukan
        int paddingLength = totalLength - currentLength;

        // Membuat format string dengan nol padding
        String formatString = "%0" + totalLength + "d";

        // Mencetak angka dengan nol padding di depan
        System.out.printf(formatString, number);

        // Menutup scanner
        scanner.close();
    }
}