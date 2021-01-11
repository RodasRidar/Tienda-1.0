package cibertec;

import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenerarReportes extends JDialog implements ActionListener {
	private JLabel lblTipodereporte;
	private JComboBox<Object> cboTipoReporte;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GenerarReportes dialog = new GenerarReportes();
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
	public GenerarReportes() {
		setTitle("Generar Reportes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		lblTipodereporte = new JLabel("Tipo de reporte:");
		lblTipodereporte.setBounds(10, 11, 105, 20);
		getContentPane().add(lblTipodereporte);

		cboTipoReporte = new JComboBox<Object>();
		cboTipoReporte.addActionListener(this);
		cboTipoReporte.setToolTipText("");
		cboTipoReporte.setModel(new DefaultComboBoxModel<Object>(new String[] {"Ventas por marca", "Marcas con venta \u00F3ptima", "Precios en relaci\u00F3n al promedio", "Precio promedio, mayor y menor"}));
		cboTipoReporte.setBounds(111, 11, 216, 20);
		getContentPane().add(cboTipoReporte);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 10, 89, 23);
		getContentPane().add(btnCerrar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 414, 208);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboTipoReporte) {
			actionPerformedCboTipoReporte(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedCboTipoReporte(ActionEvent e) {
		int rep,dif0,dif1,dif2,dif3,dif4;
		String sms0,sms1,sms2,sms3,sms4,msj0,msj1,msj2,msj3,msj4;
		double prom0,premen,premay;
		rep = getTipoReporte();
		txtS.setText("");
		dif0 = getDiferencia0();
		dif1 = getDiferencia1();
		dif2 = getDiferencia2();
		dif3 = getDiferencia3();
		dif4 = getDiferencia4();
		prom0=getPromedio();
		msj0=knowPromedio0(prom0);
		msj1=knowPromedio1(prom0);
		msj2=knowPromedio2(prom0);
		msj3=knowPromedio3(prom0);
		msj4=knowPromedio4(prom0);
		sms0=mensaje0(dif0);
		sms1=mensaje1(dif1);
		sms2=mensaje2(dif2);
		sms3=mensaje3(dif3);
		sms4=mensaje4(dif4);
		premen=getPrecioMenor();
		premay=getPrecioMayor();
		mostrarResultados(rep,dif0,dif1,dif2,dif3,dif4,sms0,sms1,sms2,sms3,sms4,msj0,msj1,msj2,msj3,msj4,prom0,premen,premay);
	}
	double getPrecioMayor(){
		double men =Tienda.precio0;
		if(Tienda.precio1>men)
			men=Tienda.precio1;
		if(Tienda.precio2>men)
			men=Tienda.precio2;
		if(Tienda.precio3>men)
			men=Tienda.precio3;
		if(Tienda.precio4>men)
			men=Tienda.precio4;
			return men ;
	}
	double getPrecioMenor(){
		double men =Tienda.precio0;
		if(Tienda.precio1<men)
			men=Tienda.precio1;
		if(Tienda.precio2<men)
			men=Tienda.precio2;
		if(Tienda.precio3<men)
			men=Tienda.precio3;
		if(Tienda.precio4<men)
			men=Tienda.precio4;
			return men ;
	}
	
	double getPromedio() {
		return (Tienda.precio0 + Tienda.precio1 + Tienda.precio2 + Tienda.precio3 + Tienda.precio4) / 5;
	}
	String knowPromedio0(double prom0){
		if (Tienda.precio0<prom0)
			return "(menor al promedio)";
		else if (Tienda.precio0==prom0)
		return "(igual al promeio)";
		else 
			return "(mayor al promedio)";
	}
	String knowPromedio1(double prom0){
		if (Tienda.precio1<prom0)
			return "(menor al promedio)";
		else if (Tienda.precio1==prom0)
		return "(igual al promeio)";
		else 
			return "(mayor al promedio)";
	}
	String knowPromedio2(double prom0){
		if (Tienda.precio2<prom0)
			return "(menor al promedio)";
		else if (Tienda.precio2==prom0)
		return "(igual al promeio)";
		else 
			return "(mayor al promedio)";
	}
	String knowPromedio3(double prom0){
		if (Tienda.precio3<prom0)
			return "(menor al promedio)";
		else if (Tienda.precio3==prom0)
		return "(igual al promeio)";
		else 
			return "(mayor al promedio)";
	}
	String knowPromedio4(double prom0){
		if (Tienda.precio4<prom0)
			return "(menor al promedio)";
		else if (Tienda.precio4==prom0)
		return "(igual al promeio)";
		else 
			return "(mayor al promedio)";
	}
	String mensaje0(int dif0){
		if (Vender.canunid0<10)
		return"(No se alcanzo venta optima)"; 
		else 
			return "("+dif0*-1+" más que la cantidad óptima)";
		
	}
	String mensaje1(int dif1){
		if (Vender.canunid1<10)
		return "(No se alcanzo venta optima)"; 
		else 
			return "("+dif1*-1+" más que la cantidad óptima)";
		
	}
	String mensaje2(int dif2){
		if (Vender.canunid2<10)
		return " (No se alcanzo venta optima)"; 
		else 
			return "("+dif2*-1+" más que la cantidad óptima)";
		
	}
	String mensaje3(int dif3){
		if (Vender.canunid3<10)
		return " (No se alcanzo venta optima)"; 
		else 
			return "("+dif3*-1+" más que la cantidad óptima)";
		
	}
	String mensaje4(int dif4){
		if (Vender.canunid4<10)
		return "(No se alcanzo venta optima)"; 
		else 
			return "("+dif4*-1+" más que la cantidad óptima)";
		
	}
	int getDiferencia0() {
			return Tienda.cantidadOptima - Vender.canunid0;
	}
	int getDiferencia1() {
			 return Tienda.cantidadOptima - Vender.canunid1;
	}
	int getDiferencia2() {
		
			return Tienda.cantidadOptima - Vender.canunid2;
	}
	int getDiferencia3() {
		
			return Tienda.cantidadOptima - Vender.canunid3;
	}
	int getDiferencia4() {
			return Tienda.cantidadOptima - Vender.canunid4;
	}

	int getTipoReporte() {
		return cboTipoReporte.getSelectedIndex();
	}

	void mostrarResultados(int r,int dif0,int dif1,int dif2,int dif3,int dif4,String sms0,String sms1,String sms2,String sms3,String sms4,String msj0,String msj1,String msj2,String msj3,String msj4,double prom0,double premen,double premay) {
		if(r==0) {
				txtS.setText("Ventas por colchon" + "\n\n");
				txtS.append("Marca:" + Tienda.marca0 + "\n");
				txtS.append("Cantidad de ventas:" + Vender.canven0 + "\n");
				txtS.append("Cantidad total de unidades vendidas:" + Vender.canunid0 + "\n");
				txtS.append("Importe total acumulado:" + Vender.imptot0 + "\n\n");
	
				txtS.append("Marca:" + Tienda.marca1 + "\n");
				txtS.append("Cantidad de ventas:" + Vender.canven1 + "\n");
				txtS.append("Cantidad total de unidades vendidas:" + Vender.canunid1 + "\n");
				txtS.append("Importe total acumulado:" + Vender.imptot1 + "\n\n");

				txtS.append("Marca:" + Tienda.marca2 + "\n");
				txtS.append("Cantidad de ventas:" + Vender.canven2 + "\n");
				txtS.append("Cantidad total de unidades vendidas:" + Vender.canunid2 + "\n");
				txtS.append("Importe total acumulado:" + Vender.imptot2 + "\n\n");

				txtS.append("Marca:" + Tienda.marca3 + "\n");
				txtS.append("Cantidad de ventas:" + Vender.canven3 + "\n");
				txtS.append("Cantidad total de unidades vendidas:" + Vender.canunid3 + "\n");
				txtS.append("Importe total acumulado:" + Vender.imptot3 + "\n\n");

				txtS.append("Marca:" + Tienda.marca4 + "\n");
				txtS.append("Cantidad de ventas:" + Vender.canven4 + "\n");
				txtS.append("Cantidad total de unidades vendidas:" + Vender.canunid4 + "\n");
				txtS.append("Importe total acumulado:" + Vender.imptot4 + "\n\n");
				}
			 if (r==1){
				 
				txtS.setText("Marcas con ventas optimas" + "\n\n");
				txtS.append("Marca:" + Tienda.marca0 + "\n");
				txtS.append("Cantidad total de unidades vendidas:" + Vender.canunid0 + sms0 + "\n\n");

				txtS.append("Marca:" + Tienda.marca1 + "\n");
				txtS.append("Cantidad total de unidades vendidas:" + Vender.canunid1 + sms1 + "\n\n");

				txtS.append("Marca:" + Tienda.marca2 + "\n");
				txtS.append("Cantidad total de unidades vendidas:" + Vender.canunid2 + sms2 + "\n\n");

				txtS.append("Marca:" + Tienda.marca3 + "\n");
				txtS.append("Cantidad total de unidades vendidas:" + Vender.canunid3 + sms3+ "\n\n");

				txtS.append("Marca:" + Tienda.marca4 + "\n");
				txtS.append("Cantidad total de unidades vendidas:" + Vender.canunid4 + sms4+ "\n\n");
				if(Vender.canunid0==0&&Vender.canunid1==0&&Vender.canunid2==0&&Vender.canunid3==0&&Vender.canunid4==0)
						JOptionPane.showMessageDialog(this, "No existen marcas con venta óptima");
				}
			 if(r==2){
				 txtS.setText("Precios en relacion al promedio" + "\n\n");
					txtS.append("Nombre:" + Tienda.marca0 + "\n");
					txtS.append("Precio :" + Tienda.precio0 + msj0 + "\n\n");
					
					txtS.append("Nombre:" + Tienda.marca1 + "\n");
					txtS.append("Precio :" + Tienda.precio1 + msj1 + "\n\n");
					
					txtS.append("Nombre:" + Tienda.marca2 + "\n");
					txtS.append("Precio :" + Tienda.precio2 + msj2 + "\n\n");
					
					txtS.append("Nombre:" + Tienda.marca3 + "\n");
					txtS.append("Precio :" + Tienda.precio3 + msj3 + "\n\n");
					
					txtS.append("Nombre:" + Tienda.marca4 + "\n");
					txtS.append("Precio :" + Tienda.precio4+ msj4 + "\n\n");
					}
			 if (r==3){
				 txtS.setText("Precio promedio, menor y mayor" + "\n\n");
					txtS.append("Precio promedio:" + prom0 + "\n");
					txtS.append("Precio menor :" + premen + "\n");
					txtS.append("Precio menor :" + premay );
			 }
	}

}
