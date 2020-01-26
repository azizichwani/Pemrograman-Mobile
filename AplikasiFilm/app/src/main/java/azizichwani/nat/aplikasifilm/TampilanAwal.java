package azizichwani.nat.aplikasifilm;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;

import azizichwani.nat.aplikasifilm.Model.Data;

public class TampilanAwal extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    private RecyclerView recyclerView;

    private TextView totalResult;

    //Global Variable
    private String type;
    private String amount;
    private String note;
    private String sutradara;
    private String durasi;
    private String tahun;
    private String stok;
    private String post_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_awal);

        Button LihatData = findViewById(R.id.lihatbtn);
        final Button InputData = findViewById(R.id.inputbtn);
        Button informasi = findViewById(R.id.infobtn);
        LihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(TampilanAwal.this, HomeActivity.class);
                startActivity(inte);
            }
        });
        InputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog();
            }
        });
        informasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte = new Intent(TampilanAwal.this, Informasi.class);
                startActivity(inte);
            }
        });



        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uId = mUser.getUid();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Aplikasi Film").child(uId);

        mDatabase.keepSynced(true);



        //Total Sum Number
        /*mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                int totalAmount = 0;
                for(DataSnapshot snap:dataSnapshot.getChildren()){
                    Data data = snap.getValue(Data.class);

                    totalAmount += data.getAmount();
                    String sttotal = String.valueOf("Rp "+totalAmount);

                    totalResult.setText(sttotal);

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
    }
    private void customDialog(){
        AlertDialog.Builder mydialog = new AlertDialog.Builder(TampilanAwal.this);

        LayoutInflater inflater = LayoutInflater.from(TampilanAwal.this);
        View myview = inflater.inflate(R.layout.input_data, null);
        final AlertDialog dialog = mydialog.create();
        dialog.setView(myview);
        dialog.show();

        final EditText type = myview.findViewById(R.id.edt_type);
        final EditText sutradara = myview.findViewById(R.id.edt_sutradara);
        final EditText tahun = myview.findViewById(R.id.edt_thn);
        final EditText durasi = myview.findViewById(R.id.edt_durasi);
        final EditText stok = myview.findViewById(R.id.edt_stok);
        final EditText amount = myview.findViewById(R.id.edt_amount);
        final EditText note = myview.findViewById(R.id.edt_note);

        Button btnSave = myview.findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mType = type.getText().toString().trim();
                String mSutradara = sutradara.getText().toString().trim();
                String mTahun = tahun.getText().toString().trim();
                String mDurasi = durasi.getText().toString().trim();
                String mStok = stok.getText().toString().trim();
                String mAmount = amount.getText().toString().trim();
                String mNote = note.getText().toString().trim();





                /*int ammint = Integer.parseInt(mAmount);*/

                if(TextUtils.isEmpty(mType)){
                    type.setError("Require Field...");
                    return;
                }

                if (TextUtils.isEmpty(mSutradara)){
                    sutradara.setError("Require Field...");
                    return;
                }

                if (TextUtils.isEmpty(mTahun)){
                    tahun.setError("Require Field...");
                    return;
                }

                if (TextUtils.isEmpty(mDurasi)){
                    durasi.setError("Require Field...");
                    return;
                }

                if (TextUtils.isEmpty(mStok)){
                    stok.setError("Require Field...");
                    return;
                }

                if(TextUtils.isEmpty(mAmount)){
                    amount.setError("Require Field...");
                    return;
                }

                if (TextUtils.isEmpty(mNote)){
                    note.setError("Require Field...");
                    return;
                }

                String id = mDatabase.push().getKey();
                String date = DateFormat.getDateInstance().format(new Date());
                Data data = new Data(mType, mSutradara, mTahun, mDurasi, mStok, mAmount, mNote, date, id);
                mDatabase.child(id).setValue(data);

                Toast.makeText(getApplicationContext(), "Data Add", Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }
        });

        dialog.show();
    }




}
