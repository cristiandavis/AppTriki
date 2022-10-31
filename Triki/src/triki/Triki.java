package triki;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
  ┣▇▇▇═─ X,O,X
 */
public class Triki extends javax.swing.JFrame implements ActionListener {

    JButton tablero[][];
    int TableroNros[][];
    int turno = 1;

    /**
     * Crear
     */
    public Triki() {
        initComponents();
        inicializarTablero();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Triki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Triki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Triki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Triki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Triki().setVisible(true);
            }
        });
    }

    // Variables 
    // 
   // tablero para crear el triki
    private void inicializarTablero() {
        this.setTitle("Triki Manuela Beltran :)");
        this.setLayout(new GridLayout(3, 3));
        this.tablero = new JButton[3][3];
        TableroNros = new int[3][3];
        for (int fila = 0; fila < 3; fila++) {
            for (int col = 0; col < 3; col++) {
                tablero[fila][col] = new JButton(); 
                tablero[fila][col].setSize(90, 90);
                tablero[fila][col].setEnabled(true);
                tablero[fila][col].setFont(new Font("Verdana", Font.BOLD, 48));
                tablero[fila][col].setName(fila + "-" + col);
                tablero[fila][col].addActionListener(this);
                this.add(tablero[fila][col]);
                TableroNros[fila][col] = 7;
            }
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton aux = (JButton) e.getSource();
        String coordenadas = " ";
        int fila, columna;
        coordenadas = aux.getName();
        fila = Integer.parseInt(String.valueOf(coordenadas.charAt(0)));
        columna = Integer.parseInt(String.valueOf(coordenadas.charAt(2)));
        System.out.println("Action command " + aux.getName());
        if (turno == 1) {  // debo modificar la posiciÃ³n del boton dentro de mi matriz numerica
            aux.setText("X");
            aux.setEnabled(false);
            TableroNros[fila][columna] = 1;
            turno = 0;
        } else { // debo modificar la posiciÃ³n del boton dentro de mi matriz numerica
            aux.setText("O");
            aux.setEnabled(false);
            TableroNros[fila][columna] = 0;
            turno = 1;
        }
        //Despues de cada jugada se debe validar si hay ganador analizando cada una de las filas
        for (int i = 0; i < 3; i++) {
            if  (TableroNros[i][0] !=7 &&(TableroNros[i][0] == TableroNros[i][1]) && (TableroNros[i][0] == TableroNros[i][2])) {
                JOptionPane.showMessageDialog(null, "Gano el jugador: " + TableroNros[i][0]);
                  System.exit(0);
            }
        }

        //Despues de cada jugada se debe validar si hay ganador analizando cada una de las columnas
        for (int c = 0; c < 3; c++) {
            if (TableroNros[0][c] !=7 &&((TableroNros[0][c] == TableroNros[1][c]) && (TableroNros[0][c] == TableroNros[2][c]))){
                JOptionPane.showMessageDialog(null, "Gano el jugador: " + TableroNros[0][c]);
                System.exit(0);
            }
        }
        //Despues de cada jugada se debe validar si hay ganador analizando cada una de las diagonales
        if (TableroNros[0][0] !=7 && ((TableroNros[0][0]==TableroNros[1][1])&&(TableroNros[0][0]==TableroNros[2][2]))){
            JOptionPane.showMessageDialog(null, "Gano el jugador: " + TableroNros[0][0]);
              System.exit(0);
        }      
        if  (TableroNros[0][2] !=7 &&(TableroNros[0][2]==TableroNros[1][1])&&(TableroNros[0][2]==TableroNros[2][0])){
            JOptionPane.showMessageDialog(null, "Gano el jugador: " + TableroNros[1][1]); 
              System.exit(0);
        }     
    }
}
 