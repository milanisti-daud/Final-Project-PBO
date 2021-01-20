package FinalProject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pengirim{
//    public IntegerProperty id_pengirim;
    public StringProperty nama,alamat,no_hp;
    
//    public Pengirim(int id_pengirim, String nama, String alamat, String no_hp) {
    public Pengirim(String nama, String alamat, String no_hp) {
//        this.id_pengirim = new SimpleIntegerProperty (id_pengirim);
        this.nama = new SimpleStringProperty (nama);
        this.alamat = new SimpleStringProperty (alamat);
        this.no_hp = new SimpleStringProperty (no_hp);
    }
    
//    public int getId_pengirim(){
//        return this.id_pengirim.get();
//    }
//    
//    public void setId_pengirim(IntegerProperty id_pengirim){
//        this.id_pengirim = id_pengirim;
//    }
    
    public String getNama(){
        return this.nama.get();
    }
    
    public void setNama(StringProperty nama){
        this.nama = nama;
    }
    
    public String getAlamat(){
        return this.alamat.get();
    }
    
    public void setAlamat(StringProperty alamat){
        this.alamat = alamat;
    }
    
    public String getNo_hp(){
        return this.no_hp.get();
    }
    
    public void setNo_hp(StringProperty no_hp){
        this.no_hp = no_hp;
    }
}