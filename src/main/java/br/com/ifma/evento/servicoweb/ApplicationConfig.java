package br.com.ifma.evento.servicoweb;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("evento")
public class ApplicationConfig extends Application {

    public Set<Class<?>> getClasses() {
    	Set<Class<?>> resources = new HashSet<>();
    	addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources){
    	
    	resources.add(EventoService.class);
    	resources.add(ClienteService.class);
    }
    
}
