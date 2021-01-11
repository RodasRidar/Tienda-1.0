package cibertec;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfiguracionDescuento extends JDialog implements ActionListener {
	private JTextField txt1to5unidades;
	private JTextField txt6to10unidades;
	private JTextField txt11to15unidades;
	private JTextField txtMoreto15unidades;
	private JLabel porcentaje2;
	private JLabel porcentaje3;
	private JLabel porcentaje4;
	private JLabel lbl1to5unidades;
	private JLabel lbl5to10unidades;
	private JLabel lbl11to15unidades;
	private JLabel lblMoreto15unidades;
	private JLabel porcentaje1;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConfiguracionDescuento dialog = new ConfiguracionDescuento();
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
	public ConfiguracionDescuento() {
		setTitle("Configuraci\u00F3n porcentaje de descuento");
		setBounds(100, 100, 453, 181);
		getContentPane().setLayout(null);
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(this);
			btnAceptar.setBounds(335, 11, 89, 23);
			getContentPane().add(btnAceptar);

			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(335, 45, 89, 23);
			getContentPane().add(btnCancelar);

			lbl1to5unidades = new JLabel("1 a 5 unidades");
			lbl1to5unidades.setBounds(10, 15, 82, 14);
			getContentPane().add(lbl1to5unidades);

			lbl5to10unidades = new JLabel("6 a 10 unidades");
			lbl5to10unidades.setBounds(10, 40, 82, 14);
			getContentPane().add(lbl5to10unidades);

			lbl11to15unidades = new JLabel("11 a 15 unidades");
			lbl11to15unidades.setBounds(10, 65, 82, 14);
			getContentPane().add(lbl11to15unidades);

			lblMoreto15unidades = new JLabel("M\u00E1s de 15 unidades");
			lblMoreto15unidades.setBounds(10, 90, 105, 17);
			getContentPane().add(lblMoreto15unidades);

			txt1to5unidades = new JTextField();
			txt1to5unidades.setBounds(115, 12, 64, 20);
			getContentPane().add(txt1to5unidades);
			txt1to5unidades.setColumns(10);

			txt6to10unidades = new JTextField();
			txt6to10unidades.setColumns(10);
			txt6to10unidades.setBounds(115, 37, 64, 20);
			getContentPane().add(txt6to10unidades);

			txt11to15unidades = new JTextField();
			txt11to15unidades.setColumns(10);
			txt11to15unidades.setBounds(115, 62, 64, 20);
			getContentPane().add(txt11to15unidades);
			txtMoreto15unidades = new JTextField();
			txtMoreto15unidades.setColumns(10);
			txtMoreto15unidades.setBounds(115, 87, 63, 20);
			getContentPane().add(txtMoreto15unidades);

			porcentaje1 = new JLabel("%");
			porcentaje1.setBounds(189, 15, 46, 14);
			getContentPane().add(porcentaje1);

		}

		porcentaje2 = new JLabel("%");
		porcentaje2.setBounds(189, 40, 46, 14);
		getContentPane().add(porcentaje2);

		porcentaje3 = new JLabel("%");
		porcentaje3.setBounds(189, 65, 46, 14);
		getContentPane().add(porcentaje3);

		porcentaje4 = new JLabel("%");
		porcentaje4.setBounds(188, 91, 46, 14);
		getContentPane().add(porcentaje4);
		txt1to5unidades.setText(Tienda.porcentaje1+"");
		txt6to10unidades.setText(Tienda.porcentaje2+"");
		txt11to15unidades.setText(Tienda.porcentaje3+"");
		txtMoreto15unidades.setText(Tienda.porcentaje4+"");
		
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
			double por1,por2,por3,por4;
		    por1 = getPorcentaje1();
			por2 = getPorcentaje2();
			por3 = getPorcentaje3();
			por4 = getPorcentaje4();
			Tienda.porcentaje1=por1;
			Tienda.porcentaje2=por2;
			Tienda.porcentaje3=por3;
			Tienda.porcentaje4=por4;
			dispose();
	}
	double getPorcentaje1(){
		return Double.parseDouble(txt1to5unidades.getText());
	}
	double getPorcentaje2(){
		return Double.parseDouble(txt6to10unidades.getText());
	}
	double getPorcentaje3(){
		return Double.parseDouble(txt11to15unidades.getText());
	}
	double getPorcentaje4(){
		return Double.parseDouble(txtMoreto15unidades.getText());
	}
}
