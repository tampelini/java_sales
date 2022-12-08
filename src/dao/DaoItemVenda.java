/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import jdbc.ConnectionFactory;
import model.ItemVenda;
import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Tampelini
 */
public class DaoItemVenda {
      private Connection con;

    public DaoItemVenda() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Metodo que cadastra Itens
    public void cadastraItem(ItemVenda obj){
        
           try {

            String sql = "insert into tb_itensvendas (venda_id, produto_id,qtd,subtotal) values (?,?,?,?)";
          
            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getVenda().getId());
            stmt.setInt(2, obj.getProduto().getId());;
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());

            stmt.execute();
            stmt.close();

           

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro : " + erro);

        }
        
        
    }
    
    //Metodo que lista Itens de uma venda por id

    public List<ItemVenda> listaItensPorVenda(int venda_id) {
        
        List<ItemVenda> lista = new ArrayList<>();
//        select p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i
//inner join tb_produtos as p on(i.produto_id = p.id) where i.venda_id =10; 
        try {
            String query = "select p.descricao, i.qtd, p.preco, i.subtotal from tb_itensvendas as i "
                                 + " inner join tb_produtos as p on(i.produto_id = p.id) where i.venda_id = ? ";
       
            PreparedStatement ps = con.prepareStatement(query);         
            ps.setInt(1, venda_id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ItemVenda item = new ItemVenda();
                Produto prod = new Produto();
                
                 prod.setDescricao(rs.getString("p.descricao"));
                 item.setQtd(rs.getInt("i.qtd"));
                 prod.setPreco(rs.getDouble("p.preco"));
                 item.setSubtotal(rs.getDouble("i.subtotal"));
                
                 item.setProduto(prod);         
              
                
                lista.add(item);
            }
            return lista;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
}
