package com.example.dongvan.SalesApp.UIView.TrangChu.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dongvan.SalesApp.Adapter.DienTuAdapter;
import com.example.dongvan.SalesApp.Adapter.ThuongHieuLonDienTuAdapter;
import com.example.dongvan.SalesApp.Adapter.TopDienThoaiDienTuAdapter;
import com.example.dongvan.SalesApp.Model.ObjectClass.DienTu;
import com.example.dongvan.SalesApp.Model.ObjectClass.SanPham;
import com.example.dongvan.SalesApp.Model.ObjectClass.ThuongHieu;
import com.example.dongvan.SalesApp.Presenter.TrangChu.XuLyMenu.DienTu.PresenterLogicDienTu;
import com.example.dongvan.SalesApp.R;
import com.example.dongvan.SalesApp.UIView.TrangChu.ViewDienTu;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DienTuFragment extends Fragment implements ViewDienTu{

    RecyclerView recyclerView,recylerTopCacThuongHieuLon,recylerHangMoiVe;
    List<DienTu> dienTuList;
    PresenterLogicDienTu presenterLogicDienTu;
    ImageView imSanPham1,imSanPham2,imSanPham3;
    TextView txtSanPham1,txtSanPham2,txtSanPham3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dien_tu,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerDienTu);
        recylerTopCacThuongHieuLon = (RecyclerView) view.findViewById(R.id.recylerTopCacThuongHieuLon);
        recylerHangMoiVe = (RecyclerView) view.findViewById(R.id.recylerHangMoiVe);
        imSanPham1 = (ImageView) view.findViewById(R.id.imSanPham1);
        imSanPham2 = (ImageView) view.findViewById(R.id.imSanPham2);
        imSanPham3 = (ImageView) view.findViewById(R.id.imSanPham3);
        txtSanPham1 = (TextView) view.findViewById(R.id.txtSanPham1);
        txtSanPham2 = (TextView) view.findViewById(R.id.txtSanPham2);
        txtSanPham3 = (TextView) view.findViewById(R.id.txtSanPham3);

        presenterLogicDienTu = new PresenterLogicDienTu(this);

        dienTuList = new ArrayList<>();

        presenterLogicDienTu.LayDanhSachDienTu();
        presenterLogicDienTu.LayDanhSachLogoThuongHieu();
        presenterLogicDienTu.LayDanhSachSanPhamMoi();

        return view;

    }


    @Override
    public void HienThiDanhSach(List<DienTu> dienTus) {

        dienTuList = dienTus;

        DienTuAdapter adapterDienTu = new DienTuAdapter(getContext(),dienTuList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterDienTu);

        adapterDienTu.notifyDataSetChanged();
    }

    @Override
    public void HienThiLogoThuongHieu(List<ThuongHieu> thuongHieus) {
        ThuongHieuLonDienTuAdapter adapterThuongHieuLonDienTu = new ThuongHieuLonDienTuAdapter(getContext(),thuongHieus);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.HORIZONTAL,false);

        recylerTopCacThuongHieuLon.setLayoutManager(layoutManager);
        recylerTopCacThuongHieuLon.setAdapter(adapterThuongHieuLonDienTu);
        adapterThuongHieuLonDienTu.notifyDataSetChanged();
    }

    @Override
    public void LoiLayDuLieu() {

    }

    @Override
    public void HienThiSanPhamMoiVe(List<SanPham> sanPhams) {
        TopDienThoaiDienTuAdapter adapterTopDienThoaiDienTu = new TopDienThoaiDienTuAdapter(getContext(),R.layout.custom_layout_topdienthoaivamaytinhbang,sanPhams);

        RecyclerView.LayoutManager layoutManagerTop = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recylerHangMoiVe.setLayoutManager(layoutManagerTop);
        recylerHangMoiVe.setAdapter(adapterTopDienThoaiDienTu);

        adapterTopDienThoaiDienTu.notifyDataSetChanged();
        Random random = new Random();

        int vitri = random.nextInt(sanPhams.size());

        Picasso.with(getContext()).load(sanPhams.get(vitri).getANHLON()).fit().centerInside().into(imSanPham1);
        txtSanPham1.setText(sanPhams.get(vitri).getTENSP());

        int vitri1 = random.nextInt(sanPhams.size());
        Picasso.with(getContext()).load(sanPhams.get(vitri1).getANHLON()).fit().centerInside().into(imSanPham2);
        txtSanPham2.setText(sanPhams.get(vitri1).getTENSP());

        int vitri2 = random.nextInt(sanPhams.size());
        Picasso.with(getContext()).load(sanPhams.get(vitri2).getANHLON()).fit().centerInside().into(imSanPham3);
        txtSanPham3.setText(sanPhams.get(vitri2).getTENSP());
    }
}
