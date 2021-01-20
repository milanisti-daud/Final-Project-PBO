package FinalProject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Pengiriman{
    private IntegerProperty id,id_lokasi,jenis_pengiriman;
    private StringProperty lokasi;

    public Pengiriman(int id, String lokasi,int id_lokasi, int jenis_pengiriman) {
        this.id = new SimpleIntegerProperty(id);
        this.lokasi = new SimpleStringProperty (lokasi);
        this.id_lokasi = new SimpleIntegerProperty (id_lokasi);
        this.jenis_pengiriman = new SimpleIntegerProperty (jenis_pengiriman);
    }
    
    public abstract int hitung();
    public abstract IntegerProperty hitungProperty();
    public abstract String jenisPengiriman();
    public abstract StringProperty namaProperty();
    
}