package azizichwani.nat.daftarbelanja.Model;
public class Data {

    String type;
    int amount;
    String note;
    String data;
    String id;
    String date;

    public Data() {

    }

    public Data(String type, int amount, String note, String data, String id) {
        this.type = type;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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
