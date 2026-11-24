package com.minecraft.core.backend.mariadb.connection;

import java.sql.Connection;
import java.sql.SQLException;

import com.minecraft.core.backend.mariadb.MariaConfig;
import org.mariadb.jdbc.MariaDbPoolDataSource;

public final class MariaConnection implements AutoCloseable {

    private final MariaDbPoolDataSource source;

    public MariaConnection(MariaConfig config) throws SQLException {
        source = new MariaDbPoolDataSource();
        source.setUrl(config.url());
        source.setUser(config.getUsername());
        source.setPassword(config.getPassword());
    }

    public Connection getConnection() throws SQLException {
        return source.getConnection();
    }

    @Override
    public void close() {
        source.close();
    }
}
