package edu.udc.psw.desenhos.DB.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer.Form;

import edu.udc.psw.desenhos.DB.DBConnection;
import edu.udc.psw.desenhos.DB.data.Desenhos;
import edu.udc.psw.desenhos.DB.data.Forma;

public class FormaDAO {
	private Statement statement;
	private ResultSet resultSet;
	private int numberOfRows;
	private String query = "SELECT forma.TipoForma, forma.texto, forma.binario, forma.desenho, forma.id_formas FROM FORMA";
	private String update = "UPDATE (Tipo Forma, Arq Texto, Arq Binario, Desenho) from desenhos with ";
	private String insert = "INSERT into forma (Tipo Forma, Arq Texto, Arq Binario, Desenho) values ";

	public FormaDAO() {
		try {
			// cria Statement para consultar banco de dados
			statement = DBConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			// configura consulta e a executa
			setQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void moveToRow(int row) {
		try {
			resultSet.absolute(row);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public Forma getTipoForma() {
		Forma formas;
		formas = new Forma(
				((Forma) resultSet).getTipoForma(),
				numberOfRows, ((Forma) resultSet).getTexto(),
				((Forma) resultSet).getBinary(),
				((Forma) resultSet).getDesenho());
		return formas;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void save(Forma forma) throws SQLException, IllegalStateException {
		String newData = insert + "('" + forma.getTipoForma() + "', '" + forma.getTexto() + "', '"+ forma.getBinary()+ "', '"
				+ forma.getDesenho() + "')" + " WHERE id_formas = " + "', '" + forma.getId_formas() + "');";
		statement.executeUpdate(newData);
	}

	public void insert(Forma forma) throws SQLException, IllegalStateException {
		String newData = insert + "('" + forma.getTipoForma() + "', '" + forma.getTexto() + "', '"+ forma.getBinary()+ "', '"
				+ forma.getDesenho() + "');";
		int affectedRows = statement.executeUpdate(newData, Statement.RETURN_GENERATED_KEYS);
		
        if (affectedRows == 0) {
            throw new SQLException("Creating Desenhos failed, no rows affected.");
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                forma.setId_formas(generatedKeys.getLong(1));
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
		setQuery();
	}

	// configura nova string de consulta de banco de dados
	public void setQuery() throws SQLException, IllegalStateException {
		// especifica consulta e a executa
		resultSet = statement.executeQuery(query);

		// determina o número de linhas em ResultSet
		resultSet.last(); // move para a última linha
		numberOfRows = resultSet.getRow(); // obtém número de linha
		resultSet.first();
	}

	// fecha Statement e Connection
	public void disconnectFromDatabase() {
		try {
			statement.close();
			DBConnection.getConnection().close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}