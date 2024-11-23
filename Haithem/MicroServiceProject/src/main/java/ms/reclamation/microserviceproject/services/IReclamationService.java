package ms.reclamation.microserviceproject.services;

import ms.reclamation.microserviceproject.entities.Reclamation;

import java.util.List;

public interface IReclamationService {
    Reclamation addReclamation(Reclamation r,int id);

    public List<Reclamation> getAllReclamations();
    public List<Reclamation> getMesReclamations(int id);

    public Reclamation getReclamationById(long idReclamation);

    public void deleteReclamation(long idReclamation);

    public Reclamation updateReclamation(Reclamation r);
}
