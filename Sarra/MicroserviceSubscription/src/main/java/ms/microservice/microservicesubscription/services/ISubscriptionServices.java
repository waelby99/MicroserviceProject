package ms.microservice.microservicesubscription.services;

import ms.microservice.microservicesubscription.entities.Subscription;
import ms.microservice.microservicesubscription.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISubscriptionServices {
    Subscription addSubscription(Subscription subscription,int id);

    Subscription updateSubscription(Subscription subscription);

    

    public List<Subscription> getMesSubscriptions(int id);
    Subscription retrieveSubscriptionById(Long numSubscription);

    Set<Subscription> getSubscriptionByType(TypeSubscription type);

    List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);

}
