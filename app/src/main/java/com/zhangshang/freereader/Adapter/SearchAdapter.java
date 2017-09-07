package com.zhangshang.freereader.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhangshang.freereader.Bean.SearchValueBean;
import com.zhangshang.freereader.R;
import com.zhangshang.freereader.UI.BookInfoActivity;

import java.util.List;

/**
 * Created by allenlucas on 17-9-6.
 */

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<SearchValueBean.DataBean> dataBeanList;
    private List<SearchValueBean.SimilarBean> similarBeanList;
    private static final int DATA_TITLE = 0;
    private static final int SIMILAR_TITLE = 1;
    private static final int DATA_LIST = 2;
    private static final int DATA_NO = 3;
    private static final int SIMILAR_LIST = 4;
    private int similarPosition;

    public SearchAdapter(Context context,
                         List<SearchValueBean.DataBean> dataBeanList,
                         List<SearchValueBean.SimilarBean> similarBeanList) {
        this.context = context;
        this.dataBeanList = dataBeanList;
        this.similarBeanList = similarBeanList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == DATA_TITLE){
            View view = LayoutInflater.from(context).inflate(R.layout.bookinfo_title,parent,false);
            return new ValueTitleHolder(view);
        }else if (viewType == SIMILAR_TITLE){
            View view = LayoutInflater.from(context).inflate(R.layout.bookinfo_title,parent,false);
            return new SimilarTitleHolder(view);
        }else if (viewType == DATA_LIST){
            View view = LayoutInflater.from(context).inflate(R.layout.bookinfo_item,parent,false);
            return new ValueHolder(view);
        }else if (viewType == SIMILAR_LIST){
            View view = LayoutInflater.from(context).inflate(R.layout.bookinfo_item,parent,false);
            return new SimilarHolder(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.sameauthor_nocontent,parent,false);
            return new NoValueHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ValueTitleHolder){
            ((ValueTitleHolder) holder).textView.setText("搜索结果");
        }
        if (holder instanceof SimilarTitleHolder){
            ((SimilarTitleHolder) holder).textView.setText("相似小说");
        }

        if (holder instanceof NoValueHolder){
            ((NoValueHolder) holder).textView.setText("没有搜索到书籍");
        }
        if (holder instanceof ValueHolder){
            int dataposition = position - 1;
            final SearchValueBean.DataBean bean = dataBeanList.get(dataposition);
            ((ValueHolder) holder).bookname.setText(bean.getBook_name());
            ((ValueHolder) holder).booktarea.setText(bean.getTextarea());
            ((ValueHolder) holder).bookauthor.setText(bean.getAuthor());
            ((ValueHolder) holder).bookidentification.setText(bean.getIdentification());
            Glide.with(context).load(bean.getImg()).into(((ValueHolder) holder).bookimg);
            ((ValueHolder) holder).layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BookInfoActivity.Companion.startAction(context,bean.getId(),bean.getBook_name());
                }
            });
        }
        if (holder instanceof SimilarHolder){
            if (dataBeanList.size() == 0){
                similarPosition = position - 3;
            }else {
                similarPosition = position - 2 - dataBeanList.size();
            }
            final SearchValueBean.SimilarBean bean = similarBeanList.get(similarPosition);
            ((SimilarHolder) holder).bookname.setText(bean.getBook_name());
            ((SimilarHolder) holder).booktarea.setText(bean.getTextarea());
            ((SimilarHolder) holder).bookauthor.setText(bean.getAuthor());
            ((SimilarHolder) holder).bookidentification.setText(bean.getIdentification());
            Glide.with(context).load(bean.getImg()).into(((SimilarHolder) holder).bookimg);
            ((SimilarHolder) holder).layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BookInfoActivity.Companion.startAction(context,bean.getId(),bean.getBook_name());
                }
            });
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (dataBeanList.size() == 0){
            if (position == 0){
                return DATA_TITLE;
            }else if (position == 1){
                return DATA_NO;
            }else if (position == 2){
                return SIMILAR_TITLE;
            }else {
                return SIMILAR_LIST;
            }
        }else {
            if (position == 0){
                return DATA_TITLE;
            }else if (position > 0 && position < dataBeanList.size() + 1){
                return DATA_LIST;
            }else if (position > dataBeanList.size() + 1){
                return SIMILAR_LIST;
            }else {
                return SIMILAR_TITLE;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (dataBeanList.size() == 0){
            return similarBeanList.size() + 3;
        }else {
            return similarBeanList.size() + dataBeanList.size() + 2;
        }
    }

    public static class ValueHolder extends RecyclerView.ViewHolder{

        private ImageView bookimg;
        private TextView bookname,booktarea,bookauthor,bookidentification;
        private LinearLayout layout;
        public ValueHolder(View itemView) {
            super(itemView);
            bookimg = itemView.findViewById(R.id.bookinfo_bookimg);
            bookname = itemView.findViewById(R.id.bookinfo_bookname);
            booktarea = itemView.findViewById(R.id.bookinfo_booktarea);
            bookauthor = itemView.findViewById(R.id.bookinfo_bookauthor);
            bookidentification = itemView.findViewById(R.id.bookinfo_bookidentification);
            layout = itemView.findViewById(R.id.bookinfo_item);
        }
    }

    public static class SimilarHolder extends RecyclerView.ViewHolder{

        private ImageView bookimg;
        private TextView bookname,booktarea,bookauthor,bookidentification;
        private LinearLayout layout;
        public SimilarHolder(View itemView) {
            super(itemView);
            bookimg = itemView.findViewById(R.id.bookinfo_bookimg);
            bookname = itemView.findViewById(R.id.bookinfo_bookname);
            booktarea = itemView.findViewById(R.id.bookinfo_booktarea);
            bookauthor = itemView.findViewById(R.id.bookinfo_bookauthor);
            bookidentification = itemView.findViewById(R.id.bookinfo_bookidentification);
            layout = itemView.findViewById(R.id.bookinfo_item);
        }
    }

    public static class SimilarTitleHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public SimilarTitleHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.bookinfo_similar);
        }
    }

    public static class ValueTitleHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public ValueTitleHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.bookinfo_similar);
        }
    }

    public static class NoValueHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        public NoValueHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.bookinfo_value);
        }
    }
}
