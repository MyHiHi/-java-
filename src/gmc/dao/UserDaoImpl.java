package gmc.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gmc.common.JdbcUtil;
import gmc.common.MD5;
import gmc.entity.Manufacture;
import gmc.entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public void insert(User user) throws Exception {
		//连接数据库，执行插入
				Connection conn = null;
				PreparedStatement ps = null;
				try {
					conn = JdbcUtil.getConnection();
					String sql = "insert into gmc_user(user_name,password,nick_name,email,status) values(?,?,?,?,?)";
					ps = conn.prepareStatement(sql);
					//设置参数
					ps.setString(1, user.getUserName());
					ps.setString(2, MD5.md5(user.getPassword()));
					ps.setString(3, user.getNickName());
					ps.setString(4, user.getEmail());
					ps.setString(5, user.getStatus());
					ps.executeUpdate();
				}finally {
					JdbcUtil.closeAll(conn, ps, null);
				}
		
	}

	@Override
	public User findUserByName(String name) throws Exception {
		
		//连接数据库，执行插入
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		User user = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from gmc_user where user_name='"+name+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setNickName(rs.getString("nick_name"));
				user.setEmail(rs.getString("email"));
				user.setStatus("status");
			}
		
			return user;
		}finally {
			JdbcUtil.closeAll(conn, ps, null);
		}

	}

	@Override
	public User findUserByUserId(int id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from gmc_user where user_id="+id;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			user = new User();
			while (rs.next()) {
				
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setNickName(rs.getString("nick_name"));
				user.setEmail(rs.getString("email"));
				user.setStatus(rs.getString("status"));
			}
			return user;
		}finally {
			JdbcUtil.closeAll(conn, ps, rs);
		}
	}

	@Override
	public int update(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update gmc_user set  user_name=?,password=?,nick_name=?,"+
			"email=?,status=? where user_id="+user.getUserId();
			ps = conn.prepareStatement(sql);
		
			ps.setString(1, user.getUserName());
			if (user.getPassword().length()==32) {
				ps.setString(2,user.getPassword());
			}
			else ps.setString(2, MD5.md5(user.getPassword()));
			ps.setString(3, user.getNickName());
		
			ps.setString(4,user.getEmail());
			ps.setString(5,user.getStatus());
			
			int i = ps.executeUpdate();
			return i;
		}finally {
			JdbcUtil.closeAll(conn, ps, rs);
		}
		
	}

}
