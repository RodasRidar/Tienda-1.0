package cibertec;



import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarCantidadOptimaColchonesVendidos extends JDialog implements ActionListener {
	private JTextField txtCantidadColchonesVendidos;
	private JLabel lblCantidadColchonesVendidos;
	private JButton btnNewButton;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarCantidadOptimaColchonesVendidos dialog = new ConfigurarCantidadOptimaColchonesVendidos();
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
	public ConfigurarCantidadOptimaColchonesVendidos() {
		setTitle("Configurar cantidad optima de colchones vendidos");
		setBounds(100, 100, 505, 150);
		getContentPane().setLayout(null);
		{
			lblCantidadColchonesVendidos = new JLabel("Cantidad \u00F3ptima de colchones vendidos:");
			lblCantidadColchonesVendidos.setBounds(10, 11, 218, 14);
			getContentPane().add(lblCantidadColchonesVendidos);
		
			txtCantidadColchonesVendidos = new JTextField();
			txtCantidadColchonesVendidos.setBounds(221, 8, 53, 20);
			getContentPane().add(txtCantidadColchonesVendidos);
			txtCantidadColchonesVendidos.setColumns(10);
		
			btnNewButton = new JButton("Aceptar");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(390, 7, 89, 23);
			getContentPane().add(btnNewButton);
		
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(390, 33, 89, 23);
			getContentPane().add(btnCancelar);
			txtCantidadColchonesVendidos.setText(Tienda.cantidadOptima+"");
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		int can;
		can=getCantidadOptima();
		Tienda.cantidadOptima=can;
		dispose();
	}
	int getCantidadOptima(){
		return Integer.parseInt(txtCantidadColchonesVendidos.getText());
	}
}
