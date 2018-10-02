package br.com.projProva.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projProva.dados.nomesDB;
import br.com.projProva.entidade.Nomes;

@WebServlet("/nomesCtrl")
public class nomesCtrl extends HttpServlet {
	private static final long serialVersionUID = 6081325521831461718L;

	public nomesCtrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String nome = request.getParameter("nome");
		String msg= "";
		// INSTANCIO O OBJETO E JOGO OS VALORES NOS PARAMETROS
		Nomes nomes = new Nomes();
		nomes.setNome(nome);			
		if(new nomesDB().inserir(nomes)) {
			msg = "Registro salvo com sucesso";
		}else {
			msg = "Erro ao inserir registro";
		}
		
	request.setAttribute("msg", msg);
	request.getRequestDispatcher("Nomes.jsp").forward(request, response);

	}
}
