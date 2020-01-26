package azizichwani.nat.aplikasifilm;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    View myview;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        myview=itemView;
    }

    public void setType(String type){
        TextView mType = myview.findViewById(R.id.type);
        mType.setText(type);
    }

    public void setSutradara(String sutradara){
        TextView mSutradara = myview.findViewById(R.id.sutradara);
        mSutradara.setText(sutradara);
    }

    public void setTahun(String tahun){
        TextView mTahun = myview.findViewById(R.id.tahun);
        mTahun.setText(tahun);
    }

    public void setDurasi(String durasi){
        TextView mDurasi = myview.findViewById(R.id.durasi);
        mDurasi.setText(durasi);
    }

    public void setStok(String stok){
        TextView mStok = myview.findViewById(R.id.stok);
        mStok.setText(stok);
    }

    public void setNote(String note){
        TextView mNote = myview.findViewById(R.id.note);
        mNote.setText(note);
    }

    /*public void setDate(String date){
        TextView mDate = myview.findViewById(R.id.date);
        mDate.setText(date);
    }*/

    public void setAmount(String amount){
        TextView mAmount = myview.findViewById(R.id.amount);
        /*String stam = String.valueOf(amount);*/
        mAmount.setText(amount);
    }
}
