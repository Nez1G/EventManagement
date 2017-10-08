/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSEventService;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import Controlo.LocalController;
import javax.ws.rs.GET;
/**
 * REST Web Service
 *
 * @author Andre
 */
@Path("Local")
public class LocalService {

    @Context
    private UriInfo context;
    private LocalController lc = new LocalController();

    /**
     * Creates a new instance of LocalService
     */
    public LocalService() {
    }

    @POST
    @Path("/criar/{nome}/{codigoPostal}/{Morada}")
    @Produces({"application/xml", "application/json"})
    public String criarLocal(@PathParam("nome") String nome, @PathParam("codigoPostal") String codigoPostal,
    @PathParam("Morada") String Morada){
        lc.criarLocal(nome, codigoPostal, Morada);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/editar/{idLocal}/{nome}/{codigoPostal}/{Morada}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String editarLocal(@PathParam("idLocal") int idLocal, @PathParam("nome") String nome, @PathParam("codigoPostal") String codigoPostal,
     @PathParam("Morada") String Morada){
        lc.editarLocal(idLocal, nome, codigoPostal, Morada);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @POST
    @Path("/remover/{idLocal}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String removerLocal(@PathParam("idLocal") int idLocal){
        lc.removerLocal(idLocal);
        Gson g = new Gson();
        return g.toJson(lc);
    }
    
    @GET
    @Path("/listar")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarLocal(){
        return lc.listarLocal();
    }
    
     
    @GET
    @Path("/listarPorId/{idLocal}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarLocalPorId(@PathParam("idLocal") int idLocal){
        return lc.listarLocalPorId(idLocal);
    }

    @GET
    @Path("/getNomeLocal/{idLocal}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String getNomeLocal(@PathParam("idLocal") int idLocal){
        return lc.getNomeLocal(idLocal);
    }
}
