package fr.pgr.wsrest.common.om;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.pgr.wsrest.common.om.base.UserOMBase;

@Entity
@Table(name = "file")
public class File extends UserOMBase {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1512682183994023862L;

	/**
	 * File type of the file
	 */
	private FileType fileType;

	/**
	 * content of the file
	 */
	private byte[] content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_file_type")
	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	@Column(name = "content")
	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
}