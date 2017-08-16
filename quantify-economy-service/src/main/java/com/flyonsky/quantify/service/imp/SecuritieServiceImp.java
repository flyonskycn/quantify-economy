package com.flyonsky.quantify.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyonsky.quantify.dao.CustomizeMapper;
import com.flyonsky.quantify.dao.SecuritiesMapper;
import com.flyonsky.quantify.entity.Securities;
import com.flyonsky.quantify.entity.SecuritiesExample;
import com.flyonsky.quantify.model.GridData;
import com.flyonsky.quantify.model.QueryInfo;
import com.flyonsky.quantify.service.AbstractService;
import com.flyonsky.quantify.service.SecuritieService;

@Service
public class SecuritieServiceImp extends AbstractService implements SecuritieService{
	
	@Autowired
	private SecuritiesMapper secMapper;
	
	@Autowired
	private CustomizeMapper cusMapper;

	@Override
	public boolean createSecuritie(Securities sec) {
		int count = this.getSecMapper().insert(sec);
		return count > 0 ?true:false;
	}

	@Override
	public boolean modifySecuritie(Securities sec) {
		int count = this.getSecMapper().updateByPrimaryKeySelective(sec);
		return count > 0 ?true:false;
	}

	@Override
	public GridData<Securities> querySecurities(QueryInfo query) {
		GridData<Securities> grid=new GridData<Securities>();
		SecuritiesExample example=new SecuritiesExample();
		example.setOrderByClause(query.getOrderByClause());
		example.setCustomWhere(query.getQueryFilter());
		grid.setTotalRows(this.getSecMapper().countByExample(example));
		
		example.setLimitStart(query.getPage()*query.getPageSize());
		example.setLimitEnd(query.getPageSize());
		grid.setPageData(this.getSecMapper().selectByExample(example));
		return grid;
	}

	@Override
	public Securities querySecurities(int id) {
		return this.getSecMapper().selectByPrimaryKey(id);
	}

	@Override
	public Securities querySecurities(String code) {
		SecuritiesExample example = new SecuritiesExample();
		example.createCriteria().andCodeEqualTo(code);
		List<Securities> list = this.getSecMapper().selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<String> querySecurities() {
		List<String> data = this.getCusMapper().querySecurities();
		return data;
	}

	public SecuritiesMapper getSecMapper() {
		return secMapper;
	}

	public void setSecMapper(SecuritiesMapper secMapper) {
		this.secMapper = secMapper;
	}

	public CustomizeMapper getCusMapper() {
		return cusMapper;
	}

	public void setCusMapper(CustomizeMapper cusMapper) {
		this.cusMapper = cusMapper;
	}

}
