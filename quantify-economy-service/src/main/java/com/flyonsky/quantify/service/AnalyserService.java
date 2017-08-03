package com.flyonsky.quantify.service;

import com.flyonsky.quantify.model.YearOnYearData;

public interface AnalyserService {

	/**
	 * 查询分析数据
	 * @param code 股票代码
	 * @return
	 */
	YearOnYearData query(String code);
}