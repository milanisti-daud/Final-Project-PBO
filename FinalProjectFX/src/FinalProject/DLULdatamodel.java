/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ACER
 */
public class DLULdatamodel {
    private final Connection CONN;
    
    public DLULdatamodel(String driver) throws SQLException {
        this.CONN = koneksi.koneksi(driver);
    }
    
    public void inputData(Transaksi transaksi)throws SQLException{
        String insertPengirim = "INSERT INTO Pengirim (id_pengirim,nama_pengirim,alamat,no_hp)"
                + " VALUES (?,?,?)";
        String insertPenerima = "INSERT INTO Penerima (id_penerima,nama,alamat,no_hp)"
                + " VALUES (?,?,?,?)";
        String insertLokasi = "INSERT INTO Lokasi (id_lokasi,Nama_lokasi)"
                + " VALUES (?,?)";
        String insertPengiriman = "INSERT INTO Pengiriman (id_pengiriman,jenis_pengiriman,lokasi_tujuan,id_lokasi)"
                + " VALUES (?,?,?,?)";
        String insertTransaksi = "INSERT INTO Transaksi (id_transaksi,id_pegirim,penerima,"
                + "id_lokasi,id_pengiriman,harga)"
                + " VALUES (?,?,?,?,?,?)";
        
        PreparedStatement stmtPengirim = CONN.prepareStatement(insertPengirim);
        
    }
}
