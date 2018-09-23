package snmaddula.sdata.multids.postgresql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import snmaddula.sdata.multids.postgresql.entity.AlphaPostgresqlEntity;

@Repository
@Transactional(transactionManager = "postgresqlTM")
public interface AlphaPostgresqlRepo extends JpaRepository<AlphaPostgresqlEntity, Long> {

}
