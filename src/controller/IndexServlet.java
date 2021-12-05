package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categorie;
import model.Produit;
import repository.BoutiqueManegment;


@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoutiqueManegment bm = new BoutiqueManegment();
		List<Categorie> listC=bm.getAllCategorie();
		List<Produit> listP;
		if(request.getParameter("id")!=null) {
			int id = Integer.parseInt(request.getParameter("id"));
			listP=bm.getProduitByCategorie(id);
		}else {
			listP=bm.getAllProduit();
		}
		request.setAttribute("listC", listC);
		request.setAttribute("listP", listP);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
