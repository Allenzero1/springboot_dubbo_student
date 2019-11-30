package com.qf.service;

import com.qf.entity.Class;
import com.qf.entity.Student;

import java.util.List;

/**
 * @author zqq
 * @version 1.0
 * @Date 2019/11/30
 */
public interface IClassService {
    List<Class> searchAll();

    void deleteById(int id);

    Class getClsById(int cid);

    void updateById(Class classes);

}
