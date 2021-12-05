package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Categorie;
import model.Produit;

public class BoutiqueManegment {

	EntityManager em;

	public BoutiqueManegment() {
		
		EntityManagerFactory factor = Persistence.createEntityManagerFactory("persis");
		em= factor.createEntityManager();
	}
	
	public List<Categorie> getAllCategorie(){
		em.getTransaction().begin();
		Query q= em.createQuery("select c from Categorie c");
		List<Categorie> listC = q.getResultList();
		em.getTransaction().commit();
		return listC;
	}
	
	public List<Produit> getAllProduit(){
		em.getTransaction().begin();
		Query q= em.createQuery("select p from Produit p");
		List<Produit> listP = q.getResultList();
		em.getTransaction().commit();
		return listP;
	}
	
	public List<Produit> getProduitByCategorie(int id){
		em.getTransaction().begin();
		Query q=em.createQuery("select p from Produit p where p.categorie.id=:id");
		q.setParameter("id", id);
		List<Produit> listP = q.getResultList();
		em.getTransaction().commit();
		return listP;
		
		
		
	}
}
