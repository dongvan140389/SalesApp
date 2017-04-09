package com.example.dongvan.SalesApp.Presenter.TrangChu.XuLyMenu.GioHang;

import android.content.Context;

import com.example.dongvan.SalesApp.Model.GioHang.ModelGioHang;
import com.example.dongvan.SalesApp.Model.ObjectClass.SanPham;
import com.example.dongvan.SalesApp.UIView.GioHang.ViewGioHang;

import java.util.List;

/**
 * Created by VoNga on 06-Apr-17.
 */

public class PresenterLogicGioHang implements IPresenterGioHang {
    ModelGioHang modelGioHang;
    ViewGioHang viewGioHang;

    public PresenterLogicGioHang(ViewGioHang viewGioHang){
        modelGioHang = new ModelGioHang();
        this.viewGioHang = viewGioHang;
    }

    @Override
    public void LayDanhSachSanPhamTrongGioHang(Context context) {
        modelGioHang.MoKetNoiSQL(context);
        List<SanPham> sanPhamList = modelGioHang.LayDanhSachSanPhamTrongGioHang();
        if(sanPhamList.size() > 0){
            viewGioHang.HienThiDanhSachSanPhamTrongGioHang(sanPhamList);
        }
    }

}
