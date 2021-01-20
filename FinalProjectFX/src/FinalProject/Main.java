/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ACER
 */
public class Main extends Application {
    
    TableView tab = new TableView();
    ObservableList Data = FXCollections.observableArrayList();
    TextField Nama = new TextField();
    TextField AlamatPeng = new TextField();
    TextField no_hp = new TextField();
    TextField Penerima = new TextField();
    TextField AlamatPenerima = new TextField();
    TextField noPenerima = new TextField();
    ComboBox Jenis = new ComboBox();
    ComboBox Lokasi = new ComboBox();
    ArrayList<String> id_lokasi = new ArrayList<String>();
    ArrayList<String> JP = new ArrayList<String>();
    int id = 1;
    
    @Override
    public void start(Stage primaryStage) {
        
        Label judul = new Label();
        judul.setText("DARI LAMPUNG UNTUK LAMPUNG");
        judul.setMinHeight(5);
        judul.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        Label subjudul = new Label();
        subjudul.setText("pengiriman dari bandar lampung "
                + "menuju berbagai \nkabupaten/kota di lampung");
        subjudul.setStyle("-fx-font-style: italic;");
        
        Nama.setPromptText("Nama Pengirim");
        AlamatPeng.setPromptText("Alamat Pengirim");
        no_hp.setPromptText("Nomor HP Pengirim");
        Penerima.setPromptText("Nama Penerima");
        AlamatPenerima.setPromptText("Alamat Penerima");
        noPenerima.setPromptText("Nomor HP Penerima");
        
        JP.add(" ");
        Jenis.setPromptText("Jenis Pengiriman");
        Jenis.setMinWidth(150);
        Jenis.getItems().add("Reguler");
        JP.add("Reguler");
        Jenis.getItems().add("Express");
        JP.add("Express");
        
        id_lokasi.add(" ");
        Lokasi.setPromptText("Lokasi Tujuan");
        Lokasi.getItems().add("Lampung Utara");
        id_lokasi.add("Lampung Utara");
        Lokasi.getItems().add("Lampung Tengah");
        id_lokasi.add("Lampung Tengah");
        Lokasi.getItems().add("Lampung Timur");
        id_lokasi.add("Lampung Timur");
        Lokasi.getItems().add("Lampung Selatan");
        id_lokasi.add("Lampung Selatan");
        Lokasi.getItems().add("Lampung Barat");
        id_lokasi.add("Lampung Barat");
        Lokasi.getItems().add("Pesawaran");
        id_lokasi.add("Pesawaran");
        Lokasi.getItems().add("Metro");
        id_lokasi.add("Metro");
        Lokasi.getItems().add("Pringsewu");
        id_lokasi.add("Pringsewu");
        Lokasi.getItems().add("Tulang Bawang");
        id_lokasi.add("Tulang Bawang");
        Lokasi.getItems().add("Tulang Bawang Barat");
        id_lokasi.add("Tulang Bawang Barat");
        Lokasi.getItems().add("Mesuji");
        id_lokasi.add("Mesuji");
        Lokasi.getItems().add("Way Kanan");
        id_lokasi.add("Way Kanan");
        Lokasi.getItems().add("Tanggamus");
        id_lokasi.add("Tanggamus");
        Lokasi.getItems().add("Pesisir Barat");
        id_lokasi.add("Pesisir Barat");
        
        Button btn = new Button();
        btn.setText("Input Data");
        btn.setOnAction(new EventHandler<ActionEvent>() {
    
            @Override
            public void handle(ActionEvent event) {
                if (Jenis.getValue().toString().equals("Reguler")){
                    Data.add(new Transaksi(id,
                        new Pengirim(
                        Nama.getText(),AlamatPeng.getText(),no_hp.getText()),
                        new Reguler(
                        id,Lokasi.getValue().toString(),id_lokasi.indexOf(
                            Lokasi.getValue().toString()),JP.indexOf(
                            Jenis.getValue().toString())),
                        new Penerima(
                            Penerima.getText(),AlamatPenerima.getText(),noPenerima.getText()),
                        new Lokasi(
                            id_lokasi.indexOf(Lokasi.getValue().toString()))
                            ));
                    id = id+1;
                }
                else if (Jenis.getValue().toString().equals("Express")){
                    Data.add(new Transaksi(id,
                        new Pengirim(
                        Nama.getText(),AlamatPeng.getText(),no_hp.getText()),
                        new Express(
                        id,Lokasi.getValue().toString(),id_lokasi.indexOf(
                            Lokasi.getValue().toString()),JP.indexOf(
                            Jenis.getValue().toString())),
                        new Penerima(
                            Penerima.getText(),AlamatPenerima.getText(),noPenerima.getText()),
                        new Lokasi(
                            id_lokasi.indexOf(Lokasi.getValue().toString()))
                            ));
                    id = id+1;
                }
                Nama.clear();
                AlamatPeng.clear();
                no_hp.clear();
                Jenis.setValue(null);
                Lokasi.setValue(null);
                Penerima.clear();
                AlamatPenerima.clear();
                noPenerima.clear();
//                Lokasi lk = new Lokasi(id_lokasi.indexOf(Lokasi.getValue().toString()));
            }
        });
        
        TableColumn colID = new TableColumn ("ID");
        colID.setCellValueFactory (new PropertyValueFactory<Transaksi,String>("ID"));
        colID.setMinWidth(100);
        
        TableColumn colPengirim = new TableColumn ("Pengirim");
        colPengirim.setCellValueFactory (new PropertyValueFactory<Transaksi,String>("pengirim"));
        colPengirim.setMinWidth(100);
        
        TableColumn colJenis = new TableColumn ("Jenis Pengiriman");
        colJenis.setCellValueFactory (new PropertyValueFactory<Transaksi,String>("Jenis"));
        colJenis.setMinWidth(100);
        
        TableColumn colPenerima = new TableColumn ("Penerima");
        colPenerima.setCellValueFactory (new PropertyValueFactory<Transaksi,String>("penerima"));
        colPenerima.setMinWidth(100);
        
        TableColumn colLokasi = new TableColumn ("Lokasi Tujuan");
        colLokasi.setCellValueFactory (new PropertyValueFactory<Transaksi,String>("lokasi"));
        colLokasi.setMinWidth(100);
        
        TableColumn colHarga = new TableColumn ("Harga");
        colHarga.setCellValueFactory (new PropertyValueFactory<Transaksi,String>("harga"));
        colHarga.setMinWidth(100);
        
        tab.setItems(Data);
        tab.getColumns().setAll(colID,colPengirim,colJenis,colLokasi,colPenerima,colHarga);
        VBox Btabel = new VBox();
        VBox Bform = new VBox(10);
        GridPane root = new GridPane();
        root.add(Btabel, 0, 0,1,1);
        Btabel.getChildren().add(tab);
        root.add(Bform, 1, 0,1,1);
        Bform.getChildren().addAll(judul,subjudul,Nama,
                AlamatPeng,no_hp,Jenis,Lokasi,Penerima,AlamatPenerima,
                noPenerima,btn);
        Bform.setStyle("-fx-padding:10;");
        // root.getChildren().add(btn);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("D L U L"); // Dari Lampung Untuk Lampung
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
//        launch(args);
          
    }
}
