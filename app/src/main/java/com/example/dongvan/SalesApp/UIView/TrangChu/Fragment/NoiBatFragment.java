package com.example.dongvan.SalesApp.UIView.TrangChu.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dongvan.SalesApp.Adapter.NoiBatAdapter;
import com.example.dongvan.SalesApp.R;

import java.util.ArrayList;
import java.util.List;


public class NoiBatFragment extends Fragment {
    RecyclerView recyclerView;
    NoiBatAdapter adapterNoiBat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noi_bat,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyleNoiBat);
        List<String> dulieu = new ArrayList<>();


        for (int i=0 ;i<50;i++){
            String ten = " Noi bat " + i;
            dulieu.add(ten);
        }

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),3);
        adapterNoiBat = new NoiBatAdapter(getActivity(),dulieu);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterNoiBat);

        adapterNoiBat.notifyDataSetChanged();
        return view;
    }

}
