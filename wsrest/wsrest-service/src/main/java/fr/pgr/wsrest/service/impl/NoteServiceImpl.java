package fr.pgr.wsrest.service.impl;

import fr.pgr.wsrest.common.om.Note;
import fr.pgr.wsrest.persistence.dao.NoteDao;
import fr.pgr.wsrest.service.NoteService;
import fr.pgr.wsrest.service.base.impl.ServiceBaseImpl;

public class NoteServiceImpl extends ServiceBaseImpl<Note> implements
		NoteService {

	/**
	 * dao
	 */
	private NoteDao dao;

	/**
	 * 
	 * @return the dao
	 */
	public NoteDao getDao() {
		return dao;
	}

	/**
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setDao(NoteDao dao) {
		this.dao = dao;
	}

}