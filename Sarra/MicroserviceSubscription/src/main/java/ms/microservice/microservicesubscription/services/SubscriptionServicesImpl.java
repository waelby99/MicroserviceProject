package ms.microservice.microservicesubscription.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms.microservice.microservicesubscription.entities.Subscription;
import ms.microservice.microservicesubscription.entities.TypeSubscription;
import ms.microservice.microservicesubscription.entities.User;
import ms.microservice.microservicesubscription.repositories.ISubscriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Slf4j
@AllArgsConstructor
@Service
public class SubscriptionServicesImpl implements ISubscriptionServices {
    private ISubscriptionRepository subscriptionRepository;
    private UserClient userClient;
    @Override
    public Subscription addSubscription(Subscription subscription,int id) {
        switch (subscription.getTypeSub()) {
            case ANNUAL:
                subscription.setEndDate(subscription.getStartDate().plusYears(1));
                break;
            case SEMESTRIEL:
                subscription.setEndDate(subscription.getStartDate().plusMonths(6));
                break;
            case MONTHLY:
                subscription.setEndDate(subscription.getStartDate().plusMonths(1));
                break;
        }
        User optUser= userClient.getUserById(id);
        if (optUser!=null) {
            subscription.setUserId(optUser.getId());
            return subscriptionRepository.save(subscription);
        }else {
            return null;
        }
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> getMesSubscriptions(int id) {
        return subscriptionRepository.findByUserId(id);
    }

    @Override
    public Subscription retrieveSubscriptionById(Long numSubscription) {
        return subscriptionRepository.findById(numSubscription).orElse(null);
    }

    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {
        return subscriptionRepository.findByTypeSubOrderByStartDateAsc(type);
    }


    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return subscriptionRepository.getSubscriptionsByStartDateBetween(startDate, endDate);
    }


}