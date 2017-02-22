package com.lemoni.model.bean;

import java.util.List;

/**
 * Created by dellit on 2017/2/20.
 */
public  class Data {
            /**
             * content : 你有吃的有喝的不第一时间想着我我无所谓，但你要有八卦没有第一时间分享给我，我们这对姐妹也算到头了。
             * hashId : 1316f448c9f5fdfde442a86d81614169
             * unixtime : 1487558030
             * updatetime : 2017-02-20 10:33:50
             */

            private String content;
            private String hashId;
            private int unixtime;
            private String updatetime;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHashId() {
                return hashId;
            }

            public void setHashId(String hashId) {
                this.hashId = hashId;
            }

            public int getUnixtime() {
                return unixtime;
            }

            public void setUnixtime(int unixtime) {
                this.unixtime = unixtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

}
