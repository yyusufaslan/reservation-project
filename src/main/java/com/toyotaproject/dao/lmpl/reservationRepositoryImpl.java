package com.toyotaproject.dao.lmpl;

import com.toyotaproject.dao.reservationRepository;
import com.toyotaproject.domain.Reservation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

//import org.custommonkey.xmlunit.ElementNameAndTextQualifier;

/**
 * Created by burakgungor on 10.03.2017.
 */
@Repository
public class reservationRepositoryImpl implements reservationRepository {
    @PersistenceContext(unitName = "toyotaproject")
    private EntityManager entityManager;

    @Override
    public List<Reservation> getAllReservation() {
        List<Reservation> reservations=new ArrayList<Reservation>();
        reservations.add((Reservation) entityManager.createQuery("SELECT Reservation FROM Reservation i order by i.id").getResultList());
        return reservations;
    }


    @Override
    public Reservation getReservationById(long id)
    {

        Reservation result=null;
        try{
            result=(Reservation) entityManager.createQuery( "SELECT Reservation FROM Reservation c WHERE c.id=:id")
                    .setParameter("id",id).getSingleResult();
        }catch (final NoResultException e){
        }

        return result;

    }

    public Reservation save(Reservation reservation)
    {
        entityManager.persist(reservation);
        return reservation;
    }

    @Override
    public Reservation update(long id,Reservation reservation)
    {
        entityManager.merge(reservation);
       return reservation;
    }


}
