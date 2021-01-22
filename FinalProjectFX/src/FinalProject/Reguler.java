package FinalProject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Reguler extends Pengiriman{
    private IntegerProperty reguler;
    private StringProperty nama;

    public Reguler(int id, String lokasi, int id_lokasi, int jenis_pengiriman) {
        super(id, lokasi, id_lokasi, jenis_pengiriman);
        this.reguler = new SimpleIntegerProperty (250);
        this.nama = new SimpleStringProperty ("Reguler");
    }
    
    @Override
    public int hitung(){
        return this.reguler.get();
    }

    @Override
    public IntegerProperty hitungProperty() {
        return this.reguler;
    }

    @Override
    public String jenisPengiriman() {
        return this.nama.get();
    }

    @Override
    public StringProperty namaProperty() {
        return this.nama;
    }

    @Override
    public String getJenis() {
        return this.nama.get();
    }
}