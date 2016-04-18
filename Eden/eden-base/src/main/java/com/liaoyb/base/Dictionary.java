package com.liaoyb.base;

/**
 * @author ybliao2
 */
public class Dictionary {

    /**
     * 歌曲类型
     */
    public enum SongType {

        SONG(1L,"歌曲"),
        MV(2L,"MV");
        private Long code;
        private String text;

        public Long getCode() {
            return code;
        }


        public String getText() {
            return text;
        }


        SongType(Long code, String text) {
            this.code=code;
            this.text=text;
        }
    }

    /**
     * 地区
     * （歌手，歌曲的所属地区）
     */
    public enum Area{
        /**
         * 内地
         */
        HINTERLAND(1L,"内地"),
        /**
         * 港台
         */
        HONGKONG_TAIWAN(2L,"港台"),
        /**
         * 欧美
         */
        EUROPE_AMERICA(3L,"欧美"),
        /**
         * 日本
         */
        JAPANESE(4L,"日本"),
        /**
         * 韩国
         */
        KOREA(5L,"韩国"),
        /**
         * 其他
         */
        OUTHER(6L,"其他");

        private Long code;
        private String text;
        Area(Long code,String text) {
            this.code=code;
            this.text=text;
        }
        public Long getCode() {
            return code;
        }


        public String getText() {
            return text;
        }

    }
}
