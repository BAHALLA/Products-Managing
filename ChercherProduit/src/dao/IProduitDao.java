package dao;

import java.util.List;

import metier.Produit;

public interface IProduitDao {

	public Produit save(Produit p);
	public List<Produit> ProduitParMC(String mc);
	public Produit getProduit(long id);
	public Produit updateProduit(Produit p);
	public void deleteProduit(long id);
}
