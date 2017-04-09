package com.example.dongvan.SalesApp.UIView.ThanhToan;

import com.example.dongvan.SalesApp.Model.ObjectClass.SanPham;

import java.util.List;

/**
 * Created by VoNga on 07-Apr-17.
 */

public interface ViewThanhToan {
    void DatHangThanhCong();
    void DatHangThatBai();
    void LayDanhSachSanPhamTrongGioHang(List<SanPham> sanPhamList);
}
