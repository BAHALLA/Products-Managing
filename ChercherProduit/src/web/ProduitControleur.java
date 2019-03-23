package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.Produit;

@WebServlet("/ProduitControleur")
public class ProduitControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IProduitDao metier;

	@Override
	public void init() throws ServletException {
		metier = new ProduitDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getServletPath();

		if (path.equals("/index")) {
			request.getRequestDispatcher("Produit.jsp").forward(request, response);
		} 
		else if (path.equals("/chercher")) {
			String mc = request.getParameter("mc");

			List<Produit> produits = metier.ProduitParMC("%" + mc + "%");
			ProduitModule module = new ProduitModule();
			module.setMc(mc);
			module.setProduits(produits);
			request.setAttribute("module", module);
			request.getRequestDispatcher("Produit.jsp").forward(request, response);
		} 
		else if (path.equals("/addProduct")) {
			request.setAttribute("produit", new Produit());
			request.getRequestDispatcher("addProduct.jsp").forward(request, response);
		} 
		else if(path.equals("/SaveProduct") && (request.getMethod().equals("POST"))) {
			String des = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int qte = Integer.parseInt(request.getParameter("quantite"));
			
			Produit p =new Produit(des, prix, qte);
			Produit res =metier.save(p);
			request.setAttribute("produit", res);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
		}
		else if(path.equals("/supprimer")) {
			long id = Long.parseLong(request.getParameter("id"));
			metier.deleteProduit(id);
			//request.getRequestDispatcher("Produit.jsp").forward(request, response);
			response.sendRedirect("chercher?mc=");
		}
		else if(path.equals("/editer")) {
			long id = Long.parseLong(request.getParameter("id"));
			Produit p = metier.getProduit(id);
			request.setAttribute("produit", p);
			request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
		}
		else if(path.equals("/UpdateProduct") && (request.getMethod().equals("POST"))) {
			long id = Long.parseLong(request.getParameter("id"));
			String des = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int qte = Integer.parseInt(request.getParameter("quantite"));
			
			Produit p =new Produit(des, prix, qte);
			p.setId(id);
			Produit res =metier.updateProduit(p);
			request.setAttribute("produit", res);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
		}
		else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
