/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrabbleedd;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.*;
import java.net.URL;
import java.util.Random;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author KMMG
 */
public class Juego extends javax.swing.JFrame {

    
    Jugadores j;
    Dobles fdb;
    Triples ftp;
    Diccionario ddd;
    String fdim;
    ColaLetras fcl;
    Usuario jugadorenturno;
    Usuario ultimoplayer;
    int v1;
    int v2;
    int v3;
    int v4;
    int v5;
    int v6;
    int v7;
    int id1;
    int id2;
    int id3;
    int id4;
    int id5;
    int id6;
    int id7;
    
    
    public Juego(Jugadores jj, Dobles db, Triples tp, Diccionario dd, String dim) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        j=jj;
        fdb=db;
        ftp=tp;
        ddd=dd;
        fdim=dim;
        fcl = new ColaLetras();
        jugadorenturno=j.inicio;
        ultimoplayer=j.fin;
        lblturno.setText(jugadorenturno.nombre);
        cb1.setText(null);
        cb2.setText(null);
        cb3.setText(null);
        cb4.setText(null);
        cb5.setText(null);
        cb6.setText(null);
        cb7.setText(null);
        
        pintarTodas();
        llenarColaLetras();
        agregarFichas();
        cargarCheckBoxs();
        //JOptionPane.showMessageDialog(null, "Se lleno la cola de letras.");
         Timer timer = new Timer (1000, new ActionListener ()
        {
            public void actionPerformed(ActionEvent e)
            {
                pintarTodas();
                
                //pintarTodas();
             }
        });

        timer.start();
        
        
        
    }
    private void pintarTodas(){
        try{
                               	
	            j.escribirArchivo();
	            generarImagen("C:\\Users\\KMMG\\Desktop\\usuarios.dot","C:\\Users\\KMMG\\Desktop\\usuarios.png");
                    ImageIcon image = new ImageIcon("C:\\Users\\KMMG\\Desktop\\usuarios.png");
                    Icon icono = new ImageIcon(image.getImage().
                    getScaledInstance(image.getIconWidth(), image.getIconHeight(), 
                    Image.SCALE_DEFAULT));

                    jLabel2.setText(null);

                    jLabel2.setIcon( icono ); 
                    
                    
                    
                    ddd.escribirArchivo();
	            generarImagen("C:\\Users\\KMMG\\Desktop\\diccionario.dot","C:\\Users\\KMMG\\Desktop\\diccionario.png");
                    ImageIcon image2 = new ImageIcon("C:\\Users\\KMMG\\Desktop\\diccionario.png");  
                    Icon icono2 = new ImageIcon(image2.getImage().
                    getScaledInstance(image2.getIconWidth(), image2.getIconHeight(), 
                    Image.SCALE_DEFAULT));

                    jLabel1.setText(null);

                    jLabel1.setIcon( icono2 );
                    
                    fcl.escribirArchivo();
	            generarImagen("C:\\Users\\KMMG\\Desktop\\colaletras.dot","C:\\Users\\KMMG\\Desktop\\colaletras.png");
                    ImageIcon image3 = new ImageIcon("C:\\Users\\KMMG\\Desktop\\colaletras.png");  
                    Icon icono3 = new ImageIcon(image3.getImage().
                    getScaledInstance(image3.getIconWidth(), image3.getIconHeight(), 
                    Image.SCALE_DEFAULT));

                    jLabel3.setText(null);

                    jLabel3.setIcon( icono3 );
                    
                    Usuario enTurno= j.buscarJugadorConcreto(lblturno.getText());
                    if(enTurno!=null){
                        enTurno.escribirArchivo();
                        generarImagen("C:\\Users\\KMMG\\Desktop\\userfichas.dot","C:\\Users\\KMMG\\Desktop\\userfichas.png");
                        ImageIcon image4 = new ImageIcon("C:\\Users\\KMMG\\Desktop\\userfichas.png");  
                        Icon icono4 = new ImageIcon(image4.getImage().
                        getScaledInstance(image4.getIconWidth(), image4.getIconHeight(), 
                        Image.SCALE_DEFAULT));

                        jLabel4.setText(null);

                        jLabel4.setIcon( icono4 );
                    }
                    
                        
	        }catch(Exception ee){
	            	System.out.println("Error en al pintarTodas ");
                        ee.printStackTrace();
	        }
    }
    
    public void generarImagen( String direccionDot, String direccionPng ){
		try
		{       
			ProcessBuilder pbuilder;
		    
			pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", direccionPng, direccionDot );
			pbuilder.redirectErrorStream( true );
			//Ejecuta el proceso
			pbuilder.start();
		    
		} catch (Exception e) { e.printStackTrace(); }
    }

    private void llenarColaLetras(){
        
        Random rnd = new Random();
        while(fcl.tam!=95){
            int i = (int) (rnd.nextDouble() * 95+ 1);
            boolean existe=fcl.buscarExistencia(i);
            if (!existe){
                switch (i){
                case 1:
                    fcl.agregar(i, "A", 1);
                    break;
                case 2:
                    fcl.agregar(i, "A", 1);
                    break;
                case 3:
                    fcl.agregar(i, "A", 1);
                    break;
                case 4:
                    fcl.agregar(i, "A", 1);
                    break;
                case 5:
                    fcl.agregar(i, "A", 1);
                    break;
                case 6:
                    fcl.agregar(i, "A", 1);
                    break;
                case 7:
                    fcl.agregar(i, "A", 1);
                    break;
                case 8:
                    fcl.agregar(i, "A", 1);
                    break;
                case 9:
                    fcl.agregar(i, "A", 1);
                    break;
                case 10:
                    fcl.agregar(i, "A", 1);
                    break;
                case 11:
                    fcl.agregar(i, "A", 1);
                    break;
                case 12:
                    fcl.agregar(i, "A", 1);
                    break;
                case 13:
                    fcl.agregar(i, "E", 1);
                    break;
                case 14:
                    fcl.agregar(i, "E", 1);
                    break;
                case 15:
                    fcl.agregar(i, "E", 1);
                    break;
                case 16:
                    fcl.agregar(i, "E", 1);
                    break;
                case 17:
                    fcl.agregar(i, "E", 1);
                    break;
                case 18:
                    fcl.agregar(i, "E", 1);
                    break;
                case 19:
                    fcl.agregar(i, "E", 1);
                    break;
                case 20:
                    fcl.agregar(i, "E", 1);
                    break;
                case 21:
                    fcl.agregar(i, "E", 1);
                    break;
                case 22:
                    fcl.agregar(i, "E", 1);
                    break;
                case 23:
                    fcl.agregar(i, "E", 1);
                    break;
                case 24:
                    fcl.agregar(i, "E", 1);
                    break;
                case 25:
                    fcl.agregar(i, "O", 1);
                    break;
                case 26:
                    fcl.agregar(i, "O", 1);
                    break;
                case 27:
                    fcl.agregar(i, "O", 1);
                    break;
                case 28:
                    fcl.agregar(i, "O", 1);
                    break;
                case 29:
                    fcl.agregar(i, "O", 1);
                    break;
                case 30:
                    fcl.agregar(i, "O", 1);
                    break;
                case 31:
                    fcl.agregar(i, "O", 1);
                    break;
                case 32:
                    fcl.agregar(i, "O", 1);
                    break;
                case 33:
                    fcl.agregar(i, "O", 1);
                    break;
                case 34:
                    fcl.agregar(i, "I", 1);
                    break;
                case 35:
                    fcl.agregar(i, "I", 1);
                    break;
                case 36:
                    fcl.agregar(i, "I", 1);
                    break;
                case 37:
                    fcl.agregar(i, "I", 1);
                    break;
                case 38:
                    fcl.agregar(i, "I", 1);
                    break;
                case 39:
                    fcl.agregar(i, "I", 1);
                    break;
                case 40:
                    fcl.agregar(i, "S", 1);
                    break;
                case 41:
                    fcl.agregar(i, "S", 1);
                    break;
                case 42:
                    fcl.agregar(i, "S", 1);
                    break;
                case 43:
                    fcl.agregar(i, "S", 1);
                    break;
                case 44:
                    fcl.agregar(i, "S", 1);
                    break;
                case 45:
                    fcl.agregar(i, "S", 1);
                    break;
                case 46:
                    fcl.agregar(i, "N", 1);
                    break;
                case 47:
                    fcl.agregar(i, "N", 1);
                    break;
                case 48:
                    fcl.agregar(i, "N", 1);
                    break;
                case 49:
                    fcl.agregar(i, "N", 1);
                    break;
                case 50:
                    fcl.agregar(i, "N", 1);
                    break;
                case 51:
                    fcl.agregar(i, "L", 1);
                    break;
                case 52:
                    fcl.agregar(i, "L", 1);
                    break;
                case 53:
                    fcl.agregar(i, "L", 1);
                    break;
                case 54:
                    fcl.agregar(i, "L", 1);
                    break;
                case 55:
                    fcl.agregar(i, "R", 1);
                    break;
                case 56:
                    fcl.agregar(i, "R", 1);
                    break;
                case 57:
                    fcl.agregar(i, "R", 1);
                    break;
                case 58:
                    fcl.agregar(i, "R", 1);
                    break;
                case 59:
                    fcl.agregar(i, "R", 1);
                    break;
                case 60:
                    fcl.agregar(i, "U", 1);
                    break;
                case 61:
                    fcl.agregar(i, "U", 1);
                    break;
                case 62:
                    fcl.agregar(i, "U", 1);
                    break;
                case 63:
                    fcl.agregar(i, "U", 1);
                    break;
                case 64:
                    fcl.agregar(i, "U", 1);
                    break;
                case 65:
                    fcl.agregar(i, "T", 1);
                    break;
                case 66:
                    fcl.agregar(i, "T", 1);
                    break;
                case 67:
                    fcl.agregar(i, "T", 1);
                    break;
                case 68:
                    fcl.agregar(i, "T", 1);
                    break;
                case 69:
                    fcl.agregar(i, "D", 2);
                    break;
                case 70:
                    fcl.agregar(i, "D", 2);
                    break;
                case 71:
                    fcl.agregar(i, "D", 2);
                    break;
                case 72:
                    fcl.agregar(i, "D", 2);
                    break;
                case 73:
                    fcl.agregar(i, "D", 2);
                    break;
                case 74:
                    fcl.agregar(i, "G", 2);
                    break;
                case 75:
                    fcl.agregar(i, "G", 2);
                    break;
                case 76:
                    fcl.agregar(i, "C", 3);
                    break;
                case 77:
                    fcl.agregar(i, "C", 3);
                    break;
                case 78:
                    fcl.agregar(i, "C", 3);
                    break;
                case 79:
                    fcl.agregar(i, "C", 3);
                    break;
                case 80:
                    fcl.agregar(i, "B", 3);
                    break;
                case 81:
                    fcl.agregar(i, "B", 3);
                    break;
                case 82:
                    fcl.agregar(i, "M", 3);
                    break;
                case 83:
                    fcl.agregar(i, "M", 3);
                    break;
                case 84:
                    fcl.agregar(i, "P", 3);
                    break;
                case 85:
                    fcl.agregar(i, "P", 3);
                    break;
                case 86:
                    fcl.agregar(i, "H", 4);
                    break;
                case 87:
                    fcl.agregar(i, "H", 4);
                    break;
                case 88:
                    fcl.agregar(i, "F", 4);
                    break;
                case 89:
                    fcl.agregar(i, "V", 4);
                    break;
                case 90:
                    fcl.agregar(i, "Y", 4);
                    break;
                case 91:
                    fcl.agregar(i, "Q", 5);
                    break;
                case 92:
                    fcl.agregar(i, "J", 8);
                    break;
                case 93:
                    fcl.agregar(i, "Ñ", 8);
                    break;
                case 94:
                    fcl.agregar(i, "X", 8);
                    break;
                case 95:
                    fcl.agregar(i, "Z", 10);
                    break;
                default:
                    System.out.println("NO SE GENERO UN VALIDO");
                }
            }
            
        }
    }
    
    private void agregarFichas(){
        Usuario tmp=jugadorenturno;
        while(tmp!=ultimoplayer){
            for(int i =0; i<7;i++){
                tmp.agregarLetra(fcl.expulsar());
            }
            tmp=tmp.siguiente;
        }
        for(int i =0; i<7;i++){
                tmp.agregarLetra(fcl.expulsar());
        }
    }
    private void cargarCheckBoxs(){
        Letra tmp=jugadorenturno.cabeza;
        int i =0;
        while(tmp!=null){
            
            switch(i){
                case 0:
                    cb1.setText(tmp.letra);
                    id1=tmp.id;
                    v1=tmp.valor;
                    break;
                case 1:
                    cb2.setText(tmp.letra);
                    id2=tmp.id;
                    v2=tmp.valor;
                    break;
                case 2:
                    cb3.setText(tmp.letra);
                    id3=tmp.id;
                    v3=tmp.valor;
                    break;
                case 3:
                    cb4.setText(tmp.letra);
                    id4=tmp.id;
                    v4=tmp.valor;
                    break;
                case 4:
                    cb5.setText(tmp.letra);
                    id5=tmp.id;
                    v5=tmp.valor;
                    break;
                case 5:
                    cb6.setText(tmp.letra);
                    id6=tmp.id;
                    v6=tmp.valor;
                    break;
                case 6:
                    cb7.setText(tmp.letra);
                    id7=tmp.id;
                    v7=tmp.valor;
                    break;
            }
            tmp=tmp.sig;
            i++;
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtnuevapal = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblturno = new javax.swing.JLabel();
        cb1 = new javax.swing.JCheckBox();
        cb2 = new javax.swing.JCheckBox();
        cb3 = new javax.swing.JCheckBox();
        cb4 = new javax.swing.JCheckBox();
        cb5 = new javax.swing.JCheckBox();
        cb6 = new javax.swing.JCheckBox();
        cb7 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Matriz Tablero", jPanel2);

        jLabel2.setText("jLabel2");
        jScrollPane1.setViewportView(jLabel2);

        jTabbedPane3.addTab("Lista Jugadores", jScrollPane1);

        jLabel1.setText("jLabel1");
        jScrollPane2.setViewportView(jLabel1);

        jTabbedPane3.addTab("Lista Diccionario", jScrollPane2);

        jLabel3.setText("jLabel3");
        jScrollPane3.setViewportView(jLabel3);

        jTabbedPane3.addTab("Cola Fichas", jScrollPane3);

        jLabel4.setText("jLabel4");
        jScrollPane4.setViewportView(jLabel4);

        jTabbedPane3.addTab("Fichas Activas", jScrollPane4);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Nueva Palabra:");

        btnAgregar.setText("Agregar Palabra");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel7.setText("Turno de:");

        lblturno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblturno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblturno.setText("JUGADOR 1");

        cb1.setText("jCheckBox1");

        cb2.setText("jCheckBox2");

        cb3.setText("jCheckBox3");

        cb4.setText("jCheckBox4");

        cb5.setText("jCheckBox5");

        cb6.setText("jCheckBox6");

        cb7.setText("jCheckBox7");

        jButton2.setText("Cambiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cb2)
                    .addComponent(cb1)
                    .addComponent(cb3)
                    .addComponent(cb4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb5)
                    .addComponent(cb6)
                    .addComponent(cb7))
                .addGap(21, 21, 21))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnuevapal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnAgregar))
                            .addComponent(lblturno, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblturno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnuevapal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb1)
                    .addComponent(cb5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb2)
                    .addComponent(cb6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb3)
                    .addComponent(cb7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb4)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(29, 29, 29))
        );

        jButton1.setText("Actualizar Labels");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tableroLayout = new javax.swing.GroupLayout(tablero);
        tablero.setLayout(tableroLayout);
        tableroLayout.setHorizontalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
        tableroLayout.setVerticalGroup(
            tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane3.getAccessibleContext().setAccessibleName("Paneles");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nueva = txtnuevapal.getText();
        ddd.agregar(nueva);
        txtnuevapal.setText("");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //--------------------------------------------------------------------------------------------------------------A
        jugadorenturno=jugadorenturno.siguiente;
        lblturno.setText(jugadorenturno.nombre);
        cargarCheckBoxs();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(cb1.isSelected()){
            Letra tmp = jugadorenturno.expulsar(id1);
            fcl.agregar(tmp.id, tmp.letra, tmp.valor);
            jugadorenturno.agregarLetra(fcl.expulsar());
        }
        if(cb2.isSelected()){
            Letra tmp = jugadorenturno.expulsar(id2);
            fcl.agregar(tmp.id, tmp.letra, tmp.valor);
            jugadorenturno.agregarLetra(fcl.expulsar());
        }
        if(cb3.isSelected()){
            Letra tmp = jugadorenturno.expulsar(id3);
            fcl.agregar(tmp.id, tmp.letra, tmp.valor);
            jugadorenturno.agregarLetra(fcl.expulsar());
        }
        if(cb4.isSelected()){
            Letra tmp = jugadorenturno.expulsar(id4);
            fcl.agregar(tmp.id, tmp.letra, tmp.valor);
            jugadorenturno.agregarLetra(fcl.expulsar());
        }
        if(cb5.isSelected()){
            Letra tmp = jugadorenturno.expulsar(id5);
            fcl.agregar(tmp.id, tmp.letra, tmp.valor);
            jugadorenturno.agregarLetra(fcl.expulsar());
        }
        if(cb6.isSelected()){
            Letra tmp = jugadorenturno.expulsar(id6);
            fcl.agregar(tmp.id, tmp.letra, tmp.valor);
            jugadorenturno.agregarLetra(fcl.expulsar());
        }
        if(cb7.isSelected()){
            Letra tmp = jugadorenturno.expulsar(id7);
            fcl.agregar(tmp.id, tmp.letra, tmp.valor);
            jugadorenturno.agregarLetra(fcl.expulsar());
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        jugadorenturno=jugadorenturno.siguiente;
        lblturno.setText(jugadorenturno.nombre);
        cargarCheckBoxs();
        
    }//GEN-LAST:event_jButton2ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JCheckBox cb1;
    private javax.swing.JCheckBox cb2;
    private javax.swing.JCheckBox cb3;
    private javax.swing.JCheckBox cb4;
    private javax.swing.JCheckBox cb5;
    private javax.swing.JCheckBox cb6;
    private javax.swing.JCheckBox cb7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lblturno;
    private javax.swing.JPanel tablero;
    private javax.swing.JTextField txtnuevapal;
    // End of variables declaration//GEN-END:variables
}
