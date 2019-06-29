package com.lenovo.test.Fragment01_Rao;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lenovo.test.R;

import java.util.ArrayList;
import java.util.List;


public class Fragment_1 extends Fragment implements View.OnClickListener {

    private ViewPager fragment_layoout01_VP_KongZhi_rao;
    private Button fragment_layoout01_Btn_KongZhi_rao;
    private Button fragment_layoout01_Btn_ZhuangTai_rao;
    private Button fragment_layoout01_Btn_ZhangHu_rao;

    private List<Fragment> fragments = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_layout01_rao, container, false);
        initView(view);




        return view;
    }

    private void initView(View view) {
        fragment_layoout01_VP_KongZhi_rao = (ViewPager) view.findViewById(R.id.fragment_layout01_VP_KongZhi_rao);
        fragment_layoout01_Btn_KongZhi_rao = (Button) view.findViewById(R.id.fragment_layout01_Btn_KongZhi_rao);
        fragment_layoout01_Btn_ZhuangTai_rao = (Button) view.findViewById(R.id.fragment_layout01_Btn_ZhuangTai_rao);
        fragment_layoout01_Btn_ZhangHu_rao = (Button) view.findViewById(R.id.fragment_layout01_Btn_ZhangHu_rao);

        fragment_layoout01_Btn_KongZhi_rao.setOnClickListener(this);
        fragment_layoout01_Btn_ZhuangTai_rao.setOnClickListener(this);
        fragment_layoout01_Btn_ZhangHu_rao.setOnClickListener(this);


        fragments.add(new Fragment_1_KongZhi_Rao());
        fragments.add(new Fragment_1_ZhaungTai_Rao());
        fragments.add(new Fragment_1_ZhangHu_Rao());


        fragment_layoout01_VP_KongZhi_rao.setAdapter(new mFragmentAdapter(getFragmentManager(),fragments));


        fragment_layoout01_VP_KongZhi_rao.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i==2){
                    switch (fragment_layoout01_VP_KongZhi_rao.getCurrentItem()){
                        case 0:


                            fragment_layoout01_Btn_KongZhi_rao.setTextColor(Color.WHITE);
                            fragment_layoout01_Btn_ZhuangTai_rao.setTextColor(Color.BLACK);
                            fragment_layoout01_Btn_ZhangHu_rao.setTextColor(Color.BLACK);

                            break;

                        case 1:


                            fragment_layoout01_Btn_KongZhi_rao.setTextColor(Color.BLACK);
                            fragment_layoout01_Btn_ZhuangTai_rao.setTextColor(Color.WHITE);
                            fragment_layoout01_Btn_ZhangHu_rao.setTextColor(Color.BLACK);

                            break;

                        case 2:


                            fragment_layoout01_Btn_KongZhi_rao.setTextColor(Color.BLACK);
                            fragment_layoout01_Btn_ZhuangTai_rao.setTextColor(Color.BLACK);
                            fragment_layoout01_Btn_ZhangHu_rao.setTextColor(Color.WHITE);

                            break;

                    }

                }



            }
        });




    }

    //各按钮的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_layout01_Btn_KongZhi_rao:

                fragment_layoout01_VP_KongZhi_rao.setCurrentItem(0);

                fragment_layoout01_Btn_KongZhi_rao.setTextColor(Color.WHITE);
                fragment_layoout01_Btn_ZhuangTai_rao.setTextColor(Color.BLACK);
                fragment_layoout01_Btn_ZhangHu_rao.setTextColor(Color.BLACK);

                break;
            case R.id.fragment_layout01_Btn_ZhuangTai_rao:

                fragment_layoout01_VP_KongZhi_rao.setCurrentItem(1);

                fragment_layoout01_Btn_KongZhi_rao.setTextColor(Color.BLACK);
                fragment_layoout01_Btn_ZhuangTai_rao.setTextColor(Color.WHITE);
                fragment_layoout01_Btn_ZhangHu_rao.setTextColor(Color.BLACK);

                break;
            case R.id.fragment_layout01_Btn_ZhangHu_rao:

                fragment_layoout01_VP_KongZhi_rao.setCurrentItem(2);

                fragment_layoout01_Btn_KongZhi_rao.setTextColor(Color.BLACK);
                fragment_layoout01_Btn_ZhuangTai_rao.setTextColor(Color.BLACK);
                fragment_layoout01_Btn_ZhangHu_rao.setTextColor(Color.WHITE);

                break;
        }
    }
}
