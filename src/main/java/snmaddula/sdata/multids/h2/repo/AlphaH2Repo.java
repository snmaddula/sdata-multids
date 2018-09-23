package snmaddula.sdata.multids.h2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import snmaddula.sdata.multids.h2.entity.AlphaH2Entity;

@Repository
@Transactional(transactionManager = "h2TM")
public interface AlphaH2Repo extends JpaRepository<AlphaH2Entity, Long> {

}
