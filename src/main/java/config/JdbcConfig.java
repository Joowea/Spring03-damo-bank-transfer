package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.user}")
    private String name;

    @Value("${jdbc.psd}")
    private String psd;


    @Bean(name = "runner")
    @Scope(value = "prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource cds = new ComboPooledDataSource();
        try {
            cds.setDriverClass(driver);
            cds.setJdbcUrl(url);
            cds.setUser(name);
            cds.setPassword(psd);
            return cds;
        } catch (PropertyVetoException e) {
            throw new RuntimeException();
        }
    }
}
