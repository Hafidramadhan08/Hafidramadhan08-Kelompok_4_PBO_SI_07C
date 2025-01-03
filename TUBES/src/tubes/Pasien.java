package tubes;

  // Constructor
public class Pasien {

    private String nama;
    private String noRekamMedis;
    private String jenisKelamin;
    private String golonganDarah;

    public Pasien(String nama, String noRekamMedis, String jenisKelamin, String golonganDarah) {
        this.nama = nama;
        this.noRekamMedis = noRekamMedis;
        this.jenisKelamin = jenisKelamin;
        this.golonganDarah = golonganDarah;
    }

    // Getter 
    public String getNama() {
        return nama;
    }

    public String getNoRekamMedis() {
        return noRekamMedis;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }
}
