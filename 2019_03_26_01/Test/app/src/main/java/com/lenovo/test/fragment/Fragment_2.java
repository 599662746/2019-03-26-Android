package com.lenovo.test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.lenovo.test.R;


public class Fragment_2 extends Fragment implements View.OnClickListener {

    private Spinner rao_paixv_SP;
    private Button rao_honglvdnegchaxun_Btn;
    private ListView rao_honglvdneg_LV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_layout02, container, false);
        initView(view);






        return view;
    }

    private void initView(View view) {
        rao_paixv_SP = (Spinner) view.findViewById(R.id.rao_paixv_SP);
        rao_honglvdnegchaxun_Btn = (Button) view.findViewById(R.id.rao_honglvdnegchaxun_Btn);
        rao_honglvdneg_LV = (ListView) view.findViewById(R.id.rao_honglvdneg_LV);
        rao_honglvdnegchaxun_Btn.setOnClickListener(this);










    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rao_honglvdnegchaxun_Btn:






                break;
        }
    }


    private void list_paixv(){





    }


}
