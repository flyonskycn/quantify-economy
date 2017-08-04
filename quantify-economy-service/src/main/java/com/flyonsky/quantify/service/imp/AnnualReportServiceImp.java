package com.flyonsky.quantify.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyonsky.quantify.dao.AnnualReportMapper;
import com.flyonsky.quantify.entity.AnnualReport;
import com.flyonsky.quantify.entity.AnnualReportExample;
import com.flyonsky.quantify.model.GridData;
import com.flyonsky.quantify.model.QueryInfo;
import com.flyonsky.quantify.service.AbstractService;
import com.flyonsky.quantify.service.AnnualReportService;

@Service
public class AnnualReportServiceImp extends AbstractService implements AnnualReportService{
	
	@Autowired
	private AnnualReportMapper annualMapper;

	@Override
	public AnnualReport queryAnnualReport(String code, int year) {
		AnnualReportExample ae = new AnnualReportExample();
		ae.createCriteria().andCodeEqualTo(code).andYearEqualTo(year);
		List<AnnualReport> list = this.getAnnualMapper().selectByExample(ae);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public GridData<AnnualReport> queryAnnualReport(QueryInfo query) {
		GridData<AnnualReport> grid=new GridData<AnnualReport>();
		AnnualReportExample example=new AnnualReportExample();
		example.setOrderByClause(query.getOrderByClause());
		example.setCustomWhere(query.getQueryFilter());
		grid.setTotalRows(this.getAnnualMapper().countByExample(example));
		
		example.setLimitStart(query.getPage()*query.getPageSize());
		example.setLimitEnd(query.getPageSize());
		grid.setPageData(this.getAnnualMapper().selectByExample(example));
		return grid;
	}

	@Override
	public boolean createAnnualReport(AnnualReport annualReport) {
		int count = this.getAnnualMapper().insert(annualReport);
		return count > 0?true:false;
	}

	@Override
	public boolean modifyAnnualReport(AnnualReport annualReport) {
		int count = this.getAnnualMapper().updateByPrimaryKey(annualReport);
		return count > 0?true:false;
	}

	public AnnualReportMapper getAnnualMapper() {
		return annualMapper;
	}

	public void setAnnualMapper(AnnualReportMapper annualMapper) {
		this.annualMapper = annualMapper;
	}

}
