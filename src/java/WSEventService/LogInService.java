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
@Path("LogIn")
public class LogInService {

    @Context
    private UriInfo context;
    private LocalController lc = new LocalController();

    /**
     * Creates a new instance of LocalService
     */
    public LogInService() {
    }

    @POST
    @Path("/login/{username}/{password}")
    @Produces({"application/xml", "application/json"})
    public String LogIn(@PathParam("username") String username, @PathParam("password") String password){
        lc.logIn(username, password);
        Gson g = new Gson();
        return g.toJson(lc);
    }

}