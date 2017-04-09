package com.example.dongvan.SalesApp.Presenter.TrangChu.XuLyMenu.ChiTietSanPham;

import android.content.Context;

import com.example.dongvan.SalesApp.Model.ObjectClass.SanPham;

/**
 * Created by VoNga on 05-Apr-17.
 */

public interface IPresenterChiTietSanPham {
    void LayChiTietSanPham(int masp);
    void LayDanhSachDanhGiaTheoCuaSanPham(int masp, int limit);
    void ThemGioHang(SanPham sanPham, Context context);
}
