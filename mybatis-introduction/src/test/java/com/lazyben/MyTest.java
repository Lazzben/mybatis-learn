package com.lazyben;

import com.lazyben.mapper.AccountMapper;
import com.lazyben.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    @Test
    public void selectUserByIdTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Account account = sqlSession.selectOne("com.lazyben.mapper.AccountMapper.selectUserById", 2);
            System.out.println(account);
        }
    }

    @Test
    public void selectAllUsers() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            List<Account> account = sqlSession.selectList("com.lazyben.mapper.AccountMapper.selectAllUsers");
            System.out.println(account);
        }
    }

    @Test
    public void updateUser() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int updateCount = sqlSession.update("com.lazyben.mapper.AccountMapper.updateUser", 2);
            System.out.println(String.format("影响的的行数为 %d 行", updateCount));
            sqlSession.commit();
        }
    }

    @Test
    public void selectUserByIdUseMapperInterfaceTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AccountMapper mapper = sqlSession.getMapper(AccountMapper.class);
            Account account = mapper.selectUserById(2);
            System.out.println(account);
        }
    }

}
