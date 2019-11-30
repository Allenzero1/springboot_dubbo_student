package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ClassMapper;
import com.qf.entity.Class;
import com.qf.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zqq
 * @version 1.0
 * @Date 2019/11/30
 */
@Service
public class ClassServiceImpl implements IClassService {

    @Autowired
    private  ClassMapper classMapper;

    @Override
    public List<Class> searchAll() {
        return classMapper.selectList(null);
    }

    @Override
    public void deleteById(int id) {
        classMapper.deleteById(id);
    }

    @Override
    public Class getClsById(int cid) {
        return classMapper.selectById(cid);
    }

    @Override
    public void updateById(Class classes) {
        classMapper.updateById(classes);
    }
}
