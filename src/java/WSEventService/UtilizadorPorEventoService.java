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
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author andre
 */
@Path("UtilizadorPorEvento")
public class UtilizadorPorEventoService {

    @Context
    private UriInfo context;
    private LocalController lc = new LocalController();

    /**
     * Creates a new instance of UtilizadorPorEventoService
     */
    public UtilizadorPorEventoService() {
    }
    
    @POST
    @Path("/criar/{idUtilizador}/{idEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String criarUtilizadorEvento(@PathParam("idUtilizador") int idUtilizador, @PathParam("idEvento") int idEvento){
        lc.criarUtilizadorEvento(idUtilizador, idEvento);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/editar/{idUtilizadorEvento}/{idUtilizador}/{idEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String editarUtilizadorEvento(@PathParam("idUtilizadorEvento") int idUtilizadorEvento, @PathParam("idUtilizador") int idUtilizador,
     @PathParam("idEvento") int idEvento){
        lc.editarUtilizadorEvento(idUtilizadorEvento, idUtilizador, idEvento);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    
    
    @POST
    @Path("/remover/{idUtilizadorEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String removerUtilizadorEvento(@PathParam("idUtilizadorEvento") int idUtilizadorEvento){
        lc.removerUtilizadorEvento(idUtilizadorEvento);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @GET
    @Path("/listar")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarUtilizadorEvento(){
      return lc.listarUtilizadorEvento();
    }
    
}
