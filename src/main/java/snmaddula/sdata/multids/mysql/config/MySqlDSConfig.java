package snmaddula.sdata.multids.mysql.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author snmaddula
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "mysqlEMF", 
		basePackages = { "narayan.sdata.multids.mysql.repo" }
)
public class MySqlDSConfig {

	@Bean(name = "mysqlDS")
	@ConfigurationProperties(prefix = "mysql.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "mysqlEMF")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			DataSource mysqlDS) {
		return builder.dataSource(mysqlDS).packages("narayan.sdata.multids.mysql.entity")
				.persistenceUnit("mysql").build();
	}

	@Primary
	@Bean(name = "mysqlTM")
	public PlatformTransactionManager transactionManager(EntityManagerFactory mysqlEMF) {
		return new JpaTransactionManager(mysqlEMF);
	}
}
