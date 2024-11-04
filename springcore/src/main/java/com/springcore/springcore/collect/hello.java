package com.springcore.springcore.collect;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class hello {
	public hello(List list, Set set, Map map, Properties props) {
		super();
		this.list = list;
		this.set = set;
		this.map = map;
		this.props = props;
	}
	private List list;
	private Set set;
	private Map map;
	private Properties props;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Set getSet() {
		return set;
	}
	public void setSet(Set set) {
		this.set = set;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	public hello() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "hello [list=" + list + "\n set=" + set + "\n map=" + map + "\n props=" + props + "]";
	}
	
	
	
}
