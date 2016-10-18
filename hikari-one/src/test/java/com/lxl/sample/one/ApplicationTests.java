package com.lxl.sample.one;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lxl.sample.one.dao.UserDao;
import com.lxl.sample.one.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by lxl on 16/10/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    @Rollback
    @Transactional
    public void findByName() throws Exception {
        for (int i = 0; i <33 ; i++) {
            userDao.insert("露馅了", i);
        }
        PageHelper.startPage(1, 10);
//        PageHelper.orderBy("age desc");
        List<User> list=userDao.findAgeByName("露馅了");
        Assert.assertEquals(10,list.size());
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println(((Page)list).getTotal());
    }

}
