package com.example.dongvan.SalesApp.UIView.DanhGia;

import com.example.dongvan.SalesApp.Model.ObjectClass.DanhGia;

import java.util.List;

/**
 * Created by VoNga on 05-Apr-17.
 */

public interface ViewDanhGia {
    void DanhGiaThanhCong();
    void DanhGiaThatBai();
    void HienThiDanhSachDanhGiaTheoSanPham(List<DanhGia> danhGiaList);
}
