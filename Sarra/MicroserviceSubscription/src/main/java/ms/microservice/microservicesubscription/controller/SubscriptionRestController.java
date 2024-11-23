package ms.microservice.microservicesubscription.controller;

import lombok.RequiredArgsConstructor;
import ms.microservice.microservicesubscription.entities.Subscription;
import ms.microservice.microservicesubscription.services.ISubscriptionServices;
import org.springframework.web.bind.annotation.*;
import ms.microservice.microservicesubscription.entities.TypeSubscription;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionRestController {
    private final ISubscriptionServices subscriptionServices;
    @PostMapping("/{id}")
    public Subscription addSubscription(@RequestBody Subscription subscription,@PathVariable int id){
        return  subscriptionServices.addSubscription(subscription,id);
    }
    @GetMapping("/{numSubscription}")
    public Subscription getById(@PathVariable("numSubscription") Long numSubscription){
        return subscriptionServices.retrieveSubscriptionById(numSubscription);
    }
    /*@GetMapping("/{typeSub}")
    public Set<Subscription> getSubscriptionsByType(@PathVariable("typeSub") TypeSubscription typeSubscription){
        return subscriptionServices.getSubscriptionByType(typeSubscription);
    }*/
    @PutMapping("/")
    public Subscription updateSubscription(@RequestBody Subscription subscription){
        return  subscriptionServices.updateSubscription(subscription);
    }

    /*@GetMapping("/{date1}/{date2}")
    public List<Subscription> getSubscriptionsByDates(@PathVariable("date1") LocalDate startDate,
                                                      @PathVariable("date2") LocalDate endDate){
        return subscriptionServices.retrieveSubscriptionsByDates(startDate, endDate);
    }*/
    @GetMapping("/user/{id}")
    public List<Subscription> getMesSubscriptions(@PathVariable int id) {
        return subscriptionServices.getMesSubscriptions(id);
    }

}
