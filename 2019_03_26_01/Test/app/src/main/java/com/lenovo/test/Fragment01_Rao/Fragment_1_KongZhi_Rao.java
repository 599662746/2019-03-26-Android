package com.lenovo.test.Fragment01_Rao;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
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

import static android.content.ContentValues.TAG;
import static com.lenovo.test.util.LoadingDialog.dialog;


public class Fragment_1_KongZhi_Rao extends Fragment {

    private Spinner fragment_layout01_SP_KongZhi_rao;
    private Switch fragment_layout01_SW_KongZhi_rao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment01_kongzhi_rao, container, false);
        initView(view);


        fragment_layout01_SW_KongZhi_rao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Integer CarId = Integer.parseInt(fragment_layout01_SP_KongZhi_rao.getSelectedItem().toString());

                if (isChecked) {

                    cat_qitingkongzhi(CarId, "Start", "user1");
                }

                cat_qitingkongzhi(CarId, "Stop", "user1");
            }
        });


        return view;
    }

    private void initView(View view) {
        fragment_layout01_SP_KongZhi_rao = (Spinner) view.findViewById(R.id.fragment_layout01_SP_KongZhi_rao);
        fragment_layout01_SW_KongZhi_rao = (Switch) view.findViewById(R.id.fragment_layout01_SW_KongZhi_rao);
    }

    private void cat_qitingkongzhi(final int CarId, final String CarAction, String UserName) {

        String action = "SetCarMove.do";

        String canshu = "{\"CarId\":" + CarId + ",\"CarAction\":\"" + CarAction + "\",\"UserName\":\"" + UserName + "\"}";

        Log.i(TAG, "cat_qitingkongzhi: 请求地址为" + action + "请求参数为" + canshu);

        Callback callback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200) {

                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());

                        String RESULT = jsonObject.optString("RESULT");
                        String ERRMSG = jsonObject.optString("ERRMSG");

                        Log.i(TAG, "onResponse: 请求数据状态为：" + ERRMSG);

                        Fragment_1_KongZhi_Rao.this.getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                if (CarAction.equals("Start"))
                                    Toast.makeText(getContext(), CarId + "号小车启动成功", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(getContext(), CarId + "号小车停止成功", Toast.LENGTH_SHORT).show();

                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }


            }
        };


        new OkHttp(canshu, action, callback);

    }


}
