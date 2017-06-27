package com.mashen.sm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashen.sm.dao.IUserDao;
import com.mashen.sm.model.User;

@Transactional(rollbackFor = java.lang.Exception.class)
@Service(value = "userServiceImp")
public class UserServiceImp implements IUserService {
	// 让他自己去识别
	@Resource
	private IUserDao userDao;

	public void add() {
		User user = new User();
		user.setId(10086);
		user.setName("小q");
		user.setPassword("123");
		userDao.add(user);
	}

	public void add2(int i) throws Exception {
		User user = new User();
		user.setId(70);
		user.setName("小白");
		user.setPassword("1235");
		userDao.add(user);
		if (i == 1) {
			throw new Exception("事务出错了");
		}
		User user1 = new User();
		user1.setId(110);
		user1.setName("小绿");
		user1.setPassword("1231");
		userDao.add(user1);
	}

}
