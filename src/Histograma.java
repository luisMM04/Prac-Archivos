import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Histograma {

    public static void main(String[] args) {
        try (BufferedReader Br = new BufferedReader(new FileReader("divina_comedia_sp.txt"))) {
            Map<Integer, Integer> LongitudPalabras = new HashMap<>();

            int valor;
            StringBuilder Palabras = new StringBuilder();

            while ((valor = Br.read()) != -1) {
                if (Character.isLetter(valor) || (valor >= 192 && valor <= 255)) {
                    Palabras.append((char) valor);
                } else if (Palabras.length() >= 2 && Palabras.length() <= 10) {
                    int Longitud = Palabras.length();
                    LongitudPalabras.put(Longitud, LongitudPalabras.getOrDefault(Longitud, 0) + 1);
                    Palabras.setLength(0);
                } else {
                    Palabras.setLength(0);
                }
            }

            Imprime(LongitudPalabras);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void Imprime(Map<Integer, Integer> histogram) {
        System.out.println("Longitud de Palabras:");
        for (Map.Entry<Integer, Integer> entry : histogram.entrySet()) {
            System.out.println("Palabras de " + entry.getKey() + " letras: " + entry.getValue());
        }
    }
}



