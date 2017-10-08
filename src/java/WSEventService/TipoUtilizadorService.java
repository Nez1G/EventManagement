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
@Path("TipoUtilizador")
public class TipoUtilizadorService {

    @Context
    private UriInfo context;
    private LocalController lc = new LocalController();

    /**
     * Creates a new instance of TipoUtilizadorService
     */
    public TipoUtilizadorService() {
    }
    
    @POST
    @Path("/criar/{designacao}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String criarTipoUtilizador(@PathParam("designacao") String designacao){
        lc.criarTipoUtilizador(designacao);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/editar/{idTipoUtilizador}/{designacao}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String editarTipoUtilizador(@PathParam("idTipoUtilizador") int idTipoUtilizador, @PathParam("designacao") String designacao){
        lc.editarTipoUtilizador(idTipoUtilizador, designacao);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/remover/{idTipoUtilizador}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String removerUtilizador(@PathParam("idTipoUtilizador") int idTipoUtilizador){
        lc.removerTipoUtilizador(idTipoUtilizador);
        Gson g = new Gson();
        return g.toJson(lc);
    }

    @GET
    @Path("/listar")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarTipoUtilizador(){
        return lc.listarTipoUtilizador();
    }
    
    @GET
    @Path("/listarPorId/{idTipoUtilizador}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarTipoUtilizadorPorId(@PathParam("idTipoUtilizador") int idTipoUtilizador){
        return lc.listarTipoUtilizadorPorId(idTipoUtilizador);
    }
    
     @GET
    @Path("/listarNome/{idTipoUtilizador}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarNome(@PathParam("idTipoUtilizador") int idTipoUtilizador){
        return lc.listarNomeTipoUtilizador(idTipoUtilizador);
    }
}
