package gmc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gmc.common.JdbcUtil;
import gmc.entity.Manufacture;

public class RoleDaoImpl implements RoleDao {

	@Override
	public int insert(Manufacture role) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into gmc_manuf(user_id,en_name,cn_name,certi_type,status) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			//…Ë÷√≤Œ ˝
			ps.setInt(1, role.getUserId());
			ps.setString(2, role.getEnName());
			ps.setString(3, role.getCnName());
			ps.setString(4, role.getCertiType());
			ps.setString(5, role.getStatus());
			int i=ps.executeUpdate();
			return i;
		}finally {
			JdbcUtil.closeAll(conn, ps, null);
		}
	}

	@Override
	public List<Manufacture> findAll() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Manufacture> roles = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from gmc_manuf";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			roles = new ArrayList<Manufacture>();
			while (rs.next()) {
				Manufacture role = new Manufacture();
				role.setManuId(rs.getInt("manu_id"));
				role.setEnName(rs.getString("en_name"));
				role.setCnName(rs.getString("cn_name"));
				role.setCertiType(rs.getString("certi_type"));
			
				role.setStatus(rs.getString("status"));
				roles.add(role);
			}
			return roles;
		}finally {
			JdbcUtil.closeAll(conn, ps, rs);
		}
		
	}

	@Override
	public int update(Manufacture role) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update gmc_manuf set  en_name=?,cn_name=?,certi_type=?,"+
			"status=? where manu_id="+role.getManuId();
			ps = conn.prepareStatement(sql);
		
			ps.setString(1, role.getEnName());
			ps.setString(2, role.getCnName());
			ps.setString(3, role.getCertiType());
		
			ps.setString(4,role.getStatus());
			
			int i = ps.executeUpdate();
			return i;
		}finally {
			JdbcUtil.closeAll(conn, ps, rs);
		}
		
	}

	@Override
	public int delete(int id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
		
			String sql = "delete from gmc_manuf where manu_id="+id;
			ps = conn.prepareStatement(sql);
			int i = ps.executeUpdate();
			return i;
		}finally {
			JdbcUtil.closeAll(conn, ps, null);
		}
	}

	@Override
	public Manufacture findRoleById(int id) throws Exception {
		Manufacture role=null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from gmc_manuf where manu_id="+id;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			role = new Manufacture();
			while (rs.next()) {
				
				role.setManuId(rs.getInt("manu_id"));
				role.setEnName(rs.getString("en_name"));
				role.setCnName(rs.getString("cn_name"));
				role.setCertiType(rs.getString("certi_type"));
				
				role.setStatus(rs.getString("status"));	
			}
			return role;
		}finally {
			JdbcUtil.closeAll(conn, ps, rs);
		}
	}

	@Override
	public  List<Manufacture> findRoleByName(String name) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Manufacture> roles = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from gmc_manuf where en_name='"+name+"' or cn_name='"+name+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			roles = new ArrayList<Manufacture>();
			while (rs.next()) {
				Manufacture role = new Manufacture();
				role.setManuId(rs.getInt("manu_id"));
				role.setEnName(rs.getString("en_name"));
				role.setCnName(rs.getString("cn_name"));
				role.setCertiType(rs.getString("certi_type"));
				role.setStatus(rs.getString("status"));
				roles.add(role);
			}
			return roles;
		}finally {
			JdbcUtil.closeAll(conn, ps, rs);
		}
		
	}

	@Override
	public List<Manufacture> findRoleByUserId(int userId) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Manufacture> roles = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from gmc_manuf where user_id="+userId;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			roles = new ArrayList<Manufacture>();
			while (rs.next()) {
				Manufacture role = new Manufacture();
				role.setManuId(rs.getInt("manu_id"));
				role.setUserId(userId);
				role.setEnName(rs.getString("en_name"));
				role.setCnName(rs.getString("cn_name"));
				role.setCertiType(rs.getString("certi_type"));
				role.setStatus(rs.getString("status"));
				roles.add(role);
			}
			return roles;
		}finally {
			JdbcUtil.closeAll(conn, ps, rs);
		}
		
	}
}
