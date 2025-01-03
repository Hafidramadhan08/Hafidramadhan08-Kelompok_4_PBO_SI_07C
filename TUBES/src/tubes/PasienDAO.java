package tubes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasienDAO {

    public void savePasien(Pasien pasien) {
        String sql = "INSERT INTO pasien (nama, no_rekam_medis, jenis_kelamin, golongan_darah) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, pasien.getNama());
                    preparedStatement.setString(2, pasien.getNoRekamMedis());
                    preparedStatement.setString(3, pasien.getJenisKelamin());
                    preparedStatement.setString(4, pasien.getGolonganDarah());

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Data pasien berhasil disimpan!");
                    } else {
                        System.out.println("Gagal menyimpan data pasien.");
                    }
                }
            } else {
                System.out.println("Koneksi ke database gagal.");
            }
        } catch (SQLException e) {
            System.out.println("Error saat menyimpan data pasien: " + e.getMessage());
        }
    }
}
