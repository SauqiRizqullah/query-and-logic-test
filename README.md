# README: 
# Tes SQL

Dokumen ini berisi penjelasan mengenai dua soal SQL beserta jawaban dan penjelasannya.

## Soal 1: Menghitung Jumlah Penjualan

### Deskripsi

Buatlah tabel `BARANG` dan `JUAL`, lalu hitung jumlah total penjualan untuk setiap barang, termasuk barang yang mungkin tidak terjual.

### Tabel dan Data

```sql
-- Membuat tabel BARANG
CREATE TABLE BARANG (
    KODEBRG int NOT NULL,
    NAMABRG varchar(255) NOT NULL
);

-- Menambahkan data ke tabel BARANG
INSERT INTO BARANG (KODEBRG, NAMABRG) VALUES (1, 'MEJA');
INSERT INTO BARANG (KODEBRG, NAMABRG) VALUES (2, 'KURSI');
INSERT INTO BARANG (KODEBRG, NAMABRG) VALUES (3, 'LAMPU');

-- Membuat tabel JUAL
CREATE TABLE JUAL (
    KODEBRG int NOT NULL,
    JUMLAH int NOT NULL
);

-- Menambahkan data ke tabel JUAL
INSERT INTO JUAL (KODEBRG, JUMLAH) VALUES (1, 2);
INSERT INTO JUAL (KODEBRG, JUMLAH) VALUES (1, 3);
INSERT INTO JUAL (KODEBRG, JUMLAH) VALUES (2, 4);
```

### Jawaban

```
-- Menghitung jumlah penjualan untuk setiap barang
SELECT a.KODEBRG,
       a.NAMABRG,
       COALESCE(SUM(B.JUMLAH), 0) AS JML_JUAL
FROM BARANG a
LEFT JOIN JUAL B
ON a.KODEBRG = B.KODEBRG
GROUP BY a.NAMABRG, a.KODEBRG
ORDER BY a.KODEBRG ASC;
```

## Soal 2: Menghitung Stok Terakhir Barang

### Tabel dan Data

```sql
-- Membuat tabel HISTORYSTOKBARANG
CREATE TABLE HISTORYSTOKBARANG (
    KODESTOK int NOT NULL,
    TANGGAL DATE,
    KODEBARANG char(1),
    STOKAKHIR int
);

-- Menambahkan data ke tabel HISTORYSTOKBARANG
INSERT INTO HISTORYSTOKBARANG (KODESTOK, TANGGAL, KODEBARANG, STOKAKHIR)
VALUES (1, '2009-01-01', 'A', 2);
INSERT INTO HISTORYSTOKBARANG (KODESTOK, TANGGAL, KODEBARANG, STOKAKHIR)
VALUES (2, '2009-01-02', 'A', 5);
INSERT INTO HISTORYSTOKBARANG (KODESTOK, TANGGAL, KODEBARANG, STOKAKHIR)
VALUES (3, '2009-01-02', 'B', 1);
INSERT INTO HISTORYSTOKBARANG (KODESTOK, TANGGAL, KODEBARANG, STOKAKHIR)
VALUES (4, '2009-01-03', 'A', 3);
INSERT INTO HISTORYSTOKBARANG (KODESTOK, TANGGAL, KODEBARANG, STOKAKHIR)
VALUES (5, '2009-01-03', 'B', 3);
INSERT INTO HISTORYSTOKBARANG (KODESTOK, TANGGAL, KODEBARANG, STOKAKHIR)
VALUES (6, '2009-01-04', 'A', 5);
INSERT INTO HISTORYSTOKBARANG (KODESTOK, TANGGAL, KODEBARANG, STOKAKHIR)
VALUES (7, '2009-01-04', 'A', 4);

```

### Jawaban

```sql
WITH TANGGALTERAKHIR AS (
    SELECT KODEBARANG,
           MAX(TANGGAL) AS TANGGAL
    FROM HISTORYSTOKBARANG
    GROUP BY KODEBARANG
)

SELECT DISTINCT a.KODEBARANG,
                a.STOKAKHIR
FROM HISTORYSTOKBARANG a
JOIN TANGGALTERAKHIR b
ON a.KODEBARANG = b.KODEBARANG
AND a.TANGGAL = b.TANGGAL
ORDER BY a.KODEBARANG ASC;

```

# Tes Pemrograman

## Ringkasan   

Program Java ini terdiri dari tiga tugas utama:

1. **Generator Urutan Fibonacci**
2. **Pola Piramida Segitiga**
3. **Penambahan dan Padding Digit**

Setiap tugas meminta input dari pengguna dan melakukan operasi tertentu berdasarkan input tersebut. Berikut adalah penjelasan mendetail tentang kode dan fungsionalitas setiap bagiannya.

## Penjelasan Kode

### Soal 3. Generator Urutan Fibonacci

#### Metode: `fibonnaci()`

Metode ini menghasilkan dan mencetak angka-angka Fibonacci hingga nilai tertentu. Urutan Fibonacci adalah rangkaian angka di mana setiap angka adalah jumlah dari dua angka sebelumnya.

**Langkah-langkah:**

1. **Input**:
    - Meminta pengguna untuk memasukkan angka (`n`).

2. **Inisialisasi**:
    - Menginisialisasi dua variabel `a` dan `b` dengan dua angka Fibonacci pertama, yaitu 1 dan 1.
    - Membuat `ArrayList<Integer>` untuk menyimpan angka-angka Fibonacci.

3. **Menambahkan Nilai Awal**:
    - Menambahkan dua angka Fibonacci pertama ke dalam daftar jika `n` lebih besar dari atau sama dengan 1.

4. **Menghasilkan Urutan**:
    - Menggunakan loop `while` untuk menghasilkan angka-angka Fibonacci dan menambahkannya ke dalam daftar hingga angka berikutnya melebihi `n`.

5. **Output**:
    - Mencetak angka-angka Fibonacci yang telah dihasilkan.

6. **Tugas Berikutnya**:
    - Memanggil `rightPyramid()` untuk melanjutkan ke tugas berikutnya.

### Soal 4. Pola Piramida Segitiga

#### Metode: `rightPyramid()`

Metode ini menghasilkan dan mencetak pola piramida segitiga bintang (`*`) berdasarkan input dari pengguna.

**Langkah-langkah:**

1. **Input**:
    - Meminta pengguna untuk memasukkan angka (`n`).

2. **Menghasilkan Pola**:
    - Menggunakan loop bersarang untuk mencetak piramida bintang (`*`).
    - Untuk setiap baris `i`, menghitung jumlah bintang sebagai `2 * i - 1` dan mencetaknya.

3. **Output**:
    - Mencetak pola bintang yang telah dihasilkan.

4. **Tugas Berikutnya**:
    - Memanggil `digitAndAddition()` untuk melanjutkan ke tugas terakhir.

### Soal 5. Penambahan dan Padding Digit

#### Metode: `digitAndAddition()`

Metode ini memformat sebuah angka dengan menambahkan nol di depan hingga mencapai panjang total yang ditentukan dan mencetak hasilnya.

**Langkah-langkah:**

1. **Input**:
    - Meminta pengguna untuk memasukkan angka.
    - Meminta pengguna untuk memasukkan panjang total output yang diinginkan.

2. **Menghitung Padding**:
    - Menghitung jumlah nol yang diperlukan untuk mencapai panjang total yang diinginkan.

3. **Format Output**:
    - Membuat string format dengan nol padding berdasarkan panjang total yang ditentukan.
    - Menggunakan `String.format` untuk menambahkan nol di depan angka dan mencetaknya.

4. **Pembersihan**:
    - Menutup instance `Scanner`.

