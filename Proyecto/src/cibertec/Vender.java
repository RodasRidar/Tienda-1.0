package cibertec;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vender extends JDialog implements ActionListener {
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JLabel lblMarca;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JComboBox<Object> cboMarca;
	private JButton btnVender;
	private JButton btnCerrar;
	private JTextArea txtS;
//Contadores Acumuladores 
	public static int canven0;
	public static int canven1;
	public static int canven2;
	public static int canven3;
	public static int canven4;
	
	public static int canunid0;
	public static int canunid1;
	public static int canunid2;
	public static int canunid3;
	public static int canunid4;
	
	public static double imptot0;
	public static double imptot1;
	public static double imptot2;
	public static double imptot3;
	public static double imptot4;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Vender dialog = new Vender();
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
	public Vender() {
		setTitle("Vender");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			btnVender = new JButton("Vender");
			btnVender.addActionListener(this);
			btnVender.setBounds(335, 11, 89, 23);
			getContentPane().add(btnVender);

			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(335, 41, 89, 23);
			getContentPane().add(btnCerrar);
			lblMarca = new JLabel("Marca:");
			lblMarca.setBounds(10, 15, 46, 14);
			getContentPane().add(lblMarca);

			lblPrecio = new JLabel("Precio (S/):");
			lblPrecio.setBounds(10, 45, 80, 14);
			getContentPane().add(lblPrecio);

			lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setBounds(10, 76, 62, 14);
			getContentPane().add(lblCantidad);

			cboMarca = new JComboBox<Object>();
			cboMarca.addActionListener(this);
			cboMarca.setModel(new DefaultComboBoxModel<Object>(new String[] { "Suavestar", "Springwall", "Paraiso", "Drimer", "Cisne" }));
			cboMarca.setBounds(92, 12, 89, 20);
			getContentPane().add(cboMarca);

			txtPrecio = new JTextField();
			txtPrecio.setEditable(false);
			txtPrecio.setBounds(92, 42, 89, 20);
			getContentPane().add(txtPrecio);
			txtPrecio.setColumns(10);

			txtCantidad = new JTextField();
			txtCantidad.setColumns(10);
			txtCantidad.setBounds(92, 73, 89, 20);
			getContentPane().add(txtCantidad);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 101, 414, 149);
			getContentPane().add(scrollPane);

			txtS = new JTextArea();
			scrollPane.setViewportView(txtS);
			
			
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnVender) {
			actionPerformedBtnVender(arg0);
		}
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

		mar = cboMarca.getSelectedIndex();
		if (mar == 0)
			txtPrecio.setText(Tienda.precio0 + "");
		else if (mar == 1)
			txtPrecio.setText(Tienda.precio1 + "");
		else if (mar == 2)
			txtPrecio.setText(Tienda.precio2 + "");
		else if (mar == 3)
			txtPrecio.setText(Tienda.precio3 + "");
		else
			txtPrecio.setText(Tienda.precio4 + "");
	}

	protected void actionPerformedBtnVender(ActionEvent arg0) {
		
		int mar, can;
		double preu, ides, icom, ipag;
		String obs, sor, marcol;
		mar = getMarca();
		can = getCantidadesAdquiridas();
		marcol = getMarcaColchon(mar);
		preu = getPrecioUnitario(mar);
		icom = calcularImporteCompra(mar, can);
		ides = calcularImporteDescuento(can, icom);
		ipag = calcularImportePagar(icom, ides);
		contadoresAcumuladores1(can , mar);
		contadoresAcumuladores2(mar,ipag);
		obs = obsequio(can);
		sor = sorpresa();
		mostrarResultados(marcol, preu, can, icom, ides, ipag, obs, sor);
	}

	int getMarca() {
		return cboMarca.getSelectedIndex();
	}

	int getCantidadesAdquiridas() {
		return Integer.parseInt(txtCantidad.getText());
	}

	String getMarcaColchon(int m) {
		if (m == 0)
			return "Suavestar";
		else if (m == 1)
			return "Springwall";
		else if (m == 2)
			return "Paraiso";
		else if (m == 3)
			return "Drimer";
		else
			return "Cisne";
	}

	double getPrecioUnitario(int m) {
		switch (m) {
			case 0:
				return Tienda.precio0;
			case 1:
				return Tienda.precio1;
			case 2:
				return Tienda.precio2;
			case 3:
				return Tienda.precio3;
			default:
				return Tienda.precio4;

		}
	}

	double calcularImporteCompra(int m, int c) {
		switch (m) {
			case 0:
				return Tienda.precio0 * c;
			case 1:
				return Tienda.precio1 * c;
			case 2:
				return Tienda.precio2 * c;
			case 3:
				return Tienda.precio3 * c;
			default:
				return Tienda.precio4 * c;
		}

	}

	double calcularImporteDescuento(int c, double ic) {
		if (c <= 5)
			return Tienda.porcentaje1 * ic;
		else if (c <= 10)
			return Tienda.porcentaje2 * ic;
		else if (c <= 15)
			return Tienda.porcentaje3 * ic;
		else
			return Tienda.porcentaje4 * ic;
	}

	double calcularImportePagar(double ic, double id) {
		return ic - id;
	}

	String obsequio(int c) {
		if (c >= Tienda.cantidadMinimaObsequiable)
			return Tienda.obsequio;
		else
			return "";
	}

	String sorpresa() {
		if (Tienda.numeroClienteSorpresa == 5)
			return Tienda.premioSorpresa;
		else
			return "";
	}
	void contadoresAcumuladores1(int c ,int m){
		switch (m){
			case 0:  canven0++;canunid0+=c;break;
			case 1: canven1++;canunid1+=c;break;
			case 2: canven2++;canunid2+=c;break;
			case 3: canven3++;canunid3+=c;break;
			default: canven4++;canunid4+=c;
		}
	}
	void contadoresAcumuladores2(int m ,double ip){
		switch (m){
			case 0:  imptot0+=ip;break;
			case 1: imptot1+=ip;break;
			case 2: imptot2+=ip;break;
			case 3: imptot3+=ip;break;
			default: imptot4+=ip;
	}
	}
	void mostrarResultados(String mc, double pu, int c, double ic, double id, double ip, String ob, String s) {
		txtS.setText("Boleta de venta" + "\n\n");
		txtS.append("Marca del colchon      :" + mc+"\n");
		txtS.append("Precio unitario        :S/." + pu+"\n");
		txtS.append("Cantidades adquiridas  :" + c+"\n");
		txtS.append("Importe compra         :S/." + ic+"\n");
		txtS.append("Importe de descuento   :S/." + id+"\n");
		txtS.append("Iporte a pagar         :S/." + ip+"\n");
		txtS.append("Obsequio               :" + ob+"\n");
		txtS.append("Premio sorpresa        :" + s+"\n");

	}
}
