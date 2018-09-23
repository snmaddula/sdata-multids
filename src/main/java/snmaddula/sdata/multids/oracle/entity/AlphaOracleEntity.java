package snmaddula.sdata.multids.oracle.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author snmaddula
 *
 */
@Entity
@Table(name = "ALPHA_ORACLE")
public class AlphaOracleEntity {

	@Id
	private Long id;

	private String name;

	private Date dob;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
