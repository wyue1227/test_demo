package com.example.demo.parent;

import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class BaseBatch extends DefaultBatchConfiguration {

    @Override
    protected DataSource getDataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("/org/springframework/batch/core/schema-h2.sql")
                .generateUniqueName(true)
                .build();
    }

    @Override
    public PlatformTransactionManager getTransactionManager() {
        return new JdbcTransactionManager(getDataSource());
    }

}
