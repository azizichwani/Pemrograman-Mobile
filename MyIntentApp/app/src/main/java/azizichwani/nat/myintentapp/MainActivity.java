package azizichwani.nat.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMoveActivity;
    Button btnMoveActivityWithData;
    Button btnDial;
    Button btnWeb;
    Button btnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveActivityWithData= findViewById(R.id.btn_move_data);
        btnMoveActivityWithData.setOnClickListener(this);

        btnDial = findViewById(R.id.btn_dial);
        btnDial.setOnClickListener(this);

        btnWeb = findViewById(R.id.btn_web);
        btnWeb.setOnClickListener(this);

        btnIntent = findViewById(R.id.btn_intent);
        btnIntent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_move_activity:
                Intent moveActivity = new Intent(MainActivity.this, NewActivity.class);
                startActivity(moveActivity);
                break;
            case R.id.btn_move_data:
                Intent moveActivityWithData = new Intent(MainActivity.this, MoveActivityWithData.class);
                moveActivityWithData.putExtra(MoveActivityWithData.EXTRA_NAME, "Abdul Aziz Ichwani");
                moveActivityWithData.putExtra(MoveActivityWithData.EXTRA_AGE, 19);
                startActivity(moveActivityWithData);
                break;
            case R.id.btn_dial:
                String phoneNumber = "089654478404";
                Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhone);
                break;
            case R.id.btn_web:
                Intent webView = new Intent(Intent.ACTION_VIEW, Uri.parse("http://polines.ac.id"));
                startActivity(webView);
                break;
            case R.id.btn_intent:
                Intent halaman1 = new Intent(MainActivity.this, Halaman1.class);
                startActivity(halaman1);
                break;
        }
    }
}
