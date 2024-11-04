package com.springcore.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springcore.jdbc.dao.Dao;
import com.springcore.jdbc.dao.DaoImple;

@Configuration
@ComponentScan(basePackages = "com.springcore.jdbc")
class jdbcconfig {
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/student");
		ds.setUsername("root");
		ds.setPassword("2815&JaiSiyaRam");
		
		return ds;
		
	}
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
	}
//	@Bean
//	public Dao getDao() {
//		DaoImple dao = new DaoImple();
//		dao.setJdbcTemplate(getJdbcTemplate());
//		return dao;
//	}

}
