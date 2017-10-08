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
@Path("TipoEvento")
public class TipoEventoService {

    @Context
    private UriInfo context;
    private LocalController lc = new LocalController();

    /**
     * Creates a new instance of TipoEventoService
     */
    public TipoEventoService() {
    }

    @POST
    @Path("/criar/{designacao}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String criarTipoEvento(@PathParam("designacao") String designacao){
        lc.criarTipoEvento(designacao);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/editar/{idTipoEvento}/{designacao}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String editarTipoEvento(@PathParam("idTipoEvento") int idTipoEvento, @PathParam("designacao") String designacao){
        lc.editarTipoEvento(idTipoEvento, designacao);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/remover/{idTipoEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String removerTipoEvento(@PathParam("idTipoEvento") int idTipoEvento){
        lc.removerTipoEvento(idTipoEvento);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @GET
    @Path("/listar")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarTipoEvento(){
        return lc.listarTipoEvento();
    }
    
    @GET
    @Path("/listarPorId/{idTipoEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarTipoEventoPorId(@PathParam("idTipoEvento") int idTipoEvento){
        return lc.listarTipoEventoPorId(idTipoEvento);
    }
    
    @GET
    @Path("/listarNome/{idTipoEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarNome(@PathParam("idTipoEvento") int idTipoEvento){
        return lc.listarNomeTipoEvento(idTipoEvento);
    }
}
