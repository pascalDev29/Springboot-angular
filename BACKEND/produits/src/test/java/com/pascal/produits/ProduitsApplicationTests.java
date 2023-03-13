package com.pascal.produits;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pascal.produits.entities.Categorie;
import com.pascal.produits.entities.Produit;
import com.pascal.produits.repos.ProduitRepository;



@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Test
	public void testCreateProduit() {
	//	Produit prod = new Produit("ultra iphone X",1300.500,new Date());
		//produitRepository.save(prod);
	}
	
	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}
	
	@Test
	public void testUpdateProduit() {
		Produit p =produitRepository.findById(1L).get();
		p.setPrixProduit(1000.0);
		produitRepository.save(p);
	}
	
	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(1L);
	}
	
	@Test
	public void testListerTousProduits() {
		List<Produit> prods=produitRepository.findAll();
		for(Produit p :prods){
			System.out.println(p);
		}
		
	}
	
	@Test
	public void testFindByNomProduit() {
		List<Produit> prods=produitRepository.findByNomProduit("iphone X");
		for(Produit p :prods){
			System.out.println(p);
		}
		
	}
	
	@Test
	public void testFindByNomProduitContains() {
		List<Produit> prods=produitRepository.findByNomProduitContains("iphone X");
		for(Produit p :prods){
			System.out.println(p);
		}
		
	}
	
	@Test
	public void testFindByNomPrix() {
		List<Produit> prods=produitRepository.findByNomPrix("iphone X",1100);
		for(Produit p :prods){
			System.out.println(p);
		}
		
	}
	
	@Test
	public void testFindByCategorie() {
		Categorie categorie = new Categorie();
		categorie.setIdCat(1L);
		List<Produit> prods=produitRepository.findByCategorie(categorie);
		for(Produit p :prods){
			System.out.println(p);
		}
		
	}
	
	@Test
	public void testFindByCategorieIdCat() {
		
		List<Produit> prods=produitRepository.findByCategorieIdCat(1L);
		for(Produit p :prods){
			System.out.println(p);
		}
		
	}
	
	@Test
	public void testFindByOrderByNomProduitAsc() {
		
		List<Produit> prods=produitRepository.findByOrderByNomProduitAsc();
		for(Produit p :prods){
			System.out.println(p);
		}
		
	}

	@Test
	public void testTrierProduitsNomsPrix() {
		
		List<Produit> prods=produitRepository.trierProduitsNomsPrix();
		for(Produit p :prods){
			System.out.println(p);
		}
		
	}

}
