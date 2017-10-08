/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSEventService;

import Commons.TipoEvento;
import com.google.gson.Gson;
import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import Controlo.LocalController;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
/**
 * REST Web Service
 *
 * @author Andre
 */
@Path("Evento")
public class EventoService {

    @Context
    private UriInfo context;
    private LocalController lc = new LocalController();
    /**
     * Creates a new instance of EventService
     */
    public EventoService() {
        
    }
   
    @POST
    @Path("/criar/{tipoEvento}/{nomeEvento}/{nomeCliente}/{contactoCliente}/{emailCliente}/{descricao}/{dataInicio}/{dataFim}/{horaInicio}/{horaFim}/{apoioCamara}")
    @Produces({"application/xml", "application/json"})
    public String criarEvento(@PathParam("tipoEvento") int tipoEvento, @PathParam("nomeEvento") String nomeEvento,
           @PathParam("nomeCliente") String nomeCliente, @PathParam("contactoCliente") String contactoCliente, @PathParam("emailCliente") String emailCliente,
           @PathParam("descricao") String descricao, @PathParam("dataInicio") String dataInicio, @PathParam("dataFim") String dataFim,
           @PathParam("horaInicio") String horaInicio, @PathParam("horaFim") String horaFim, @PathParam("apoioCamara") int apoioCamara) throws ParseException{ 
        Date datai;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        datai = df.parse(dataInicio);
        DateFormat sdf = new SimpleDateFormat("hh:mm");
        Date horasi = sdf.parse(horaInicio);
        Date dataf;
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        dataf = df1.parse(dataFim);
        DateFormat sdf1 = new SimpleDateFormat("hh:mm");
        Date horasf = sdf.parse(horaFim);
        lc.criarEvento(nomeEvento, nomeCliente, contactoCliente, emailCliente, descricao, datai, dataf, horasi, horasf, apoioCamara, tipoEvento);
        Gson g = new Gson();
        return g.toJson(lc);
    } 
    
    @POST
    @Path("/editar/{idEvento}/{idTipoEvento}/{nomeEvento}/{estado}/{nomeCliente}/{contactoCliente}/{emailCliente}/{descricao}/{dataInicio}/{dataFim}/{horaInicio}/{horaFim}/{apoioCamara}")
    @Produces({"application/xml", "application/json"})
    public String editarEvento(@PathParam("idEvento") int idEvento, @PathParam("idTipoEvento") int idTipoEvento, @PathParam("nomeEvento") String nomeEvento, @PathParam("estado") int estado,
           @PathParam("nomeCliente") String nomeCliente, @PathParam("contactoCliente") String contactoCliente, @PathParam("emailCliente") String emailCliente,
           @PathParam("descricao") String descricao, @PathParam("dataInicio") String dataInicio, @PathParam("dataFim") String dataFim,
           @PathParam("horaInicio") String horaInicio, @PathParam("horaFim") String horaFim, @PathParam("apoioCamara") int apoioCamara) throws ParseException{ 
       Date datai;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        datai = df.parse(dataInicio);
        DateFormat sdf = new SimpleDateFormat("hh:mm");
        Date horasi = sdf.parse(horaInicio);
        Date dataf;
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        dataf = df1.parse(dataFim);
        DateFormat sdf1 = new SimpleDateFormat("hh:mm");
        Date horasf = sdf.parse(horaFim);
        lc.editarEvento(idEvento, nomeEvento, estado, nomeCliente, contactoCliente, emailCliente, descricao, datai, dataf, horasi, horasf, apoioCamara, idTipoEvento);
        Gson g = new Gson();
        return g.toJson(lc);
    } 
    
//    @POST
//    @Path("/editar")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public String editarEvento(String json) throws ParseException, IOException{
//        JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
//        Integer idEvento = obj.get("idEvento").getAsInt();
//        String nomeEvento = obj.get("nomeEvento").getAsString();
//        
//        String nomeCliente = obj.get("nomeCliente").getAsString();
//        String contactoCliente = obj.get("contactoCliente").getAsString();
//        String emailCliente = obj.get("emailCliente").getAsString();
//        
//        Integer estado = obj.get("estado").getAsInt();
//        String descricao = obj.get("descricao").getAsString();
//        
//        String dataInicio = obj.get("dataInicio").getAsString();
//        String horaInicio = obj.get("horaInicio").getAsString();
//        
//        String dataFim = obj.get("dataFim").getAsString();
//        String horaFim = obj.get("horaFim").getAsString();
//        
//        Integer idTipoEvento = obj.get("idTipoEvento").getAsInt();
//
//        
//        Integer apoioCamara = obj.get("apoioCamara").getAsInt();
//        
//        
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        Date dataI = df.parse(dataInicio);
//        Date dataF = df.parse(dataFim);
//        DateFormat sdf = new SimpleDateFormat("mm:hh");
//        Date horaI = sdf.parse(horaInicio);
//        Date horaF = sdf.parse(horaFim);
//        
//        
//        lc.editarEvento(idEvento, nomeEvento, estado, nomeCliente, contactoCliente, emailCliente, descricao, dataI, dataF, horaI, horaF, apoioCamara, idTipoEvento);
//        Gson g = new Gson();
//        return g.toJson(lc);
//    }

    @POST
    @Path("/remover/{idEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String removerEvento(@PathParam("idEvento")int idEvento){ 
        lc.removerEvento(idEvento);
        Gson g = new Gson();
        return g.toJson(lc);
    }
	
    @POST
    @Path("/reativar/{idEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String reativarEvento(@PathParam("idEvento")int idEvento){ 
        lc.reativarEvento(idEvento);
        Gson g = new Gson();
          return g.toJson(lc);
      }

    @GET
    @Path("/listar")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarEvento(){ 
       return lc.listarEvento();
    }
    
    
    @GET
    @Path("/listarPorId/{idEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String listarEventoPorId(@PathParam("idEvento")int idEvento){ 
       return lc.listarEventoPorId(idEvento);
    }
    
    @POST
    @Path("/mudarEstado/{idEvento}/{estado}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String mudarEstadoEvento(@PathParam("idEvento")int idEvento, @PathParam("estado")int estado){ 
       lc.mudarEstadoEvento(idEvento, estado);
       Gson g = new Gson();
        return g.toJson(lc);
    }

    @GET
    @Path("/getNomeEvento/{idEvento}")
    @Produces({"application/xml", "application/json"})
    @Consumes("application/json")
    public String getNomeEvento(@PathParam("idEvento")int idEvento){ 
       return lc.getNomeEvento(idEvento);
    }
    
}