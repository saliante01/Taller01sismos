import java.util.InputMismatchException;
import java.util.Scanner;
public class Taller01Sismos {
    public static void main(String args[]) {
        double[] arr= new double[70];

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Ingreso de datos");
            System.out.println("2. Mostrar sismo de mayor magnitud");
            System.out.println("3. Contar sismos mayores o iguales a 5.0");
            System.out.println("4. enviar sms por cada sismo mayor a 7.0");
            System.out.println("5. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        arr=generarArreglo();
                        mostrarArreglo(arr);
                        System.out.println("" + arr);
                        break;
                    case 2:
                        calcularMayor(arr);
                        System.out.println("Sismo de mayor magnitud \n"+calcularMayor(arr));
                        break;
                    case 3:
                        contarSismos(arr);
                        System.out.println("sismos mayores a 5.0 " + contarSismos(arr));
                        break;
                    case 4:
                        enviarSMS(arr);
                        System.out.println(enviarSMS(arr));
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

    }

    public static double[] generarArreglo() {
        double[] arregloAleatorio = new double[70];
        for (int i = 0; i < arregloAleatorio.length; i++) {
            arregloAleatorio[i] = Math.random() * 10;
        }
        return arregloAleatorio;
    }

    public static void mostrarArreglo(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "]");
            System.out.println("");
        }
    }

    public static double calcularMayor(double[] arr) {
        double mayor = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mayor) {
                mayor = arr[i];
            }
        }
        return mayor;
    }

    public static int contarSismos(double[] arr) {
        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5.0) {
                contador = contador + 1;
            }


        }
        return contador;
    }

    public static String enviarSMS(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 7.0) {
                System.out.println("Alerta!!! se debe evacuar zona costera!");

            }

        }
        return "Alerta!!! se debe evacuar zona costera!";
    }
}

