
public class Main {

    public static void main(String[] args) {


        int[] productosVectorA = {1,2,45,69,84,21,74,35,14,69};//Vector productos
        int[] pedidosVectorB =   {1,2,3,4,5,6,7,25,9,96};//Vector pedidos
        int[] vectorC = new int[10];

        for (int i = 0; i < 10; i++) {

            if(productosVectorA[i] == pedidosVectorB[i]){//Si el producto es igual que el pedido se almacena el mismo numero
                    vectorC[i] = productosVectorA[i];
            }

            else if(pedidosVectorB[i] > productosVectorA[i]){//Si el pedido es mayor que el producto se almacena el doble de la diferencia entre b y a
                vectorC[i] = 2 * (pedidosVectorB[i] - productosVectorA[i]);
            }

            else if(productosVectorA[i] > pedidosVectorB[i]) {//Si A es mayor que B, se almacena B
                vectorC[i] = pedidosVectorB[i];
            }

        }

        for (int i = 0; i < vectorC.length; i++) {//Imprimimos los resultados
            System.out.println("Producto "+(i+1)+" tiene "+vectorC[i]+" unidades en existencia");
        }

    }

}
