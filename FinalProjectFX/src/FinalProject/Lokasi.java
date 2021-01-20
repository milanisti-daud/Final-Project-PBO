package FinalProject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Lokasi{
    public IntegerProperty lokasi;
    public StringProperty NamaLok;

    public Lokasi(int lokasi){
        this.lokasi = new SimpleIntegerProperty (lokasi);
        this.NamaLok = new SimpleStringProperty();
    }
    
    int jarak(){
        switch (this.lokasi.get()) {
            case 4 : 
                this.NamaLok.set("Lampung Selatan");
                return 1 * 20;
                 
            case 6 :
                this.NamaLok.set("Pesawaran");
                return 2 * 20;
                 
            case 7 :
                this.NamaLok.set("Metro");
                return 3 * 20;
                 
            case 2 :
                this.NamaLok.set("Lampung Tengah");
                return 4 * 20;
                 
            case 3 :
                this.NamaLok.set("Lampung Timur");
                return 5 * 20; 
            
            case 8 :
                this.NamaLok.set("Pringsewu");
                return 6 * 20; 
            
            case 1 :
                this.NamaLok.set("Lampung Utara");
                return 7 * 20; 
            case 10 :
                this.NamaLok.set("Tulang Bawang Barat");
                return 8 * 20; 
            case 9 :
                this.NamaLok.set("Tulang Bawang");
                return 9 * 20; 
            case 11 :
                this.NamaLok.set("Mesuji");
                return 10 * 20; 
            case 5 :
                this.NamaLok.set("Lampung Barat");
                return 11 * 20; 
            case 12 :
                this.NamaLok.set("Way Kanan");
                return 12 * 20; 
            case 13 :
                this.NamaLok.set("Tanggamus");
                return 13 * 20; 
            case 14 :
                this.NamaLok.set("Pesisir Barat");
                return 14 * 20;  
            default :
                return 0;
            }
        }
    }