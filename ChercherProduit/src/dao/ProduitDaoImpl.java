package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class ProduitDaoImpl implements IProduitDao{

	@Override
	public Produit save(Produit p) {
		
		Connection conn=Connexion.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("insert into produit (designation,prix,quantite) values(?,?,?)");
			st.setString(1, p.getDesignation());
			st.setFloat(2, (long)p.getPrix());
			st.setInt(3, p.getQuantite());
			st.executeUpdate();
			
			PreparedStatement st2=conn.prepareStatement("select max(id) as max from produit");
			ResultSet res=st2.executeQuery();
			if(res.next()) {
				p.setId(res.getInt("max"));
			}
			st2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
		
	}

	@Override
	public List<Produit> ProduitParMC(String mc) {
		List<Produit> list=new ArrayList<Produit>();
		Connection conn=Connexion.getConnection();
		Produit p ;
		ResultSet res;
		
		try {
			PreparedStatement st=conn.prepareStatement("select * from produit where designation LIKE ?");
			st.setString(1, mc);
			res = st.executeQuery();
			while (res.next()) {
				p = new Produit();
				p.setId(res.getInt(1));
				p.setDesignation(res.getString(2));
				p.setPrix(res.getFloat(3));
				p.setQuantite(res.getInt(4));
				
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Produit getProduit(long id) {

		Connection conn=Connexion.getConnection();
		Produit p=null ;
		ResultSet res;
		
		try {
			PreparedStatement st=conn.prepareStatement("select * from produit where id = ?");
			st.setLong(1, id);
			res = st.executeQuery();
			if (res.next()) {
				p = new Produit();
				p.setId(res.getInt(1));
				p.setDesignation(res.getString(2));
				p.setPrix(res.getFloat(3));
				p.setQuantite(res.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public Produit updateProduit(Produit p) {
		Connection conn=Connexion.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("update produit set designation = ? ,prix = ? ,quantite=? where id =?");
			st.setString(1, p.getDesignation());
			st.setFloat(2, (long)p.getPrix());
			st.setInt(3, p.getQuantite());
			st.setLong(4, p.getId());
			st.executeUpdate();
			
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public void deleteProduit(long id) {
		Connection conn=Connexion.getConnection();
		try {
			PreparedStatement st=conn.prepareStatement("delete from produit where id = ?");
			st.setLong(1,id);
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
}
