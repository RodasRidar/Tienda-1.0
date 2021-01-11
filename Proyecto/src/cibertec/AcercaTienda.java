package cibertec;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcercaTienda extends JDialog implements ActionListener {
	private JLabel lblTienda;
	private JSeparator separator;
	private JLabel lblAutores;
	private JLabel lblNewLabel_1;
	private JLabel lblMoissAldairGolzales;
	private JLabel lblGabriela;
	private JLabel lblGleydi;
	private JLabel lblSebastian;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AcercaTienda dialog = new AcercaTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AcercaTienda() {
		setTitle("Acerca de tienda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(172, 227, 89, 23);
			getContentPane().add(btnCerrar);
		}

		lblTienda = new JLabel("Tienda 1.0");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTienda.setBounds(168, 24, 97, 14);
		getContentPane().add(lblTienda);

		separator = new JSeparator();
		separator.setBounds(10, 55, 414, 2);
		getContentPane().add(separator);

		lblAutores = new JLabel("Autor:");
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutores.setBounds(187, 68, 60, 14);
		getContentPane().add(lblAutores);

		lblNewLabel_1 = new JLabel("Richard Saul Rodas Pita");
		lblNewLabel_1.setBounds(147, 134, 153, 14);
		getContentPane().add(lblNewLabel_1);
	}

		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
