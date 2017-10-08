/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSEventService;

import Controlo.LocalController;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Diogo
 */
@Path("LocalEvento")
public class LocalEventoService {

   @Context
    private UriInfo context;
    private LocalController lc = new LocalController();
    /**
     * Creates a new instance of EventService
     */
    public LocalEventoService() {
        
    }
    
    @POST
    @Path("/criar/{idEvento}/{idLocal}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String criarLocalEvento(@PathParam("idEvento") int idEvento, @PathParam("idLocal") int idLocal){
        lc.criarLocalEvento(idEvento, idLocal);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/editar/{idLocalEvento}/{idEvento}/{idLocal}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String editarLocalEvento(@PathParam("idLocalEvento") int idLocalEvento, @PathParam("idEvento") int idEvento, @PathParam("idLocal") int idLocal){
        lc.editarLocalEvento(idLocalEvento,idEvento, idLocal);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/remover/{idLocalEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String removerLocalEvento(@PathParam("idLocalEvento") int idLocalEvento){
        lc.removerLocalEvento(idLocalEvento);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @GET
    @Path("/listar")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarLocalEvento(){
        lc.listarLocalEvento();
        Gson g = new Gson();
        return g.toJson(lc);
    }
}
