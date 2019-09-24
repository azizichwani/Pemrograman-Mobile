package azizichwani.nat.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Halaman1 extends AppCompatActivity {
    EditText edit;
    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman1);
        edit = findViewById(R.id.editext);
        enter = findViewById(R.id.btn_enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String masuk = edit.getText().toString();
                Intent teks = new Intent(Halaman1.this, Halaman2.class);
                teks.putExtra("enterisi", masuk);
                startActivity(teks);
            }
        });
    }
}
