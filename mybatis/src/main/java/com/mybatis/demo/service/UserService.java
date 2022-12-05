package com.mybatis.demo.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mybatis.demo.domain.User;
import com.mybatis.demo.mapper.UserMapper;

@Service
public class UserService {

	public void insertUser(User user)
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try
		{
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.insertUser(user);
			sqlSession.commit();
		} finally
		{
			sqlSession.close();
		}
	}

	public User getUserById(Integer userId)
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try
		{
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getUserById(userId);
		} finally
		{
			sqlSession.close();
		}
	}

	public List<User> getAllUsers()
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try
		{
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getAllUsers();
		} finally
		{
			sqlSession.close();
		}
	}

	public void updateUser(User user)
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try
		{
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.updateUser(user);
			sqlSession.commit();
		} finally
		{
			sqlSession.close();
		}
	}

	public ResponseEntity<Map<String, Boolean>> deleteUser(long id)
	{
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try
		{
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			userMapper.deleteUser((int) id);
			sqlSession.commit();
		} finally
		{
			sqlSession.close();
		}
		return null;
	}

	public ResponseEntity<User> updateUser(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
}
