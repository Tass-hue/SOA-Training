package graphql;

import business.ModuleBusiness;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import entities.Module;

import java.util.List;

public class QueryResolver implements GraphQLQueryResolver {

    private final ModuleBusiness moduleBusiness;

    public QueryResolver(ModuleBusiness moduleBusiness) {
        this.moduleBusiness = moduleBusiness;
    }

    public List<Module> getallmodules() {
        return moduleBusiness.getAllModules();
    }

    public Module getmodulebymatricule(String matricule) {
        return moduleBusiness.getModuleByMatricule(matricule);
    }

    public List<Module> getmodulesbytype(Module.TypeModule type) {
        return moduleBusiness.getModulesByType(type);
    }
}