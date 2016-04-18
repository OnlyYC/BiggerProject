package com.liaoyb.persistence;

/**
 * Created by back on 2016/1/13.
 */
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@TransactionConfiguration(defaultRollback=false)
@ContextConfiguration(locations = {"/spring/applicationContext-dao.xml","/spring/applicationContext-service.xml"})
public class SpringTest extends AbstractTransactionalJUnit4SpringContextTests{

}