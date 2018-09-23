package snmaddula.sdata.multids.oracle.config;

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
		entityManagerFactoryRef = "oracleEMF", 
		basePackages = { "narayan.sdata.multids.oracle.repo" }
)
public class OracleDSConfig {

	@Bean
	@ConfigurationProperties(prefix = "oracle.datasource")
	public DataSource oracleDS() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean oracleEMF(EntityManagerFactoryBuilder builder,
			DataSource oracleDS) {
		return builder.dataSource(oracleDS).packages("narayan.sdata.multids.oracle.entity")
				.persistenceUnit("oracle").build();
	}

	@Bean
	public PlatformTransactionManager oracleTM(EntityManagerFactory oracleEMF) {
		return new JpaTransactionManager(oracleEMF);
	}
}
