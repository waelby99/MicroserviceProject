package ms.piste.microserviceproject.services;

import ms.piste.microserviceproject.entities.Piste;

import java.util.List;

public interface IPisteServices {
    List<Piste> retrieveAllPistes();

    Piste  addPiste(Piste  piste,int id);

    List<Piste> mesPistes(int id);

    Piste updatePiste(Piste piste);

    void removePiste (Long numPiste);

    Piste retrievePiste (Long numPiste);
}
