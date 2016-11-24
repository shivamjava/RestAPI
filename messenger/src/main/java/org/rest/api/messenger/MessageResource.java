/**
 * 
 */
package org.rest.api.messenger;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rest.api.messenger.model.Message;
import org.rest.api.messenger.service.MessageService;

/**
 * @author sharm073
 *
 */
@Path ("messages")
public class MessageResource {
	
	private MessageService service = new MessageService();
	
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return service.getAllMessages();
	}
	
	@GET
	@Path("{messageId}")
	@Produces (MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") final long messageId){
		return service.getMessage(messageId);
	}

	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Message addMessage(final Message message){
		return service.addMessage(message); 
	}
	
	@PUT
	@Path("{messageId}")
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") final long messageId, final Message message){
		message.setId(messageId);
		System.out.println(message.getAuthor());
		return service.updateMessage(message); 
	}
}