package azizichwani.nat.aplikasifilm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
import azizichwani.nat.aplikasifilm.Model.Data;

import java.text.DateFormat;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    private FloatingActionButton fab_btn;

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
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser = mAuth.getCurrentUser();
        String uId = mUser.getUid();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Aplikasi Film").child(uId);

        mDatabase.keepSynced(true);

        fab_btn = findViewById(R.id.fab);
        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog();
            }
        });

        /*totalResult = findViewById(R.id.total);*/

        recyclerView = findViewById(R.id.recycler_home);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        //Total Sum Number
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                /*int totalAmount = 0;*/


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void customDialog(){
        AlertDialog.Builder mydialog = new AlertDialog.Builder(HomeActivity.this);

        LayoutInflater inflater = LayoutInflater.from(HomeActivity.this);
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

    @Override
    protected void onStart(){
        super.onStart();

        FirebaseRecyclerAdapter<Data, MyViewHolder> adapter = new FirebaseRecyclerAdapter<Data, MyViewHolder>
                (
                        Data.class,
                        R.layout.item_data,
                        MyViewHolder.class,
                        mDatabase
                )
        {
            @Override
            protected void populateViewHolder(MyViewHolder viewHolder, final Data model, final int position) {
               /* viewHolder.setDate(model.getDate());*/
                viewHolder.setType(model.getType());
                viewHolder.setSutradara(model.getSutradara());
                viewHolder.setTahun(model.getTahun());
                viewHolder.setDurasi(model.getDurasi());
                viewHolder.setStok(model.getStok());
                viewHolder.setNote(model.getNote());
                viewHolder.setAmount(model.getAmount());

                viewHolder.myview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        post_key = getRef(position).getKey();
                        type=model.getType();
                        sutradara=model.getSutradara();
                        tahun=model.getTahun();
                        durasi=model.getDurasi();
                        stok=model.getStok();
                        note=model.getNote();
                        amount=model.getAmount();

                        updateData();
                    }
                });
            }
        };

        recyclerView.setAdapter(adapter);
    }

    public void updateData(){
        AlertDialog.Builder mydialog = new AlertDialog.Builder(HomeActivity.this);
        LayoutInflater inflater = LayoutInflater.from(HomeActivity.this);
        View mView = inflater.inflate(R.layout.update_input, null);

        final AlertDialog dialog = mydialog.create();
        dialog.setView(mView);

        final EditText edt_type = mView.findViewById(R.id.edt_type_upd);
        final EditText edt_sutradara = mView.findViewById(R.id.edt_sutradara_upd);
        final EditText edt_tahun = mView.findViewById(R.id.edt_thn_upd);
        final EditText edt_durasi = mView.findViewById(R.id.edt_durasi_upd);
        final EditText edt_stok = mView.findViewById(R.id.edt_stok_upd);
        final EditText edt_amount = mView.findViewById(R.id.edt_amount_upd);
        final EditText edt_note = mView.findViewById(R.id.edt_note_upd);

        edt_type.setText(type);
        edt_type.setSelection(type.length());

        edt_sutradara.setText(sutradara);
        edt_sutradara.setSelection(sutradara.length());

        edt_tahun.setText(tahun);
        edt_tahun.setSelection(tahun.length());

        edt_durasi.setText(durasi);
        edt_durasi.setSelection(durasi.length());

        edt_stok.setText(stok);
        edt_stok.setSelection(stok.length());

        edt_amount.setText(amount);
        edt_amount.setSelection(amount.length());

        edt_note.setText(note);
        edt_note.setSelection(note.length());

        Button btnUpdate = mView.findViewById(R.id.btn_save_upd);
        Button btnDelete = mView.findViewById(R.id.btn_delete_upd);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = edt_type.getText().toString().trim();
                sutradara = edt_sutradara.getText().toString().trim();
                tahun = edt_tahun.getText().toString().trim();
                durasi = edt_durasi.getText().toString().trim();
                stok = edt_stok.getText().toString().trim();
                /*String mAmount = String.valueOf(amount);*/
                amount = edt_amount.getText().toString().trim();
                note = edt_note.getText().toString().trim();

                if(TextUtils.isEmpty(type)){
                    edt_type.setError("Require Field...");
                    return;
                }

                if (TextUtils.isEmpty(sutradara)){
                    edt_sutradara.setError("Require Field...");
                    return;
                }

                if (TextUtils.isEmpty(tahun)){
                    edt_tahun.setError("Require Field...");
                    return;
                }

                if (TextUtils.isEmpty(durasi)){
                    edt_durasi.setError("Require Field...");
                    return;
                }

                if (TextUtils.isEmpty(stok)){
                    edt_stok.setError("Require Field...");
                    return;
                }

                if(TextUtils.isEmpty(amount)){
                    edt_amount.setError("Require Field...");
                    return;
                }

                if (TextUtils.isEmpty(note)){
                    edt_note.setError("Require Field...");
                    return;
                }

                /*int intAmount = Integer.parseInt(mAmount);*/
                String date = DateFormat.getDateInstance().format(new Date());

                Data data = new Data(type,sutradara,tahun,durasi,stok, amount, note, date, post_key);

                mDatabase.child(post_key).setValue(data);
                dialog.dismiss();

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase.child(post_key).removeValue();

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){

            case R.id.change_setting:
                Intent activity2 = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(activity2);
                return true;

            case R.id.log_out:
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                break;


        }

        return super.onOptionsItemSelected(item);
    }

}
