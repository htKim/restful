package com.sec.ax.restful.utils;

import java.io.IOException;
import java.io.Reader;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sec.ax.restful.pojo.Note;

/**
 *
 * @author heesik.jeon
 *
 */

public class FormatHelperTest extends TestCase {

	private Logger logger = Logger.getLogger(this.getClass());
	
	public FormatHelperTest() {
		logger.setLevel(Level.DEBUG);
	}
	
	public void testPrintPretty() throws IOException {
		
		Reader reader = null;
		
		try {

			reader = StreamHelper.getStream("/com/sec/ax/restful/utils/list.json");
			
			String text = IOUtils.toString(reader);
			
			Note note = new Gson().fromJson(text, Note.class);
			
			logger.debug(text);
			logger.debug(FormatHelper.printPretty(note));
			
		} catch (Exception e) {
			fail(e.toString());
		} finally {
			reader.close();
		}

	}

}
