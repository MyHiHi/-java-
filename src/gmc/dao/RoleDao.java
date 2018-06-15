package gmc.dao;

import java.util.List;

import gmc.entity.Manufacture;

public interface RoleDao {
	public int insert(Manufacture role) throws Exception;
	public List<Manufacture> findAll() throws Exception;
	public int update(Manufacture role) throws Exception;
	public int delete(int id) throws Exception;
	public Manufacture findRoleById(int id) throws Exception;
	public List<Manufacture> findRoleByName(String name) throws Exception;
	public List<Manufacture> findRoleByUserId(int userId) throws Exception;
}
