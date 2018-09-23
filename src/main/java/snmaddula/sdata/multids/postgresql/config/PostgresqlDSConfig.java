package snmaddula.sdata.multids.postgresql.config;

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
		entityManagerFactoryRef = "postgresqlEMF", 
		basePackages = { "narayan.sdata.multids.postgresql.repo" }
)
public class PostgresqlDSConfig {

	@Bean
	@ConfigurationProperties(prefix = "postgresql.datasource")
	public DataSource postgresqlDS() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean postgresqlEMF(EntityManagerFactoryBuilder builder,
			DataSource postgresqlDS) {
		return builder.dataSource(postgresqlDS).packages("narayan.sdata.multids.postgresql.entity")
				.persistenceUnit("postgresql").build();
	}

	@Bean
	public PlatformTransactionManager postgresqlTM(EntityManagerFactory postgresqlEMF) {
		return new JpaTransactionManager(postgresqlEMF);
	}
}
