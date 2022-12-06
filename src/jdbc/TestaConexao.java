
package jdbc;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Tampelini
 */
public class TestaConexao {
    
     public static void main(String[] args) {
        
         try {
             
             ConnectionFactory aux = new ConnectionFactory();
             aux.getConnection();
             
             // caso sucesso
             JOptionPane.showMessageDialog(null, "Conectado com sucesso!");             
         } catch (HeadlessException erro) {
             
             // caso erro
              JOptionPane.showMessageDialog(null, "Ops aconteceu o erro: "  + erro);    
         }
         
         
     }
    
}
