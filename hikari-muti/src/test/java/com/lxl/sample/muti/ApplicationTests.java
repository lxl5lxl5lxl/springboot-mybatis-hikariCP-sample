package com.lxl.sample.muti;

import com.lxl.sample.muti.entity.Teacher;
import com.lxl.sample.muti.dao.db1.UserDao;
import com.lxl.sample.muti.dao.db2.TeacherDao;
import com.lxl.sample.muti.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    private TeacherDao teacherDao;
    @Resource
    private DataSource ds1;
    @Resource
    private DataSource ds2;

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

    @Test
    @Rollback
    @Transactional(transactionManager = "ds2TransactionManager")
    public void findByName2() throws Exception {
        teacherDao.insert("露馅了",30);
//        User u = userDao.findByName("露馅了");
//        Assert.assertEquals(20, u.getAge().intValue());
        Teacher teacher=teacherDao.findByName("露馅了");
        Assert.assertNotNull(teacher);
        System.err.println(teacher);
    }
}
