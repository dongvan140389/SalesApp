package com.example.dongvan.SalesApp.Model.TrangTru.XuLyMenu;

import android.util.Log;

import com.example.dongvan.SalesApp.ConnectInternet.DownloadJSON;
import com.example.dongvan.SalesApp.Model.ObjectClass.LoaiSanPham;
import com.example.dongvan.SalesApp.UIView.TrangChu.TrangChuActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by VoNga on 25-Mar-17.
 */

public class XuLyJSONMenu {
    String tennguoidung = "";

    public List<LoaiSanPham> ParserJSONMenu(String dulieujson){
        List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();
        try {
            Log.d("kiemtraXlMNU",dulieujson);
            JSONObject jsonObject = new JSONObject(dulieujson);
            JSONArray loaisanpham = jsonObject.getJSONArray("LOAISANPHAM");
            int count = loaisanpham.length();
            for(int i=0;i<count;i++){
                JSONObject value = loaisanpham.getJSONObject(i);

                LoaiSanPham dataloaiSanPham = new LoaiSanPham();
                dataloaiSanPham.setMALOAISP(Integer.parseInt(value.getString("MALOAISP")));
                dataloaiSanPham.setMALOAICHA(Integer.parseInt(value.getString("MALOAI_CHA")));
                dataloaiSanPham.setTENLOAISP(value.getString("TENLOAISP"));

                loaiSanPhamList.add(dataloaiSanPham);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return loaiSanPhamList;
    }

    public List<LoaiSanPham> LayLoaiSanPhamTheoMaLoai(int maloaisp){
        List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();
        List<HashMap<String,String>> attrs = new ArrayList<>();
        String dataJSON = "";

        String duongdan = TrangChuActivity.SERVER_NAME;

        HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham","LayDanhSachMenu");

        HashMap<String,String> hsMaLoaiCha = new HashMap<>();
        //hsMaLoaiCha.put("maloaicha",String.valueOf(maloaisp));
        hsMaLoaiCha.put("maloaicha","0");

        attrs.add(hsMaLoaiCha);
        attrs.add(hsHam);

        DownloadJSON downloadJSON = new DownloadJSON(duongdan,attrs);
        //end phương thức post
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();
            XuLyJSONMenu xuLyJSONMenu = new XuLyJSONMenu();
            loaiSanPhamList = xuLyJSONMenu.ParserJSONMenu(dataJSON);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return loaiSanPhamList;
    }


}
