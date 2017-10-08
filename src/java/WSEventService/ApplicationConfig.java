/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSEventService;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Andre
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(WSEventService.EventoService.class);
        resources.add(WSEventService.FeedbackService.class);
        resources.add(WSEventService.LocalEventoService.class);
        resources.add(WSEventService.LocalService.class);
        resources.add(WSEventService.LogInService.class);
        resources.add(WSEventService.MaterialEventoService.class);
        resources.add(WSEventService.RecursoService.class);
        resources.add(WSEventService.ServicoEventoService.class);
        resources.add(WSEventService.ServicoService.class);
        resources.add(WSEventService.TipoEventoService.class);
        resources.add(WSEventService.TipoUtilizadorService.class);
        resources.add(WSEventService.UtilizadorPorEventoService.class);
        resources.add(WSEventService.UtilizadorService.class);
    }
    
}
