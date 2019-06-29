package com.lenovo.test.Fragment01_Rao;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.lenovo.test.R;
import com.lenovo.test.httppost.OkHttp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class Fragment_1_ZhangHu_Rao extends Fragment implements View.OnClickListener {

    private Spinner fragment_01_zhanghu_sp_cars_chaxun_rao;
    private Button fragment_layout01_Btn_ZhangHu_chaxun_rao;
    private Spinner fragment_01_zhanghu_sp_cars_chongzhi_rao;
    private EditText fragment_01_zhuanghu_ET_Monay_chongzhi_rao;
    private Button fragment_layout01_Btn_ZhangHu_chongzhi_rao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment01_zhanghu_rao, container, false);
        initView(view);



        return view;
    }

    private void initView(View view) {
        fragment_01_zhanghu_sp_cars_chaxun_rao = (Spinner) view.findViewById(R.id.fragment_01_zhanghu_sp_cars_chaxun_rao);
        fragment_layout01_Btn_ZhangHu_chaxun_rao = (Button) view.findViewById(R.id.fragment_layout01_Btn_ZhangHu_chaxun_rao);
        fragment_01_zhanghu_sp_cars_chongzhi_rao = (Spinner) view.findViewById(R.id.fragment_01_zhanghu_sp_cars_chongzhi_rao);
        fragment_01_zhuanghu_ET_Monay_chongzhi_rao = (EditText) view.findViewById(R.id.fragment_01_zhanghu_ET_Monay_chongzhi_rao);
        fragment_layout01_Btn_ZhangHu_chongzhi_rao = (Button) view.findViewById(R.id.fragment_layout01_Btn_ZhangHu_chongzhi_rao);

        fragment_layout01_Btn_ZhangHu_chaxun_rao.setOnClickListener(this);
        fragment_layout01_Btn_ZhangHu_chongzhi_rao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_layout01_Btn_ZhangHu_chaxun_rao:

                Integer CarId = Integer.parseInt(fragment_01_zhanghu_sp_cars_chaxun_rao.getSelectedItem().toString());

                car_chaxun(CarId,"user1");



                break;
            case R.id.fragment_layout01_Btn_ZhangHu_chongzhi_rao:


                String fragment_01_zhuanghu_ET_Monay_chongzhi_test_rao = fragment_01_zhuanghu_ET_Monay_chongzhi_rao.getText().toString();

                final int monay;

                if (fragment_01_zhuanghu_ET_Monay_chongzhi_test_rao.equals("")){

                    Fragment_1_ZhangHu_Rao.this.getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(getContext(),"请输入充值金额后充值",Toast.LENGTH_SHORT).show();

                        }
                    });

                }
                else
                {
                    monay = Integer.parseInt(fragment_01_zhuanghu_ET_Monay_chongzhi_test_rao);

                    final Integer CarId2 = Integer.parseInt(fragment_01_zhanghu_sp_cars_chongzhi_rao.getSelectedItem().toString());

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setIcon(R.mipmap.icon101);
                    builder.setTitle(" 小车账户充值");
                    //点击对话框外部 对话框不消失
                    builder.setCancelable(false);
                    builder.setMessage("在"+new SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
                            .format(System.currentTimeMillis())+"将要给"+CarId2+"号小车充值"+monay+"元");
                    //设置正面按钮
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            car_chongzhi(CarId2,monay,"user1");
                        }
                    });
                    //设置反面按钮
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    //设置中立按钮
                    builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });


                    builder.create().show();

                }


        }
    }


    private void car_chaxun(final int CarId, String UserName){

        String action = "GetCarAccountBalance.do";

        String canshu = "{\"CarId\":"+CarId+", \"UserName\":\""+UserName+"\"}";

        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        final String RESULT = jsonObject.optString("RESULT");
                        String ERRMSG = jsonObject.optString("ERRMSG");
                        final Integer Balance = jsonObject.optInt("Balance");

                        Fragment_1_ZhangHu_Rao.this.getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                if(RESULT.equals("S")){

                                    Toast.makeText(getContext(),CarId+"号小车余额为："+Balance,Toast.LENGTH_SHORT).show();

                                }

                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }




            }
        };




        new OkHttp(canshu,action,callback);


    }




    private void car_chongzhi(final int CarId, final int Monay, String UserName){

        String action = "GetCarAccountBalance.do";

        String canshu = "{\"CarId\":"+CarId+",\"Money\":"+Monay+", \"UserName\":\""+UserName+"\"}";


        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        final String RESULT = jsonObject.optString("RESULT");
                        String ERRMSG = jsonObject.optString("ERRMSG");

                        Fragment_1_ZhangHu_Rao.this.getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                if(RESULT.equals("S")){

                                    Toast.makeText(getContext(),CarId+"号小车充值成功",Toast.LENGTH_SHORT).show();

                                }

                            }
                        });


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }




            }
        };




        new OkHttp(canshu,action,callback);


    }











    private void submit() {
        // validate
        String rao = fragment_01_zhuanghu_ET_Monay_chongzhi_rao.getText().toString().trim();
        if (TextUtils.isEmpty(rao)) {
            Toast.makeText(getContext(), "1-9999", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
