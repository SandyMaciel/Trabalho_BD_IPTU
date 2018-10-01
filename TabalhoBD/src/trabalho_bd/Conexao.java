package trabalho_bd;
import java.sql.*;

/**
 * Created by Sandy on 09/05/2016.
 */
public class Conexao {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String driverName = "com.mysql.jdbc.Driver";

        Class.forName(driverName);

        String serverName = "localhost";    //caminho do servidor do BD

        String mydatabase ="trabalhodbiptu";        //nome do seu banco de dados

        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

        String username = "root";        //nome de um usu�rio de seu BD

        String p = "sandy";      //sua senha de acesso

        Connection connection = DriverManager.getConnection(url, username, password);


        System.out.println("args = [" + connection + "]");

        String sql = "SELECT * FROM BAIRRO";
        PreparedStatement ps = connection.prepareStatement(sql);

        //Executa o comando de consulta aonde guarda os dados retornados dentro do ResultSet.
//Pelo fato de gerar uma lista de valores, � necess�rio percorrer os dados atrav�s do la�o while
        ResultSet rs = ps.executeQuery();
//Faz a verifica��o de enquanto conter registros, percorre e resgata os valores
        while(rs.next()){
            //Recupera valor referente ao nome da coluna
            int nome = rs.getInt("NOME");
            //Recupera o �ndice do campo referente ao campo nome
            String representante = rs.getString("representante");
            int tel_contato = rs.getInt("TEL_CONTATO");

            System.out.printf("C�digo %d: %s - %d | Sal�rio: \n", nome, representante,tel_contato);
        }
    }
}
