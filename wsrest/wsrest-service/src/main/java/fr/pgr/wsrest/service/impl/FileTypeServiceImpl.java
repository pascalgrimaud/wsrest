package fr.pgr.wsrest.service.impl;

import fr.pgr.wsrest.common.om.FileType;
import fr.pgr.wsrest.persistence.dao.FileTypeDao;
import fr.pgr.wsrest.service.FileTypeService;
import fr.pgr.wsrest.service.base.impl.ServiceBaseImpl;

public class FileTypeServiceImpl extends ServiceBaseImpl<FileType> implements
		FileTypeService {

	/**
	 * dao
	 */
	private FileTypeDao dao;

	/**
	 * 
	 * @return the dao
	 */
	public FileTypeDao getDao() {
		return dao;
	}

	/**
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(FileTypeDao dao) {
		this.dao = dao;
	}
}