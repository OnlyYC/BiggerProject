package com.liaoyb.persistence.serviceImpl;

import com.alibaba.dubbo.common.utils.Assert;
import com.alibaba.dubbo.config.annotation.Service;
import com.liaoyb.base.SysCode;
import com.liaoyb.base.annotation.PageAnnotation;
import com.liaoyb.base.domain.Page;
import com.liaoyb.base.enums.UserRoleTypeEnum;
import com.liaoyb.persistence.dao.base.MessMapper;
import com.liaoyb.persistence.dao.base.UserWithRoleMapper;
import com.liaoyb.persistence.dao.custom.MessMapperCustom;
import com.liaoyb.persistence.dao.custom.UserMapperCustom;
import com.liaoyb.persistence.domain.dto.UserDto;
import com.liaoyb.persistence.domain.vo.base.Mess;
import com.liaoyb.persistence.domain.vo.base.User;
import com.liaoyb.persistence.domain.vo.base.UserWithRole;
import com.liaoyb.persistence.service.ManagerServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author ybliao2
 */
@Service
public class ManagerServiceImpl implements ManagerServcie {

    @Autowired
    private MessMapperCustom messMapperCustom;

    @Autowired
    private MessMapper messMapper;

    @Autowired
    private UserMapperCustom userMapperCustom;

    @Autowired
    private UserWithRoleMapper userWithRoleMapper;


    /**
     * 还未处理的申请
     *
     * @return
     */
    @Override
    @PageAnnotation
    public Page<Mess> notYetDiposeApplication(Page<Mess> page) {
        page.setResult(messMapperCustom.findNotYetDisponseApplication());
        return page;
    }

    /**
     * 高级管理员对申请的处理
     *
     * @param isAgree
     * @param reply
     */
    @Override
    @Transactional
    public void disposeApplication(Long messId,boolean isAgree, String reply) {
        Assert.notNull(messId,"申请不能为空");
        Mess mess=messMapper.selectByPrimaryKey(messId);
        mess.setLooked(1L);
        UserDto userDto=userMapperCustom.findUserDto(mess.getFromUser());
        //是否同意
        if(isAgree){
            //赋予权限

            //看权限是否已经存在
            if(userDto.getRoleType().contains(UserRoleTypeEnum.Admin.value())){
                //权限已经存在,
                return;
            }else{
                //插入
                UserWithRole userWithRole=new UserWithRole();
                userWithRole.setRoleId(2L);
                userWithRole.setUserId(userDto.getId());
                userWithRoleMapper.insertSelective(userWithRole);
            }
        }


        //发送消息给用户
        Mess adminreply=new Mess();
        adminreply.setContent(reply);
        adminreply.setDate(new Date().getTime());
        adminreply.setType(SysCode.MESS_TYPE.NOTICE);
        messMapper.insertSelective(adminreply);

    }

    /**
     * 管理员
     *
     * @return
     */
    @Override
    @PageAnnotation
    public Page<User> findManager(Page<User>page) {
        page.setResult(userMapperCustom.findManager());
        return page;
    }
}
