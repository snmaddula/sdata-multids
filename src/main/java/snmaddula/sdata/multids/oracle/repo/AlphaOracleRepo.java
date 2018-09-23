package snmaddula.sdata.multids.oracle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import snmaddula.sdata.multids.oracle.entity.AlphaOracleEntity;

@Repository
@Transactional(transactionManager = "oracleTM")
public interface AlphaOracleRepo extends JpaRepository<AlphaOracleEntity, Long> {

}
