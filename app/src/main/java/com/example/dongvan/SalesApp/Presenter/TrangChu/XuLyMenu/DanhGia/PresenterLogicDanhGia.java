package com.example.dongvan.SalesApp.Presenter.TrangChu.XuLyMenu.DanhGia;

import android.view.View;
import android.widget.ProgressBar;

import com.example.dongvan.SalesApp.Model.DanhGia.ModelDanhGia;
import com.example.dongvan.SalesApp.Model.ObjectClass.DanhGia;
import com.example.dongvan.SalesApp.UIView.DanhGia.ViewDanhGia;

import java.util.List;

/**
 * Created by VoNga on 05-Apr-17.
 */

public class PresenterLogicDanhGia implements IPresenterDanhGia{
    ViewDanhGia viewDanhGia;
    ModelDanhGia modelDanhGia;

    public PresenterLogicDanhGia(ViewDanhGia viewDanhGia){
        this.viewDanhGia = viewDanhGia;
        modelDanhGia = new ModelDanhGia();
    }

    @Override
    public void ThemDanhGia(DanhGia danhGia) {
        boolean kiemtra = modelDanhGia.ThemDanhGia(danhGia);
        if (kiemtra){
            viewDanhGia.DanhGiaThanhCong();
        }else{
            viewDanhGia.DanhGiaThatBai();
        }
    }

    @Override
    public void LayDanhSachDanhGiaCuaSanPham(int masp, int limit, ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
        List<DanhGia> danhGiaList = modelDanhGia.LayDanhSachDanhGiaCuaSanPham(masp,limit);

        if(danhGiaList.size()>=0){
            progressBar.setVisibility(View.GONE);
        }
        if (danhGiaList.size() > 0){
            //progressBar.setVisibility(View.GONE);
            viewDanhGia.HienThiDanhSachDanhGiaTheoSanPham(danhGiaList);
        }
    }
}
