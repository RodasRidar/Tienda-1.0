package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Tienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Datos mínimos del primer colchón
	public static String marca0 = "Suavestar";
	public static double precio0 = 499.0;
	public static int garantia0 = 7;
	public static String tamaño0 = "1 1/2 Plaza";
	public static String material0 = "Tela Tricot Acolchada";

	// Datos mínimos del segundo colchón
	public static String marca1 = "Springwall";
	public static double precio1 = 679.0;
	public static int garantia1 = 10;
	public static String tamaño1 = "2 Plazas";
	public static String material1 = "Tejido de Punto con Algodón Orgánico";

	// Datos mínimos del tercer colchón
	public static String marca2 = "Paraiso";
	public static double precio2 = 479.0;
	public static int garantia2 = 5;
	public static String tamaño2 = "1 1/2 Plazas";
	public static String material2 = "Tejido de Punto";

	// Datos mínimos del cuarto colchón
	public static String marca3 = "Drimer";
	public static double precio3 = 749.0;
	public static int garantia3 = 4;
	public static String tamaño3 = "Queen";
	public static String material3 = "Jacquard";

	// Datos mínimos del quinto colchón
	public static String marca4 = "Cisne";
	public static double precio4 = 389.0;
	public static int garantia4 = 2;
	public static String tamaño4 = "1 1/2 Plazas";
	public static String material4 = "Tejido de Punto";

	// Porcentajes de descuento
	public static double porcentaje1 = 0.075;
	public static double porcentaje2 = 0.10;
	public static double porcentaje3 = 0.125;
	public static double porcentaje4 = 0.15;

	// Cantidad óptima de colchones vendidos
	public static int cantidadOptima = 10;

	// Cantidad mínima de colchones adquiridos para acceder al obsequio
	public static int cantidadMinimaObsequiable = 3;

	// Obsequio por cantidad mínima de colchones adquiridos
	public static String obsequio = "USB";

	// Número de cliente que recibe el premio sorpresa
	public static int numeroClienteSorpresa = 5;

	// Premio sorpresa
	public static String premioSorpresa = "Un polo";
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarColchon;
	private JMenuItem mntmModificarcolchon;
	private JMenuItem mntmListarcolchon;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarreportes;
	private JMenuItem mntmConfigurardescuento;
	private JMenuItem mntmConfigurarobsequio;
	private JMenuItem mntmConfigurarcantidadoptimadecolchonesvendidos;
	private JMenuItem mntmConfigurarpremiosorpresa;
	private JMenuItem mntmAcercadetienda;

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tienda() {
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 465);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		mntmConsultarColchon = new JMenuItem("Consultar colch\u00F3n");
		mntmConsultarColchon.addActionListener(this);
		mnMantenimiento.add(mntmConsultarColchon);

		mntmModificarcolchon = new JMenuItem("Modificar colch\u00F3n");
		mntmModificarcolchon.addActionListener(this);
		mnMantenimiento.add(mntmModificarcolchon);

		mntmListarcolchon = new JMenuItem("Listar colch\u00F3n");
		mntmListarcolchon.addActionListener(this);
		mnMantenimiento.add(mntmListarcolchon);

		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);

		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);

		mntmGenerarreportes = new JMenuItem(" Generar reportes");
		mntmGenerarreportes.addActionListener(this);
		mnVentas.add(mntmGenerarreportes);

		mnConfiguracion = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguracion);

		mntmConfigurardescuento = new JMenuItem("Configurar descuentos");
		mntmConfigurardescuento.addActionListener(this);
		mnConfiguracion.add(mntmConfigurardescuento);

		mntmConfigurarobsequio = new JMenuItem("Configurar obsequio");
		mntmConfigurarobsequio.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarobsequio);

		mntmConfigurarcantidadoptimadecolchonesvendidos = new JMenuItem("Configurar cantidad optima de colchones vendidos ");
		mntmConfigurarcantidadoptimadecolchonesvendidos.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarcantidadoptimadecolchonesvendidos);

		mntmConfigurarpremiosorpresa = new JMenuItem("Configurar premio sorpresa");
		mntmConfigurarpremiosorpresa.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarpremiosorpresa);

		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		mntmAcercadetienda = new JMenuItem("Acerca de  tienda");
		mntmAcercadetienda.addActionListener(this);
		mnAyuda.add(mntmAcercadetienda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() == mntmAcercadetienda) {
			actionPerformedMntmAcercaTienda(e);
		}
		if (e.getSource() == mntmConfigurarpremiosorpresa) {
			actionPerformedMntmConfiguracionPremioSorpresa(e);
		}
		if (e.getSource() == mntmConfigurarcantidadoptimadecolchonesvendidos) {
			actionPerformedMntmConfigurarCantidadOptimaColchonesVendidos(e);
		}
		if (e.getSource() == mntmConfigurarobsequio) {
			actionPerformedMntmConfigurarObsequio(e);
		}
		if (e.getSource() == mntmConfigurardescuento) {
			actionPerformedMntmConfiguracionDescuento(e);
		}
		if (e.getSource() == mntmGenerarreportes) {
			actionPerformedMntmGenerarReportes(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmListarcolchon) {
			actionPerformedMntmListarColchon(e);
		}
		if (e.getSource() == mntmModificarcolchon) {
			actionPerformedMntmModificarColchon(e);
		}
		if (e.getSource() == mntmConsultarColchon) {
			actionPerformedMntmConsultarColchon(e);
		}
	}

	protected void actionPerformedMntmConsultarColchon(ActionEvent e) {
		// Declarar el nombre de la caja de dialogo
		ConsultarColchon d;
		// Crear la caja de diálogo y asignar el control a la variable d
		d = new ConsultarColchon();
		// Centrar la caja de dialogo
		d.setLocationRelativeTo(this);
		// Hacer visible la caja de diálogo
		d.setVisible(true);
	}

	protected void actionPerformedMntmModificarColchon(ActionEvent e) {
		// Declarar el nombre de la caja de dialogo
		ModificarColchon d;
		// Crear la caja de diálogo y asignar el control a la variable d
		d = new ModificarColchon();
		// Centrar la caja de dialogo
		d.setLocationRelativeTo(this);
		// Hacer visible la caja de diálogo
		d.setVisible(true);
	}

	protected void actionPerformedMntmListarColchon(ActionEvent e) {
		// Declarar el nombre de la caja de dialogo
		ListarColchon d;
		// Crear la caja de diálogo y asignar el control a la variable d
		d = new ListarColchon();
		// Centrar la caja de dialogo
		d.setLocationRelativeTo(this);
		// Hacer visible la caja de diálogo
		d.setVisible(true);
	}

	protected void actionPerformedMntmVender(ActionEvent e) {
		// Declarar el nombre de la caja de dialogo
		Vender d;
		// Crear la caja de diálogo y asignar el control a la variable d
		d = new Vender();
		// Centrar la caja de dialogo
		d.setLocationRelativeTo(this);
		// Hacer visible la caja de diálogo
		d.setVisible(true);

	}

	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		// Declarar el nombre de la caja de dialogo
		GenerarReportes d;
		// Crear la caja de diálogo y asignar el control a la variable d
		d = new GenerarReportes();
		// Centrar la caja de dialogo
		d.setLocationRelativeTo(this);
		// Hacer visible la caja de diálogo
		d.setVisible(true);

	}

	protected void actionPerformedMntmConfiguracionDescuento(ActionEvent e) {
		// Declarar el nombre de la caja de dialogo
		ConfiguracionDescuento d;
		// Crear la caja de diálogo y asignar el control a la variable d
		d = new ConfiguracionDescuento();
		// Centrar la caja de dialogo
		d.setLocationRelativeTo(this);
		// Hacer visible la caja de diálogo
		d.setVisible(true);

	}

	protected void actionPerformedMntmConfigurarObsequio(ActionEvent e) {
		// Declarar el nombre de la caja de dialogo
		ConfigurarObsequio d;
		// Crear la caja de diálogo y asignar el control a la variable d
		d = new ConfigurarObsequio();
		// Centrar la caja de dialogo
		d.setLocationRelativeTo(this);
		// Hacer visible la caja de diálogo
		d.setVisible(true);

	}

	protected void actionPerformedMntmConfigurarCantidadOptimaColchonesVendidos(ActionEvent e) {
		// Declarar el nombre de la caja de dialogo
		ConfigurarCantidadOptimaColchonesVendidos d;
		// Crear la caja de diálogo y asignar el control a la variable d
		d = new ConfigurarCantidadOptimaColchonesVendidos();
		// Centrar la caja de dialogo
		d.setLocationRelativeTo(this);
		// Hacer visible la caja de diálogo
		d.setVisible(true);
	}

	protected void actionPerformedMntmConfiguracionPremioSorpresa(ActionEvent e) {
		// Declarar el nombre de la caja de dialogo
		ConfiguracionPremioSorpresa d;
		// Crear la caja de diálogo y asignar el control a la variable d
		d = new ConfiguracionPremioSorpresa();
		// Centrar la caja de dialogo
		d.setLocationRelativeTo(this);
		// Hacer visible la caja de diálogo
		d.setVisible(true);

	}

	protected void actionPerformedMntmAcercaTienda(ActionEvent e) {
		// Declarar el nombre de la caja de dialogo
		AcercaTienda d;
		// Crear la caja de diálogo y asignar el control a la variable d
		d = new AcercaTienda();
		// Centrar la caja de dialogo
		d.setLocationRelativeTo(this);
		// Hacer visible la caja de diálogo
		d.setVisible(true);

	}

	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
}
