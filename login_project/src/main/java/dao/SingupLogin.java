package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.Signuppage;



public class SingupLogin {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void saveSignup(Signuppage sign){
		entityTransaction.begin();
		entityManager.persist(sign);
		entityTransaction.commit();
	}
	
	public Signuppage LoginUser(long mobileno){
		 List<Signuppage> list= entityManager.createQuery("select x from Signuppage x where mobileno=?1").setParameter(1, mobileno).getResultList();
		if (list.isEmpty()) {
			return null;
		}else{
			return list.get(0);
		}
	}
	
	public Signuppage LoginUser(String  email){
		 List<Signuppage> list= entityManager.createQuery("select x from Signuppage x where email=?1").setParameter(1, email).getResultList();
		if (list.isEmpty()) {
			return null;
		}else{
			return list.get(0);
		}
	}
	
	public List<Signuppage> fetchAll(){
		return entityManager.createQuery("select x frpm Signuppage x").getResultList();
		
	}
	
	public void deleteById(int id){
		entityTransaction.begin();
		entityManager.remove(find(id));
		entityTransaction.commit();
	}
	
	public Signuppage find(int id){
		return entityManager.find(Signuppage.class, id);
	}
	
	public void update(Signuppage signuppage){
		entityTransaction.begin();
		entityManager.merge(signuppage);
		entityTransaction.commit();
	}

	
}














