# 15-Puzzle Solution using Branch &amp; Bound Algorithm 


## Penjelasan 15-Puzzle dan Algoritma Branch & Bound
Repositori ini berisi program Java untuk menyelesaikan persoalan 15-Puzzle dengan menggunakan Algoritma Branch & Bound. Nilai bound tiap simpul adalah penjumlahan cost yang diperlukan untuk sampai suatu simpul x dari akar, dengan taksiran cost simpul x untuk sampai ke <i>goal</i>. Taksiran cost yang diguanakan adalah jumlah ubin tidak kosong yang tidak berada pada tempat sesuai susunan akhir (goal state). Untuk semua instansiasi persoalan 15-puzzle, susunan akhir yang diinginkan sesuai dengan gambar di bawah: <br><br>
![15PuzzleGoal](https://user-images.githubusercontent.com/72206534/160339481-b254c17c-38ff-42f2-9de0-53e2221d59eb.png) <br>

## Spesifikasi Program
1. Program dapat menentukan apakah posisi awal suatu masukan dapat diselesaikan hingga mencapai susunan akhir dengan menimplementasikan fungsi Kurang(i) dan posisi ubin kosong di kondisi awal (X)
2. Jika tidak bisa mencapai susunan akhir, program akan menampilkan pesan tidak bisa diselesaikan
3. Jika dapat diselesaikan, program menampilkan urutan matriks rute (path) aksi yang dilakukan dari posisi awal ke susunan akhir. 
4. Program menampilkan waktu eksekusi (diluar baca input/tulis output)
5. Program menampilkan jumlah simpul yang dibangkiatkan di dalam pohon ruang status pencarian
6. (Bonus) Program dapat menampilkan pergeseran ubin dengan Graphical User Interface

### Data Uji
Data yang diujikan berupa 5 buah instansiasi persoalan 15-puzzle, dengan 2 kasus tidak dapat diselesaikan dan 3 kasus dapat diselesaikan. 
<hr>

### Made with :heart_on_fire: by Nayotama Pradipta - 13520089