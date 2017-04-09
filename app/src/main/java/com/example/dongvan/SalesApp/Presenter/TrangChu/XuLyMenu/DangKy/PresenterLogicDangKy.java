package com.example.dongvan.SalesApp.Presenter.TrangChu.XuLyMenu.DangKy;

import com.example.dongvan.SalesApp.Model.DangNhap_DangKy.ModelDangKy;
import com.example.dongvan.SalesApp.Model.ObjectClass.NhanVien;
import com.example.dongvan.SalesApp.UIView.DangNhap_DangKy.ViewDangKy;

/**
 * Created by VoNga on 02-Apr-17.
 */

public class PresenterLogicDangKy implements IPresenterDangKy {
    ViewDangKy viewDangKy;
    ModelDangKy modelDangKy;

    public PresenterLogicDangKy(ViewDangKy viewDangKy){
        this.viewDangKy = viewDangKy;
        modelDangKy = new ModelDangKy();
    }

    @Override
    public void ThucHienDangKy(NhanVien nhanvien) {
        boolean kiemtra = modelDangKy.DangKyThanhVien(nhanvien);
        if(kiemtra){
            viewDangKy.DangKyThangCong();
        }else{
            viewDangKy.DangKyThatBai();
        }
    }
}
