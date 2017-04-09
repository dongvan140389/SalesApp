package com.example.dongvan.SalesApp.UIView.ChiTietSanPham;

import com.example.dongvan.SalesApp.Model.ObjectClass.DanhGia;
import com.example.dongvan.SalesApp.Model.ObjectClass.SanPham;

import java.util.List;

/**
 * Created by VoNga on 05-Apr-17.
 */

public interface ViewChiTietSanPham {
    void HienChiTietSanPham(SanPham sanPham);
    void HienSliderSanPham(String[] linkhinhsanpham);
    void HienThiDanhGia(List<DanhGia> danhGiaList);
    void ThemGioHangThanhCong();
    void ThemGiohangThatBai();
}
