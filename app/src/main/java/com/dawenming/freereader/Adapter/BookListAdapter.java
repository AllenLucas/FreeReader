package com.dawenming.freereader.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dawenming.freereader.R;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */

public class BookListAdapter<T1, T2 extends ViewDataBinding>
        extends RecyclerView.Adapter<BookListAdapter.BaseViewHolder>  {

    private List<T1> list;
    private LayoutInflater inflater;
    private Context context;
    @LayoutRes
    private int layout;
    private BindView<T2> bindView;


    public BookListAdapter(Context context, @LayoutRes int layout) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.layout = layout;
        list = new ArrayList<>();
    }

    public void initList(List<T1> list) {
        this.list = list;
    }

    public void setOnBindViewHolder(BindView<T2> bindView) {
        this.bindView = bindView;
    }

    @Override
    public BookListAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = inflater.inflate(layout, parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final BookListAdapter.BaseViewHolder holder, final int position) {
        bindView.onBindViewHolder((T2) holder.getBinding(), position);
        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                shelf.clickBook((FreeBookBean) list.get(position));
            }
        });
        holder.getBinding().getRoot().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                shelf.longClickBook((FreeBookBean) list.get(position));
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface BindView<T2> {
        void onBindViewHolder(T2 b, int position);
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding b;

        public BaseViewHolder(final View itemView) {
            super(itemView);
            b = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding() {
            return b;
        }
    }

}
