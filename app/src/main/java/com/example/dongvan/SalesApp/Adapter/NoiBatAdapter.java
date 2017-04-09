package com.example.dongvan.SalesApp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dongvan.SalesApp.R;

import java.util.List;

/**
 * Created by VoNga on 02-Apr-17.
 */

public class NoiBatAdapter extends RecyclerView.Adapter<NoiBatAdapter.ViewHolder> {
    Context context;
    List<String> stringList;

    public NoiBatAdapter(Context context,List<String> stringList){
        this.context = context;
        this.stringList = stringList;
    }

    //Chạy đầu tiên
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_recyclerview_noibat,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //Chay thứ 3
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    //Chạy thứ 2
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txtTieuDeNoiBat);
        }
    }
}
