/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSEventService;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import Controlo.LocalController;
import javax.ws.rs.GET;

/**
 * REST Web Service
 *
 * @author Diogo
 */
@Path("Feedback")
public class FeedbackService {

    @Context
    private UriInfo context;
    private LocalController lc = new LocalController();
    /**
     * Creates a new instance of EventService
     */
    public FeedbackService() {
        
    }
    
    @POST
    @Path("/criar/{nota}/{observacao}/{idEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String criarFeedback(@PathParam("nota") int nota, @PathParam("observacao") String observacao, @PathParam("idEvento") int idEvento){
        lc.criarFeedback(nota, observacao, idEvento);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/editar/{idFeedback}/{nota}/{observacao}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String editarFeedback(@PathParam("idFeedback") int idFeedback, @PathParam("nota") int nota, @PathParam("observacao") String observacao){
        lc.editarFeedback(idFeedback ,nota, observacao);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/remover/{idFeedback}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String removerFeedback(@PathParam("idFeedback") int idFeedback){
        lc.removerFeedback(idFeedback);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @GET
    @Path("/listar")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarFeedback(){
        lc.listarFeedback();
        Gson g = new Gson();
        return g.toJson(lc);
    }
}
