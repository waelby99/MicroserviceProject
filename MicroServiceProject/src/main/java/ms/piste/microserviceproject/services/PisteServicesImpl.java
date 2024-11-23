package ms.piste.microserviceproject.services;

import lombok.AllArgsConstructor;
import ms.piste.microserviceproject.entities.Piste;
import ms.piste.microserviceproject.entities.User;
import ms.piste.microserviceproject.repositories.IPisteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class PisteServicesImpl implements  IPisteServices{

    private IPisteRepository pisteRepository;
    private UserClient userClient;

    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste piste,int id) {
        User optUser= userClient.getUserById(id);
        if (optUser!=null) {
            piste.setUserId(optUser.getId());
            return pisteRepository.save(piste);
        }
        else {
            return null;
        }
    }

    @Override
    public List<Piste> mesPistes(int id) {
        return pisteRepository.findByUserId(id);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }


    @Override
    public void removePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }
}

