package gmc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import gmc.common.JdbcUtil;
import gmc.entity.Brand;
import gmc.entity.Manufacture;

public class BrandDaoImpl implements BrandDao {

	@Override
	public int insert(Brand brand,int manuId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into gmc_brand(manu_id,en_name,cn_name,logo) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			//…Ë÷√≤Œ ˝
			
			ps.setInt(1,manuId );
			ps.setString(2, brand.getEnName());
			ps.setString(3, brand.getCnName());
			ps.setString(4, brand.getLogo());
			int i=ps.executeUpdate();
			return i;
		}finally {
			JdbcUtil.closeAll(conn, ps, null);
		}
	}

	@Override
	public int update(Brand brand) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "update gmc_brand set manu_id=?,en_name=?,cn_name=?,"+
			"logo=? where brand_id="+brand.getBrandId();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, brand.getManuId());
			ps.setString(2, brand.getEnName());
			ps.setString(3, brand.getCnName());
			ps.setString(4, brand.getLogo());
		//	ps.setInt(5,brand.getBrandId());
			System.out.println("ERERERERER"+ps);
			int i = ps.executeUpdate();
			return i;
		}finally {
			JdbcUtil.closeAll(conn, ps, rs);
		}
	}

	@Override
	public int delete(int brandId) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
		
			String sql = "delete from gmc_brand where brand_id="+brandId;
			ps = conn.prepareStatement(sql);
			int i = ps.executeUpdate();
			return i;
		}finally {
			JdbcUtil.closeAll(conn, ps, null);
		}
	}

	@Override
	public Brand findBrandById(int brandId) throws Exception {
		Brand brand=null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from gmc_brand where brand_id="+brandId;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			brand = new Brand();
			while (rs.next()) {
				
				brand.setBrandId(rs.getInt("brand_id"));
				brand.setManuId(rs.getInt("manu_id"));
				brand.setEnName(rs.getString("en_name"));
				brand.setCnName(rs.getString("cn_name"));
				
				brand.setLogo(rs.getString("logo"));	
			}
			return brand;
		}finally {
			JdbcUtil.closeAll(conn, ps, rs);
		}
	}

	@Override
	public List<Brand> findBrandByManuId(int manuId) throws Exception {
		List<Brand> brands = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from gmc_brand where manu_id="+manuId;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			brands = new ArrayList<Brand>();
			while (rs.next()) {
				Brand brand = new Brand();
				brand.setBrandId(rs.getInt("brand_id"));
				brand.setManuId(rs.getInt("manu_id"));
				brand.setEnName(rs.getString("en_name"));
				brand.setCnName(rs.getString("cn_name"));
				
				brand.setLogo(rs.getString("logo"));
				brands.add(brand);
			}
			return brands;
		}finally {
			JdbcUtil.closeAll(conn, ps, rs);
		}
	}

	@Override
	public Brand findBrandByBrandId(int brandId) throws Exception {
		Brand brand = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from gmc_brand where brand_id="+brandId;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			brand = new Brand();
			while (rs.next()) {
				
				brand.setBrandId(rs.getInt("brand_id"));
				brand.setManuId(rs.getInt("manu_id"));
				brand.setEnName(rs.getString("en_name"));
				brand.setCnName(rs.getString("cn_name"));
				
				brand.setLogo(rs.getString("logo"));
				
			}
			return brand;
		}finally {
			JdbcUtil.closeAll(conn, ps, rs);
		}
	
	}

	@Override
	public int deleteByManuId(int manuId) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConnection();
		
			String sql = "delete from gmc_brand where manu_id="+manuId;
			ps = conn.prepareStatement(sql);
			int i = ps.executeUpdate();
			return i;
		}finally {
			JdbcUtil.closeAll(conn, ps, null);
		}
	}

	@Override
	public List<Brand> findBrandByName(String  name) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Brand> brands = null;
		try {
			conn = JdbcUtil.getConnection();
			String sql = "select * from gmc_brand where en_name='"+name+"' or cn_name='"+name+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			brands = new ArrayList<Brand>();
			while (rs.next()) {
				Brand brand = new Brand();
				brand.setBrandId(rs.getInt("brand_id"));
				brand.setManuId(rs.getInt("manu_id"));
				brand.setEnName(rs.getString("en_name"));
				brand.setCnName(rs.getString("cn_name"));
				brand.setLogo(rs.getString("logo"));
				brands.add(brand);
			}
			return brands;
		}finally {
			JdbcUtil.closeAll(conn, ps, rs);
		}
	}
	


}
