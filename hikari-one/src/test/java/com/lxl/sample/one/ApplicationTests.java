package com.lxl.sample.one;


import com.lxl.sample.one.dao.UserDao;
import com.lxl.sample.one.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * Created by lxl on 16/10/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private UserDao userDao;
    @Autowired
    private DataSource ds;

    @Test
    @Rollback
    @Transactional
    public void findByName() throws Exception {
        userDao.insert("露馅了", 20);
//        User u = userDao.findByName("露馅了");
//        Assert.assertEquals(20, u.getAge().intValue());
        User user=userDao.findByName("露馅了");
        Assert.assertNotNull(user);
        System.err.println(user);
    }

}
