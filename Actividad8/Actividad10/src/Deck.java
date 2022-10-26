//Libreria para generar los arreglos y listas correspondientes a las cartas de poker
import java.util.*;
import javax.swing.*;

//Clase que agregara una carta de poker a la clase principal Deck
class Card
{
    //Arreglo con todas las cartas
    ArrayList<String> deck = new ArrayList<String>();

    //Atributos del tipo de carta
    String [] Palo = {"Treboles", "Corazones", "Picas", "Diamantes"};
    String [] Color = {"Rojo", "Negro"};
    String [] Valor = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};
}

//Clase que representara el conjunto de cartas de poker
public class Deck
{
    public static void main(String[] args) throws Exception {
        //Variables para obtener los valores de las cartas
        Card card = new Card();
        int palo = card.Palo.length;
        int color = card.Color.length;
        int valor = card.Valor.length;

        //Tamaño del arreglo
        int tamaño = palo * color * valor;

        //Inicio del arreglo deck
        ArrayList<String> deck = new ArrayList<String>();

        //Inicializa los valores de las cartas, los palos y finalmente agrega el color de las mismas
        for(int i =0; i < valor; i++)
        {
            for(int j = 0; j < palo; j++)
            {
                deck.add(card.Palo[j] + ", Rojo , " + card.Valor[i]);
                deck.add(card.Palo[j] + ", Negro , " + card.Valor[i]);
            }
        }

        //Crear la iteracion para imprimir los valores dentro del arreglo
        Iterator<String> impresion = deck.iterator();

        while(impresion.hasNext())
        {
            String componente = impresion.next();
            System.out.println(componente);
        }

        //Métodos que haran las funciones con los valores del deck
        /*
        shuffle (deck);
        head (deck);
        pick (deck);
        hand (deck);
         */

        //Metodo que imprimira las funciones del menu
        show_menu(deck);


    }

    //Metodo para mezclar el deck, debe imprimir un mensaje que diga se mezclo el deck
    public static void shuffle(ArrayList deck)
    {
        ArrayList<String> elementos = deck;
        Collections.shuffle(elementos);
        System.out.println("\n\n Se mezclo el Deck.\n\n");
        Iterator<String> impresionShuffle = deck.iterator();

        while(impresionShuffle.hasNext())
        {
            String componente = impresionShuffle.next();
            System.out.println(componente);
        }
    }

    //Se muestra la primera carta del deck y se remueve del arreglo y mostrar las demás cartas restantes
    public static void head (ArrayList deck) throws Exception
    {
        //Imprimir el primer valor del arreglo y luego borrarlo
        System.out.println("\n\nLa primera carta del deck es: " + deck.get(0) + "\n\n");
        deck.remove(0);

        System.out.println("Quedan " + deck.size() + "cartas");
        if (deck.size() <= 134)
        {
            throw new Exception("Se han agotado las cartas");
        }
    }

    //Pick busca seleccionar una carta al azar y removerala del deck
    public static void pick (ArrayList deck) throws Exception
    {
        //Imprimir un valor al azar del arreglo y removerlo del deck
        Random azar = new Random();
        System.out.println("\n\nLa carta al azar seleccionada es: " + deck.get(azar.nextInt(deck.size())) + "\n\n");
        deck.remove(azar.nextInt(deck.size()));
        System.out.println("Quedan " + deck.size() + "cartas\n\n");
        if (deck.size() <= 134)
        {
            throw new Exception("Se han agotado las cartas");
        }
    }


    //Imprime un arreglo de 5 cartas y se remueven del deck
    public static void hand (ArrayList deck) throws Exception
    {

        System.out.println("La mano de cartas que te toco fue: \n\n");

        //Ciclo para imprimir 5 valores del deck y posteriormente removerlos
        for(int i = 0; i<=4; i++)
        {
            System.out.println(deck.get(i));
        }

        for(int i=0; i<=4; i++)
        {
            deck.remove(i);
        }

        System.out.println("\n\nQuedan " + deck.size() + " cartas");
        if (deck.size() <= 134)
        {
            throw new Exception("Se han agotado las cartas");
        }
    }

    public static void show_menu (ArrayList<String> deck) throws Exception
    {
        //Variable para registrar en el escaner la opcion seleccionada y boolean para continuar con el programa
        int opcion=0;
        boolean finalizar=true;

        Scanner menu = new Scanner (System.in);

        do
        {

            //Impresion del menu
            System.out.println("\n\nBienvenido a poker!");
            System.out.println("1.- Mezclar deck");
            System.out.println("2.- Sacar una carta");
            System.out.println("3.- Carta al azar");
            System.out.println("4.- Generar una mano de 5 cartas");
            System.out.println("0.- Salir \n\n");

            //Escaner para el numero de la opcion que se desea registrar
            try
            {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("Selecciona una opcion: "));
            }
            catch(InputMismatchException e)
            {
                System.out.println("Opcion no valida");
            }

            //Switch que demostrara los diferentes casos del menu e imprimira lo correspondiente a cada caso y terminara su ejecucion
            try {
                switch (opcion) {
                    case 1:
                        shuffle(deck);
                        System.out.println();
                        break;

                    case 2:
                        head(deck);
                        System.out.println();
                        break;

                    case 3:
                        pick(deck);
                        System.out.println();
                        break;

                    case 4:
                        hand(deck);
                        System.out.println();
                        break;

                    case 0:
                        finalizar = false;
                        break;

                    // caso que sirve para cualquier opcion que no sea cualquiera de las anteriores
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Opcion no valida");
            }


        }

        //Proceso para finalizar el caso al cambiar el boolean a falso
        while (finalizar);
        {
            System.out.println("Finalizando programa");
        }

    }


}
