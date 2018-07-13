package com.briup.app02.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Student;
import com.briup.app02.dao.StudentMapper;
import com.briup.app02.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentMapper studentMapper;
	
	
	@Override
	public List<Student> findAll() throws Exception {
		//调用studentMapper查询所有学生
		List<Student> list = studentMapper.findAll();
		
		return list;
	}


	@Override
	public Student findById(long id) throws Exception {
		return studentMapper.findById(id);
	}
	@Override
	public void deleteById(long id) throws Exception {
		studentMapper.deleteById(id);
	}
	


	@Override
	public void update(Student student) throws Exception {
		Student newStudent =studentMapper.findById(student.getId());
		if(newStudent!=null){
			studentMapper.update(student);
		}
		else{
			throw new Exception("要更新的学生不存在！");
		}
	}


	@Override
	public void save(Student student) throws Exception {
		// TODO Auto-generated method stub
		studentMapper.save(student);
	}

}













