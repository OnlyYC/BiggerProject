package com.liaoyb.persistence.service;

import com.liaoyb.base.domain.Page;
import com.liaoyb.persistence.domain.vo.base.Mess;
import com.liaoyb.persistence.domain.vo.base.User;

import java.util.List;

/**
 * 管理
 * @author ybliao2
 */
public interface ManagerServcie {

    /**
     * 还未处理的申请
     * @return
     */
    Page<Mess>notYetDiposeApplication(Page<Mess> page);

    /**
     * 高级管理员对申请的处理
     * @param isAgree
     * @param reply
     */
    void disposeApplication(Long messId,boolean isAgree,String reply);


    /**
     * 管理员
     * @return
     */
    Page<User>findManager(Page<User>page);
}
