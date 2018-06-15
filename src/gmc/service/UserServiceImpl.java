package gmc.service;



import gmc.dao.UserDao;
import gmc.dao.UserDaoImpl;
import gmc.entity.User;

public class UserServiceImpl implements UserService {

	UserDao dao = new UserDaoImpl();
	@Override
	public void save(User user) throws Exception {
		
		dao.insert(user);

	}

	@Override
	public User findUserByName(String name) throws Exception {
		
		return dao.findUserByName(name);
	}

	@Override
	public User findUserByUserId(int id) throws Exception {
		
		return dao.findUserByUserId(id);
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(user);
	}

}
