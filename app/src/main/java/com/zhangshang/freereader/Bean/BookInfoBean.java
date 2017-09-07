package com.zhangshang.freereader.Bean;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by allenlucas on 17-9-5.
 */

public class BookInfoBean {

    /**
     * error : 0
     * msg : [{"id":"10","img":"http://47.92.115.233/web/Public/images/book/10.jpg","book_name":"情倾火云剑","textarea":"烈辰希对刚刚醒过来的白小雪说：我是你的救命恩人，所以我要对你负责。白小雪看着他的笑，感觉周围的花都在开放了，因为这一句话，她穷尽一生来爱他。","author":"大明湖","type":"玄幻奇幻","type_class":"1","txt":"http://47.92.115.233/web/Public/txt/情倾火云剑.zip","status":"1","is_frequency":"0","is_competitive":"1","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/10.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"6339","total_number":"420000","identification":"完结","label":"玄幻奇幻","rise":"10"}]
     * other : [{"id":"251","img":"http://47.92.115.233/web/Public/images/book/251.jpg","book_name":"高手欲成仙","textarea":"王宁宇出生书香门第，却向往修仙，被世人当成笑柄，这世界哪有修仙？他出走江湖，林间偶意白衣仙子，更结识江湖侠客，渐结仙缘，开启了一条不寻常的修仙路。","author":"大明湖","type":"古代言情","type_class":"6","txt":"http://47.92.115.233/web/Public/txt/高手欲成仙.zip","status":"1","is_frequency":"0","is_competitive":"0","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/251.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"7576","total_number":"161729","identification":"完结","label":"古代言情","rise":"251"}]
     * similar : [{"id":"2","img":"http://47.92.115.233/web/Public/images/book/2.jpg","book_name":"冥语纹神","textarea":"一个普通的纹身师，来到了一个修炼魔纹的世界。在这里，他可以修复天生的魔纹！而整个神祈大陆的山川草木，更组成了一幅关系世界命运的魔纹。试图触动和守护这魔纹的神秘组织，引出一段创世之初的神话！收集起四片分离的阿修慕德之镜，神秘的镜中世界留下了提示，风凌终于觉醒自己被穿越的使命！","author":"斩月","type":"玄幻奇幻","type_class":"1","txt":"http://47.92.115.233/web/Public/txt/冥语纹神.zip","status":"1","is_frequency":"0","is_competitive":"1","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/2.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"1","carousel_id":"2","read_num":"8731","total_number":"1080000","identification":"完结","label":"玄幻奇幻","rise":"1"},{"id":"4","img":"http://47.92.115.233/web/Public/images/book/4.jpg","book_name":"龙啸都市","textarea":"赵奕阳是生活在海东市的一个大学生，他平常呢就是经常去捡垃圾和做小工，帮别人跑腿买东西。一次意外，让他金鳞化龙，又巧遇极品美女总裁，犹如风云一般，让他龙啸都市。","author":"川河水","type":"玄幻奇幻","type_class":"3","txt":"http://47.92.115.233/web/Public/txt/龙啸都市.zip","status":"1","is_frequency":"0","is_competitive":"1","is_weird":"0","is_required":"0","edit_book_name":"龙啸都市","recommend_img":"http://47.92.115.233/web/Public/images/book/1121.jpg","required_text":"","is_recommend":"1","recommend_text":"","is_carousel":"1","carousel_id":"4","read_num":"6634","total_number":"500000","identification":"完结","label":"都市校园","rise":"3"},{"id":"6","img":"http://47.92.115.233/web/Public/images/book/6.jpg","book_name":"恶少的替身新娘","textarea":"一场意外让两个相爱的人从此形同陌路，失忆后的她却成为了他的未婚妻，你长得跟她再相似但始终不是她，你只是个替身。他将对她的思念与怨恨发泄在这个替身的身上，却不知道，在她失去的记忆里，他就是视她如命的人，而今却变成了最痛恨他的人","author":"小颜","type":"玄幻奇幻","type_class":"5","txt":"http://47.92.115.233/web/Public/txt/恶少的替身新娘.zip","status":"1","is_frequency":"1","is_competitive":"1","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/121211.jpg","required_text":"","is_recommend":"1","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"8232","total_number":"490000","identification":"完结","label":"现代言情","rise":"7"},{"id":"7","img":"http://47.92.115.233/web/Public/images/book/7.jpg","book_name":"重生之妖娆灰姑娘","textarea":"她是妖娆女特工，她是绝世灰姑娘。一次意外，让她们合二为一。她成为最妖娆的灰姑娘，陪伴着一个最冷酷的男人。她为他守护，他为她构筑爱巢。她以为这是属于她的童话。但，一场灭门，一场恩怨，因为她的重生而风云再起。当他的旧爱回归，她心碎离去。殊不知这仅仅是悲剧的开始\u2026\u2026","author":"飘若梦","type":"玄幻奇幻","type_class":"5","txt":"http://47.92.115.233/web/Public/txt/重生之妖娆灰姑娘.zip","status":"1","is_frequency":"0","is_competitive":"1","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/23343.jpg","required_text":"","is_recommend":"1","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"7233","total_number":"480000","identification":"完结","label":"现代言情","rise":"8"},{"id":"9","img":"http://47.92.115.233/web/Public/images/book/9.jpg","book_name":"我的美女老板娘","textarea":"为了一个老板娘，拥有绝顶厨艺的楚离屈身于一个小饭店当小厨师，却没想到这个老板娘竟然是个医学天才，为了她，楚离又屈身于一个小医院当医生，他与这个纯情又神秘的老板娘纠缠不清","author":"夜逢凉","type":"玄幻奇幻","type_class":"3","txt":"http://47.92.115.233/web/Public/txt/我的美女老板娘.zip","status":"1","is_frequency":"0","is_competitive":"1","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/43333.jpg","required_text":"","is_recommend":"1","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"2225","total_number":"430000","identification":"完结","label":"都市校园","rise":"9"},{"id":"12","img":"http://47.92.115.233/web/Public/images/book/12.jpg","book_name":"修罗武尊","textarea":"叶风偶然醒来，竟发现自己穿越异世，魂入他体。机缘巧合，叶风被崖上野松挂起，幸得一命，并遇上太古美女云曦。在美女的指导下，叶风修功法，炼神体，战妖霸，杀邪魔。一路上探寻奇景宝藏，追求至高仙体，杀戮妖魔怪兽，开辟异界神机。","author":"若雨情书","type":"玄幻奇幻","type_class":"1","txt":"http://47.92.115.233/web/Public/txt/修罗武尊.zip","status":"1","is_frequency":"0","is_competitive":"1","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/12.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"4718","total_number":"390000","identification":"完结","label":"玄幻奇幻","rise":"12"},{"id":"13","img":"http://47.92.115.233/web/Public/images/book/13.jpg","book_name":"傲世灭尊","textarea":"他本是绝世天才，却被迫隐藏修为，潜藏家族中，受尽白眼和凌辱。忍无可忍，无需再忍，强势爆发，踏碎一切阻碍，以灭世之姿，让诸神在我脚下颤抖！","author":"爱恨雾气","type":"玄幻奇幻","type_class":"1","txt":"http://47.92.115.233/web/Public/txt/傲世灭尊.zip","status":"1","is_frequency":"0","is_competitive":"1","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/13.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"1261","total_number":"370000","identification":"完结","label":"玄幻奇幻","rise":"13"},{"id":"16","img":"http://47.92.115.233/web/Public/images/book/16.jpg","book_name":"万古蛮妖","textarea":"我若为妖,吞天噬月。神魔遇之,为我精食。欺我权势，扰我红尘，乱我大道征伐那又如何？终有一日，我必携万钧之势足踏尔等，会当绝顶之姿目空一切。那一日，定当告之天下鼠辈，我便是那万古蛮妖！\u201d","author":"无笔","type":"玄幻奇幻","type_class":"1","txt":"http://47.92.115.233/web/Public/txt/万古蛮妖.zip","status":"1","is_frequency":"0","is_competitive":"1","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/444333.jpg","required_text":"","is_recommend":"1","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"1566","total_number":"320000","identification":"完结","label":"玄幻奇幻","rise":"16"},{"id":"17","img":"http://47.92.115.233/web/Public/images/book/17.jpg","book_name":"极品流氓录之天下无双","textarea":"现代男主穿越到古代流氓国，偶遇高人得到一本极品书，男主照着书籍不断修炼，泡无数妞，最后混到宫廷，与公主结婚，待皇帝因战事牺牲承袭皇位，国富民强，流芳百世","author":"百世轮回","type":"玄幻奇幻","type_class":"1","txt":"http://47.92.115.233/web/Public/txt/极品流氓录之天下无双.zip","status":"1","is_frequency":"0","is_competitive":"1","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/17.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"4073","total_number":"300000","identification":"完结","label":"玄幻奇幻","rise":"17"},{"id":"19","img":"http://47.92.115.233/web/Public/images/book/19.jpg","book_name":"药王转世","textarea":"药王菩萨星宿光在极乐世界里享了几千年清福之后，终于渐渐有些厌倦了，于是重入六道，轮回转世，然而他却发现，人间远远不是他想象中的那样。","author":"白玉金刚","type":"玄幻奇幻","type_class":"1","txt":"http://47.92.115.233/web/Public/txt/药王转世.zip","status":"1","is_frequency":"0","is_competitive":"1","is_weird":"0","is_required":"0","edit_book_name":"编辑的小说名","recommend_img":"http://47.92.115.233/web/Public/images/book/19.jpg","required_text":"","is_recommend":"0","recommend_text":"","is_carousel":"0","carousel_id":"0","read_num":"1506","total_number":"300000","identification":"完结","label":"玄幻奇幻","rise":"19"}]
     */

    private String error;
    private List<MsgBean> msg;
    private List<OtherBean> other;
    private List<SimilarBean> similar;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<MsgBean> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgBean> msg) {
        this.msg = msg;
    }

    public List<OtherBean> getOther() {
        return other;
    }

    public void setOther(List<OtherBean> other) {
        this.other = other;
    }

    public List<SimilarBean> getSimilar() {
        return similar;
    }

    public void setSimilar(List<SimilarBean> similar) {
        this.similar = similar;
    }

    public static class MsgBean {
        /**
         * id : 10
         * img : http://47.92.115.233/web/Public/images/book/10.jpg
         * book_name : 情倾火云剑
         * textarea : 烈辰希对刚刚醒过来的白小雪说：我是你的救命恩人，所以我要对你负责。白小雪看着他的笑，感觉周围的花都在开放了，因为这一句话，她穷尽一生来爱他。
         * author : 大明湖
         * type : 玄幻奇幻
         * type_class : 1
         * txt : http://47.92.115.233/web/Public/txt/情倾火云剑.zip
         * status : 1
         * is_frequency : 0
         * is_competitive : 1
         * is_weird : 0
         * is_required : 0
         * edit_book_name : 编辑的小说名
         * recommend_img : http://47.92.115.233/web/Public/images/book/10.jpg
         * required_text :
         * is_recommend : 0
         * recommend_text :
         * is_carousel : 0
         * carousel_id : 0
         * read_num : 6339
         * total_number : 420000
         * identification : 完结
         * label : 玄幻奇幻
         * rise : 10
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

        @BindingAdapter({"app:imageUrl"})
        public static void loadIMage(ImageView imageView, String url){
            Glide.with(imageView.getContext())
                    .load(url)
                    .into(imageView);
        }
    }

    public static class OtherBean {
        /**
         * id : 251
         * img : http://47.92.115.233/web/Public/images/book/251.jpg
         * book_name : 高手欲成仙
         * textarea : 王宁宇出生书香门第，却向往修仙，被世人当成笑柄，这世界哪有修仙？他出走江湖，林间偶意白衣仙子，更结识江湖侠客，渐结仙缘，开启了一条不寻常的修仙路。
         * author : 大明湖
         * type : 古代言情
         * type_class : 6
         * txt : http://47.92.115.233/web/Public/txt/高手欲成仙.zip
         * status : 1
         * is_frequency : 0
         * is_competitive : 0
         * is_weird : 0
         * is_required : 0
         * edit_book_name : 编辑的小说名
         * recommend_img : http://47.92.115.233/web/Public/images/book/251.jpg
         * required_text :
         * is_recommend : 0
         * recommend_text :
         * is_carousel : 0
         * carousel_id : 0
         * read_num : 7576
         * total_number : 161729
         * identification : 完结
         * label : 古代言情
         * rise : 251
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
    }

    public static class SimilarBean {
        /**
         * id : 2
         * img : http://47.92.115.233/web/Public/images/book/2.jpg
         * book_name : 冥语纹神
         * textarea : 一个普通的纹身师，来到了一个修炼魔纹的世界。在这里，他可以修复天生的魔纹！而整个神祈大陆的山川草木，更组成了一幅关系世界命运的魔纹。试图触动和守护这魔纹的神秘组织，引出一段创世之初的神话！收集起四片分离的阿修慕德之镜，神秘的镜中世界留下了提示，风凌终于觉醒自己被穿越的使命！
         * author : 斩月
         * type : 玄幻奇幻
         * type_class : 1
         * txt : http://47.92.115.233/web/Public/txt/冥语纹神.zip
         * status : 1
         * is_frequency : 0
         * is_competitive : 1
         * is_weird : 0
         * is_required : 0
         * edit_book_name : 编辑的小说名
         * recommend_img : http://47.92.115.233/web/Public/images/book/2.jpg
         * required_text :
         * is_recommend : 0
         * recommend_text :
         * is_carousel : 1
         * carousel_id : 2
         * read_num : 8731
         * total_number : 1080000
         * identification : 完结
         * label : 玄幻奇幻
         * rise : 1
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
    }
}
