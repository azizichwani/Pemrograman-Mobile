package azizichwani.nat.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Halaman2 extends AppCompatActivity {
    TextView up;
    String okemasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman2);

        up = findViewById(R.id.enter2);

        okemasuk = getIntent().getStringExtra("enterisi");
        up.setText(okemasuk);
    }
}
