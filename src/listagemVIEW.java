import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class listagemVIEW extends javax.swing.JFrame {

    public listagemVIEW() {
        initComponents();
        listarProdutos();
    }

    private void listarProdutos() {
        try {
            ProdutosDAO produtosdao = new ProdutosDAO();
            DefaultTableModel model = (DefaultTableModel) tabelaProdutos.getModel();
            model.setNumRows(0);

            ArrayList<ProdutosDTO> listagem = produtosdao.listarProdutos();
            for (ProdutosDTO produto : listagem) {
                model.addRow(new Object[] {
                        produto.getId(),
                        produto.getNome(),
                        produto.getValor(),
                        produto.getStatus()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "ID", "Nome", "Valor", "Status" }));
        jScrollPane1.setViewportView(tabelaProdutos);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabel1.setText("Listagem de Produtos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGap(50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(50, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(30)
                        .addComponent(jLabel1)
                        .addGap(20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE));

        pack();
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaProdutos;
}
