package com.stupin.config;

import dev.miku.r2dbc.mysql.MySqlConnection;
import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;

@Configuration
public class R2DBCConfig {

	@Value("${spring.r2dbc.url}")
	private String url;

	@Value("${spring.r2dbc.username}")
	private String username;

	@Value("${spring.r2dbc.password}")
	private String password;

	@Bean
	public MySqlConnectionFactory mysqlConnectionFactory() {
		return MySqlConnectionFactory.from(MySqlConnectionConfiguration.builder()
			.port(getPortFromUrl())
			.host(getHostFromUrl())
			.database(getDatabaseNameFromUrl())
			.username(username)
			.password(password)
			.build());
	}

	@Bean
	public ReactiveTransactionManager transactionManager(MySqlConnectionFactory mysqlConnectionFactory) {
		return new R2dbcTransactionManager(mysqlConnectionFactory);
	}

	@Bean
	public MySqlConnection mysqlConnection(MySqlConnectionFactory mysqlConnectionFactory) {
		return mysqlConnectionFactory.create().block();
	}

	private Integer getPortFromUrl() {
		final String[] urlParts = url.split("//");
		final String[] hostParts = urlParts[1].split(":");
		final String[] port = hostParts[1].split("/");
		final String port2 = port[0];
		return Integer.valueOf(port2);
	}

	private String getHostFromUrl() {
		final String[] urlParts = url.split("//");
		return urlParts[1].split(":")[0];
	}

	private String getDatabaseNameFromUrl() {
		final String[] urlParts = url.split("/");
		return urlParts[urlParts.length - 1];
	}
}
