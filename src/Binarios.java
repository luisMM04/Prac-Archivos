import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Binarios{
    public static void main(String[] args) {
        try {

            DataInputStream inputA = new DataInputStream(new FileInputStream("a.mat"));
            int FilasA = inputA.readByte();
            int ColumnasA = inputA.readByte();
            double[][] matrizA = new double[FilasA][ColumnasA];
            for (int i = 0; i < FilasA; i++) {
                for (int j = 0; j < ColumnasA; j++) {
                    matrizA[i][j] = inputA.readDouble();
                }
            }
            inputA.close();


            DataInputStream inputB = new DataInputStream(new FileInputStream("b.mat"));
            int FilasB = inputB.readByte();
            int ColumnasB = inputB.readByte();
            double[][] matrizB = new double[FilasB][ColumnasB];

            for (int i = 0; i < FilasB; i++) {
                for (int j = 0; j < ColumnasB; j++) {
                    matrizB[i][j] = inputB.readDouble();
                }
            }
            inputB.close();


            // Calcular el producto de las matrices
            double[][] MatrizResultante = new double[FilasA][ColumnasB];
            for (int i = 0; i < FilasA; i++) {
                for (int j = 0; j < ColumnasB; j++) {
                    for (int k = 0; k < ColumnasA; k++) {
                        MatrizResultante[i][j] += matrizA[i][k] * matrizB[k][j];
                    }
                }
            }

            DataOutputStream outputMatriz= new DataOutputStream(new FileOutputStream("c.mat"));
            outputMatriz.writeByte(FilasA);
            outputMatriz.writeByte(ColumnasB);
            for (int i = 0; i < FilasA; i++) {
                for (int j = 0; j <ColumnasB ; j++) {
                    outputMatriz.writeDouble(MatrizResultante[i][j]);
                }

            }






            // Imprimir el resultado
            System.out.println("Producto de las matrices:");
            for (int i = 0; i < FilasA; i++) {
                for (int j = 0; j < ColumnasB; j++) {
                    System.out.print(MatrizResultante[i][j] + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

