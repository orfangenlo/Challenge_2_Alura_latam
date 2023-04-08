package Conversor_moneda;


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class ConversorMoneda extends JFrame implements ActionListener {
	    // Componentes de la interfaz gráfica
	    private JLabel etiquetaMonto, etiquetaMonedaOrigen, etiquetaMonedaDestino, etiquetaResultado;
	    private JTextField campoMonto;
	    private JComboBox<String> comboMonedaOrigen, comboMonedaDestino;
	    private JButton botonConvertir;

	    // Tasas de conversión de cada moneda a dólares estadounidenses
	    private static final double TASA_USD = 1.0;
	    private static final double TASA_EUR = 1.17;
	    private static final double TASA_GBP = 1.39;
	    private static final double TASA_JPY = 0.0091;
	    private static final double TASA_COP = 0.0002;
	    private static final double TASA_MEX = 0.055;

	    public ConversorMoneda() {
	        super("Conversor de moneda");

	        // Crear componentes de la interfaz gráfica
	        etiquetaMonto = new JLabel("Monto:");
	        etiquetaMonedaOrigen = new JLabel("Moneda origen:");
	        etiquetaMonedaDestino = new JLabel("Moneda destino:");
	        etiquetaResultado = new JLabel("");
	        campoMonto = new JTextField(10);
	        comboMonedaOrigen = new JComboBox<String>(new String[]{"USD", "EUR", "GBP", "JPY", "COP", "MEX"});
	        comboMonedaDestino = new JComboBox<String>(new String[]{"USD", "EUR", "GBP", "JPY", "COP", "MEX"});
	        botonConvertir = new JButton("Convertir");

	        // Establecer el diseño de la interfaz gráfica
	        setLayout(new GridLayout(4, 2));

	        // Agregar componentes a la interfaz gráfica
	        add(etiquetaMonto);
	        add(campoMonto);
	        add(etiquetaMonedaOrigen);
	        add(comboMonedaOrigen);
	        add(etiquetaMonedaDestino);
	        add(comboMonedaDestino);
	        add(etiquetaResultado);
	        add(botonConvertir);

	        // Establecer el tamaño de la ventana y hacerla visible
	        setSize(400, 150);
	        setVisible(true);

	        // Establecer el comportamiento del botón Convertir al hacer clic en él
	        botonConvertir.addActionListener(this);
	    }

	    public void actionPerformed(ActionEvent e) {
	        // Obtener los valores del campo de monto y los combos de moneda origen y destino
	        double monto = Double.parseDouble(campoMonto.getText());
	        String monedaOrigen = comboMonedaOrigen.getSelectedItem().toString();
	        String monedaDestino = comboMonedaDestino.getSelectedItem().toString();

	        // Convertir el monto a dólares estadounidenses
	        double montoUSD = 0.0;
	        switch (monedaOrigen) {
	            case "USD":
	                montoUSD = monto;
	                break;
	            case "EUR":
	                montoUSD = monto * TASA_EUR;
	                break;
	            case "GBP":
	                montoUSD = monto * TASA_GBP;
	                break;
	            case "JPY":
	                montoUSD = monto * TASA_JPY;
	                break;
	            case "COP":
	                montoUSD = monto * TASA_COP;
	                break;
	            case "MEX":
	                montoUSD = monto * TASA_MEX;
	                break;
	        }

	        // Convertir el monto de dólares estadounidenses a la moneda destino
	        double montoDestino = 0.0;
	        switch (monedaDestino) {
	            case "USD":
		            montoDestino = montoUSD;
	            break;
	        case "EUR":
	            montoDestino = montoUSD / TASA_EUR;
	            break;
	        case "GBP":
	            montoDestino = montoUSD / TASA_GBP;
	            break;
	        case "JPY":
	            montoDestino = montoUSD / TASA_JPY;
	            break;
	        case "COP":
	            montoDestino = montoUSD / TASA_COP;
	            break;   
	        case "MEX":
	            montoDestino = montoUSD / TASA_MEX;
	            break;
	            
	    }

	    // Mostrar el resultado en la etiqueta correspondiente
	    etiquetaResultado.setText(String.format("%.2f %s = %.2f %s", monto, monedaOrigen, montoDestino, monedaDestino));
	}

	public static void main(String[] args) {
	    new ConversorMoneda();
	}

	
}