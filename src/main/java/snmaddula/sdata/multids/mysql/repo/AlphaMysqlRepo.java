package snmaddula.sdata.multids.mysql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import snmaddula.sdata.multids.mysql.entity.AlphaMysqlEntity;

@Repository
@Transactional(transactionManager = "mysqlTM")
public interface AlphaMysqlRepo extends JpaRepository<AlphaMysqlEntity, Long> {

}
