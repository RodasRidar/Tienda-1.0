package cibertec;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarObsequio extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtObsequio;
	private JLabel lblCantidadColchones;
	private JLabel lblObsequio;
	private JTextField txtCantidadColchones;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfigurarObsequio dialog = new ConfigurarObsequio();
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
	public ConfigurarObsequio() {
		setTitle("Configurar obsequio");
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblCantidadColchones = new JLabel("Cantidad m\u00EDnima de colchones adquiridos");
			lblCantidadColchones.setBounds(10, 11, 224, 14);
			contentPanel.add(lblCantidadColchones);

			lblObsequio = new JLabel("Obsequio");
			lblObsequio.setBounds(10, 36, 82, 14);
			contentPanel.add(lblObsequio);

			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(335, 7, 89, 23);
			contentPanel.add(btnAceptar);

			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(335, 32, 89, 23);
			contentPanel.add(btnCancelar);
			txtCantidadColchones = new JTextField();
			txtCantidadColchones.setBounds(232, 8, 60, 20);
			contentPanel.add(txtCantidadColchones);
			txtCantidadColchones.setColumns(10);

			txtObsequio = new JTextField();
			txtObsequio.setColumns(10);
			txtObsequio.setBounds(232, 33, 60, 20);
			contentPanel.add(txtObsequio);
			txtObsequio.setText(Tienda.obsequio + "");
			txtCantidadColchones.setText(Tienda.cantidadMinimaObsequiable + "");
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
		try {
			int can;
			String obs;
			can = getCantidadMinimaObsequiable();
			obs = getObsequio();
			if (can < 0) {
				mensaje("Importe mínimo debe ser positivo o cero");
				enfocarCaja(txtCantidadColchones);
			}
			else if (obs.length() == 0) {
				mensaje("Obsequio no puede estar vacio");
				enfocarCaja(txtObsequio);
			}
			else {
				Tienda.cantidadMinimaObsequiable = can;
				Tienda.obsequio = obs;
				dispose();
			}
		}
		catch (Exception e2) {
			mensaje("Importe mínimo debe ser número");
			enfocarCaja(txtCantidadColchones);
		}
	}

	void enfocarCaja(JTextField t) {
		t.requestFocus();
		t.selectAll();
	}

	void mensaje(String men) {
		JOptionPane.showMessageDialog(this, men);
	}

	int getCantidadMinimaObsequiable() {
		return Integer.parseInt(txtCantidadColchones.getText());
	}

	String getObsequio() {
		return txtObsequio.getText();
	}
}
