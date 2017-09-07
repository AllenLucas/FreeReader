package com.zhangshang.freereader.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhangshang.freereader.Bean.BookInfoBean;
import com.zhangshang.freereader.R;
import com.zhangshang.freereader.UI.BookInfoActivity;

import java.util.List;


/**
 * Created by allenlucas on 17-9-5.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<BookInfoBean.SimilarBean> list;
    private List<BookInfoBean.OtherBean> ohterlist;
    private List<BookInfoBean.MsgBean> headerlist;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_OTHER = 1;
    private static final int TYPE_TITLE = 2;
    private static final int TYPE_SIMILAR = 3;
    private static final int TYPE_SAME = 4;
    private int similarposition;

    public MyAdapter(Context context,
                     List<com.zhangshang.freereader.Bean.BookInfoBean.SimilarBean> list,
                     List<BookInfoBean.MsgBean> headerlist,
                     List<BookInfoBean.OtherBean> ohterlist) {
        this.context = context;
        this.list = list;
        this.headerlist = headerlist;
        this.ohterlist = ohterlist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER){
            View header = LayoutInflater.from(context).inflate(R.layout.bookinfo_header,parent,false);
            return new HeaderHolder(header);
        }else if (viewType == TYPE_SIMILAR){
            View view = LayoutInflater.from(context).inflate(R.layout.bookinfo_item,parent,false);
            return new ViewHolder(view);
        }else if (viewType == TYPE_OTHER){
            View view = LayoutInflater.from(context).inflate(R.layout.bookinfo_item,parent,false);
            return new OtherHodler(view);
        }else if (viewType == TYPE_SAME){
            View view = LayoutInflater.from(context).inflate(R.layout.sameauthor_nocontent,parent,false);
            return new SameHodler(view);
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.bookinfo_title,parent,false);
            return new TitleHoder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof HeaderHolder){
            if (headerlist.size() > 0){
                final TextView des = ((HeaderHolder) holder).booktarea;
                ((HeaderHolder) holder).bookauthorname.setText(headerlist.get(0).getAuthor());
                des.setText(headerlist.get(0).getTextarea());
                des.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (des.getMaxLines() == 99){
                            des.setMaxLines(4);
                        }else {
                            des.setMaxLines(99);
                        }
                    }
                });
            }
        }
        if (holder instanceof ViewHolder){
            if (ohterlist.size() == 0){
                similarposition = position - 3;
            }else {
                similarposition = position - ohterlist.size() - 2;
            }
            ((ViewHolder) holder).bookname.setText(list.get(similarposition).getBook_name());
            ((ViewHolder) holder).bookauthor.setText(list.get(similarposition).getAuthor());
            ((ViewHolder) holder).booktarea.setText(list.get(similarposition).getTextarea());
            ((ViewHolder) holder).bookidentification.setText(list.get(similarposition).getIdentification());
            Glide.with(context).load(list.get(similarposition).getImg()).into(((ViewHolder) holder).bookimg);
            ((ViewHolder) holder).layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ohterlist.size() == 0){
                        BookInfoActivity
                                .Companion.startAction(context,
                                list.get(position - 3).getId(),
                                list.get(position - 3).getBook_name());
                    }else {
                        BookInfoActivity
                                .Companion.startAction(context,
                                list.get(position - ohterlist.size() - 2).getId(),
                                list.get(position - ohterlist.size() - 2).getBook_name());
                    }

                }
            });
        }

        if (holder instanceof OtherHodler){
            final int otherposition = position - 1;
            ((OtherHodler) holder).bookname.setText(ohterlist.get(otherposition).getBook_name());
            ((OtherHodler) holder).bookauthor.setText(ohterlist.get(otherposition).getAuthor());
            ((OtherHodler) holder).booktarea.setText(ohterlist.get(otherposition).getTextarea());
            ((OtherHodler) holder).bookidentification.setText(ohterlist.get(otherposition).getIdentification());
            Glide.with(context).load(ohterlist.get(otherposition).getImg()).into(((OtherHodler) holder).bookimg);
            ((OtherHodler) holder).layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BookInfoActivity.Companion
                            .startAction(context
                                    ,ohterlist.get(otherposition).getId()
                                    ,ohterlist.get(otherposition).getBook_name());
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (ohterlist.size() == 0){
            if (position == 0){
                return TYPE_HEADER;
            }else if (position == 1){
                return TYPE_SAME;
            }else if (position == 2){
                return TYPE_TITLE;
            }else {
                return TYPE_SIMILAR;
            }
        }else {
            if (position == 0){
                return TYPE_HEADER;
            }else if (position > 0 && position < ohterlist.size() + 1){
                return TYPE_OTHER;
            }else if (position > ohterlist.size() + 1){
                return TYPE_SIMILAR;
            }else {
                return TYPE_TITLE;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (ohterlist.size() == 0){
            return list.size() + 3;
        }else {
            return list.size() + 2 + ohterlist.size();
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView bookimg;
        private TextView bookname,booktarea,bookauthor,bookidentification;
        private LinearLayout layout;
        public ViewHolder(View itemView) {
            super(itemView);
            bookimg = itemView.findViewById(R.id.bookinfo_bookimg);
            bookname = itemView.findViewById(R.id.bookinfo_bookname);
            booktarea = itemView.findViewById(R.id.bookinfo_booktarea);
            bookauthor = itemView.findViewById(R.id.bookinfo_bookauthor);
            bookidentification = itemView.findViewById(R.id.bookinfo_bookidentification);
            layout = itemView.findViewById(R.id.bookinfo_item);
        }
    }

    public static class HeaderHolder extends RecyclerView.ViewHolder{

        private TextView booktarea,bookauthorname;
        public HeaderHolder(View itemView) {
            super(itemView);
            booktarea = itemView.findViewById(R.id.bookinfo_des);
            bookauthorname = itemView.findViewById(R.id.bookinfo_header_bookauthorsname);
        }
    }

    public static class OtherHodler extends RecyclerView.ViewHolder{
        private ImageView bookimg;
        private TextView bookname,booktarea,bookauthor,bookidentification;
        private LinearLayout layout;
        public OtherHodler(View itemView) {
            super(itemView);
            bookimg = itemView.findViewById(R.id.bookinfo_bookimg);
            bookname = itemView.findViewById(R.id.bookinfo_bookname);
            booktarea = itemView.findViewById(R.id.bookinfo_booktarea);
            bookauthor = itemView.findViewById(R.id.bookinfo_bookauthor);
            bookidentification = itemView.findViewById(R.id.bookinfo_bookidentification);
            layout = itemView.findViewById(R.id.bookinfo_item);
        }
    }

    public static class TitleHoder extends RecyclerView.ViewHolder{

        public TitleHoder(View itemView) {
            super(itemView);
        }
    }

    public static class SameHodler extends RecyclerView.ViewHolder{

        public SameHodler(View itemView) {
            super(itemView);
        }
    }

}
