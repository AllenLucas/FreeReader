package com.dawenming.freereader.Bean;

import java.util.List;

/**
 * Created by allenlucas on 17-8-30.
 */

public class TabBean {

    /**
     * error : 0
     * msg : [{"cid":"1","type":"玄幻奇幻","class_type":"1"},{"cid":"2","type":"武侠仙侠","class_type":"2"},{"cid":"3","type":"都市校园","class_type":"3"},{"cid":"4","type":"历史军事","class_type":"4"},{"cid":"5","type":"现代言情","class_type":"5"},{"cid":"6","type":"古代言情","class_type":"6"},{"cid":"7","type":"幻想言情","class_type":"7"},{"cid":"8","type":"耽美同人","class_type":"8"},{"cid":"9","type":"科幻悬疑","class_type":"9"},{"cid":"10","type":"游戏动漫","class_type":"10"},{"cid":"11","type":"文学名著","class_type":"11"},{"cid":"12","type":"轻小说","class_type":"12"}]
     */

    private String error;
    private List<MsgBean> msg;

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

    public static class MsgBean {
        /**
         * cid : 1
         * type : 玄幻奇幻
         * class_type : 1
         */

        private String cid;
        private String type;
        private String class_type;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getClass_type() {
            return class_type;
        }

        public void setClass_type(String class_type) {
            this.class_type = class_type;
        }
    }
}
