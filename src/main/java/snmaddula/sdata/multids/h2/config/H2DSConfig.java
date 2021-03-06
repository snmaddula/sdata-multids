package snmaddula.sdata.multids.h2.config;

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
		entityManagerFactoryRef = "h2EMF", 
		basePackages = { "narayan.sdata.multids.h2.repo" }
)
public class H2DSConfig {

	@ConfigurationProperties(prefix = "h2.datasource")
	public DataSource h2DS() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean h2EMF(EntityManagerFactoryBuilder builder,
			DataSource h2DS) {
		return builder.dataSource(h2DS).packages("narayan.sdata.multids.h2.entity")
				.persistenceUnit("h2").build();
	}

	@Bean
	public PlatformTransactionManager h2TM(EntityManagerFactory h2EMF) {
		return new JpaTransactionManager(h2EMF);
	}
}
