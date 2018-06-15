package gmc.service;

import java.util.List;

import gmc.dao.BrandDao;
import gmc.dao.BrandDaoImpl;
import gmc.entity.Brand;

public class BrandServiceImpl implements BrandService {

	BrandDao brand = new BrandDaoImpl();
	@Override
	public int insert(Brand brand, int manuId) throws Exception {
		BrandDao brand2 = new BrandDaoImpl();
		return brand2.insert(brand,manuId) ;
	}

	@Override
	public int update(Brand brand) throws Exception {
		BrandDao brand2 = new BrandDaoImpl();
		return brand2.update(brand);
	}

	@Override
	public int delete(int brandId) throws Exception {
		
		return brand.delete(brandId);
	}

	@Override
	public Brand findBrandById(int brandId) throws Exception {
		
		return brand.findBrandById(brandId);
	}

	@Override
	public List<Brand> findBrandByManuId(int manuId) throws Exception {
		return brand.findBrandByManuId(manuId);
	}

	@Override
	public Brand findBrandByBrandId(int brandId) throws Exception {
		
		return brand.findBrandByBrandId(brandId);
	}

	@Override
	public int deleteByManuId(int manuId) throws Exception {
		
		return brand.deleteByManuId(manuId);
	}

	@Override
	public List<Brand> findBrandByName(String name) throws Exception {
		
		return brand.findBrandByName(name);
	}

}
