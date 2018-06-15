package gmc.service;

import gmc.entity.User;

public interface UserService {
	public void save(User user) throws Exception;
	public User findUserByName(String name) throws Exception;
	public User findUserByUserId(int id) throws Exception;
	public int update(User user) throws Exception;
}
