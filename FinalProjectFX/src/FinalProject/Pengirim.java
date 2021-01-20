package FinalProject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pengirim{
    public StringProperty nama,alamat,no_hp;
    
    public Pengirim(String nama, String alamat, String no_hp) {
        this.nama = new SimpleStringProperty (nama);
        this.alamat = new SimpleStringProperty (alamat);
        this.no_hp = new SimpleStringProperty (no_hp);
    }
}