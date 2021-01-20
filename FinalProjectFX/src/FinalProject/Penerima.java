package FinalProject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Penerima{
//    public IntegerProperty id_penerima;
    public StringProperty nama,alamat,no_hp;
    
    public Penerima(String nama, String alamat, String no_hp) {
//    public Penerima(int id_penerima, String nama, String alamat, String no_hp) {
//        this.id_penerima = new SimpleIntegerProperty (id_penerima);
        this.nama = new SimpleStringProperty (nama);
        this.alamat = new SimpleStringProperty (alamat);
        this.no_hp = new SimpleStringProperty (no_hp);
    }
    
//    public int getId_penerima(){
//        return this.id_penerima.get();
//    }
//    
//    public void setId_penerima(IntegerProperty id_penerima){
//        this.id_penerima = id_penerima;
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