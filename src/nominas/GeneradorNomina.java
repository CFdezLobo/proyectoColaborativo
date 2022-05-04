package nominas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

/**
 * Clase que calcula una nómina según los parámeros introducidos por el usuario en el JFrame
 * @author Carlos Fernández
 * @version 12/01/2021
 */
public class GeneradorNomina extends JFrame {

	// Campos de la clase
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JTextField textNIF;
	private JTextField textHoras;
	private JTextField textTarifa;
	private JTextField textNSS;

	/**
	 * Método que arranca la aplicación
	 * @param args (Array de Strings)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneradorNomina frame = new GeneradorNomina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Método que crea el JFrame
	 */
	public GeneradorNomina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 14, 69, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setForeground(Color.BLACK);
		textNombre.setBackground(Color.WHITE);
		textNombre.setBounds(89, 11, 306, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 57, 69, 14);
		contentPane.add(lblApellidos);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(89, 54, 306, 20);
		contentPane.add(textApellidos);
		textApellidos.setColumns(10);
		
		JLabel lblNIF = new JLabel("NIF:");
		lblNIF.setBounds(10, 102, 69, 14);
		contentPane.add(lblNIF);
		
		textNIF = new JTextField();
		textNIF.setBounds(89, 99, 115, 20);
		contentPane.add(textNIF);
		textNIF.setColumns(10);
		
		JLabel lblHoras = new JLabel("Horas:");
		lblHoras.setBounds(220, 148, 50, 14);
		contentPane.add(lblHoras);
		
		textHoras = new JTextField();
		textHoras.setBounds(280, 145, 115, 20);
		contentPane.add(textHoras);
		textHoras.setColumns(10);
		
		textTarifa = new JTextField();
		textTarifa.setBounds(89, 145, 115, 20);
		contentPane.add(textTarifa);
		textTarifa.setColumns(10);
		
		JLabel lblTarifa = new JLabel("Tarifa:");
		lblTarifa.setBounds(10, 148, 69, 14);
		contentPane.add(lblTarifa);
		
		JLabel lblNSS = new JLabel("N\u00BA SS:");
		lblNSS.setBounds(220, 102, 50, 14);
		contentPane.add(lblNSS);
		
		textNSS = new JTextField();
		textNSS.setBounds(280, 99, 115, 20);
		contentPane.add(textNSS);
		textNSS.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 225, 414, 195);
		contentPane.add(textArea);
		
		JButton btnNomina = new JButton("Generar n\u00F3mina");
		btnNomina.addActionListener(new ActionListener() {
			/**
			 * Método que almacena los datos introducidos por el usuario, calcula el salario en función de los bonus y las retenciones y muestra el resultado final.
			 * @param e (Acción del boton "Generar nómina")
			 */
			public void actionPerformed(ActionEvent e) {
				
				String nombre = textNombre.getText();
				String apellidos = textApellidos.getText();
				String nif = textNIF.getText();
				String n_ss = textNSS.getText();
				double tarifa = Double.parseDouble(textTarifa.getText());
				double horas = Double.parseDouble(textHoras.getText());
				double salario_base = tarifa * horas;
				double bonificacion = 0;
				double salario_bruto = 0;
				double retenciones = 0;
				double salario_neto = 0;
				
				if (horas >= 1 && horas <= 10) {
					bonificacion = salario_base * 0.05;
				}else if (horas >= 11 && horas <= 20) {
					bonificacion = salario_base * 0.1;
				}else if (horas > 20) {
					bonificacion = salario_base * 0.3;
				}
				salario_bruto = salario_base + bonificacion;
				retenciones = salario_bruto * 0.15;
				salario_neto = salario_bruto - retenciones;
				
				textArea.append("Nombre: " + nombre + " " + apellidos + "\n");
				textArea.append("NIF: " + nif + "\n");
				textArea.append("Nº SS: " + n_ss + "\n");
				textArea.append("Tarifa por hora: " + tarifa + "€\n");
				textArea.append("Horas trabajadas: " + horas + "\n");
				textArea.append("Salario base: " + salario_base + "€\n");
				textArea.append("Bonificación: " + bonificacion + "€\n");
				textArea.append("Salario bruto: " + salario_bruto + "€\n");
				textArea.append("Retenciones: " + retenciones + "€\n");
				textArea.append("Salario neto: " + salario_neto + "€\n");
			}
		});
		btnNomina.setBounds(44, 191, 160, 23);
		contentPane.add(btnNomina);
		
		JButton btnBorrar = new JButton("Borrar datos");
		btnBorrar.addActionListener(new ActionListener() {
			/**
			 * Método que deja vacios los campos de texto
			 * @param e ((Acción del boton "Borrar datos")
			 */
			public void actionPerformed(ActionEvent e) {
				textNombre.setText("");
				textApellidos.setText("");
				textNIF.setText("");
				textNSS.setText("");
				textTarifa.setText("");
				textHoras.setText("");
				textArea.setText("");
				textNombre.grabFocus();
			}
		});
		btnBorrar.setBounds(235, 191, 160, 23);
		contentPane.add(btnBorrar);
		
	}
}
