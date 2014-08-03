package org.apache.helix.webapp.resources;

import java.util.concurrent.ConcurrentMap;

import org.restlet.Message;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.engine.header.Header;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;
import org.restlet.util.Series;
import org.restlet.resource.Resource;
import org.restlet.Response;

public class Headers extends ServerResource{
	 private static final String HEADERS_KEY = "org.restlet.http.headers";

	 public Headers()
	 {
		super();
	 }

	 public void addHeaders(org.restlet.Response  response) throws ResourceException
	 {
		 try{
		 	getMessageHeaders(response).add("Access-Control-Allow-Origin", "*");
			getMessageHeaders(response).add("Access-Control-Allow-Methods", "POST,OPTIONS,DELETE");
			getMessageHeaders(response).add("Access-Control-Allow-Headers", "Content-Type");
			getMessageHeaders(response).add("Access-Control-Allow-Credentials", "true");
			getMessageHeaders(response).add("Access-Control-Max-Age", "60");
		 }
		 catch(ResourceException ex)
		 {

		      ex.printStackTrace();
		      System.exit(0);
		 }
	 }



	@SuppressWarnings("unchecked")
	  static Series<Header> getMessageHeaders(Message message) {
	      ConcurrentMap<String, Object> attrs = message.getAttributes();
	      Series<Header> headers = (Series<Header>) attrs.get(HEADERS_KEY);
	      if (headers == null) {
	          headers = new Series<Header>(Header.class);
	          Series<Header> prev = (Series<Header>)
	              attrs.putIfAbsent(HEADERS_KEY, headers);
	          if (prev != null) { headers = prev; }
	      }
	      return headers;
	  }
}