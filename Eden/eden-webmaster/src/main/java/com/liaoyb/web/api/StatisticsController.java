package com.liaoyb.web.api;

import com.liaoyb.persistence.domain.dto.UserStatisticsInfo;
import com.liaoyb.persistence.service.StatisticsService;
import com.liaoyb.support.utils.MyResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * 数据分析
 * @author ybliao2
 */
@Controller
@RequestMapping("/api/statist")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/userStatisticsInfo")
    public void userStatisticsInfo(HttpServletResponse response){
        UserStatisticsInfo statisticsInfo=statisticsService.userStatistics();
        MyResultUtil.sendObject(response,statisticsInfo);

    }
}
