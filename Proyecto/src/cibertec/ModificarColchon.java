package cibertec;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ModificarColchon extends JDialog implements ActionListener {

	private final JPanel Content = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtGarantia;
	private JTextField txtTama�o;
	private JTextField txtMaterial;
	private JComboBox<Object> cboMarca;
	private JLabel lblMarca;
	private JLabel lblPrecio;
	private JLabel lblGarantia;
	private JLabel lblTama�o;
	private JLabel lblMaterial;
	private JButton btnCerrar;
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			ModificarColchon dialog = new ModificarColchon();
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
	public ModificarColchon() {
		setTitle("Modificar colchon");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		Content.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(Content, BorderLayout.CENTER);
		Content.setLayout(null);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(134, 42, 115, 20);
		Content.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtGarantia = new JTextField();
		txtGarantia.setBounds(134, 73, 115, 20);
		Content.add(txtGarantia);
		txtGarantia.setColumns(10);

		txtTama�o = new JTextField();
		txtTama�o.setBounds(134, 104, 115, 20);
		Content.add(txtTama�o);
		txtTama�o.setColumns(10);

		txtMaterial = new JTextField();
		txtMaterial.setBounds(134, 135, 115, 20);
		Content.add(txtMaterial);
		txtMaterial.setColumns(10);

		cboMarca = new JComboBox<Object>();
		cboMarca.addActionListener(this);
		cboMarca.setModel(new DefaultComboBoxModel<Object>(new String[] { "Suavestar", "Springwall", "Paraiso", "Drimer", "Cisne" }));
		cboMarca.setBounds(134, 11, 115, 20);
		Content.add(cboMarca);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 14, 46, 14);
		Content.add(lblMarca);

		lblPrecio = new JLabel("Precio(S/)");
		lblPrecio.setBounds(10, 45, 57, 14);
		Content.add(lblPrecio);

		lblGarantia = new JLabel("Garantia)");
		lblGarantia.setBounds(10, 76, 75, 14);
		Content.add(lblGarantia);

		lblTama�o = new JLabel("Tama�o");
		lblTama�o.setBounds(10, 107, 46, 14);
		Content.add(lblTama�o);

		lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(10, 138, 46, 14);
		Content.add(lblMaterial);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(319, 10, 89, 23);
		Content.add(btnCerrar);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(319, 41, 89, 23);
		Content.add(btnGrabar);
		mostrarResultados(Tienda.precio0, Tienda.garantia0, Tienda.material0, Tienda.tama�o0);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboMarca) {
			actionPerformedCboMarca(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();

	}

	int mar;

	protected void actionPerformedCboMarca(ActionEvent arg0) {
		mar = getMarca0();

		switch (mar) {
			case 0:
				mostrarResultados(Tienda.precio0, Tienda.garantia0, Tienda.material0, Tienda.tama�o0);
				break;
			case 1:
				mostrarResultados(Tienda.precio1, Tienda.garantia1, Tienda.material1, Tienda.tama�o1);
				break;
			case 2:
				mostrarResultados(Tienda.precio2, Tienda.garantia2, Tienda.material2, Tienda.tama�o2);
				break;
			case 3:
				mostrarResultados(Tienda.precio3, Tienda.garantia3, Tienda.material3, Tienda.tama�o3);
				break;
			case 4:
				mostrarResultados(Tienda.precio4, Tienda.garantia4, Tienda.material4, Tienda.tama�o4);
				break;
		}
	}

	int getMarca0() {
		return cboMarca.getSelectedIndex();
	}

	void mostrarResultados(double pre, int gar, String mat, String tam) {
		txtPrecio.setText(pre + "");
		txtGarantia.setText(gar + "");
		txtMaterial.setText(mat + "");
		txtTama�o.setText(tam + "");
	}

	// Grabar
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		if (mar == 0) {

			Tienda.precio0 = getPrecio();
			Tienda.garantia0 = getGarantia();
			Tienda.tama�o0 = getTama�o();
			Tienda.material0 = getMaterial();
		}
		else if (mar == 1) {
			Tienda.precio1 = getPrecio();
			Tienda.garantia1 = getGarantia();
			Tienda.tama�o1 = getTama�o();
			Tienda.material1 = getMaterial();
		}
		else if (mar == 2) {
			Tienda.precio2 = getPrecio();
			Tienda.garantia2 = getGarantia();
			Tienda.tama�o2 = getTama�o();
			Tienda.material2 = getMaterial();
		}
		else if (mar == 3) {
			Tienda.precio3 = getPrecio();
			Tienda.garantia3 = getGarantia();
			Tienda.tama�o3 = getTama�o();
			Tienda.material3 = getMaterial();
		}
		else {
			Tienda.precio4 = getPrecio();
			Tienda.garantia4 = getGarantia();
			Tienda.tama�o4 = getTama�o();
			Tienda.material4 = getMaterial();
		}
		dispose();
	}
	
	int getMarca1() {
		return cboMarca.getSelectedIndex();
	}

	double getPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}

	int getGarantia() {
		return Integer.parseInt(txtGarantia.getText());
	}

	String getTama�o() {
		return txtTama�o.getText();
	}

	String getMaterial() {
		return txtMaterial.getText();
	}
}
