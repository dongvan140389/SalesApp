package com.example.dongvan.SalesApp.UIView.TrangChu;

import com.example.dongvan.SalesApp.Model.ObjectClass.DienTu;
import com.example.dongvan.SalesApp.Model.ObjectClass.SanPham;
import com.example.dongvan.SalesApp.Model.ObjectClass.ThuongHieu;

import java.util.List;

/**
 * Created by VoNga on 02-Apr-17.
 */

public interface ViewDienTu {
    void HienThiDanhSach (List<DienTu> dienTus);
    void HienThiLogoThuongHieu(List<ThuongHieu> thuongHieus);
    void LoiLayDuLieu();
    void HienThiSanPhamMoiVe(List<SanPham> sanPhams);
}
