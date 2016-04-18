package com.liaoyb.persistence.Util;

import com.liaoyb.util.MailUtil;
import org.junit.Test;

import javax.mail.MessagingException;

/**
 * @author ybliao2
 */
public class TestMailUtil {
    @Test
    public void testSend() throws MessagingException {
        MailUtil.send("876714394@qq.com","测试","我的测试环境");
    }
}
