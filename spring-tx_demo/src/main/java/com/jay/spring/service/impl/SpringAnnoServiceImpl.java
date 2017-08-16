package com.jay.spring.service.impl;

import com.jay.spring.service.SpringAnnoService;
import com.jay.spring.service.SpringTxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * Created by xiang.wei on 2017/8/11.
 */
@Service
public class SpringAnnoServiceImpl implements SpringAnnoService {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SpringTxService springTxService;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public int mysqlConnection() {
        return jdbcTemplate.queryForObject("select count(*) from user",Integer.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void rollbackForException() throws Exception {
        jdbcTemplate.update("INSERT  INTO USER (name,password) VALUES (?,?)","wei","11111112");
        if (springTxService.mysqlConnection()==1){
            throw new Exception();
        }
    }
    @Override
    public void cleanUp() {
        jdbcTemplate.update("DELETE FROM USER ");
    }


}
