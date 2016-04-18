package com.liaoyb.persistence.domain.vo.custom;

import com.liaoyb.persistence.domain.vo.base.Songtype;

import java.util.List;

/**
 * 分类扩展
 *
 * @author liao
 * @create 2016-02-05-11:10
 **/
public class SongtypeCustom extends Songtype {

    //子类别
    private List<Songtype>childSongtype;

    public List<Songtype> getChildSongtype() {
        return childSongtype;
    }

    public void setChildSongtype(List<Songtype> childSongtype) {
        this.childSongtype = childSongtype;
    }
}
