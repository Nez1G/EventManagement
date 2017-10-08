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
@Path("Servico")
public class ServicoService {

    @Context
    private UriInfo context;
    private LocalController lc = new LocalController();

    /**
     * Creates a new instance of ServicoService
     */
    public ServicoService() {
    }

    @POST
    @Path("/criar/{nome}/{email}/{contacto}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String criarServico(@PathParam("nome") String nome, @PathParam("email") String email, @PathParam("contacto") String contacto){
        lc.criarServico(nome, email, contacto);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/editar/{idServico}/{nome}/{email}/{contacto}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String editarServico(@PathParam("idServico") int idServico, @PathParam("nome") String nome,
     @PathParam("email") String email, @PathParam("contacto") String contacto){
        lc.editarServico(idServico, nome, email, contacto);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
     
    @POST
    @Path("/remover/{idServico}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String removerServico(@PathParam("idServico") int idServico){
        lc.removerServico(idServico);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @GET
    @Path("/listar")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarServico(){
      return lc.listarServico();
    }
    
    @GET
    @Path("/listarporid/{idServico}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarServicoPorId(@PathParam("idServico")int idServico){ 
       return lc.listarServicoPorId(idServico);
    }

    @GET
    @Path("/getNomeServico/{idServico}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String getNomeServico(@PathParam("idServico")int idServico){ 
       return lc.getNomeServico(idServico);
    }
}
