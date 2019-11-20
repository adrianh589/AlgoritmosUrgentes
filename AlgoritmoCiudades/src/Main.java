import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase que permite viajar de una ciudad a otra validadndo los caminos
 * @author: Adrian Hoyos
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//Lector para captura de datos

        boolean[][] conexiones = //Matriz con las posibles conexiones del problema original
                {
                      //0     1     2     3     4     5    6
                /*0*/{false,false,true ,false,false,true ,false},
                /*1*/{false,false,false,true ,false,false,false},
                /*2*/{true ,false,false,false,true ,false,false},
                /*3*/{false,true ,false,false,false,true ,false},
                /*4*/{false,false,true ,false,false,false,false},
                /*5*/{true ,false,false,true ,false,false,true },
                /*6*/{false,false,false,false,false,true ,false}
                };

        System.out.println("Digite la ciudad de origen");
        int ciudadOrigen = Integer.parseInt(br.readLine());
        System.out.println("Digite la ciudad de destino");
        int ciudadDestino = Integer.parseInt(br.readLine());
        int[] solucion = new int[0];
        recorridoCiudades(ciudadOrigen , -1, ciudadDestino , conexiones, solucion);
    }

    /**
     * Metodo recursivo que permite realizar el recorrido entre las ciudades
     * @param ciudadActual Ciudad en la que nos encontramos actualmente
     * @param ciudadAnterior Ciudad de la que veniamos
     */
    static void recorridoCiudades(int ciudadActual, int ciudadAnterior, int ciudadDestino, boolean[][] conexiones, int[] solucion){

        if(ciudadActual == ciudadDestino){//Si llegamos a la ciudad de destino, es porque se acaba la recursion
            System.out.println("Camino encontrado");
            solucion = aniadirSolucion(solucion, ciudadActual);//Añadimos la ultima ciudad
            imprimirSolucion(solucion);//Mostramos el camino generado
            return;
        }
        else{//Aqui iremos buscando las posibles ciudades
            for (int eleccion = 0; eleccion < conexiones.length; eleccion++) { //Se pregunta por los posibles caminos de la ciudad actual
                if(conexiones[ciudadActual][eleccion] == true && eleccion != ciudadAnterior){//Tener en cuenta que se debe verificar con la matriz del problema y que no se vuelva a elegir la ciudad anterior
                    recorridoCiudades(eleccion, ciudadActual,ciudadDestino, conexiones, aniadirSolucion(solucion, ciudadActual));//Recursion: ahora la ciudad actual sera la elegida
                                                                                                                                 //La ciudad anterior sera la actual
                                                                                                                                 //La ciudad de destino es la misma al igual que las conexiones
                                                                                                                                 //el metodo aniadirSolucion nos ayuda a redimensionar la solucion
                }
            }
        }
    }

    /**
     * Metodo que permitira almacenar la solucion
     * @param solucion Recibe la solucion
     * @param ciudad Recibe la ciudad en la que esta actualmente
     * @return La solucion redimensionada
     */
    static int[] aniadirSolucion(int[] solucion, int ciudad){
        int[] aux = new int[solucion.length+1];//Redimensionamos el arreglo
        for (int i = 0; i < solucion.length; i++) {//Copiamos lo que teniamos en el nuevo arreglo
            aux[i] = solucion[i];
        }
        aux[aux.length-1] = ciudad+1;//En la ultima posicion añadimos la nueva ciudad
        return aux;//Se retorna el arreglo generado
    }

    /**
     * Metodo para imprimir la solucion
     * @param solucion Recibe la solucion generada
     */
    static void imprimirSolucion(int[] solucion){
        for (int i = 0; i < solucion.length; i++) {
            System.out.print(solucion[i] + " ");
        }
    }


}
