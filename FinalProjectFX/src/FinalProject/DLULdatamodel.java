/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ACER
 */
public class DLULdatamodel {

    public final Connection CONN;

    public DLULdatamodel(String driver) throws SQLException {
        this.CONN = koneksi.koneksi(driver);
    }

    public void inputData(Transaksi transaksi) throws SQLException {
        String insertPengirim = "INSERT INTO Pengirim (id_pengirim,nama_pengirim,alamat,no_hp)"
                + " VALUES (?,?,?,?)";
        String insertPenerima = "INSERT INTO Penerima (id_penerima,nama,alamat,no_hp)"
                + " VALUES (?,?,?,?)";
        String insertPengiriman = "INSERT INTO Pengiriman (id_pengiriman,jenis_pengiriman,lokasi_tujuan,id_lokasi)"
                + " VALUES (?,?,?,?)";
        String insertTransaksi = "INSERT INTO `transaksi` (`id_transaksi`, `id_pengirim`, `id_penerima`, "
                + "`id_lokasi`, `id_pengiriman`, `Harga`)"
                + " VALUES (?,?,?,?,?,?)";

        PreparedStatement stmtPengirim = CONN.prepareStatement(insertPengirim);
        stmtPengirim.setInt(1, transaksi.ID.get());
        stmtPengirim.setString(2, transaksi.pengirim.getNama());
        stmtPengirim.setString(3, transaksi.pengirim.getAlamat());
        stmtPengirim.setString(4, transaksi.pengirim.getNo_hp());
        stmtPengirim.execute();

        PreparedStatement stmtPenerima = CONN.prepareStatement(insertPenerima);
        stmtPenerima.setInt(1, transaksi.ID.get());
        stmtPenerima.setString(2, transaksi.penerima.getNama());
        stmtPenerima.setString(3, transaksi.penerima.getAlamat());
        stmtPenerima.setString(4, transaksi.penerima.getNo_hp());
        stmtPenerima.execute();

        PreparedStatement stmtPengiriman = CONN.prepareStatement(insertPengiriman);
        stmtPengiriman.setInt(1, transaksi.pengiriman.getID());
        stmtPengiriman.setString(2, transaksi.pengiriman.getJenis());
        stmtPengiriman.setString(3, transaksi.lokasi.NamaLok.get());
        stmtPengiriman.setInt(4, transaksi.lokasi.lokasi.get());
        stmtPengiriman.execute();

        PreparedStatement stmtTransaksi = CONN.prepareStatement(insertTransaksi);
        stmtTransaksi.setInt(1, transaksi.ID.get());
        stmtTransaksi.setInt(2, transaksi.ID.get());
        stmtTransaksi.setInt(3, transaksi.ID.get());
        stmtTransaksi.setInt(4, transaksi.lokasi.lokasi.get());
        stmtTransaksi.setInt(5, transaksi.pengiriman.getID());
        stmtTransaksi.setInt(6, transaksi.Harga.get());
        stmtTransaksi.execute();

    }

    public ObservableList getData() throws SQLException {
        ObservableList<Transaksi> data = FXCollections.observableArrayList();
        Pengirim pengirim;
        Penerima penerima;
        Lokasi lokasi;
        Pengiriman pengiriman;

        String sqlPengirim = "SELECT * FROM `pengirim`";
        String sqlPenerima = "SELECT * FROM `penerima`";
        String sqlPengiriman = "SELECT * FROM `pengiriman`";
        String sqlLokasi = "SELECT * FROM `transaksi` NATURAL JOIN `lokasi`";
        String sqlTransaksi = "SELECT * FROM `transaksi`";


        try {
            ResultSet rsTransaksi = CONN.createStatement().executeQuery(sqlTransaksi);
            ResultSet rsPenerima = CONN.createStatement().executeQuery(sqlPenerima);
            ResultSet rsPengiriman = CONN.createStatement().executeQuery(sqlPengiriman);
            ResultSet rsPengirim = CONN.createStatement().executeQuery(sqlPengirim);
            ResultSet rsLokasi = CONN.createStatement().executeQuery(sqlLokasi);
            while (rsTransaksi.next() && rsPengirim.next() && rsPenerima.next()
                    && rsPengiriman.next() && rsLokasi.next()) {
                if (rsPengiriman.getString("jenis_pengiriman").equals("Reguler")) {

                    pengirim = new Pengirim(rsPengirim.getString("nama_pengirim"),
                            rsPengirim.getString("alamat"),
                            rsPengirim.getString("no_hp"));

                    penerima = new Penerima(rsPenerima.getString("nama"),
                            rsPenerima.getString("alamat"),
                            rsPenerima.getString("no_hp"));

                    pengiriman = new Reguler(rsPengiriman.getInt("id_pengiriman"),
                            rsPengiriman.getString("lokasi_tujuan"),
                            rsPengiriman.getInt("id_lokasi"), 1);

                    lokasi = new Lokasi(rsLokasi.getInt("id_lokasi"));
                    data.add(new Transaksi(rsTransaksi.getInt(1), pengirim, pengiriman,
                            penerima, lokasi));
                } else {

                    pengirim = new Pengirim(rsPengirim.getString("nama_pengirim"),
                            rsPengirim.getString("alamat"),
                            rsPengirim.getString("no_hp"));

                    penerima = new Penerima(rsPenerima.getString("nama"),
                            rsPenerima.getString("alamat"),
                            rsPenerima.getString("no_hp"));

                    pengiriman = new Express(rsPengiriman.getInt("id_pengiriman"),
                            rsPengiriman.getString("lokasi_tujuan"),
                            rsPengiriman.getInt("id_lokasi"), 1);

                    lokasi = new Lokasi(rsLokasi.getInt("id_lokasi"));
                    data.add(new Transaksi(rsTransaksi.getInt(1), pengirim, pengiriman,
                            penerima, lokasi));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DLULdatamodel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public int ID() throws SQLException {
        String sql = "SELECT MAX(id_transaksi) from transaksi";
        ResultSet rs = CONN.createStatement().executeQuery(sql);
        while (rs.next()) {
            return rs.getInt(1) == 0 ? 1001 : rs.getInt(1) + 1;
        }
        return 1001;
    }
}
