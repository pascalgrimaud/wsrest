package fr.pgr.wsrest.common.om;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.pgr.wsrest.common.om.base.OMBase;

@Entity
@Table(name = "file_type")
public class FileType extends OMBase {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -875476332791289538L;
	/**
	 * Label of the type
	 */
	private String label;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
