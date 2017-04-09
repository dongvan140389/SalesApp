package com.example.dongvan.SalesApp.UIView.ManHinhChao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.dongvan.SalesApp.R;
import com.example.dongvan.SalesApp.UIView.TrangChu.TrangChuActivity;

public class ManHinhChaoActivity extends AppCompatActivity {

    ImageView imgLogo;
    Animation animFade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chao);

        //find imgLogo trên giao diện + tạo animation
        imgLogo = (ImageView) findViewById(R.id.imgLogo);
        animFade = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    //set animation cho imgLogo
                    imgLogo.startAnimation(animFade);
                    Thread.sleep(2500);
                }catch (Exception e){

                }finally {
                    //chuyển sang trang chủ
                    Intent iTrangChu = new Intent(ManHinhChaoActivity.this, TrangChuActivity.class);
                    startActivity(iTrangChu);
                }
            }
        });

        thread.start();
    }
}
