package cibertec;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ListarColchon extends JDialog implements ActionListener {
	private JButton btnCerrar;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarColchon dialog = new ListarColchon();
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
	public ListarColchon() {
		setTitle("Listado de colchones");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(86, 227, 89, 23);
		getContentPane().add(btnCerrar);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(260, 227, 89, 23);
		getContentPane().add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 202);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnListar(ActionEvent e) {
		txtS.setText("Listado de Colchones" + "\n\n");
		mostrarColchon(Tienda.marca0, Tienda.precio0, Tienda.garantia0, Tienda.tamaño0, Tienda.material0);
		mostrarColchon(Tienda.marca1, Tienda.precio1, Tienda.garantia1, Tienda.tamaño1, Tienda.material1);
		mostrarColchon(Tienda.marca2, Tienda.precio2, Tienda.garantia2, Tienda.tamaño2, Tienda.material2);
		mostrarColchon(Tienda.marca3, Tienda.precio3, Tienda.garantia3, Tienda.tamaño3, Tienda.material3);
		mostrarColchon(Tienda.marca4, Tienda.precio4, Tienda.garantia4, Tienda.tamaño4, Tienda.material4);
	}

	void mostrarColchon(String mar, double pre, int gar, String tam, String mat) {
		imprimir("Marca      : " + mar);
		imprimir("Precio     : S/ " + pre);
		imprimir("Garantia   : " + gar+" años");
		imprimir("Tamaño     : " + tam);
		imprimir("Material   : " + mat + "\n");
	}

	void imprimir(String cad) {
		txtS.append(cad + "\n");

	}
}