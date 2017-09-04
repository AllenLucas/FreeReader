package com.dawenming.freereader.Bean;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by allenlucas on 17-8-31.
 */

public class TabBookBean {

    /**
     * error : 0
     * msg : [{"id":"4","img":"http://47.92.115.233/web/Public/images/book/4.jpg","book_name":"龙啸都市","textarea":"赵奕阳是生活在海东市的一个大学生，他平常呢就是经常去捡垃圾和做小工，帮别人跑腿买东西。一次意外，让他金鳞化龙，又巧遇极品美女总裁，犹如风云一般，让他龙啸都市。","author":"川河水","type":"都市校园","type_class":"3","txt":"http://47.92.115.233/web/Public/txt/龙啸都市.zip","status":"1","is_frequency":"0","is_competitive":"1","is_weird":"0","is_required":"0","edit_book_name":"龙啸都市","recommend_img":"http://47.92.115.233/web/Public/images/book/1121.jpg","required_text":"","is_recommend":"1","recommend_text":"","is_carousel":"1","carousel_id":"4","read_num":"6634","total_number":"500000","identification":"完结","label":"都市校园","rise":"3","cid":"3","class_type":"3"},{"id":"8","img":"http://47.92.115.233/web/Public/images/book/8.jpg","book_name":"我的21岁女秘书","textarea":"一个厌倦了血与火生涯的特种兵，回到繁华的都市，开了一家替身事物所，招个萌妹子做秘书，本想赚点小钱，喝点小酒，逗逗萌妹，潇潇洒洒的过下半辈子，却不料因为一个替身任务，被一个神秘美女缠上\u2026\u2026","author":"无想转生","type":"都市校园","type_class":"3","txt":"http://47.92.115.233/web/Public/txt/我的21岁女秘书.zip","status":"1","is_frequency":"0","is_competitive":"0","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/8.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"9066","total_number":"460000","identification":"完结","label":"都市校园","rise":"2","cid":"3","class_type":"3"},{"id":"9","img":"http://47.92.115.233/web/Public/images/book/9.jpg","book_name":"我的美女老板娘","textarea":"为了一个老板娘，拥有绝顶厨艺的楚离屈身于一个小饭店当小厨师，却没想到这个老板娘竟然是个医学天才，为了她，楚离又屈身于一个小医院当医生，他与这个纯情又神秘的老板娘纠缠不清","author":"夜逢凉","type":"都市校园","type_class":"3","txt":"http://47.92.115.233/web/Public/txt/我的美女老板娘.zip","status":"1","is_frequency":"0","is_competitive":"1","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/43333.jpg","required_text":"","is_recommend":"1","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"2225","total_number":"430000","identification":"完结","label":"都市校园","rise":"9","cid":"3","class_type":"3"},{"id":"23","img":"http://47.92.115.233/web/Public/images/book/23.jpg","book_name":"异世神龙穿都市","textarea":"世间有许多事，明明像是已降临到你头上，但却仅擦身而过；而另一些事，却在你毫无所觉间，降临在你的身上。一条异界的神龙降临在现代都市中，遇到一个落魄少年易其，从此海阔凭鱼跃\u2026\u2026","author":"我是五歌","type":"都市校园","type_class":"3","txt":"http://47.92.115.233/web/Public/txt/异世神龙穿都市.zip","status":"1","is_frequency":"1","is_competitive":"0","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/23.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"6667","total_number":"260000","identification":"完结","label":"都市校园","rise":"23","cid":"3","class_type":"3"},{"id":"32","img":"http://47.92.115.233/web/Public/images/book/32.jpg","book_name":"合租情圣","textarea":"主人公薛怀，因受不了他大姐的唠叨，在他二姐的帮助下，从台湾转学到杭城迦林大学，而在他来杭城之前，早已买下离迦林大学最近的公寓，此次一去，就要住在那公寓里，但是，他万万没想到，在自己的公寓里，竟然住着三个大美女\u2026","author":"一天晴","type":"都市校园","type_class":"3","txt":"http://47.92.115.233/web/Public/txt/合租情圣.zip","status":"1","is_frequency":"1","is_competitive":"0","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/32.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"5248","total_number":"200000","identification":"完结","label":"都市校园","rise":"32","cid":"3","class_type":"3"},{"id":"40","img":"http://47.92.115.233/web/Public/images/book/40.jpg","book_name":"医者传奇","textarea":"他是一个落魄的大学生，在怪教授的栽培下，脱颖而出，成为一名技艺绝顶的名医。他一边是手术台上的主刀医师，一边是恣意花丛的情场高手\u2026\u2026","author":"稀里糊涂喝粥","type":"都市校园","type_class":"3","txt":"http://47.92.115.233/web/Public/txt/医者传奇.zip","status":"1","is_frequency":"1","is_competitive":"0","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/40.jpg","required_text":"","is_recommend":"1","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"7222","total_number":"200000","identification":"完结","label":"都市校园","rise":"40","cid":"3","class_type":"3"},{"id":"78","img":"http://47.92.115.233/web/Public/images/book/78.jpg","book_name":"末世黑龙的齐人之福","textarea":"记住了把，仙子道。记住了，黑龙点头。黑龙默默的念了一百零八遍，最后终于解除了那禁忌。此时已经大彻大悟的黑龙默默用天眼的看了看自己穿越到的这个世界，又忽悠一闪，回到了现实重新开始了崭新的生活。世上本无事，庸人自扰之，一切如梦幻泡影。作品标签： 末世黑龙的齐人之福","author":"皇兄","type":"都市校园","type_class":"3","txt":"http://47.92.115.233/web/Public/txt/末世黑龙的齐人之福.zip","status":"1","is_frequency":"1","is_competitive":"0","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/78.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"7146","total_number":"196263","identification":"完结","label":"都市校园","rise":"78","cid":"3","class_type":"3"},{"id":"82","img":"http://47.92.115.233/web/Public/images/book/82.jpg","book_name":"重生之戮世骇客","textarea":"杨傲，三十岁，戴一副金边眼镜，瘦骨嶙峋的。几乎每次和老婆床第之欢，都被老婆损曰硌得慌，情志压抑，加上一副猥琐被人瞧不起的容貌，性格孤僻，很少与人交往但是在中情局工作的人都知道，杨傲外貌虽然不出众，在计算机领域，却是一个传奇。五次中美黑客大战，杨傲都扮演着中方极为强硬的角色，攻城掠地，奋力厮杀，捍卫国家尊严","author":"大马士革","type":"都市校园","type_class":"3","txt":"http://47.92.115.233/web/Public/txt/重生之戮世骇客.zip","status":"1","is_frequency":"1","is_competitive":"0","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/82.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"6370","total_number":"191730","identification":"完结","label":"都市校园","rise":"82","cid":"3","class_type":"3"},{"id":"94","img":"http://47.92.115.233/web/Public/images/book/94.jpg","book_name":"我为学院武","textarea":"清明的夏夜，漫天繁星。墨瑜寒仰躺在房顶，望着夜空。晚风轻轻吹过，柔顺的发丝散落脸前。流星迅速划过天边，可是在这浩瀚的星空下，流星一闪而逝的光彩太不引人注目。墨瑜寒笑笑，转身从房顶上滚下这是一个平凡的大陆，有着现代的科技，也有着不为人知的武术，还有一些人们不知道的隐世高手。作为武术世家的墨瑜寒，保守着自己的武术秘密，憧憬着未来。        房子是老旧的..作品标签： 我为学院武 墨瑜寒","author":"柳絮飞","type":"都市校园","type_class":"3","txt":"http://47.92.115.233/web/Public/txt/我为学院武.zip","status":"1","is_frequency":"1","is_competitive":"0","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/94.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"7759","total_number":"182781","identification":"完结","label":"都市校园","rise":"94","cid":"3","class_type":"3"},{"id":"99","img":"http://47.92.115.233/web/Public/images/book/99.jpg","book_name":"重生之王牌高手","textarea":"十三晃动着自己有些笨拙的身体朝着外面就走了去，就在这宅子的外面\u2026\u2026外面有数百人正捉刀厮杀着\u2026\u2026飞溅的鲜血，已经在地上汇集成了一条又一条的小河流\u2026\u2026散落一地的断手断脚，以及那已经躺着不再动弹的尸体\u2026\u2026将十三的眼睛给映成了血红色\u2026\u2026","author":"长风斩月圆","type":"都市校园","type_class":"3","txt":"http://47.92.115.233/web/Public/txt/重生之王牌高手.zip","status":"1","is_frequency":"1","is_competitive":"0","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/99.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"2058","total_number":"179157","identification":"完结","label":"都市校园","rise":"99","cid":"3","class_type":"3"}]
     */

    private String error;
    private List<TabBookListBean> msg;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<TabBookListBean> getMsg() {
        return msg;
    }

    public void setMsg(List<TabBookListBean> msg) {
        this.msg = msg;
    }

    public static class TabBookListBean {
        /**
         * id : 4
         * img : http://47.92.115.233/web/Public/images/book/4.jpg
         * book_name : 龙啸都市
         * textarea : 赵奕阳是生活在海东市的一个大学生，他平常呢就是经常去捡垃圾和做小工，帮别人跑腿买东西。一次意外，让他金鳞化龙，又巧遇极品美女总裁，犹如风云一般，让他龙啸都市。
         * author : 川河水
         * type : 都市校园
         * type_class : 3
         * txt : http://47.92.115.233/web/Public/txt/龙啸都市.zip
         * status : 1
         * is_frequency : 0
         * is_competitive : 1
         * is_weird : 0
         * is_required : 0
         * edit_book_name : 龙啸都市
         * recommend_img : http://47.92.115.233/web/Public/images/book/1121.jpg
         * required_text :
         * is_recommend : 1
         * recommend_text :
         * is_carousel : 1
         * carousel_id : 4
         * read_num : 6634
         * total_number : 500000
         * identification : 完结
         * label : 都市校园
         * rise : 3
         * cid : 3
         * class_type : 3
         */

        private String id;
        private String img;
        private String book_name;
        private String textarea;
        private String author;
        private String type;
        private String type_class;
        private String txt;
        private String status;
        private String is_frequency;
        private String is_competitive;
        private String is_weird;
        private String is_required;
        private String edit_book_name;
        private String recommend_img;
        private String required_text;
        private String is_recommend;
        private String recommend_text;
        private String is_carousel;
        private String carousel_id;
        private String read_num;
        private String total_number;
        private String identification;
        private String label;
        private String rise;
        private String cid;
        private String class_type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getBook_name() {
            return book_name;
        }

        public void setBook_name(String book_name) {
            this.book_name = book_name;
        }

        public String getTextarea() {
            return textarea;
        }

        public void setTextarea(String textarea) {
            this.textarea = textarea;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType_class() {
            return type_class;
        }

        public void setType_class(String type_class) {
            this.type_class = type_class;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIs_frequency() {
            return is_frequency;
        }

        public void setIs_frequency(String is_frequency) {
            this.is_frequency = is_frequency;
        }

        public String getIs_competitive() {
            return is_competitive;
        }

        public void setIs_competitive(String is_competitive) {
            this.is_competitive = is_competitive;
        }

        public String getIs_weird() {
            return is_weird;
        }

        public void setIs_weird(String is_weird) {
            this.is_weird = is_weird;
        }

        public String getIs_required() {
            return is_required;
        }

        public void setIs_required(String is_required) {
            this.is_required = is_required;
        }

        public String getEdit_book_name() {
            return edit_book_name;
        }

        public void setEdit_book_name(String edit_book_name) {
            this.edit_book_name = edit_book_name;
        }

        public String getRecommend_img() {
            return recommend_img;
        }

        public void setRecommend_img(String recommend_img) {
            this.recommend_img = recommend_img;
        }

        public String getRequired_text() {
            return required_text;
        }

        public void setRequired_text(String required_text) {
            this.required_text = required_text;
        }

        public String getIs_recommend() {
            return is_recommend;
        }

        public void setIs_recommend(String is_recommend) {
            this.is_recommend = is_recommend;
        }

        public String getRecommend_text() {
            return recommend_text;
        }

        public void setRecommend_text(String recommend_text) {
            this.recommend_text = recommend_text;
        }

        public String getIs_carousel() {
            return is_carousel;
        }

        public void setIs_carousel(String is_carousel) {
            this.is_carousel = is_carousel;
        }

        public String getCarousel_id() {
            return carousel_id;
        }

        public void setCarousel_id(String carousel_id) {
            this.carousel_id = carousel_id;
        }

        public String getRead_num() {
            return read_num;
        }

        public void setRead_num(String read_num) {
            this.read_num = read_num;
        }

        public String getTotal_number() {
            return total_number;
        }

        public void setTotal_number(String total_number) {
            this.total_number = total_number;
        }

        public String getIdentification() {
            return identification;
        }

        public void setIdentification(String identification) {
            this.identification = identification;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getRise() {
            return rise;
        }

        public void setRise(String rise) {
            this.rise = rise;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getClass_type() {
            return class_type;
        }

        public void setClass_type(String class_type) {
            this.class_type = class_type;
        }

        @BindingAdapter({"app:imageUrl"})
        public static void loadIMage(ImageView imageView,String url){
            Glide.with(imageView.getContext())
                    .load(url)
                    .into(imageView);
        }

    }
}
