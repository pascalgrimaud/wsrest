package fr.pgr.wsrest.webservice.impl;

import java.io.IOException;

import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.resource.DomRepresentation;
import org.restlet.resource.Representation;
import org.restlet.resource.Resource;
import org.restlet.resource.ResourceException;
import org.restlet.resource.Variant;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.pgr.wsrest.common.om.Note;
import fr.pgr.wsrest.common.xml.XMLUtils;
import fr.pgr.wsrest.service.NoteService;
import fr.pgr.wsrest.webservice.security.SecurityUtils;

public class NoteWs extends Resource {

	private NoteService noteService;
	private Note note;
	private String noteId;

	@Override
	public boolean allowDelete() {
		return true;
	}

	@Override
	public boolean allowGet() {
		return true;
	}

	@Override
	public boolean allowPost() {
		return true;
	}

	@Override
	public boolean allowPut() {
		return true;
	}

	public NoteWs() {
		this.getVariants().add(new Variant(MediaType.TEXT_XML));
	}

	private void parseRequest() {
		noteId = (String) getRequest().getAttributes().get("id");
		if (noteId != null) {
			try {
				note = noteService.load(Integer.valueOf(noteId));
			} catch (Exception e) {
				e.printStackTrace();
				getResponse().setStatus(Status.SERVER_ERROR_INTERNAL);
			}
		}
	}

	public Representation represent(Variant variant) {
		parseRequest();
		Representation resource = null;
		if (note == null) {
			try {
				if (noteId == null) {
					return representError("Provide an ID !");
				} else {
					return representError("Note not found !");
				}
			} catch (ResourceException e) {
				e.printStackTrace();
			}
		} else {
			try {
				resource = new DomRepresentation(MediaType.TEXT_XML);
				// User user = (User)
				// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				((DomRepresentation) resource).setDocument(XMLUtils
						.marshal(note));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return resource;
	}

	@Override
	public void acceptRepresentation(Representation entity)
			throws ResourceException {
		parseRequest();
		Form form = new Form(entity);
		String content = form.getFirstValue("content");
		try {
			note.setContent(content);
			noteService.save(note);
			getResponse().setStatus(Status.SUCCESS_OK);
		} catch (Exception e) {
			e.printStackTrace();
			getResponse().setStatus(Status.SERVER_ERROR_INTERNAL);
		}

	}

	@Override
	public void storeRepresentation(Representation entity)
			throws ResourceException {
		parseRequest();
		Form form = new Form(entity);
		String content = form.getFirstValue("content");
		try {
			Note note = new Note();
			note.setContent(content);
			note.setUser(SecurityUtils.getConnectedUser());
			noteService.save(note);
			getResponse().setStatus(Status.SUCCESS_OK);
		} catch (Exception e) {
			e.printStackTrace();
			getResponse().setStatus(Status.SERVER_ERROR_INTERNAL);
		}

	}

	@Override
	public void removeRepresentations() throws ResourceException {
		parseRequest();
		if (note == null) {
			if (noteId == null) {
				getResponse().setEntity(representError("Provide an ID !"));
			} else {
				getResponse().setEntity(representError("Note note found"));
			}
			getResponse().setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
			return;
		} else {
			try {
				noteService.delete(note);
				getResponse().setStatus(Status.SUCCESS_OK);
			} catch (Exception e) {
				getResponse().setStatus(Status.SERVER_ERROR_INTERNAL);
				e.printStackTrace();
			}
		}
	}

	private Representation representError(String msg) throws ResourceException {
		Representation result = null;
		try {
			result = new DomRepresentation(MediaType.TEXT_XML);
			Document doc = ((DomRepresentation) result).getDocument();
			Element root = doc.createElement("error");
			root.setTextContent(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
	}
}