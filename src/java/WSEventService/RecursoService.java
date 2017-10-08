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
import javax.ws.rs.DELETE;
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
@Path("Recurso")
public class RecursoService {

    @Context
    private UriInfo context;
    private LocalController lc = new LocalController();


    /**
     * Creates a new instance of RecursoService
     */
    public RecursoService() {
    }

    @POST
    @Path("/criar/{quantidadeDisponivel}/{designacao}/{valorUnitario}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String criarRecurso(@PathParam("quantidadeDisponivel") int quantidadeDisponivel, @PathParam("designacao") String designacao,
    @PathParam("valorUnitario") float valorUnitario){
        lc.criarRecurso(quantidadeDisponivel, designacao, valorUnitario);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/editar/{idRecurso}/{quantidadeDisponivel}/{designacao}/{valorUnitario}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String editarRecurso(@PathParam("idRecurso") int idRecurso, @PathParam("quantidadeDisponivel") int quantidadeDisponivel,
     @PathParam("designacao") String designacao, @PathParam("valorUnitario") float valorUnitario){
        lc.editarRecurso(idRecurso, quantidadeDisponivel, designacao, valorUnitario);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    
    
    @POST
    @Path("/remover/{idRecurso}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String removerRecurso(@PathParam("idRecurso") int idRecurso){
        lc.removerRecurso(idRecurso);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/reativar/{idRecurso}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String reativarRecurso(@PathParam("idRecurso") int idRecurso){
        lc.reativarRecurso(idRecurso);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @GET
    @Path("/listar")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarRecurso(){
        return lc.listarRecurso();
    }
    
    @GET
    @Path("/listarporid/{idRecurso}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarRecursoPorId(@PathParam("idRecurso")int idRecurso){ 
       return lc.listarRecursoPorId(idRecurso);
    }

    @GET
    @Path("/getNomeRecurso/{idRecurso}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String getNomeRecurso(@PathParam("idRecurso")int idRecurso){ 
       return lc.getNomeRecurso(idRecurso);
    }
}
