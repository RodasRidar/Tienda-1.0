package cibertec;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfiguracionPremioSorpresa extends JDialog implements ActionListener {
	private JTextField txtNumeroCliente;
	private JTextField txtPremioSorpresa;
	private JLabel lblNumeroCliente;
	private JLabel lblPremioSorpresa;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfiguracionPremioSorpresa dialog = new ConfiguracionPremioSorpresa();
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
	public ConfiguracionPremioSorpresa() {
		setTitle("Configuracion del premio sorpresa");
		setBounds(100, 100, 425, 156);
		getContentPane().setLayout(null);
		{
			lblNumeroCliente = new JLabel("N\u00FAmero de cliente:");
			lblNumeroCliente.setBounds(10, 11, 115, 14);
			getContentPane().add(lblNumeroCliente);
		
			lblPremioSorpresa = new JLabel("Premio Sorpresa:");
			lblPremioSorpresa.setBounds(10, 36, 97, 14);
			getContentPane().add(lblPremioSorpresa);
		
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(311, 7, 89, 23);
			getContentPane().add(btnAceptar);
		
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(311, 32, 89, 23);
			getContentPane().add(btnCancelar);
		
			txtNumeroCliente = new JTextField();
			txtNumeroCliente.setBounds(132, 8, 86, 20);
			getContentPane().add(txtNumeroCliente);
			txtNumeroCliente.setColumns(10);
		
			txtPremioSorpresa = new JTextField();
			txtPremioSorpresa.setColumns(10);
			txtPremioSorpresa.setBounds(132, 33, 86, 20);
			getContentPane().add(txtPremioSorpresa);
			txtNumeroCliente.setText(Tienda.numeroClienteSorpresa+"");
			txtPremioSorpresa.setText(Tienda.premioSorpresa+"");
			
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		int num;
		String pre;
		num=getNumeroCliente();
		pre=getPremioSorpresa();
		Tienda.numeroClienteSorpresa=num;
		Tienda.premioSorpresa=pre;
		dispose();
	}
	int getNumeroCliente(){
		return Integer.parseInt(txtNumeroCliente.getText());
	}
	String getPremioSorpresa(){
		return txtPremioSorpresa.getText();
	}
}
