package fr.pgr.wsrest.common.om.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class OMBase implements IOM {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6934243104895561562L;
	private Integer identifier;

	@Id
	@GeneratedValue
	@Column(name = "identifier", unique = true, nullable = false)
	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}
}
