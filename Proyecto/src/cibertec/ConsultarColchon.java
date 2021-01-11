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

public class ConsultarColchon extends JDialog implements ActionListener {

	private final JPanel Content = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtGarantia;
	private JTextField txtTamaño;
	private JTextField txtMaterial;
	private JComboBox<Object> cboMarca;
	private JLabel lblMarca;
	private JLabel lblPrecio;
	private JLabel lblGarantia;
	private JLabel lblTamaño;
	private JLabel lblMaterial;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConsultarColchon dialog = new ConsultarColchon();
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
	public ConsultarColchon() {
		setTitle("Consultar colch\u00F3n");
		setBounds(100, 100, 533, 279);
		getContentPane().setLayout(new BorderLayout());
		Content.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(Content, BorderLayout.CENTER);
		Content.setLayout(null);

		cboMarca = new JComboBox<Object>();
		cboMarca.addActionListener(this);
		cboMarca.setModel(new DefaultComboBoxModel<Object>(new String[] { "Suavestar", "Springwall", "Paraiso", "Drimer", "Cisne" }));
		cboMarca.setBounds(134, 11, 221, 20);
		Content.add(cboMarca);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(134, 42, 221, 20);
		Content.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtGarantia = new JTextField();
		txtGarantia.setEditable(false);
		txtGarantia.setBounds(134, 73, 221, 20);
		Content.add(txtGarantia);
		txtGarantia.setColumns(10);

		txtTamaño = new JTextField();
		txtTamaño.setEditable(false);
		txtTamaño.setBounds(134, 104, 221, 20);
		Content.add(txtTamaño);
		txtTamaño.setColumns(10);

		txtMaterial = new JTextField();
		txtMaterial.setEditable(false);
		txtMaterial.setBounds(134, 135, 221, 20);
		Content.add(txtMaterial);
		txtMaterial.setColumns(10);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 14, 46, 14);
		Content.add(lblMarca);

		lblPrecio = new JLabel("Precio(S/)");
		lblPrecio.setBounds(10, 45, 57, 14);
		Content.add(lblPrecio);

		lblGarantia = new JLabel("Garantia");
		lblGarantia.setBounds(10, 76, 114, 14);
		Content.add(lblGarantia);

		lblTamaño = new JLabel("Tamaño");
		lblTamaño.setBounds(10, 107, 57, 14);
		Content.add(lblTamaño);

		lblMaterial = new JLabel("Material");
		lblMaterial.setBounds(10, 138, 46, 14);
		Content.add(lblMaterial);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(409, 10, 89, 23);
		Content.add(btnCerrar);
		mostrarResultados(Tienda.precio0,Tienda.garantia0,Tienda.material0,Tienda.tamaño0);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboMarca) {
			actionPerformedCboMarca(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();

	}

	protected void actionPerformedCboMarca(ActionEvent arg0) {
		int mar;

		mar = getMarca();

		switch (mar) {
			case 0:
				mostrarResultados(Tienda.precio0, Tienda.garantia0, Tienda.material0, Tienda.tamaño0);
				break;
			case 1:
				mostrarResultados(Tienda.precio1, Tienda.garantia1, Tienda.material1, Tienda.tamaño1);
				break;
			case 2:
				mostrarResultados(Tienda.precio2, Tienda.garantia2, Tienda.material2, Tienda.tamaño2);
				break;
			case 3:
				mostrarResultados(Tienda.precio3, Tienda.garantia3, Tienda.material3, Tienda.tamaño3);
				break;
			case 4:
				mostrarResultados(Tienda.precio4, Tienda.garantia4, Tienda.material4, Tienda.tamaño4);
				break;

		}

	}

	private void mostrarResultados(double pre, int gar, String mat, String tam) {
		txtPrecio.setText(pre + "");
		txtGarantia.setText(gar + "");
		txtMaterial.setText(mat + "");
		txtTamaño.setText(tam + "");
	}

	int getMarca() {
		return cboMarca.getSelectedIndex();

	}
}
