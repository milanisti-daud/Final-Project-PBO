# Final Project PBO - Dari Lampung Untuk Lampung

Daud Maranatha Purba 1917051042

Adrian Septa Yoka 1917051043

Achmad Romadoni 1917051055

Untuk pembagian tugas Final Project dikerjakan bersama-sama

### Class Diagram
```mermaid
classDiagram
    Pengiriman <|-- Reguler
    Pengiriman <|-- Express
    Pengiriman <|-- Lokasi
    Transaksi <|-- Pengiriman
    Transaksi <|-- Pengirim
    Transaksi <|-- Penerima

    class Pengiriman{
        -int id
        -String lokasi
        -int id_lokasi
        -int jenis_pengiriman
        +Pengiriman(int id, String lokasi, int id_lokasi, int jenis_pengiriman)
        +Hitung()* int
        +jenisPengiriman()* String
    }
    
    class Reguler{
        -int reguler
        -String nama
        +Reguler(int id, String lokasi, int id_lokasi, int jenis_pengiriman)
        +Hitung() int
        +jenisPengiriman() String
    }

    class Express{
        -int express
        -String nama
        +Express(int id, String lokasi, int id_lokasi, int jenis_pengiriman)
        +Hitung() int
        +jenisPengiriman() String
    }

    class Lokasi{
        +int lokasi
        +String NamaLok
        +Lokasi(int lokasi)
        +Jarak() int
    }

    class Pengirim{
        -String nama
        -String alamat
        -String no_hp
        +Pengirim(String nama, String alamat, String no_hp)
        +setNama()
        +getNama() String
        +setAlamat()
        +getAlamat() String
        +setNo_hp()
        +getNo_hp() String
    }

    class Penerima{
        -String nama
        -String alamat
        -String no_hp
        +Penerima(String nama, String alamat, String no_hp)
        +setNama()
        +getNama() String
        +setAlamat()
        +getAlamat() String
        +setNo_hp()
        +getNo_hp() String
    }

    class Transaksi{
        +int ID
        +Pengirim pengirim
        +Penerima penerima
        +Lokasi lokasi
        +Pengiriman pengiriman
        +int Harga
        +Transaksi(int ID, Pengirim pengirim, Pengiriman pengiriman, Penerima penerima, Lokasi lokasi)
    }
```

### ER Diagram
```mermaid
erDiagram
          PENGIRIMAN ||--|| REGULER : is
          PENGIRIMAN ||--|| EXPRESS : is
          PENGIRIMAN }|--|| LOKASI : to
          TRANSAKSI ||--|| PENGIRIMAN : has
          TRANSAKSI }|..|| PENGIRIM : do
          TRANSAKSI }|--|| PENERIMA : do

          PENGIRIMAN{
            int id
            String lokasi
            int id_lokasi
            int jenis_pengiriman
          }

          REGULER{
            int reguler
            String nama
          }

          EXPRESS{
            int express
            String nama
          }

          LOKASI{
            int lokasi
            String NamaLok
          }

          PENGIRIM{
            String nama
            String alamat
            String no_hp
          }

          PENERIMA{
            String nama
            String alamat
            String no_hp
          }

          TRANSAKSI{
            int ID
            Pengirim pengirim
            Penerima penerima
            Lokasi lokasi
            Pengiriman pengiriman
            int Harga
          }
```
