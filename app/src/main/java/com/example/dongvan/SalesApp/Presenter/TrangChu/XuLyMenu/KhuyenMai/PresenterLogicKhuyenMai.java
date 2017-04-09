package com.example.dongvan.SalesApp.Presenter.TrangChu.XuLyMenu.KhuyenMai;

import com.example.dongvan.SalesApp.Model.KhuyenMai.ModelKhuyenMai;
import com.example.dongvan.SalesApp.Model.ObjectClass.KhuyenMai;
import com.example.dongvan.SalesApp.UIView.TrangChu.ViewKhuyenMai;

import java.util.List;

/**
 * Created by VoNga on 07-Apr-17.
 */

public class PresenterLogicKhuyenMai implements IPresenterKhuyenMai {
    ViewKhuyenMai viewKhuyenMai;
    ModelKhuyenMai modelKhuyenMai;

    public PresenterLogicKhuyenMai(ViewKhuyenMai viewKhuyenMai){
        this.viewKhuyenMai = viewKhuyenMai;
        modelKhuyenMai = new ModelKhuyenMai();
    }

    @Override
    public void LayDanhSachKhuyenMai() {
        List<KhuyenMai> khuyenMaiList = modelKhuyenMai.LayDanhSachSanPhamTheoMaLoai("LayDanhSachKhuyenMai","DANHSACHKHUYENMAI");
        if(khuyenMaiList.size() > 0){
            viewKhuyenMai.HienThiDanhSachKhuyenMai(khuyenMaiList);
        }
    }
}
