package com.zhangshang.freereader.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.zhangshang.freereader.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allenlucas on 17-8-31.
 */

public class TabBookAdapter<T1,T2 extends ViewDataBinding>
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<T1> list;
    private LayoutInflater inflater;
    private Context context;
    @LayoutRes
    private int layout;
    private BindView bindView;
    final private static int TYPE_NORMAL = 0;
    final private static int TYPE_FOOTER = 1;
    public static final int PULLUP_LOAD_MORE = 0;
    public static final int LOADING_MORE = 1;
    public static final int LOAD_END = 2;
    public static final int START_ACTION = 3;
    public static final int INIT_INT = 0;
    private int load_more_status = 0;


    public TabBookAdapter(Context context,@LayoutRes int layout ){
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.layout = layout;
        list = new ArrayList<>();
    }



    public void initList(List<T1> list){
        this.list = list;
    }

    public void setOnBindViewHolder(BindView<T2> bindView){
        this.bindView = bindView;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case TYPE_NORMAL:
                final View view = inflater.inflate(layout,parent,false);
                return new BaseViewHolder(view);
            case TYPE_FOOTER:
                final View view1 = inflater.inflate(R.layout.footer_layout,parent,false);
                return new FooterView(view1);
            default: return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BaseViewHolder){
            bindView.onBindViewHolder((T2)((BaseViewHolder)holder).getBinding(),position);
        }

        if (holder instanceof FooterView){
            Log.e("code",load_more_status + "");
            switch (load_more_status){
                case PULLUP_LOAD_MORE:
                    ((FooterView) holder).layout.setVisibility(View.INVISIBLE);
                    ((FooterView) holder).progressBar.setVisibility(View.GONE);
                    ((FooterView) holder).content.setText("上拉加载更多...");
                    ((FooterView) holder).layout.setBackgroundColor(Color.parseColor("#ececec"));
                    break;
                case LOADING_MORE:
                    ((FooterView) holder).layout.setVisibility(View.VISIBLE);
                    ((FooterView) holder).progressBar.setVisibility(View.VISIBLE);
                    ((FooterView) holder).content.setText("正在加载中...");
                    ((FooterView) holder).layout.setBackgroundColor(Color.parseColor("#ececec"));
                    break;
                case LOAD_END:
                    ((FooterView) holder).progressBar.setVisibility(View.GONE);
                    ((FooterView) holder).content.setText("没有更多数据");
                    ((FooterView) holder).layout.setBackgroundColor(Color.parseColor("#ececec"));
                    break;
                case START_ACTION:
                    ((FooterView) holder).layout.setBackgroundColor(Color.parseColor("#00000000"));
                    break;
                default:
                    ((FooterView) holder).layout.setVisibility(View.GONE);
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }


    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()){
            return TYPE_FOOTER;
        }else {
            return TYPE_NORMAL;
        }
    }

    public interface BindView<T2>{
        void onBindViewHolder(T2 b , int position);
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder{

        private ViewDataBinding b;

        public BaseViewHolder(View itemView) {
            super(itemView);
            b = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding(){
            return b;
        }
    }

    public static class FooterView extends RecyclerView.ViewHolder{

        private ProgressBar progressBar;
        private TextView content;
        private LinearLayout layout;
        public FooterView(View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressbar);
            content = itemView.findViewById(R.id.loadmore_content);
            layout = itemView.findViewById(R.id.layout);
        }
    }

    public void changeMOreStatus(int status){
        load_more_status = status;
        if (status == LOAD_END || status == START_ACTION){
            notifyDataSetChanged();
        }else {
            notifyItemInserted(getItemCount());
        }
    }

}
