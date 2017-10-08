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
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
@Path("ServicoEvento")
public class ServicoEventoService {

    @Context
    private UriInfo context;
    private LocalController lc = new LocalController();

    /**
     * Creates a new instance of ServicoEventoService
     */
    public ServicoEventoService() {
    }

    
    @POST
    @Path("/criar/{idEvento}/{idServico}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String criarServicoEvento(@PathParam("idEvento") int idEvento, @PathParam("idServico") int idServico){
        lc.criarServicoEvento(idEvento, idServico);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/editar/{idServicoEvento}/{idEvento}/{idServico}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String editarServicoEvento(@PathParam("idServicoEvento") int idServicoEvento, @PathParam("idEvento") int idEvento,
     @PathParam("idServico") int idServico){
        lc.editarServicoEvento(idServicoEvento, idEvento, idServico);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    
    
    @POST
    @Path("/remover/{idServicoEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String removerServicoEvento(@PathParam("idServicoEvento") int idServicoEvento){
        lc.removerServicoEvento(idServicoEvento);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @GET
    @Path("/listar")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarServicoEvento(){
      return lc.listarServicoEvento();
    }
    
    @GET
    @Path("/listarServicoEventoPorId/{idEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarServicoEvento(@PathParam("idEvento") int idEvento){
      return lc.listarServicoEventoPorId(idEvento);
    }
}
