import javax.swing.JOptionPane;

public class cadastroVIEW extends javax.swing.JFrame {

    public cadastroVIEW() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jLabel1.setText("Cadastro de Produtos");

        jLabel2.setText("Nome:");

        jLabel3.setText("Valor:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar Produtos");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        // Layout simples
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSalvar)
                    .addComponent(btnListar))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(30)
                .addComponent(jLabel1)
                .addGap(30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addComponent(btnSalvar)
                .addGap(20)
                .addComponent(btnListar)
                .addContainerGap(30, Short.MAX_VALUE));

        pack();
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String nome = txtNome.getText();
            int valor = Integer.parseInt(txtValor.getText());
            String status = "A Venda";

            ProdutosDTO produto = new ProdutosDTO();
            produto.setNome(nome);
            produto.setValor(valor);
            produto.setStatus(status);

            ProdutosDAO produtosDAO = new ProdutosDAO();
            produtosDAO.cadastrarProduto(produto);

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            txtNome.setText("");
            txtValor.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor inválido!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {
        listagemVIEW listagem = new listagemVIEW();
        listagem.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new cadastroVIEW().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValor;
}
