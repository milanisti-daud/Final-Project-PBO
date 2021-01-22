package FinalProject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;


public class Transaksi{
    IntegerProperty ID;
    Pengirim pengirim;
    Penerima penerima;
    Lokasi lokasi;
    Pengiriman pengiriman;
    IntegerProperty Harga;

    public Transaksi(int ID,Pengirim pengirim, Pengiriman pengiriman, Penerima penerima, Lokasi lokasi) {
        this.ID = new SimpleIntegerProperty(ID);
        this.pengiriman = pengiriman;
        this.pengirim = pengirim;
        this.penerima = penerima;
        this.lokasi = lokasi;
        this.Harga = new SimpleIntegerProperty(pengiriman.hitung() * lokasi.jarak());
    }
    
    
    public IntegerProperty hargaProperty(){
        return this.Harga;
    }
    
    public StringProperty penerimaProperty(){
        return penerima.nama;
    }
    
    public StringProperty pengirimProperty(){
        return pengirim.nama;
    }
    
    public StringProperty lokasiProperty(){
        return lokasi.NamaLok;
    }
    
    public StringProperty JenisProperty(){
        return pengiriman.namaProperty();
    }
    
    public IntegerProperty IDProperty(){
        return this.ID;
    }
}