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
@Path("MaterialEvento")
public class MaterialEventoService {

    @Context
    private UriInfo context;
    private LocalController lc = new LocalController();

    /**
     * Creates a new instance of MaterialEventoService
     */
    public MaterialEventoService() {
    }

    
    @POST
    @Path("/criar/{idEvento}/{idRecurso}/{quantidadeUsadaRecurso}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String criarMaterialEvento(@PathParam("idEvento") int idEvento, @PathParam("idRecurso") int idRecurso, 
            @PathParam("quantidadeUsadaRecurso") int quantidadeUsadaRecurso){
        lc.criarMaterialEvento(idEvento, idRecurso, quantidadeUsadaRecurso);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/editar/{idMaterialEvento}/{idEvento}/{idRecurso}/{quantidadeUsadaRecurso}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String editarMaterialEvento(@PathParam("idMaterialEvento") int idMaterialEvento, @PathParam("idEvento") int idEvento,
     @PathParam("idRecurso") int idRecurso, @PathParam("quantidadeUsadaRecurso") int quantidadeUsadaRecurso){
        lc.editarMaterialEvento(idMaterialEvento, idEvento, idRecurso, quantidadeUsadaRecurso);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/remover/{idMaterialEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String removerMaterialEvento(@PathParam("idMaterialEvento") int idMaterialEvento){
        lc.removerMaterialEvento(idMaterialEvento);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @GET
    @Path("/listar")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarMaterialEvento(){
      return lc.listarMaterialEvento();
    }
    
    @GET
    @Path("/listarMaterialEventoPorId/{idEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarMaterialEventoPorID(@PathParam("idEvento") int idEvento){
      return lc.listarMaterialEventoPorId(idEvento);
    }
    
}
