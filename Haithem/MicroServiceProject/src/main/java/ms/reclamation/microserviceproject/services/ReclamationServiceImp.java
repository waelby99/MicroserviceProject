package ms.reclamation.microserviceproject.services;

import lombok.AllArgsConstructor;
import ms.reclamation.microserviceproject.entities.Reclamation;
import ms.reclamation.microserviceproject.entities.User;
import ms.reclamation.microserviceproject.repositories.ReclamationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReclamationServiceImp implements IReclamationService {


    private ReclamationRepository reclamationReposiory;
    private UserClient userClient;

    public Reclamation addReclamation(Reclamation r,int id) {
        User optUser= userClient.getUserById(id);
        if (optUser!=null){
            r.setUserId(optUser.getId());
            return reclamationReposiory.save(r);
        }
        else {
            return null;
        }
    }

    @Override
    public List<Reclamation> getAllReclamations() {
        return reclamationReposiory.findAll();
    }

    @Override
    public List<Reclamation> getMesReclamations(int id) {
        return reclamationReposiory.findByUserId(id);
    }

    @Override
    public void deleteReclamation(long idReclamation) {
        reclamationReposiory.deleteById(idReclamation);
    }

    @Override
    public Reclamation updateReclamation(Reclamation r) {
        return reclamationReposiory.save(r);
    }

    @Override
    public Reclamation getReclamationById(long idReclamation) {
        return reclamationReposiory.findById(idReclamation).orElse(null);
    }

}