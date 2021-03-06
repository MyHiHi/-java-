package gmc.dao;

import java.util.List;

import gmc.entity.Brand;



public interface BrandDao {
	public int insert(Brand brand,int manuId) throws Exception;
	public int update(Brand brand) throws Exception;
	public int delete(int brandId) throws Exception;
	public int deleteByManuId(int manuId) throws Exception;
	public Brand findBrandById(int brandId) throws Exception;
	public List<Brand> findBrandByManuId(int manuId) throws Exception;
	public List<Brand> findBrandByName(String name) throws Exception;
	public Brand findBrandByBrandId(int brandId) throws Exception;
}
