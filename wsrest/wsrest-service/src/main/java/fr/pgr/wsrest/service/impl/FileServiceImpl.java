package fr.pgr.wsrest.service.impl;

import fr.pgr.wsrest.common.om.File;
import fr.pgr.wsrest.persistence.dao.FileDao;
import fr.pgr.wsrest.service.FileService;
import fr.pgr.wsrest.service.base.impl.ServiceBaseImpl;

public class FileServiceImpl extends ServiceBaseImpl<File> implements
		FileService {

	/**
	 * dao
	 */
	private FileDao dao;

	/**
	 * 
	 * @return the dao
	 */
	public FileDao getDao() {
		return dao;
	}

	/**
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(FileDao dao) {
		this.dao = dao;
	}
}