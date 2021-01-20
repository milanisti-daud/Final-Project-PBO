package FinalProject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Express extends Pengiriman{
    IntegerProperty express;
    StringProperty nama;

    public Express(int id, String lokasi, int id_lokasi, int jenis_pengiriman) {
        super(id, lokasi, id_lokasi, jenis_pengiriman);
        this.express = new SimpleIntegerProperty (500);
        this.nama = new SimpleStringProperty ("Express");
    }
    
    @Override
    public int hitung(){
        return this.express.get();
    }

    @Override
    public IntegerProperty hitungProperty() {
        return this.express;
    }

    @Override
    public String jenisPengiriman() {
        return this.nama.get();
    }

    @Override
    public StringProperty namaProperty() {
        return this.nama;
    }
}