package com.example.dongvan.SalesApp.Presenter.TrangChu.XuLyMenu.DanhGia;

import android.widget.ProgressBar;

import com.example.dongvan.SalesApp.Model.ObjectClass.DanhGia;

/**
 * Created by VoNga on 05-Apr-17.
 */

public interface IPresenterDanhGia {
    void ThemDanhGia(DanhGia danhGia);
    void LayDanhSachDanhGiaCuaSanPham(int masp, int limit, ProgressBar progressBar);
}
