
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lecox
 */
public class crudEstoque extends ConnectionFactory {

    public boolean create(Estoque estoque) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "INSERT INTO mecanica.estoque (nome, preco,quantidade) VALUES (?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estoque.getNome());
            ps.setDouble(2, estoque.getPreco());
            ps.setInt(3, estoque.getQuantidade());
            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            CloseConnection();
        }

    }

    public boolean update(Estoque estoque) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "UPDATE  mecanica.estoque SET nome=?, preco=?,quantidade=? WHERE CodProduto=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estoque.getNome());
            ps.setDouble(2, estoque.getPreco());
            ps.setInt(3, estoque.getQuantidade());
            ps.setInt(4, estoque.getCodProduto());
            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            CloseConnection();
        }

    }

    public ArrayList<Estoque> read(Estoque estoque) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String sql = "SELECT * FROM  mecanica.estoque";
        ArrayList<Estoque> estoques = new ArrayList();
        try {
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                estoque = new Estoque();
                estoque.setCodProduto(Integer.parseInt(rs.getString("CodProduto")));
                estoque.setNome(rs.getString("nome"));
                estoque.setPreco(rs.getDouble("preco"));
                estoque.setQuantidade(rs.getInt("quantidade"));
                estoques.add(estoque);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            CloseConnection();
        }
        return estoques;

    }

    public double soma(Estoque estoque) {
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        Connection con = getConnection();
        String sql = "SELECT SUM(preco * quantidade) AS total FROM mecanica.estoque";
        String sql2 = "SELECT SUM(quantidade) AS tot FROM mecanica.estoque";
        String sql3 = "SELECT COUNT(quantidade) AS cnt FROM mecanica.estoque";
        try {
            ps = con.prepareStatement(sql);
            ps2 = con.prepareStatement(sql2);
            ps3 = con.prepareStatement(sql3);
            rs = ps.executeQuery();
            rs2 = ps2.executeQuery();
            rs3 = ps3.executeQuery();
            while (rs.next() && rs2.next() && rs3.next()) {

                estoque.setTotal(rs.getDouble("total"));
                estoque.setTotalQuantidade(rs2.getInt("tot"));
                estoque.setQuantidadeItens(rs3.getInt("cnt"));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            CloseConnection();
        }
        return 0;

    }

    public ArrayList<Estoque> busca(String desc) {
        Estoque estoque = new Estoque();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        String sql = "SELECT * FROM  mecanica.estoque WHERE nome LIKE ? ";
        ArrayList<Estoque> estoques = new ArrayList();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + desc + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                estoque = new Estoque();
                estoque.setCodProduto(Integer.parseInt(rs.getString("CodProduto")));
                estoque.setNome(rs.getString("nome"));
                estoque.setPreco(rs.getDouble("preco"));
                estoque.setQuantidade(rs.getInt("quantidade"));
                estoques.add(estoque);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            CloseConnection();
        }
        return estoques;

    }

    public boolean delete(Estoque estoque) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "DELETE FROM mecanica.estoque WHERE CodProduto=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estoque.getCodProduto());
            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            CloseConnection();
        }

    }

}
