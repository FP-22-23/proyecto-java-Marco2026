package fp.tipos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;
import fp.common.Purchase;
import fp.common.TypeCountry;
import fp.utiles.Checkers;

public class FactoriaCompras {

	public static Compras leerCompras(String rutaFichero) {
		Compras res = null;
		try {
			Stream<Compra> sc = 
					Files.lines(Paths.get(rutaFichero)).
					skip(1).
					map(FactoriaCompras::parsearCompra);
			res = new ComprasImpl(sc);
		} catch(IOException e) {
			System.out.println("No se ha encontrado el fichero " + rutaFichero);
		}
		return res;
	}

	public static Compra parsearCompra(String lineaCSV) {
		String[] campos = lineaCSV.split(";");
		Checkers.check("Error en elementos de Compra", campos.length == 8);
		String stockCode = campos[0].trim();
		String description = campos[1].trim();
		Purchase purchase = new Purchase(Integer.valueOf(campos[2].trim()), Double.valueOf(campos[3].trim().replace(",",".")));
		LocalDateTime purchaseDate = LocalDateTime.parse(campos[4].trim(), DateTimeFormatter.ofPattern("dd/M/yyyy H:mm"));
		Integer customerId = Integer.valueOf(campos[5].trim());
		TypeCountry country = TypeCountry.valueOf(campos[6].trim().toUpperCase().replace(" ", "_"));
		Boolean satisfied = parseBool(campos[7].trim());
		
		return new Compra(stockCode, description, purchase, purchaseDate, customerId, country, satisfied);
	}

	private static Boolean parseBool(String s) {
		Boolean res = false;
		if(s.equals("VERDADERO")) {
			res = true;
		}
		return res;
	}
	
}
