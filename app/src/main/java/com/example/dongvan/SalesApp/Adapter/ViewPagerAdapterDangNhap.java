package com.example.dongvan.SalesApp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dongvan.SalesApp.UIView.DangNhap_DangKy.Fragment.DangKyFragment;
import com.example.dongvan.SalesApp.UIView.DangNhap_DangKy.Fragment.DangNhapFragment;

/**
 * Created by VoNga on 27-Mar-17.
 */

public class ViewPagerAdapterDangNhap extends FragmentPagerAdapter {

    public ViewPagerAdapterDangNhap(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                DangNhapFragment fragmentDangNhap = new DangNhapFragment();
                return fragmentDangNhap;
            case 1 :
                DangKyFragment fragmentDangKy = new DangKyFragment();
                return fragmentDangKy;

            default: return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 :
                return "Đăng nhập";
            case 1 :
                return "Đăng ký";

            default: return null;
        }

    }
}
