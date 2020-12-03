package com.example.projetihm.Classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetihm.R;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.ViewHolder>{
    @NonNull
    @Override
    public NumberAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lf = LayoutInflater.from(parent.getContext());
         View ite = lf.inflate(R.layout.number_item, parent, false);

        return new ViewHolder(ite);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberAdapter.ViewHolder holder, int position) {
        TextView textView = holder.itemView.findViewById(R.id.txt);
        textView.setText(""+position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public  class ViewHolder  extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView ) {
            super(itemView);
        }
    }
}
