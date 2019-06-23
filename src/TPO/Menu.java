package TPO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.xml.ws.handler.MessageContext;

import java.awt.Color;
import javax.swing.JCheckBox;

public class Menu {

	private JFrame frmEstacionamiento;
	private JTextField txtNombreCliente;
	private JTextField txtApellidoCliente;
	private JTextField txtDniCliente;
	private JTextField txtDniCobroCliente;
	private JTextField txtPatenteEventual;
	private JTextField txtPatenteVehiculoCliente;
	private JTextField txtMarcaVehiculoCliente;
	private JTextField txtModeloVehiculoCliente;
	private JTextField txtCocheraVehiculoCliente;
	private JTextField txtPatenteCobroEventual;
	private JTextField txtNumeroNuevaCochera;
	private JTextField txtDniVehiculoCliente;
	private Controlador controlador;
	
	public Menu (Controlador con) {
		super();
		initialize();
		this.controlador = con;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			Controlador con=new Controlador();
			public void run() {
				try {
					Menu window = new Menu(con);
					window.frmEstacionamiento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		frmEstacionamiento = new JFrame();
		frmEstacionamiento.setTitle("Estacionamiento");
		frmEstacionamiento.setBounds(100, 100, 488, 400);
		frmEstacionamiento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEstacionamiento.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmEstacionamiento.getContentPane().add(tabbedPane);
		
		JPanel cliente = new JPanel();
		tabbedPane.addTab("Cliente", null, cliente, null);
		
		JLabel lblNuevoCliente = new JLabel("Nuevo cliente");
		
		JLabel lblNombreCliente = new JLabel("Nombre");
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setColumns(10);
		
		JLabel lblApellidoCliente = new JLabel("Apellido");
		
		txtApellidoCliente = new JTextField();
		txtApellidoCliente.setColumns(10);
		
		JLabel lblDniCliente = new JLabel("DNI");
		
		txtDniCliente = new JTextField();
		txtDniCliente.setColumns(10);
		
		JButton btnCrearCliente = new JButton("Crear cliente");
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean existe = controlador.existeCliente(txtDniCliente.getText());	//Verifico que el cliente no exista
				if (existe==false) {	//No existe, lo creo
					controlador.crearCliente(txtNombreCliente.getText(), txtApellidoCliente.getText(), txtDniCliente.getText());
					System.out.println("Cliente " + txtApellidoCliente.getText() + ", " + txtNombreCliente.getText() + " - " + txtDniCliente.getText() + " creado con exito");
					JOptionPane.showMessageDialog(frmEstacionamiento, "Cliente creado con exito!", "Exito", 1);
				}
				else	//Existe, no lo creo
					JOptionPane.showMessageDialog(frmEstacionamiento, "El cliente ya existe", "Cliente existente", 1);
			}
		});
		
		JLabel lblCobranzaCliente = new JLabel("Cobranza cliente");
		
		JLabel lblDniCobroCliente = new JLabel("DNI");
		
		txtDniCobroCliente = new JTextField();
		txtDniCobroCliente.setColumns(10);
		
		JButton btnCobrarCliente = new JButton("Cobrar cliente");
		btnCobrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblImporteCliente = new JLabel("Importe");
		
		JLabel lblImporteacobrarcliente = new JLabel("");
		lblImporteacobrarcliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImporteacobrarcliente.setForeground(Color.RED);
		
		JLabel lblVehiculoCliente = new JLabel("Vehiculo cliente");
		
		JLabel lblPatenteVehiculoCliente = new JLabel("Patente");
		
		txtPatenteVehiculoCliente = new JTextField();
		txtPatenteVehiculoCliente.setColumns(10);
		
		JLabel lblTipoVehiculoCliente = new JLabel("Tipo");
		
		final JComboBox cboTipoVehiculoCliente = new JComboBox();
		cboTipoVehiculoCliente.setModel(new DefaultComboBoxModel(TipoVechiculo.values()));
		
		JLabel lblMarcaVehiculoCliente = new JLabel("Marca");
		
		txtMarcaVehiculoCliente = new JTextField();
		txtMarcaVehiculoCliente.setColumns(10);
		
		JLabel lblModeloVehiculoCliente = new JLabel("Modelo");
		
		txtModeloVehiculoCliente = new JTextField();
		txtModeloVehiculoCliente.setColumns(10);
		
		JLabel lblCocheraVehiculoCliente = new JLabel("Cochera");
		
		txtCocheraVehiculoCliente = new JTextField();
		txtCocheraVehiculoCliente.setColumns(10);
		
		JButton btnAgregarVehiculo = new JButton("Agregar vehiculo");
		btnAgregarVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean booexisteCliente = controlador.existeCliente(txtDniCliente.getText());	//Verifico que el cliente exista.
				if (booexisteCliente==true) {				//Cliente existe
					boolean booexisteVehiculo = false;		//Validar existencia vehiculo (HACER METODO existeVehiculo)
					if (booexisteVehiculo==false){ 			//Vehiculo no existe, lo creo
						//HACER METODO agregarVehiculo
					} else { //Vehiculo existe, no lo creo
						JOptionPane.showMessageDialog(frmEstacionamiento, "El vehiculo ya existe", "Vehiculo existente", 1);
						System.out.println("El vehiculo ya existe");
					}
				}
				else {	//Cliente no existe
					JOptionPane.showMessageDialog(frmEstacionamiento, "El cliente no existe", "Cliente inexistente", 1);
					System.out.println("Cliente inexistente");
				}
			}
		});
		
		txtDniVehiculoCliente = new JTextField();
		txtDniVehiculoCliente.setColumns(10);
		
		JLabel lblDniVehiculoCliente = new JLabel("DNI");
		GroupLayout gl_cliente = new GroupLayout(cliente);
		gl_cliente.setHorizontalGroup(
			gl_cliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cliente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_cliente.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_cliente.createSequentialGroup()
							.addComponent(lblDniCliente)
							.addContainerGap(439, Short.MAX_VALUE))
						.addGroup(gl_cliente.createSequentialGroup()
							.addGroup(gl_cliente.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_cliente.createSequentialGroup()
									.addGroup(gl_cliente.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDniCobroCliente, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
										.addComponent(lblImporteCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(gl_cliente.createSequentialGroup()
										.addGap(17)
										.addComponent(txtDniCobroCliente, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
										.addGap(18)
										.addComponent(btnCobrarCliente, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
								.addGroup(gl_cliente.createSequentialGroup()
									.addGap(52)
									.addGroup(gl_cliente.createSequentialGroup()
										.addGap(141)
										.addGroup(gl_cliente.createSequentialGroup()
											.addComponent(lblCobranzaCliente, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
											.addGap(149)))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblImporteacobrarcliente, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
							.addGap(19))
						.addGroup(gl_cliente.createSequentialGroup()
							.addComponent(lblMarcaVehiculoCliente)
							.addContainerGap(428, Short.MAX_VALUE))
						.addGroup(gl_cliente.createSequentialGroup()
							.addGroup(gl_cliente.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_cliente.createSequentialGroup()
									.addComponent(lblNombreCliente)
									.addGap(18)
									.addComponent(txtNombreCliente, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
								.addGroup(gl_cliente.createSequentialGroup()
									.addComponent(lblApellidoCliente)
									.addGap(18)
									.addGroup(gl_cliente.createParallelGroup(Alignment.LEADING)
										.addComponent(txtApellidoCliente, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
										.addGroup(gl_cliente.createSequentialGroup()
											.addComponent(txtDniCliente, GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(btnCrearCliente, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
								.addGroup(gl_cliente.createSequentialGroup()
									.addGroup(gl_cliente.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCocheraVehiculoCliente)
										.addComponent(lblDniVehiculoCliente))
									.addGap(12)
									.addGroup(gl_cliente.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_cliente.createSequentialGroup()
											.addGroup(gl_cliente.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtDniVehiculoCliente)
												.addComponent(txtMarcaVehiculoCliente, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
											.addGap(18)
											.addGroup(gl_cliente.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_cliente.createSequentialGroup()
													.addComponent(lblVehiculoCliente)
													.addPreferredGap(ComponentPlacement.RELATED, 172, Short.MAX_VALUE))
												.addGroup(gl_cliente.createSequentialGroup()
													.addGap(10)
													.addGroup(gl_cliente.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblModeloVehiculoCliente)
														.addComponent(lblPatenteVehiculoCliente))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_cliente.createParallelGroup(Alignment.LEADING)
														.addComponent(txtPatenteVehiculoCliente, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
														.addComponent(txtModeloVehiculoCliente, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))))
										.addGroup(gl_cliente.createSequentialGroup()
											.addComponent(txtCocheraVehiculoCliente, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblTipoVehiculoCliente)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(cboTipoVehiculoCliente, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
											.addGap(17)
											.addComponent(btnAgregarVehiculo, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))))
							.addGap(19))))
				.addGroup(gl_cliente.createSequentialGroup()
					.addGap(200)
					.addComponent(lblNuevoCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(202))
		);
		gl_cliente.setVerticalGroup(
			gl_cliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cliente.createSequentialGroup()
					.addComponent(lblNuevoCliente)
					.addGap(11)
					.addGroup(gl_cliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreCliente)
						.addComponent(txtNombreCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidoCliente)
						.addComponent(txtApellidoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDniCliente)
						.addComponent(txtDniCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCrearCliente))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblVehiculoCliente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_cliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPatenteVehiculoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPatenteVehiculoCliente)
						.addComponent(txtDniVehiculoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDniVehiculoCliente))
					.addGap(11)
					.addGroup(gl_cliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarcaVehiculoCliente)
						.addComponent(txtMarcaVehiculoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblModeloVehiculoCliente)
						.addComponent(txtModeloVehiculoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCocheraVehiculoCliente)
						.addComponent(txtCocheraVehiculoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAgregarVehiculo)
						.addComponent(lblTipoVehiculoCliente)
						.addComponent(cboTipoVehiculoCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_cliente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cliente.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
							.addComponent(lblImporteacobrarcliente, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_cliente.createSequentialGroup()
							.addGap(18)
							.addComponent(lblCobranzaCliente)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_cliente.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDniCobroCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCobrarCliente)
								.addComponent(lblDniCobroCliente))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblImporteCliente)
							.addContainerGap())))
		);
		cliente.setLayout(gl_cliente);
		
		JPanel eventual = new JPanel();
		tabbedPane.addTab("Eventual", null, eventual, null);
		
		JLabel lblNuevoIngreso = new JLabel("Nuevo ingreso");
		
		JLabel lblPatente = new JLabel("Patente");
		
		txtPatenteEventual = new JTextField();
		txtPatenteEventual.setColumns(10);
		
		JLabel lblTipoVehiculoEventual = new JLabel("Tipo");
		
		final JComboBox<TipoVechiculo> cboTipoVehiculoEventual = new JComboBox();
		cboTipoVehiculoEventual.setModel(new DefaultComboBoxModel(TipoVechiculo.values()));
		
		JButton btnCrearEventual = new JButton("Crear eventual");
		btnCrearEventual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date ingreso = new Date();
				boolean booExisteEventual = controlador.existeEventual(txtPatenteEventual.getText());	//Verifico que no este ingresado
				if (booExisteEventual==false) {						//Si no se encuentra, lo ingreso
					int nroCochera = controlador.buscarCochera(cboTipoVehiculoEventual.getSelectedItem().toString());
					if (nroCochera != 0) {	//Hay cochera disponible
						if (cboTipoVehiculoEventual.getSelectedItem().toString().equals("Auto")) {
							controlador.crearEventual(txtPatenteEventual.getText(), TipoVechiculo.Auto, ingreso, nroCochera);
							System.out.println("Nuevo vehiculo eventual: " + txtPatenteEventual.getText() + ", tipo: " + TipoVechiculo.Auto + ", fecha: " + ingreso + ", cochera: " + nroCochera);
						}
						if (cboTipoVehiculoEventual.getSelectedItem().toString().equals("Suv")) {
							controlador.crearEventual(txtPatenteEventual.getText(), TipoVechiculo.Suv, ingreso, nroCochera);
							System.out.println("Nuevo vehiculo eventual: " + txtPatenteEventual.getText() + ", tipo: " + TipoVechiculo.Suv + ", fecha: " + ingreso + ", cochera: " + nroCochera);
						}
						if (cboTipoVehiculoEventual.getSelectedItem().toString().equals("Moto")) {
							controlador.crearEventual(txtPatenteEventual.getText(), TipoVechiculo.Moto, ingreso, nroCochera);
							System.out.println("Nuevo vehiculo eventual: " + txtPatenteEventual.getText() + ", tipo: " + TipoVechiculo.Moto + ", fecha: " + ingreso + ", cochera: " + nroCochera);
						}
						JOptionPane.showMessageDialog(frmEstacionamiento, "Vehiculo ingresado con exito! Cochera N°: " + nroCochera + ".", "Vehiculo ingresado", 1);
					} else {	//No hay cochera disponible
						JOptionPane.showMessageDialog(frmEstacionamiento, "No existen cocheras disponibles o no hay para este tipo de vehiculo", "Vehiculo ingresado", 1);
					}
				} else 		//Si se encuentra, no lo ingreso
					JOptionPane.showMessageDialog(frmEstacionamiento, "El vehiculo ya se encuentra ingresado", "Vehiculo existente", 1);
			}
		});
		
		JLabel lblCobroEventual = new JLabel("Cobro eventual");
		
		JLabel lblPatenteCobroEventual = new JLabel("Patente");
		
		txtPatenteCobroEventual = new JTextField();
		txtPatenteCobroEventual.setColumns(10);
		
		JLabel lblImporteCobroEventual = new JLabel("Importe");
		
		JLabel lblImporteACobrarEventual = new JLabel("");
		lblImporteACobrarEventual.setForeground(Color.RED);
		lblImporteACobrarEventual.setHorizontalAlignment(SwingConstants.CENTER);
		lblImporteACobrarEventual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnCobroEventual = new JButton("Cobro eventual");
		GroupLayout gl_eventual = new GroupLayout(eventual);
		gl_eventual.setHorizontalGroup(
			gl_eventual.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_eventual.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_eventual.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_eventual.createSequentialGroup()
							.addComponent(lblNuevoIngreso)
							.addGap(193))
						.addGroup(gl_eventual.createSequentialGroup()
							.addGroup(gl_eventual.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPatente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTipoVehiculoEventual, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_eventual.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_eventual.createSequentialGroup()
									.addComponent(cboTipoVehiculoEventual, 0, 177, Short.MAX_VALUE)
									.addGap(73)
									.addComponent(btnCrearEventual, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
									.addGap(66))
								.addGroup(gl_eventual.createSequentialGroup()
									.addComponent(txtPatenteEventual, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))))
				.addGroup(Alignment.TRAILING, gl_eventual.createSequentialGroup()
					.addGap(204)
					.addComponent(lblCobroEventual, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(189))
				.addGroup(gl_eventual.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPatenteCobroEventual)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPatenteCobroEventual, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
					.addGap(22))
				.addGroup(gl_eventual.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImporteCobroEventual)
					.addGap(29)
					.addComponent(lblImporteACobrarEventual, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(btnCobroEventual, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
					.addGap(63))
		);
		gl_eventual.setVerticalGroup(
			gl_eventual.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_eventual.createSequentialGroup()
					.addComponent(lblNuevoIngreso)
					.addGap(11)
					.addGroup(gl_eventual.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPatente)
						.addComponent(txtPatenteEventual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_eventual.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoVehiculoEventual)
						.addComponent(cboTipoVehiculoEventual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCrearEventual))
					.addGap(18)
					.addComponent(lblCobroEventual)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_eventual.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPatenteCobroEventual)
						.addComponent(txtPatenteCobroEventual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_eventual.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_eventual.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblImporteCobroEventual)
							.addComponent(btnCobroEventual))
						.addComponent(lblImporteACobrarEventual, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(140, Short.MAX_VALUE))
		);
		eventual.setLayout(gl_eventual);
		
		JPanel cochera = new JPanel();
		tabbedPane.addTab("Cochera", null, cochera, null);
		
		JLabel lblNuevaCochera = new JLabel("Nueva cochera");
		
		JLabel lblNumero = new JLabel("Numero");
		
		txtNumeroNuevaCochera = new JTextField();
		txtNumeroNuevaCochera.setColumns(10);
		
		final JCheckBox chckbxSuv = new JCheckBox("SUV");
		
		final JCheckBox chckbxAuto = new JCheckBox("Auto");
		
		JButton btnCrearCochera = new JButton("Crear cochera");
		btnCrearCochera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int nroCochera = Integer.parseInt(txtNumeroNuevaCochera.getText());
				boolean suv = false, auto=false;
				if (chckbxSuv.isSelected())
					suv = true;
				if (chckbxAuto.isSelected())
					auto = true;
				boolean booExisteCochera = controlador.existeCochera(nroCochera);	//Verifico que la cochera no exista
				if (booExisteCochera==false) {	//Si no existe, la creo
					controlador.crearCochera(nroCochera, suv, auto, true);
					JOptionPane.showMessageDialog(frmEstacionamiento, "Cochera creada con exito", "Cochera creada", 1);
					System.out.println("Cochera " + nroCochera + " creada, SUV=" + suv + ", Auto=" + auto +".");
				} else							//Si existe, no la creo
					JOptionPane.showMessageDialog(frmEstacionamiento, "La cochera ya existe", "Cochera existente", 1);
			}
		});
		GroupLayout gl_cochera = new GroupLayout(cochera);
		gl_cochera.setHorizontalGroup(
			gl_cochera.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cochera.createSequentialGroup()
					.addGap(204)
					.addComponent(lblNuevaCochera, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
					.addGap(191))
				.addGroup(gl_cochera.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNumero)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtNumeroNuevaCochera, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addComponent(chckbxSuv, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
					.addGap(37)
					.addComponent(chckbxAuto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(67))
				.addGroup(Alignment.TRAILING, gl_cochera.createSequentialGroup()
					.addGap(189)
					.addComponent(btnCrearCochera, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(177))
		);
		gl_cochera.setVerticalGroup(
			gl_cochera.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cochera.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNuevaCochera)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_cochera.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumero)
						.addComponent(txtNumeroNuevaCochera, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxAuto)
						.addComponent(chckbxSuv))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCrearCochera)
					.addContainerGap(228, Short.MAX_VALUE))
		);
		cochera.setLayout(gl_cochera);
	}
}
