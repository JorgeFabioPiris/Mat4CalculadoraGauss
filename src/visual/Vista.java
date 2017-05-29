/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import metodos.GaussSimpleCalculos;
import metodos.GaussUtilidades;

/**
 *
 * @author Jorge Fabio
 */
public class Vista extends JFrame implements MouseListener, MouseMotionListener {

    public static TextField txtX00;
    public static TextField txtX01;
    public static TextField txtX02;
    public static TextField txtX03;
    public static TextField txtX10;
    public static TextField txtX11;
    public static TextField txtX12;
    public static TextField txtX13;
    public static TextField txtX20;
    public static TextField txtX21;
    public static TextField txtX22;
    public static TextField txtX23;
    public static TextField txtResult1;
    public static TextField txtResult2;
    public static TextField txtResult3;
    private static JScrollPane scrollPane;
    public static JTextArea ResultadosMatrices;
    private static Button btn1;
    private static Button btn2;
    private static Button btn3;

    private final Font LABEL_FONT = new Font("Agency FB", Font.PLAIN, 24);
    private final Color LABEL_COLOR = new Color(214, 214, 212);

    private Point initialClick;//para el movimiento

    /**
     * Constructor de clase
     */
    public Vista() {
        Vista.this.setUndecorated(true);
        initComponents();
        Vista.this.setLocationRelativeTo(null);
        Vista.this.addMouseListener(Vista.this);
        Vista.this.addMouseMotionListener(Vista.this);
    }

    private void initComponents() {
        setResizable(false);
        Vista.this.setBackground(new Color(0, 0, 0, 0));//transparencia total

        Panel panel = new Panel();
        panel.setLayout(null);

        //objetos que forman la interfaz
        JLabel lblGrupo = new JLabel("Por Adriana Arrua, Eduardo Espinola, Gabriel Arrua y Jorge Fabio");
        lblGrupo.setFont(LABEL_FONT);
        lblGrupo.setBounds(30, 5, 800, 32);
        lblGrupo.setForeground(Color.RED);

        JLabel lblTitle = new JLabel("CALCULADORA DE SISTEMA DE ECUACIONES LINEALES METODO DE GAUSS SIMPLE");
        lblTitle.setFont(LABEL_FONT);
        lblTitle.setBounds(50, 40, 800, 32);
        lblTitle.setForeground(LABEL_COLOR);

        JLabel lblResult = new JLabel("RESULTADOS");
        lblResult.setFont(LABEL_FONT);
        lblResult.setBounds(50, 260, 800, 32);
        lblResult.setForeground(LABEL_COLOR);

        //Primera fila
        txtX00 = new TextField();
        txtX00.setBounds(80, 80, 100, 36);
        txtX00.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.moverConEnter(evt, txtX01);
            }
        });
        txtX00.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtX00.selectAll();
            }
        });

        txtX01 = new TextField();
        txtX01.setBounds(225, 80, 100, 36);
        txtX01.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.moverConEnter(evt, txtX02);
            }
        });
        txtX01.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtX01.selectAll();
            }
        });

        txtX02 = new TextField();
        txtX02.setBounds(370, 80, 100, 36);
        txtX02.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.moverConEnter(evt, txtX03);
            }
        });
        txtX02.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtX02.selectAll();
            }
        });

        txtX03 = new TextField();
        txtX03.setBounds(515, 80, 100, 36);
        txtX03.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.moverConEnter(evt, txtX10);
            }
        });
        txtX03.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtX03.selectAll();
            }
        });

        //Segunda fila
        txtX10 = new TextField();
        txtX10.setBounds(80, 130, 100, 36);
        txtX10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.moverConEnter(evt, txtX11);
            }
        });
        txtX10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtX10.selectAll();
            }
        });

        txtX11 = new TextField();
        txtX11.setBounds(225, 130, 100, 36);
        txtX11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.moverConEnter(evt, txtX12);
            }
        });
        txtX11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtX11.selectAll();
            }
        });

        txtX12 = new TextField();
        txtX12.setBounds(370, 130, 100, 36);
        txtX12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.moverConEnter(evt, txtX13);
            }
        });
        txtX12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtX12.selectAll();
            }
        });

        txtX13 = new TextField();
        txtX13.setBounds(515, 130, 100, 36);
        txtX13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.moverConEnter(evt, txtX20);
            }
        });
        txtX13.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtX13.selectAll();
            }
        });

        //Tercera fila
        txtX20 = new TextField();
        txtX20.setBounds(80, 180, 100, 36);
        txtX20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.moverConEnter(evt, txtX21);
            }
        });
        txtX20.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtX20.selectAll();
            }
        });

        txtX21 = new TextField();
        txtX21.setBounds(225, 180, 100, 36);
        txtX21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.moverConEnter(evt, txtX22);
            }
        });
        txtX21.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtX21.selectAll();
            }
        });

        txtX22 = new TextField();
        txtX22.setBounds(370, 180, 100, 36);
        txtX22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.moverConEnter(evt, txtX23);
            }
        });
        txtX22.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtX22.selectAll();
            }
        });

        txtX23 = new TextField();
        txtX23.setBounds(515, 180, 100, 36);
        txtX23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.moverConEnter(evt, btn1);
            }
        });
        txtX23.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtX23.selectAll();
            }
        });

        //Primera fila
        JLabel lblX1 = new JLabel("x1 + ");
        lblX1.setFont(LABEL_FONT);
        lblX1.setBounds(185, 80, 340, 32);
        lblX1.setForeground(LABEL_COLOR);

        JLabel lblX2 = new JLabel("y1 + ");
        lblX2.setFont(LABEL_FONT);
        lblX2.setBounds(330, 80, 340, 32);
        lblX2.setForeground(LABEL_COLOR);

        JLabel lblX3 = new JLabel("z1 = ");
        lblX3.setFont(LABEL_FONT);
        lblX3.setBounds(475, 80, 340, 32);
        lblX3.setForeground(LABEL_COLOR);

        //segunda fila
        JLabel lblX11 = new JLabel("x2 + ");
        lblX11.setFont(LABEL_FONT);
        lblX11.setBounds(185, 130, 340, 32);
        lblX11.setForeground(LABEL_COLOR);

        JLabel lblX12 = new JLabel("y2 + ");
        lblX12.setFont(LABEL_FONT);
        lblX12.setBounds(330, 130, 340, 32);
        lblX12.setForeground(LABEL_COLOR);

        JLabel lblX13 = new JLabel("z2 = ");
        lblX13.setFont(LABEL_FONT);
        lblX13.setBounds(475, 130, 340, 32);
        lblX13.setForeground(LABEL_COLOR);

        //Tercera fila
        JLabel lblX21 = new JLabel("x3 + ");
        lblX21.setFont(LABEL_FONT);
        lblX21.setBounds(185, 180, 340, 32);
        lblX21.setForeground(LABEL_COLOR);

        JLabel lblX22 = new JLabel("y3 + ");
        lblX22.setFont(LABEL_FONT);
        lblX22.setBounds(330, 180, 340, 32);
        lblX22.setForeground(LABEL_COLOR);

        JLabel lblX23 = new JLabel("z3 = ");
        lblX23.setFont(LABEL_FONT);
        lblX23.setBounds(475, 180, 340, 32);
        lblX23.setForeground(LABEL_COLOR);

        //resultados
        txtResult1 = new TextField();
        txtResult1.setBounds(110, 575, 100, 36);
        txtResult1.setEditable(false);

        txtResult2 = new TextField();
        txtResult2.setBounds(270, 575, 100, 36);
        txtResult2.setEditable(false);

        txtResult3 = new TextField();
        txtResult3.setBounds(425, 575, 100, 36);
        txtResult3.setEditable(false);

        JLabel lblResult1 = new JLabel("X = ");
        lblResult1.setFont(LABEL_FONT);
        lblResult1.setBounds(80, 575, 340, 32);
        lblResult1.setForeground(LABEL_COLOR);

        JLabel lblResult2 = new JLabel("Y = ");
        lblResult2.setFont(LABEL_FONT);
        lblResult2.setBounds(235, 575, 340, 32);
        lblResult2.setForeground(LABEL_COLOR);

        JLabel lblResult3 = new JLabel("Z = ");
        lblResult3.setFont(LABEL_FONT);
        lblResult3.setBounds(395, 575, 340, 32);
        lblResult3.setForeground(LABEL_COLOR);

        //botones
        btn1 = new Button();
        btn1.setText("CALCULAR");
        btn1.setBounds(80, 630, 120, 36);
        btn1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.hacerClicConEnter(evt, btn1);
            }
        });

        btn2 = new Button();
        btn2.setText("LIMPIAR");
        btn2.setBounds(210, 630, 120, 36);
        btn2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.hacerClicConEnter(evt, btn2);
            }
        });

        btn3 = new Button();
        btn3.setText("SALIR");
        btn3.setBounds(340, 630, 120, 36);
        btn3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GaussUtilidades.hacerClicConEnter(evt, btn3);
            }
        });

        //Area de texto
        ResultadosMatrices = new JTextArea();
        ResultadosMatrices.setFont(LABEL_FONT);
        scrollPane = new JScrollPane();
        scrollPane.setBounds(80, 300, 530, 250);
        scrollPane.setViewportView(ResultadosMatrices);

        //listener        
        btn1.addActionListener((ActionEvent e) -> {
            GaussSimpleCalculos.calcular();
        });//btn1

        btn2.addActionListener((ActionEvent e) -> {
            GaussUtilidades.limpiar();
        });//btn2

        btn3.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });//btn3

        //se añade todo 
        panel.add(lblGrupo);
        panel.add(lblTitle);
        panel.add(lblResult);
        panel.add(txtX00);
        panel.add(txtX01);
        panel.add(txtX02);
        panel.add(txtX03);
        panel.add(txtX10);
        panel.add(txtX11);
        panel.add(txtX12);
        panel.add(txtX13);
        panel.add(txtX20);
        panel.add(txtX21);
        panel.add(txtX22);
        panel.add(txtX23);
        panel.add(lblX1);
        panel.add(lblX2);
        panel.add(lblX3);
        panel.add(lblX11);
        panel.add(lblX12);
        panel.add(lblX13);
        panel.add(lblX21);
        panel.add(lblX22);
        panel.add(lblX23);
        panel.add(txtResult1);
        panel.add(txtResult2);
        panel.add(txtResult3);
        panel.add(lblResult1);
        panel.add(lblResult2);
        panel.add(lblResult3);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(scrollPane);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        pack();
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new Vista().setVisible(true);
        });
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //obtiene posicion de la ventana
        int thisX = getLocation().x;
        int thisY = getLocation().y;

        //determina el desplazamiento
        int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
        int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

        //mueve la ventana a su nueva posicion
        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        this.setLocation(X, Y);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setCursor(new Cursor(Cursor.MOVE_CURSOR));
        initialClick = e.getPoint();
        getComponentAt(initialClick);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
