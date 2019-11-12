package azizichwani.nat.aplikasimidterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView myRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = findViewById(R.id.recyclerview);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this,getMylist());
        myRecyclerView.setAdapter(myAdapter);
    }
    private ArrayList<Model> getMylist(){

        ArrayList<Model> models = new ArrayList<>();

        Model model = new Model();
        model.setTitle("Institut Teknologi Bandung");
        model.setDescription("Institut Teknologi Bandung adalah sebuah perguruan tinggi negeri yang berkedudukan di Kota Bandung. Nama ITB diresmikan pada tanggal 2 Maret 1959. Sejak tanggal 14 Oktober 2013 ITB menjadi Perguruan Tinggi Negeri Badan Hukum yang memiliki otonomi pengelolaan dalam akademik dan nonakademik.");
        model.setImg(R.drawable.itb);
        models.add(model);

        model = new Model();
        model.setTitle("Institut Teknologi Sepuluh November");
        model.setDescription("Institut Teknologi Sepuluh Nopember adalah perguruan tinggi negeri yang terletak di Surabaya. ITS awalnya didirikan oleh Yayasan Perguruan Tinggi Teknik yang diketuai oleh dr. Angka Nitisastro pada tanggal 10 November 1957. Sampai tahun 2016, ITS memiliki 5 Fakultas dengan 12 Program Doktoral, 18 Program Magister, 28 jurusan/program studi tingkat sarjana (10 jurusan diantaranya juga menyelenggarakan program ekstensi S-1 atau lintas jalur), 6 Program Studi D-3 (5 program diantaranya juga menyelenggarakan program ekstensi D-3), dan 1 Program Studi D-4.");
        model.setImg(R.drawable.its);
        models.add(model);

        model = new Model();
        model.setTitle("Institut Seni Indonesia Yogyakarta");
        model.setDescription("Institut Seni Indonesia (ISI) merupakan perguruan tinggi negeri yang mengkhususkan diri pada pendidikan seni. Di Indonesia terdapat empat institut dengan nama sama namun terletak di kota yang berbeda dan di bawah kepengurusan yang berbeda-beda pula. Institut Seni Indonesia pertama kali didirikian di Jogjakarta atas dasar pengabungan beberapa Sekolah Tinggi Seni (ST ASRI, ST TARI, ST MUSIK)agar lebih fokus dan besar.");
        model.setImg(R.drawable.isi);
        models.add(model);

        model = new Model();
        model.setTitle("Universitas Brawijaya");
        model.setDescription("Universitas Brawijaya merupakan kampus elit di Indonesia dan secara konsisten menduduki peringkat 5 terbaik bersama dengan Universitas Indonesia, Institut Pertanian Bogor, Universitas Gadjah Mada, dan Institut Teknologi Bandung berdasarkan penilaian resmi Kemenristekdikti. Sedangkan di tingkat Internasional, UB menduduki peringkat 51 di Asia dan 400 dunia. UB adalah salah satu dari sebagian kecil kampus Indonesia yang terindeks secara Internasional oleh QS");
        model.setImg(R.drawable.unbraw);
        models.add(model);

        model = new Model();
        model.setTitle("Universitas Indonesia");
        model.setDescription("Universitas Indonesia disingkat sebagai UI, adalah sebuah perguruan tinggi di Indonesia. Kampus utamanya terletak di bagian Utara dari Depok, Jawa Barat tepat di perbatasan antara Depok dengan wilayah Jakarta Selatan, dan kampus utama lainnya terdapat di daerah Salemba di Jakarta Pusat. Universitas Indonesia adalah kampus modern, komprehensif, terbuka, multibudaya, dan humanis yang mencakup disiplin ilmu yang luas. Telah menghasilkan lebih dari 400.000 alumni. Secara umum dianggap sebagai salah satu dari tiga perguruan tinggi papan atas di Indonesia bersama dengan Universitas Gadjah Mada dan Institut Teknologi Bandung.");
        model.setImg(R.drawable.ui);
        models.add(model);

        model = new Model();
        model.setTitle("Universitas Negeri Semarang");
        model.setDescription("UNNES merupakan salah satu perguruan tinggi eks-IKIP yang statusnya meningkat menjadi Universitas. Kampus utamanya terletak di daerah Sekaran (Gunungpati), wilayah selatan Kota Semarang, Jawa Tengah. Dan kampus lainnya terletak di Ngaliyan (Semarang), Kelud (Semarang), Bendan Ngisor (Semarang) dan di Kemandungan, Tegal. Motto yang menjadi pedoman perguruan tinggi ini adalah Unnes Sutera (Sehat, Unggul, Sejahtera)");
        model.setImg(R.drawable.unnes);
        models.add(model);

        model = new Model();
        model.setTitle("Universitas Sebelas Maret");
        model.setDescription("Universitas Sebelas Maret (disingkat UNS) adalah salah satu universitas negeri di Indonesia yang berada di Kota Solo. Universitas yang giat membangun ini, menyediakan berbagai paket pendidikan diploma, sarjana, pascasarjana, dan doktoral.");
        model.setImg(R.drawable.uns);
        models.add(model);

        model = new Model();
        model.setTitle("Universitas Gadjah Mada");
        model.setDescription("UGM merupakan universitas negeri di Indonesia yang didirikan oleh Pemerintah Republik Indonesia pada tanggal 19 Desember 1949. Kampus UGM yang terletak di Yogyakarta merupakan universitas pertama yang didirikan oleh Pemerintah Republik Indonesia setelah Indonesia merdeka. Pada saat didirikan, Universitas Gadjah Mada hanya memiliki enam fakultas, sekarang memiliki 18 Fakultas dan dua Sekolah yaitu Sekolah Vokasi dan Sekolah Pascasarjana (dahulu bernama Program Pascasarjana), dan lebih dari 100 Program Studi untuk S2, S3, dan Spesialis.");
        model.setImg(R.drawable.ugm);
        models.add(model);

        return models;
    }
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.profil:
                Intent activity1 = new Intent(this, Toolbar.class);
                startActivity(activity1);
                return true;
            default:
                return true;
        }
    }
}
