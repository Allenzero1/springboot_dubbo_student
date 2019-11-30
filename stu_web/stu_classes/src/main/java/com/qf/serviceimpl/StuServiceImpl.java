package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.StuMapper;
import com.qf.entity.Student;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zqq
 * @version 1.0
 * @Date 2019/11/30
 */
@Service
public class StuServiceImpl implements IStuService {

    @Autowired
    private StuMapper stuMapper;
    @Override
    public List<Student> searchAll() {
        return stuMapper.selectList(null);
    }
}
