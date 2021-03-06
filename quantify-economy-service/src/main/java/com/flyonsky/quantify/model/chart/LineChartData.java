package com.flyonsky.quantify.model.chart;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 单个曲线图数据
 * @author luowg
 *
 */
public class LineChartData {
	
	// 曲线名称
	private String lineName;

	// x 轴数据
	private SortedSet<Number> xdata = new TreeSet<Number>();
	
	// y 轴数据
	private List<List<Object>> ydata = new ArrayList<List<Object>>();
	
	// y 描述
	private String yunit;

	public SortedSet<Number> getXdata() {
		return xdata;
	}

	public void setXdata(SortedSet<Number> xdata) {
		this.xdata = xdata;
	}
	
	/**
	 * 添加图表数据
	 * @param x
	 * @param y
	 */
	public void addData(Number x,Number y) {
		this.xdata.add(x);
		List<Object> list = new ArrayList<Object>();
		list.add(x.toString());
		list.add(y);
		this.ydata.add(list);
	}

	public List<List<Object>> getYdata() {
		return ydata;
	}

	public void setYdata(List<List<Object>> ydata) {
		this.ydata = ydata;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getYunit() {
		return yunit;
	}

	public void setYunit(String yunit) {
		this.yunit = yunit;
	}
	
}
