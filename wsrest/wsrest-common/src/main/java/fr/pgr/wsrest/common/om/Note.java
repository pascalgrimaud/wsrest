package fr.pgr.wsrest.common.om;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.pgr.wsrest.common.om.base.UserOMBase;

@Entity
@Table(name = "note")
public class Note extends UserOMBase {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5655839966678453884L;
	/**
	 * content of the note
	 */
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
