package org.ciberfarma.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmManteUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txtusuario;
	private JTextField txtclave;
	private JTextField txtfecha;
	private JTextField txttipo;
	private JTextField txtestado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteUsuario frame = new FrmManteUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANTENIMIENTO DE USUARIOS");
		lblNewLabel.setBounds(119, 11, 201, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo:");
		lblNewLabel_1.setBounds(10, 54, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(10, 79, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido:");
		lblNewLabel_3.setBounds(10, 102, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Usuario:");
		lblNewLabel_4.setBounds(10, 127, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Clave:");
		lblNewLabel_5.setBounds(10, 158, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha:");
		lblNewLabel_6.setBounds(10, 184, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tipo:");
		lblNewLabel_7.setBounds(10, 212, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Estado:");
		lblNewLabel_8.setBounds(10, 237, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(59, 50, 103, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(59, 76, 152, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtapellido = new JTextField();
		txtapellido.setBounds(59, 99, 152, 20);
		contentPane.add(txtapellido);
		txtapellido.setColumns(10);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(59, 124, 86, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		txtclave = new JTextField();
		txtclave.setBounds(59, 152, 86, 20);
		contentPane.add(txtclave);
		txtclave.setColumns(10);
		
		txtfecha = new JTextField();
		txtfecha.setBounds(59, 181, 86, 20);
		contentPane.add(txtfecha);
		txtfecha.setColumns(10);
		
		txttipo = new JTextField();
		txttipo.setBounds(59, 209, 86, 20);
		contentPane.add(txttipo);
		txttipo.setColumns(10);
		
		txtestado = new JTextField();
		txtestado.setBounds(59, 234, 86, 20);
		contentPane.add(txtestado);
		txtestado.setColumns(10);
		
		JButton btnregistrar = new JButton("Registrar");
		btnregistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnregistrar.setBounds(304, 50, 89, 23);
		contentPane.add(btnregistrar);
		
		JButton btnactualizar = new JButton("Actualizar");
		btnactualizar.setBounds(304, 98, 89, 23);
		contentPane.add(btnactualizar);
		
		JButton btnborrar = new JButton("Borrar");
		btnborrar.setBounds(304, 154, 89, 23);
		contentPane.add(btnborrar);
		
		JButton btnconsultar = new JButton("Consultar");
		btnconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			consultar();
			}
		});
		btnconsultar.setBounds(304, 208, 89, 23);
		contentPane.add(btnconsultar);
	}
	
	void consultar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		//consulta
      
		Usuario u = em.find(Usuario.class,Integer.parseInt(txtcodigo.getText()));
if (u != null) {
	txtnombre.setText(u.getNombre());
	txtapellido.setText(u.getApellido());
	
} else {
	JOptionPane.showMessageDialog(this, "Usuario con codigo  NO  existe");

}
		
        em.close();
		fabrica.close();
		
	}
	void registrar() {
		
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
				EntityManager em = fabrica.createEntityManager();
				
				Usuario u = new Usuario();
				//u.setCodigo(6);
				u.setNombre(txtnombre.getText());
				u.setApellido(txtapellido.getText());
				u.setUsuario(txtusuario.getText());
				u.setClave(txtclave.getText());
				u.setFnacim(txtfecha.getText());
				u.setTipo(Integer.parseInt(txttipo.getText()));
				u.setEstado(Integer.parseInt(txtestado.getText()));
				
				// 3. empezar mi transacci�n
				em.getTransaction().begin();
				// proceso a realizar (persistencia)
				//em.persist(u);
				em.merge(u);
				// 4. confirmar la transacci�n
				em.getTransaction().commit();
				
				//cerrar
				
				em.close();
				fabrica.close();
	}
}
