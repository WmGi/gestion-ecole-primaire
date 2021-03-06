package com.school.myschool.dao;

import com.school.myschool.entity.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class dao_implementaion {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public dao_implementaion(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;

 //crud Eleve
    public List<Eleve> findAllEleve() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Eleve> theQuery =
                currentSession.createQuery("SELECT u FROM Eleve u", Eleve.class);

        // execute query and get result list
        List<Eleve> Eleve = theQuery.getResultList();

        // return the results
        return Eleve;
    }


    public Eleve findEleveById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the eleve
        Eleve Eleve =
                currentSession.get(Eleve.class, theId);

        // return the eleve
        return Eleve;
    }


    public void saveEleve(Eleve theEleve) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        // save eleve
        currentSession.saveOrUpdate(theEleve);
    }



    public void deleteEleveById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Eleve where id=:eleveId");
        theQuery.setParameter("eleveId", theId);

        theQuery.executeUpdate();
    }


//crud Classe

    public List<Classe> findAllClasse() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Classe> theQuery =
                currentSession.createQuery("SELECT u FROM Classe u", Classe.class);

        // execute query and get result list
        List<Classe> classe = theQuery.getResultList();

        // return the results
        return classe;
    }



    public Classe findClasseById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the classe
        Classe Classe =
                currentSession.get(Classe.class, theId);

        // return the classe
        return Classe;
    }

    public void saveClasse(Classe theClasse) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save classe
        currentSession.saveOrUpdate(theClasse);
    }

    public void deleteClasseById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Classe where id=:classeId");
        theQuery.setParameter("classeId", theId);

        theQuery.executeUpdate();
    }


    //crud Matiere

    public List<Matiere> findAllMatiere() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Matiere> theQuery =
                currentSession.createQuery("SELECT u FROM Matiere u", Matiere.class);

        // execute query and get result list
        List<Matiere> matiere = theQuery.getResultList();

        // return the results
        return matiere;
    }



    public Matiere findMatiereById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the Matiere
        Matiere Matiere =
                currentSession.get(Matiere.class, theId);

        // return the Matiere
        return Matiere;
    }

    public void saveMatiere(Matiere theMatiere) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save Matiere
        currentSession.saveOrUpdate(theMatiere);
    }

    public void deleteMatiereById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Matiere where id=:matiereId");
        theQuery.setParameter("matiereId", theId);

        theQuery.executeUpdate();
    }

    //crud User

    public List<User> findAllUser() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<User> theQuery =
                currentSession.createQuery("SELECT u FROM User u where u.genre=:g", User.class);
        theQuery.setParameter("g",0);
        // execute query and get result list
        List<User> User = theQuery.getResultList();

        // return the results
        return User;
    }



    public User findUserById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the User
        User User =
                currentSession.get(User.class, theId);

        // return the User
        return User;
    }

    public void saveUser(User theUser) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
theUser.setPassword(theUser.getEmail());
        // save User
        currentSession.saveOrUpdate(theUser);
    }

    public void deleteUserById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from User where id=:UserId");
        theQuery.setParameter("UserId", theId);

        theQuery.executeUpdate();
    }


    public List<emploiEntity> findAllemploiEntity() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<emploiEntity> theQuery =
                currentSession.createQuery("SELECT u FROM emploiEntity u ", emploiEntity.class);
        // execute query and get result list
        List<emploiEntity> emploiEntity = theQuery.getResultList();

        // return the results
        return emploiEntity;
    }



    public emploiEntity findemploiEntityById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the User
        emploiEntity emploiEntity =
                currentSession.get(emploiEntity.class, theId);

        // return the User
        return emploiEntity;
    }

    public void saveemploiEntity(emploiEntity theemploiEntity) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save User
        currentSession.saveOrUpdate(theemploiEntity);
    }

    public void deleteemploiEntityById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from emploiEntity where emploiEntityId=:UserId");
        theQuery.setParameter("UserId", theId);

        theQuery.executeUpdate();
    }
    public Horaire findHoraireById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the User
        Horaire Horaire =
                currentSession.get(Horaire.class, theId);

        // return the User
        return Horaire;
    }

    public days finddayseById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the User
        days days =
                currentSession.get(days.class, theId);

        // return the User
        return days;
    }
    public List<emploiEntity> findAllemploiEntityById(User enseignant) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<emploiEntity> theQuery =
                currentSession.createQuery("SELECT u FROM emploiEntity u where u.enseignant=:enseignant", emploiEntity.class);
        theQuery.setParameter("enseignant", enseignant);

        // execute query and get result list
        List<emploiEntity> emploiEntity = theQuery.getResultList();

        // return the results
        return emploiEntity;
    }
    public void saveusers(User User) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
       String password= passwordEncoder.encode(User.getEmail());
        users_spring users_spring=new users_spring(
               User.getEmail(),
                password, "ROLE_USER",1);
        // save User
        currentSession.saveOrUpdate(users_spring);
    }
    public User findenseignateByName(String email) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the User
        Query<User> theQuery =
                currentSession.createQuery("SELECT u FROM User u where u.email=:email", User.class);
        theQuery.setParameter("email", email);
          User user=theQuery.getSingleResult();
        // return the User
        return user;
    }


}
