package azizichwani.nat.aplikasifilm.Model;
public class Data {

    String type;
    String sutradara;
    String tahun;
    String durasi;
    String stok;
    String amount;
    String note;
    String data;
    String id;
    String date;

    public Data() {

    }

    public Data(String type, String sutradara, String tahun, String durasi, String stok, String amount, String note, String data, String id) {
        this.type = type;
        this.sutradara = sutradara;
        this.tahun = tahun;
        this.durasi = durasi;
        this.stok = stok;
        this.amount = amount;
        this.note = note;
        this.data = data;
        this.id = id;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSutradara() {
        return sutradara;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
