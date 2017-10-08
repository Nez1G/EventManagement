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
@Path("Utilizador")
public class UtilizadorService {

    @Context
    private UriInfo context;
    private LocalController lc = new LocalController();

    /**
     * Creates a new instance of UtilizadorService
     */
    public UtilizadorService() {
    }

    @POST
    @Path("/criar/{nicename}/{username}/{password}/{email}/{nif}/{telemovel}/{idTipoUtilizador}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String criarUtilizador(@PathParam("nicename") String nicename,
    @PathParam("username") String username, @PathParam("password") String password, @PathParam("email") String email, 
    @PathParam("nif") String nif, @PathParam("telemovel") String telemovel, @PathParam("idTipoUtilizador") int idTipoUtilizador){
        lc.criarUtilizador(nicename, username, password, email, nif, telemovel, idTipoUtilizador);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/editar/{idUtilizador}/{nicename}/{username}/{password}/{email}/{nif}/{telemovel}/{idTipoUtilizador}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String editarUtilizador(@PathParam("idUtilizador") int idUtilizador, @PathParam("nicename") String nicename,
    @PathParam("username") String username,@PathParam("password") String password, @PathParam("email") String email,
    @PathParam("nif") String nif, @PathParam("telemovel") String telemovel, @PathParam("idTipoUtilizador") int idTipoUtilizador){
        lc.editarUtilizador(idUtilizador, nicename, username, password, email, nif, telemovel, idTipoUtilizador);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/remover/{idUtilizador}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String removerUtilizador(@PathParam("idUtilizador") int idUtilizador){
        lc.removerUtilizador(idUtilizador);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/reativar/{idUtilizador}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String reativarUtilizador(@PathParam("idUtilizador") int idUtilizador){
        lc.reativarUtilizador(idUtilizador);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @GET
    @Path("/listar")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarUtilizador(){
       return lc.listarUtilizador();
    }
    
    @GET
    @Path("/listarUtilizadorPorId/{idUtilizador}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarUtilizadorPorId(@PathParam("idUtilizador")int idUtilizador){ 
       return lc.listarUtilizadorPorId(idUtilizador);
    }
    
    @POST
    @Path("/mudarpermissao/{idUtilizador}/{idTipoUtilizador}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String mudarPermissao(@PathParam("idUtilizador") int idUtilizador, @PathParam("idTipoUtilizador") int idTipoUtilizador){
        lc.mudarPermissao(idUtilizador, idTipoUtilizador);
        Gson g = new Gson();
        return g.toJson(lc);
    }

    @GET
    @Path("/getNomeUtilizador/{idUtilizador}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String getNomeUtilizador(@PathParam("idUtilizador")int idUtilizador){ 
       return lc.getNomeUtilizador(idUtilizador);
    }

}
