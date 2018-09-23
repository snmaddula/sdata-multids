package snmaddula.sdata.multids.mysql.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

	@Bean
	@ConfigurationProperties(prefix = "mysql.datasource")
	public DataSource mysqlDS() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean mysqlEMF(EntityManagerFactoryBuilder builder,
			DataSource mysqlDS) {
		return builder.dataSource(mysqlDS).packages("narayan.sdata.multids.mysql.entity")
				.persistenceUnit("mysql").build();
	}

	@Bean
	public PlatformTransactionManager mysqlTM(EntityManagerFactory mysqlEMF) {
		return new JpaTransactionManager(mysqlEMF);
	}
}
