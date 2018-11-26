package edu.udc.psw.desenhos.DB.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.udc.psw.desenhos.DB.DBConnection;
import edu.udc.psw.desenhos.DB.data.Desenhos;
import edu.udc.psw.desenhos.DB.data.TipoForma;

public class TipoFormaDao {
	private Statement statement;
	private ResultSet resultSet;
	private int numberOfRows;
	private String query = "SELECT tipoforma.nome, tipoforma.qtd_pontos, tipoforma_qtd_escalares, tipoforma.id_tipo FROM TipoForma";
	private String update = "UPDATE (nome, qtd_pontos, qtd_escalares) from TipoForma with ";
	private String insert = "INSERT into TipoForma nome, qtd_pontos, qtd_escalares values ";

	public TipoFormaDao() {
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

	public int getTipoForma() {
		int tipoforma;
		tipoforma = new TipoForma(
				((TipoForma) resultSet).getNome(),
				(TipoForma) resultSet).getQtd_escalares();
		return tipoforma;
		
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void save(TipoForma tipoforma) throws SQLException, IllegalStateException {
		String newData = update + "('" + tipoforma.getId_tipo() + "', '" + tipoforma.getQtd_escalares() + "', '" 
				+ tipoforma.getQtd_pontos() + "')" + " WHERE id_tipo = " + "', '" + tipoforma.getId_tipo() + "');";
		statement.executeUpdate(newData);
	}

	public void insert(TipoForma tipoforma) throws SQLException, IllegalStateException {
		String newData = update + "('" + tipoforma.getId_tipo() + "', '" + tipoforma.getQtd_escalares() + "', '" 
				+ tipoforma.getQtd_pontos() + "');";
		int affectedRows = statement.executeUpdate(newData, Statement.RETURN_GENERATED_KEYS);
		
        if (affectedRows == 0) {
            throw new SQLException("Creating Desenhos failed, no rows affected.");
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                tipoforma.setId_tipo(generatedKeys.getLong(1));
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