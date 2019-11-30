package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.StuMapper;
import com.qf.entity.Class;
import com.qf.entity.Student;
import com.qf.service.IClassService;
import com.qf.service.IStuService;
import com.qf.stu_classes.StuClassesApplication1;
import org.apache.zookeeper.data.Id;
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

    @Reference
    IClassService classService;
    @Override
    public List<Student> searchAll() {
        List<Student> students =stuMapper.selectList(null);
        for (Student s:students){
            //当前学生所属班级
            int cid = s.getCid();
            //获得班级信息
            Class cls = classService.getClsById(cid);
            s.setCls(cls);

        }
        return students;
    }

    @Override
    public void deleteById(int id) {
        stuMapper.deleteById(id);
    }

    @Override
    public Student getStuById(int id) {

        return stuMapper.selectById(id);
    }

    @Override
    public void updateById(Student student) {
        stuMapper.updateById(student);
    }

}
