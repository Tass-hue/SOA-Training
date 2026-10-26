package graphql;

import business.ModuleBusiness;
import business.UniteEnseignementBusiness;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import entities.Module;
import entities.UniteEnseignement;

public class MutationResolver implements GraphQLMutationResolver {

    private final ModuleBusiness moduleBusiness;
    private final UniteEnseignementBusiness ueBusiness = new UniteEnseignementBusiness();

    public MutationResolver(ModuleBusiness moduleBusiness) {
        this.moduleBusiness = moduleBusiness;
    }

    // CREATE
    public Module addmodule(String matricule, String nom, int coefficient, int volumeHoraire,
                            Module.TypeModule type, int codeUE) {
        UniteEnseignement ue = ueBusiness.getUEByCode(codeUE);
        if (ue == null) return null;                       // UE inexistante
        Module module = new Module(matricule, nom, coefficient, volumeHoraire, type, ue);
        return moduleBusiness.addModule(module) ? module : null;
    }

    // UPDATE
    public Module updatemodule(String matricule, String nom, int coefficient, int volumeHoraire,
                               Module.TypeModule type, int codeUE) {
        UniteEnseignement ue = ueBusiness.getUEByCode(codeUE);
        if (ue == null) return null;
        Module module = new Module(matricule, nom, coefficient, volumeHoraire, type, ue);
        return moduleBusiness.updateModule(matricule, module) ? module : null;
    }

    // DELETE
    public boolean deletemodule(String matricule) {
        return moduleBusiness.deleteModule(matricule);
    }
}