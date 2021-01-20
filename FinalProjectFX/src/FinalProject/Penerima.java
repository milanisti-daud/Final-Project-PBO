package FinalProject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Penerima{
    public StringProperty nama,alamat,no_hp;

    public Penerima(String nama, String alamat, String no_hp) {
        this.nama = new SimpleStringProperty (nama);
        this.alamat = new SimpleStringProperty (alamat);
        this.no_hp = new SimpleStringProperty (no_hp);
    }
    
    public String getNama(){
        return this.nama.get();
    }
}