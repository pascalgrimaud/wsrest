package fr.pgr.wsrest.common.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.DomWriter;

import fr.pgr.wsrest.common.om.File;
import fr.pgr.wsrest.common.om.FileType;
import fr.pgr.wsrest.common.om.Note;
import fr.pgr.wsrest.common.om.User;
import fr.pgr.wsrest.common.util.HibernateProxyCleaner;

public class XMLUtils {
	public static Document marshal(Object object) {
		Document document = createDocument();

		try {
			HibernateProxyCleaner.cleanObject(object, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		XStream xstream = getXStream();
		try {
			xstream.marshal(object, new DomWriter(document));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return document;
	}

	public static Object unmarshal(String string) {
		return getXStream().fromXML(string);
	}

	private static XStream getXStream() {
		XStream xstream = new XStream(new DomDriver());
		xstream.setMode(XStream.ID_REFERENCES);
		xstream.autodetectAnnotations(true);
		xstream.alias("note", Note.class);
		xstream.alias("user", User.class);
		xstream.alias("file", File.class);
		xstream.alias("file_type", FileType.class);
		return xstream;
	}

	public static Document createDocument() {
		Document document;

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.newDocument();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

		return document;
	}
}
