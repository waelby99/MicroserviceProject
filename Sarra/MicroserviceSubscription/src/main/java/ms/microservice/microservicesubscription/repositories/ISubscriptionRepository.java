package ms.microservice.microservicesubscription.repositories;

import ms.microservice.microservicesubscription.entities.Subscription;
import ms.microservice.microservicesubscription.entities.TypeSubscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ISubscriptionRepository extends CrudRepository<Subscription, Long> {

    @Query("select s from Subscription s where s.typeSub = :typeS order by s.startDate")
    Set<Subscription> findByTypeSubOrderByStartDateAsc(@Param("typeS") TypeSubscription typeSub);

    List<Subscription> getSubscriptionsByStartDateBetween(LocalDate date1, LocalDate date2);

    @Query("select distinct s from Subscription s where s.endDate <= CURRENT_TIME order by s.endDate")
    List<Subscription> findDistinctOrderByEndDateAsc();


    @Query("select (sum(s.price))/(count(s)) from Subscription s where s.typeSub = ?1")
    Float recurringRevenueByTypeSubEquals(TypeSubscription typeSub);

    List<Subscription> findByUserId(int id);
}
