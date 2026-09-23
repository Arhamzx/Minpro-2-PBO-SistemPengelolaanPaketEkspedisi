# Minpro-1-PBO-SistemPengelolaanPaketEkspedisi

MUHAMMAD ARHAM ANUGRAH - 2509116044


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Sistem Pengelolaan Paket merupakan program berbasis Java yang dibuat untuk membantu proses pencatatan dan pengelolaan data paket pada suatu layanan pengiriman. Program ini dirancang untuk mengelola paket dari berbagai jasa ekspedisi, seperti JNE, J&T, dan SPX, sehingga sistem tidak terbatas pada satu perusahaan ekspedisi saja.Setiap paket memiliki informasi yang dapat dikelola, seperti nomor resi, nama penerima, alamat tujuan, jenis layanan, serta jasa ekspedisi yang digunakan. Dengan demikian, pengguna dapat mencatat dan mengelola berbagai paket dari ekspedisi yang berbeda dalam satu sistem.


Program menyediakan fitur CRUD (Create, Read, Update, Delete) yang memungkinkan pengguna untuk menambahkan data paket baru, melihat daftar paket, mengubah informasi paket, dan menghapus data paket. Penggunaan berbagai jasa ekspedisi pada program bertujuan agar sistem lebih fleksibel dan dapat digunakan untuk mengelola paket secara umum. Jasa ekspedisi diperlakukan sebagai bagian dari informasi paket, sehingga pengguna dapat mencatat paket berdasarkan ekspedisi yang digunakan tanpa perlu membuat sistem yang berbeda untuk setiap perusahaan ekspedisi.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Alur Program

**1.** Program dijalankan melalui `Minpro2.java` sebagai entry point dan masuk pada tampilan menu utama 

<img width="1277" height="715" alt="image" src="https://github.com/user-attachments/assets/84bfc69c-250d-4edd-b439-0a3873e6da28" /> Program menampilkan 6 pilihan menu yakni tambah paket, tampilkan semua paket, cari paket, update paket, hapus paket, dan keluar

**2.** User memilih menu 1 untuk menambah data paket (create) 

<img width="548" height="736" alt="image" src="https://github.com/user-attachments/assets/31f59304-671b-4999-bca7-bfbc0b99d290" /> 

Setelah masuk dalam menu tambah paket, user akan diminta untuk mengisi data paket mulai dari id paket, no resi, nama pengirim, dan tanggal masuk. Di data penerima id penerima, nama penerima, alamat, dan no hp. Pada data ekspedisi, id ekspedisi, nama ekspedisi ex"JNE", dan jenis layanan ex"REG, EXPRESS etc". Terakhir adalah data kurir yakni idkurir, nama kurir dan no hp kurir.

**3.** Untuk menampilkan semua data paket (Read), user memilih menu 2 

<img width="765" height="806" alt="image" src="https://github.com/user-attachments/assets/1ca9be37-76c4-43dd-8fb5-53e1de0d4de8" />

**4.** Cari paket menggunakan menu 3 (Read), 

<img width="549" height="431" alt="image" src="https://github.com/user-attachments/assets/0267e493-6729-475b-a9eb-e79b02dc66df" /> 

pertama, user akan memilih mencari berdasarkan id atau no resi, pada kasus dimana paket sedikit, user bisa menggunakan pencarian berdasarkan id, disaat data paket cukup banyak dapat menggunakan no resi. Program akan menampilkan data paket yang tertera mulai dari detail, penerima, ekspedisi hingga kurir.

**5.** Update paket (update), dapat digunakan user untuk mengubah status paket ataupun data penerima hinngga kurir jika terjadi salah input menggunakan menu 4. 

<img width="691" height="552" alt="image" src="https://github.com/user-attachments/assets/4e4cc94a-aeee-4a60-a018-857416ffa99b" /> 

jika user tidak jadi menupdate data maka dapat menekan keluar.

**6.** Hapus paket(delete) 

<img width="584" height="394" alt="image" src="https://github.com/user-attachments/assets/916f16a5-f73e-452c-b9d4-fe2f17802166" /> 

dapat user gunakan apabila ingin menghapus data paket

**7.** Menu keluar, dapat digunakan user untuk keluar dari program
   
<img width="856" height="484" alt="image" src="https://github.com/user-attachments/assets/1565a28f-4324-4302-a162-112dcd7ff72d" />


------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Access modifier diterapkan pada deklarasi atribut dan method di setiap class, seperti penggunaan private pada atribut dan public pada method. Encapsulation diterapkan dengan membatasi akses atribut menggunakan private dan menyediakan method seperti getter untuk mengakses data tersebut. Input validation diterapkan pada bagian program yang menerima input dari pengguna seperti pada menu utama yang mewajibkan user memilih menu 1 - 6, ketika user memilih 0, maka user akan diminta untuk memasukkan angka >0 dan jika >6 maka menampilkan output menu tidak tersedia!, Validasi input juga digunakan pada input tanggal masuk paket yang mewajibkan menggunakan format dd-mm-yy

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Penerapan Encapsulation & Inheritance
- **Encapsulation** = semua atribut di class (`Person`, `Paket`, `Ekspedisi`, dll.) dibuat `private` dan diakses melalui getter/setter.  
- **Inheritance** = class `Kurir`, `Penerima`, dan `PengelolaPaket` merupakan subclass dari superclass `Person`. Dengan pewarisan ini, atribut umum (`id`, `nama`, `nomorHp`) tidak perlu ditulis ulang di setiap subclass.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Struktur MVC
Program ini menerapkan **struktur MVC**:
- **Model** = package `model` berisi class data (`Person`, `Kurir`, `Penerima`, `PengelolaPaket`, `Ekspedisi`, `Paket`).  
- **View + Controller** = package `app` berisi `ManajemenPaket.java` yang menangani input/output dan logika menu.  
- **Entry Point** = `Minpro2.java` sebagai penghubung utama yang menjalankan program.  

Dengan pemisahan ini, kode lebih terstruktur, mudah dipelihara, dan sesuai prinsip MVC.
