package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties
@PropertySource("classpath:app.properties")
public class PropConfig {
	@Value("${ipaddress}")
	public String ipaddress;
	
	@Value("${databaseUserid}")
	public String dbUserid;
	
	public String getDbUserid() {
		return dbUserid;
	}
	public void setDbUserid(String dbUserid) {
		this.dbUserid = dbUserid;
	}
	public String getDbPwd() {
		return dbPwd;
	}
	public void setDbPwd(String dbPwd) {
		this.dbPwd = dbPwd;
	}
	@Value("${databasePassword}")
	public String dbPwd;
	
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
}
