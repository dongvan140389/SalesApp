package com.example.dongvan.SalesApp.Presenter.TrangChu.XuLyMenu.TimKiem;

import com.example.dongvan.SalesApp.Model.ObjectClass.SanPham;
import com.example.dongvan.SalesApp.Model.TimKiem.ModelTimKiem;
import com.example.dongvan.SalesApp.UIView.TimKiem.ViewTimKiem;

import java.util.List;

/**
 * Created by VoNga on 08-Apr-17.
 */

public class PresenterLogicTimKiem implements IPresenterTimKiem {
    ViewTimKiem viewTimKiem;
    ModelTimKiem modelTimKiem;

    public PresenterLogicTimKiem(ViewTimKiem viewTimKiem){
        this.viewTimKiem = viewTimKiem;
        modelTimKiem = new ModelTimKiem();
    }

    @Override
    public void TimKiemSanPhamTheoTenSP(String tensp, int limit) {
        List<SanPham> sanPhamList = modelTimKiem.TimKiemSanPhamTheoTen(tensp,"DANHSACHSANPHAM","TimKiemSanPhamTheoTenSP",limit);

        if(sanPhamList.size() > 0){
            viewTimKiem.TimKiemThanhCong(sanPhamList);

        }else{
            viewTimKiem.TimKiemThatBai();
        }
    }
}
