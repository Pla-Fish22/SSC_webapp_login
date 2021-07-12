package io.muzoo.ooc.webapp.basic.database;

import com.zaxxer.hikari.HikariDataSource;
import io.muzoo.ooc.webapp.basic.security.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManager {

    private static HikariDataSource dataSource;

    public DatabaseManager() {
        dataSource = new HikariDataSource();
        dataSource.setMaximumPoolSize(20);

        ConfigProperties configProperties = ConfigurationLoader.load();

        dataSource.setDriverClassName(configProperties.getDatabaseDriver());
        dataSource.setJdbcUrl(configProperties.getDatabaseConnectionUrl());
        dataSource.addDataSourceProperty("user", configProperties.getDatabaseUser());
        dataSource.addDataSourceProperty("password", configProperties.getDatabasePassword());
        dataSource.setAutoCommit(false);

    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
