package com.liaoyb.persistence.serviceImpl;

import com.liaoyb.base.SysCode;
import com.liaoyb.base.enums.CollectTypeEnum;
import com.liaoyb.base.support.exception.CustomException;
import com.liaoyb.persistence.dao.base.CollectMapper;
import com.liaoyb.persistence.dao.custom.CollectMapperCustom;
import com.liaoyb.persistence.domain.dto.Response;
import com.liaoyb.persistence.domain.vo.base.Collect;
import com.liaoyb.persistence.service.CollectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ybliao2
 */
@Service
public class CollectServiceImpl implements CollectService {

    private static Logger logger= LoggerFactory.getLogger(CollectService.class);
    @Autowired
    private CollectMapper collectMapper;

    @Autowired
    private CollectMapperCustom collectMapperCustom;
    /**
     * 添加到收藏
     *
     * @param collect
     * @return
     */
    @Override
    @Transactional
    public Response andToCollect(Collect collect) throws CustomException {
        if(collect==null||collect.getCollectType()==null){
            throw new CustomException("非法参数");
        }
        if(isExistTheCollect(collect)){
            return returnMessByCollectType(collect.getCollectType(),false);
        }

        try {
            addCollect(collect);
        }catch (Exception e){
            logger.error("收藏异常",e);
            return new Response().failure("收藏失败");
        }

        return returnMessByCollectType(collect.getCollectType(),true);
    }

    /**
     * 收藏
     * @param collect
     */
    private void addCollect(Collect collect){
        collectMapper.insertSelective(collect);
    }

    /**
     * 用于返回收藏信息
     * @param collectType
     * @param isSuccess 是否收藏成功
     * @return
     */
    private Response returnMessByCollectType(Long collectType,boolean isSuccess){

        switch (collectType.intValue()){
            case 1:
                if(isSuccess){
                    return new Response().success("歌单收藏成功",null);
                }
                return new Response().failure("此歌单已收藏过了");
            case 2:
                if(isSuccess){
                    return new Response().success("专辑收藏成功",null);
                }
                return new Response().failure("此专辑已收藏过了");
            case 3:
                if(isSuccess){
                    return new Response().success("歌手关注成功",null);
                }
                return new Response().failure("此歌手已关注过了");
            case 4:
                if(isSuccess){
                    return new Response().success("MV收藏成功",null);
                }
                return new Response().failure("此MV已收藏过了");
            case 5:
                if(isSuccess){
                    return new Response().success("用户关注成功",null);
                }
                return new Response().failure("此用户你已经关注过了");
            default:
                if(isSuccess){
                    return new Response().success("收藏成功",null);
                }
                return new Response().failure("收藏已存在");
        }
    }

    /**
     * 收藏是否已存在
     *
     * @param collect
     * @return
     */
    @Override
    public boolean isExistTheCollect(Collect collect) {
        List<Collect>collects=collectMapperCustom.findCollect(collect);
        if(collects.size()>0){
            return true;
        }
        return false;
    }

}
