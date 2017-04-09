package com.example.dongvan.SalesApp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dongvan.SalesApp.UIView.TrangChu.Fragment.ChuongTrinhKhuyenMaiFragment;
import com.example.dongvan.SalesApp.UIView.TrangChu.Fragment.DienTuFragment;
import com.example.dongvan.SalesApp.UIView.TrangChu.Fragment.LamDepFragment;
import com.example.dongvan.SalesApp.UIView.TrangChu.Fragment.MeVaBeFragment;
import com.example.dongvan.SalesApp.UIView.TrangChu.Fragment.NhaCuaVaDoiSongFragment;
import com.example.dongvan.SalesApp.UIView.TrangChu.Fragment.NoiBatFragment;
import com.example.dongvan.SalesApp.UIView.TrangChu.Fragment.TheThaoVaDuLichFragment;
import com.example.dongvan.SalesApp.UIView.TrangChu.Fragment.ThoiTrangFragment;
import com.example.dongvan.SalesApp.UIView.TrangChu.Fragment.ThuongHieuFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VoNga on 24-Mar-17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> listFragment = new ArrayList<Fragment>();
    List<String> titleFragment = new ArrayList<String>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        listFragment.add(new NoiBatFragment());
        listFragment.add(new ChuongTrinhKhuyenMaiFragment());
        listFragment.add(new DienTuFragment());
        listFragment.add(new NhaCuaVaDoiSongFragment());
        listFragment.add(new MeVaBeFragment());
        listFragment.add(new LamDepFragment());
        listFragment.add(new ThoiTrangFragment());
        listFragment.add(new TheThaoVaDuLichFragment());
        listFragment.add(new ThuongHieuFragment());

        titleFragment.add("Nổi bật");
        titleFragment.add("Chương trình khuyến mãi");
        titleFragment.add("Điện tử");
        titleFragment.add("Nhà cửa & đời sống");
        titleFragment.add("Mẹ và bé");
        titleFragment.add("Làm đẹp");
        titleFragment.add("Thời trang");
        titleFragment.add("Thể thao & du lịch");
        titleFragment.add("Thương hiệu");
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }
}
