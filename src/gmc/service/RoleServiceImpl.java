package gmc.service;

import java.util.List;

import gmc.dao.BrandDao;
import gmc.dao.BrandDaoImpl;
import gmc.dao.RoleDao;
import gmc.dao.RoleDaoImpl;

import gmc.entity.Manufacture;

public class RoleServiceImpl implements RoleService {
	

	
	RoleDao manu = new RoleDaoImpl();
	@Override
	public int save(Manufacture role) throws Exception {
		
		return manu.insert(role);
	}

	@Override
	public List<Manufacture> findAll() throws Exception {
		List<Manufacture> manus = manu.findAll();
		return manus;
	}

	@Override
	public int update(Manufacture role) throws Exception {
		
		return manu.update(role);
	}

	@Override
	public int delete(int id) throws Exception {
		return manu.delete(id);
	}

	public Manufacture findRoleById(int id) throws Exception {
		return manu.findRoleById(id);
	}

	@Override
	public List<Manufacture> findRoleByName(String name) throws Exception {
		List<Manufacture> manus = manu.findRoleByName(name);
		return manus;
	}

	@Override
	public List<Manufacture> findRoleByUserId(int userId) throws Exception {
		return manu.findRoleByUserId(userId);
	}

}
