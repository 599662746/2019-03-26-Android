package com.lenovo.test.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.ListView;

import com.lenovo.test.R;

public class FragmentLayout02Adapter extends BaseAdapter {

    private List<fragment02_list_Bean> objects = new ArrayList<fragment02_list_Bean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public FragmentLayout02Adapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public fragment02_list_Bean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.fragment_layout02, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((fragment02_list_Bean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(fragment02_list_Bean object, ViewHolder holder) {
        //TODO implement
    }

    protected class ViewHolder {
        private Spinner raoPaixvSP;
    private Button raoHonglvdnegchaxunBtn;
    private ListView raoHonglvdnegLV;

        public ViewHolder(View view) {
            raoPaixvSP = (Spinner) view.findViewById(R.id.rao_paixv_SP);
            raoHonglvdnegchaxunBtn = (Button) view.findViewById(R.id.rao_honglvdnegchaxun_Btn);
            raoHonglvdnegLV = (ListView) view.findViewById(R.id.rao_honglvdneg_LV);
        }
    }
}
