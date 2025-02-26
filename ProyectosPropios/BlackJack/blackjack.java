package Terminado;

import java.util.Scanner;
import java.util.ArrayList;

public class blackjack {

    // TODO Si el jugador consigui blackjack (21 exacto) se tiene que pagar un 0.5
    // más, ósea se devuelve lo que invierte por 2.5, a no ser que el crupier tenga
    // también un blackjack, en ese caso se devuelve el dinero invertido

    // El total del numero que se puede tener contando las cartas de la mano
    static final byte NUMERO_MAXIMO = 21;
    static int dineroQueVaApostar = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Estas final nos diran cual es la primera y la ultima opción
        // Cambiar los valores si se añade o se quita alguna opcion
        final byte EMPEZAR_JUEGO = 1;
        final byte RESULTADO_PARTIDAS = 2;
        final byte SALIR_DEL_JUEGO = 3;
        // Variable que asignara una primera cantidad de dinero al jugador
        final byte DINERO_INICIAL_JUGADOR = 100;
        boolean ejecucionPrograma = true;
        // Asignamos el dinero que tendrá el jugador en la variable mutable
        double dineroJugador = DINERO_INICIAL_JUGADOR;
        // Variables para guardar cada vez que uno de los dos gane
        int partidasGanadasCrupier = 0;
        int partidasGanadasJugador = 0;
        do {
            System.out.println("\n-----------");
            System.out.println(" BLACKJACK");
            System.out.println("-----------");
            System.out.println("1) Empezar juego");
            System.out.println("2) Ver resultado de las partidas");
            System.out.println("3) Salir");
            System.out.print("\nElige alguna opción: ");
            if (sc.hasNextInt()) {
                int eleccionJugador = sc.nextInt();
                if (eleccionJugador >= EMPEZAR_JUEGO && eleccionJugador <= SALIR_DEL_JUEGO) {
                    switch (eleccionJugador) {
                        case EMPEZAR_JUEGO -> {
                            // El jugador tiene que poner cuanto dinero quiere aposta
                            boolean cantidadDeDineroCorrecta = false;
                            do {
                                System.out.println("\nDinero actual: " + dineroJugador);
                                System.out.print("Introduce la cantidad de dinero que quieres apostar: ");
                                if (sc.hasNextInt()) {
                                    dineroQueVaApostar = sc.nextInt();
                                    if (dineroQueVaApostar > 0 && dineroQueVaApostar <= dineroJugador) {
                                        System.out.println("Has decidido apostar: " + dineroQueVaApostar);
                                        dineroJugador -= dineroQueVaApostar;
                                        cantidadDeDineroCorrecta = true;
                                    } else {
                                        System.out.println(
                                                "Tienes que introducir un número acorde con el dinero que tienes.");
                                    }
                                } else {
                                    sc.next();
                                    System.out.println(
                                            "Tienes que introducir un número acorde con el dinero que tienes.");
                                }
                            } while (!cantidadDeDineroCorrecta);
                            // Opciones
                            final byte PEDIR_CARTA = 1;
                            final byte PLANTARSE = 2;
                            final byte DOBLAR = 3;
                            final byte SEPARAR = 4;
                            // Las cartas que se repartirán al empezar el juego
                            final byte CANTIDAD_CARTAS_POR_REPARTIR = 2;
                            // Array con todas las cartas de una baraja de poker
                            ArrayList<String> barajaDeCartas = new ArrayList<>();
                            // Metodo que rellenará la baraja con cartas
                            barajaDeCartas = meterCartasBaraja();
                            boolean sePlanta = false;
                            // Almacenamos las cartas de cada jugador en un array
                            ArrayList<String> manoJugador = new ArrayList<>();
                            ArrayList<String> manoCrupier = new ArrayList<>();
                            // Si el jugador tiene el mismo valor de cartas en la mano podrá doblar, para
                            // esto crearé dos array para cada montón
                            ArrayList<String> manoJugadorDobladaIzquierda = new ArrayList<>();
                            ArrayList<String> manoJugadorDobladaDerecha = new ArrayList<>();
                            // Repartimos 2 cartas para el jugador y el crupier
                            for (int i = 0; i < CANTIDAD_CARTAS_POR_REPARTIR; i++) {
                                manoJugador.add(repartirMano(barajaDeCartas));
                                manoCrupier.add(repartirMano(barajaDeCartas));
                            }
                            // Variable que nos dirá si el jugar ha seleccionado pedir la carta
                            boolean haPedido = false;
                            // Lo mismo pero con la opción doblar, plantar y separar
                            boolean haDoblado = false;
                            boolean haPlantado = false;
                            boolean haSeparado = false;
                            // Variables por si puede doblar, comprovaremos si se ha pasado de 21 o no
                            boolean seHaPasadoManoIzquierda = false;
                            boolean seHaPasadoManoDerecha = false;
                            do {
                                System.out.println("\nCartas crupier");
                                System.out.println("-----------");
                                // Imprime la primera carta
                                System.out.println(manoCrupier.get(0));
                                // La segunda carta es un misterio
                                System.out.println("???\n");

                                System.out.println("Cartas jugador");
                                System.out.println("-----------");
                                // Mostramos las cartas del jugador
                                if (!haSeparado) {
                                    for (String cartasJugador : manoJugador) {
                                        System.out.println(cartasJugador);
                                    }
                                } else {
                                    System.out.println("Mano 1");
                                    System.out.println("-----------");
                                    for (String cartasJugadorMano1 : manoJugadorDobladaIzquierda) {
                                        System.out.println(cartasJugadorMano1);
                                    }
                                    System.out.println("-----------");
                                    System.out.println("Mano 2");
                                    System.out.println("-----------");
                                    for (String cartasJugadorMano2 : manoJugadorDobladaDerecha) {
                                        System.out.println(cartasJugadorMano2);
                                    }
                                }
                                // Comprovamos que las cartas del jugador tengan el mismo número para poder
                                // separar
                                boolean puedeSeparar = (manoJugador.get(0).split(" ")[1]
                                        .equals(manoJugador.get(1).split(" ")[1])) ? true : false;
                                System.out.println("\n1) Pedir Carta");
                                System.out.println("2) Plantarse");
                                // Solo se imprimirá si el jugador no ha pedido carta
                                if (!haPedido && puedeSeparar) {
                                    System.out.println("3) Doblar");
                                    System.out.println("4) Separar");
                                } else if (!haPedido && !puedeSeparar) {
                                    System.out.println("3) Doblar");
                                }
                                System.out.print("Introduce tu elección: ");
                                if (sc.hasNextInt()) {
                                    int opcionJugador = sc.nextInt();
                                    if (opcionJugador >= PEDIR_CARTA && opcionJugador <= SEPARAR) {
                                        switch (opcionJugador) {
                                            case PEDIR_CARTA -> {
                                                if (!haSeparado) {
                                                    // Se añade la carta al jugador
                                                    manoJugador.add(repartirMano(barajaDeCartas));
                                                    // Se comprueba si se ha pasado de 21
                                                    int sumaCartas = contarTotalMano(manoJugador);
                                                    // Si es mayor al máximo el jugador a perdido
                                                    if (sumaCartas > NUMERO_MAXIMO) {
                                                        System.out.println("Te has pasado de 21.");
                                                        sePlanta = true;
                                                    }
                                                    // Contamos que el jugador ya ha pedido
                                                    haPedido = true;
                                                } else {
                                                    final byte PRIMERA_MANO = 1;
                                                    final byte SEGUNDA_MANO = 2;
                                                    System.out.print(
                                                            "\nIntroduce a que mano quieres meter cartas (1/2): ");
                                                    if (sc.hasNextInt()) {
                                                        int manoSeleccionada = sc.nextInt();
                                                        if (manoSeleccionada >= PRIMERA_MANO
                                                                && manoSeleccionada <= SEGUNDA_MANO) {
                                                            if (manoSeleccionada == PRIMERA_MANO
                                                                    && !seHaPasadoManoIzquierda) {
                                                                manoJugadorDobladaIzquierda
                                                                        .add(repartirMano(barajaDeCartas));
                                                            } else if (manoSeleccionada == SEGUNDA_MANO
                                                                    && !seHaPasadoManoDerecha) {
                                                                manoJugadorDobladaDerecha
                                                                        .add(repartirMano(barajaDeCartas));
                                                            } else {
                                                                System.out.println(
                                                                        "No puedes introducir más cartas en una mano que se ha pasado de "
                                                                                + NUMERO_MAXIMO);
                                                            }
                                                        } else {
                                                            System.out.println("Introduce 1 o 2.");
                                                        }
                                                    } else {
                                                        System.out.println("Introduce 1 o 2.");
                                                        sc.next();
                                                    }
                                                }
                                            }
                                            case PLANTARSE -> {
                                                haPlantado = true;
                                            }
                                            case DOBLAR -> {
                                                if (!haPedido) {
                                                    System.out.println("\nHas decidido doblar.");
                                                    // Volvemos a restar lo que el jugador ha apostado de su monedero
                                                    dineroJugador -= dineroQueVaApostar;
                                                    // Doblamos el dinero que se apuesta
                                                    dineroQueVaApostar *= 2;
                                                    // Y añadimos una carta
                                                    manoJugador.add(repartirMano(barajaDeCartas));
                                                    haDoblado = true;
                                                } else {
                                                    System.out.println("No puedes doblar si has pedido carta.");
                                                }
                                            }
                                            case SEPARAR -> {
                                                if (!haSeparado && !haPedido) {
                                                    // Pasamos la primera carta de la mano del jugador al array del
                                                    // montón de la izquierda
                                                    manoJugadorDobladaIzquierda.add(manoJugador.get(0));
                                                    // Hacemos lo mismo pero con el de la derecha
                                                    manoJugadorDobladaDerecha.add(manoJugador.get(1));
                                                    // Le volvemos a quitar el dinero apostado porque se entiende que
                                                    // quiere doblar
                                                    dineroJugador -= dineroQueVaApostar;
                                                    dineroQueVaApostar *= 2;
                                                    haSeparado = true;
                                                }
                                            }
                                        }
                                        if (haDoblado || haPlantado) {
                                            boolean haTerminado = false;
                                            int sumaCartasCrupier = 0;
                                            // El crupier coge cartas hasta tener 17 o más
                                            while (!haTerminado) {
                                                // Contamos las cartas del crupier
                                                sumaCartasCrupier = contarTotalMano(manoCrupier);
                                                // En el blackjack el crupier pide cartas hasta tener 17 o más
                                                if (sumaCartasCrupier < 17) {
                                                    manoCrupier.add(repartirMano(barajaDeCartas));
                                                } else {
                                                    haTerminado = true;
                                                }
                                            }
                                            // Mostramos las cartas del jugador solo si no se planta
                                            if (!haPlantado) {
                                                System.out.println("\nCartas jugador");
                                                System.out.println("-----------");
                                                for (String cartasJugador : manoJugador) {
                                                    System.out.println(cartasJugador);
                                                }
                                            }
                                            // Mostramos las cartas del crupier siempre
                                            System.out.println("\nCartas crupier");
                                            System.out.println("-----------");
                                            for (String cartasCrupier : manoCrupier) {
                                                System.out.println(cartasCrupier);
                                            }

                                            // Si el crupier se pasa, si el jugador separa la logica cambia un poco
                                            if (sumaCartasCrupier > NUMERO_MAXIMO && !haSeparado) {
                                                System.out.println("\nEl crupier se ha pasado.");
                                                System.out.println("El jugador recibe " + dineroQueVaApostar);
                                                // Se multiplica x2 para que le devuelva el dinero y le den lo que ha
                                                // ganado
                                                dineroJugador += dineroQueVaApostar * 2;
                                                partidasGanadasJugador++;
                                                // Si no se pasa
                                            } else {
                                                if (haSeparado) {
                                                    // Contamos cada una de las manos
                                                    int totalManoIzquierda = contarTotalMano(
                                                            manoJugadorDobladaIzquierda);
                                                    int totalManoDerecha = contarTotalMano(manoJugadorDobladaDerecha);
                                                    boolean gananLasDosManos = (!seHaPasadoManoIzquierda
                                                            && !seHaPasadoManoDerecha
                                                            && totalManoIzquierda > sumaCartasCrupier
                                                            && totalManoDerecha > sumaCartasCrupier) ? true : false;
                                                    boolean ganaUnaMano = (!seHaPasadoManoIzquierda
                                                            && !seHaPasadoManoDerecha
                                                            && totalManoIzquierda > sumaCartasCrupier
                                                            || totalManoDerecha > sumaCartasCrupier) ? true : false;
                                                    boolean empatanLasDosManos = (!seHaPasadoManoIzquierda
                                                            && !seHaPasadoManoDerecha
                                                            && totalManoIzquierda == sumaCartasCrupier
                                                            && totalManoDerecha == sumaCartasCrupier) ? true : false;
                                                    boolean empataUnaMano = (!seHaPasadoManoIzquierda
                                                            && !seHaPasadoManoDerecha
                                                            && totalManoIzquierda == sumaCartasCrupier
                                                            || totalManoDerecha == sumaCartasCrupier) ? true : false;
                                                    if (gananLasDosManos || ganaUnaMano) {
                                                        System.out.println(
                                                                "\nEl jugador ha ganado, recibe " + dineroQueVaApostar);
                                                        dineroJugador += dineroQueVaApostar * 2;
                                                        partidasGanadasJugador++;
                                                    } else if (empatanLasDosManos || empataUnaMano) {
                                                        System.out.println(
                                                            "\nEl jugador ha empatado, recibe " + dineroQueVaApostar);
                                                        dineroJugador += dineroQueVaApostar;
                                                        partidasGanadasJugador++;
                                                    } else {
                                                        System.out.println("\nEl crupier ha ganado");
                                                        System.out.println("El jugador pierde " + dineroQueVaApostar);
                                                        partidasGanadasCrupier++;
                                                    }
                                                } else {
                                                    // Contamos las cartas que tiene el jugador
                                                    int sumaCartasJugador = contarTotalMano(manoJugador);
                                                    if (sumaCartasCrupier > sumaCartasJugador) {
                                                        System.out.println("\nEl crupier ha ganado");
                                                        System.out.println("El jugador pierde " + dineroQueVaApostar);
                                                        partidasGanadasCrupier++;
                                                    } else if (sumaCartasCrupier < sumaCartasJugador) {
                                                        System.out.println(
                                                                "\nEl jugador ha ganado, recibe " + dineroQueVaApostar);
                                                        dineroJugador += dineroQueVaApostar * 2;
                                                        partidasGanadasJugador++;
                                                    } else {
                                                        System.out.println("\nHabeis empatado.");
                                                        System.out.println("Se rembolsa el dinero al jugador.");
                                                        // Se rembolsa el dinero
                                                        dineroJugador += dineroQueVaApostar;
                                                        partidasGanadasCrupier++;
                                                        partidasGanadasJugador++;
                                                    }
                                                }
                                            }
                                            // Terminamos la partida
                                            sePlanta = true;
                                        } else if (haSeparado) {
                                            // Contamos cada una de las manos
                                            int totalManoIzquierda = contarTotalMano(manoJugadorDobladaIzquierda);
                                            int totalManoDerecha = contarTotalMano(manoJugadorDobladaDerecha);
                                            // Comprovamos si se pasa de 21
                                            seHaPasadoManoIzquierda = (totalManoIzquierda > NUMERO_MAXIMO) ? true
                                                    : false;
                                            seHaPasadoManoDerecha = (totalManoDerecha > NUMERO_MAXIMO) ? true : false;
                                            // Si ambas manos se pasan del máximo, fin de la partida
                                            if (seHaPasadoManoIzquierda && seHaPasadoManoDerecha) {
                                                sePlanta = true;
                                                System.out.println("Te has pasado de 21 en ambas manos.");
                                            } else if (seHaPasadoManoIzquierda) {
                                                System.out.println("La mano 1 se ha pasado de " + NUMERO_MAXIMO);
                                            } else if (seHaPasadoManoDerecha) {
                                                System.out.println("La mano 2 se ha pasado de " + NUMERO_MAXIMO);
                                            }
                                        }
                                    } else {
                                        System.out.println("Tienes que introducir una de las opciones.");
                                    }
                                } else {
                                    sc.next();
                                    System.out.println("Tienes que introducir una de las opciones.");
                                }
                            } while (!sePlanta);
                        }
                        case RESULTADO_PARTIDAS -> {
                            System.out.println("\nPartidas ganadas crupier: " + partidasGanadasCrupier);
                            System.out.println("Partidas ganadas jugador: " + partidasGanadasJugador);
                        }
                        case SALIR_DEL_JUEGO -> {
                            System.out.println("\nHas salido del juego.");
                            ejecucionPrograma = false;
                        }
                    }
                } else {
                    System.out.println("Tienes que introducir una de las opciones");
                }
            } else {
                sc.next();
                System.out.println("Tienes que introducir una de las opciones");
            }
            // Si el dinero del jugador llega a 0 o menos se parará el progrma
        } while (ejecucionPrograma && dineroJugador > 0);
    }

    static ArrayList<String> meterCartasBaraja() {
        ArrayList<String> barajaDeCartas = new ArrayList<>();
        // Una baraja de poker tiene 4 palos, cada palo con 13 cartas, del 2 al 10 y
        // K, Q, J, A
        // Palos: Corazones, Diamantes, Treboles, Picas
        final byte CANTIDAD_DE_CARTAS_POR_PALO = 13;
        final byte CANTIDAD_DE_PALOS = 4;
        for (int i = 0; i < CANTIDAD_DE_PALOS; i++) {
            String cartaActual = "";
            if (i == 0) {
                cartaActual = "Corazon";
            } else if (i == 1) {
                cartaActual = "Diamante";
            } else if (i == 2) {
                cartaActual = "Trebol";
            } else if (i == 3) {
                cartaActual = "Pica";
            }
            for (int j = 1; j <= CANTIDAD_DE_CARTAS_POR_PALO; j++) {
                if (j == 1) {
                    barajaDeCartas.add(cartaActual + " A");
                } else if (j == 11) {
                    barajaDeCartas.add(cartaActual + " J");
                } else if (j == 12) {
                    barajaDeCartas.add(cartaActual + " Q");
                } else if (j == 13) {
                    barajaDeCartas.add(cartaActual + " K");
                } else {
                    barajaDeCartas.add(cartaActual + " " + j);
                }
            }
        }
        return barajaDeCartas;
    }

    static String repartirMano(ArrayList<String> barajaDeCartas) {
        // Numero random para seleccionar una carta aleatoria
        int numeroRandom = (int) (Math.random() * (barajaDeCartas.size()));
        // Eliminamos la carta seleccionada
        barajaDeCartas.remove(numeroRandom);
        // Añadimos la carta aleatoria a la mano del jugador
        return barajaDeCartas.get(numeroRandom);
    }

    static int contarTotalMano(ArrayList<String> manoJugador) {
        // Los palos que existen
        final String AS = "A";
        final String JOTA = "J";
        final String REINA = "Q";
        final String REI = "K";
        // Variable donde iremos guardando la suma de las cartas
        int sumaCartas = 0;
        for (int i = 0; i < manoJugador.size(); i++) {
            String carta = manoJugador.get(i);
            String valorCarta = carta.split(" ")[1];

            if (valorCarta.equals(AS)) {
                // El as puede ser 11 o 1, si se supera el número máximo será 1, si no 11
                if (sumaCartas + 11 > NUMERO_MAXIMO) {
                    sumaCartas++;
                } else {
                    sumaCartas += 11;
                }
                // Tanto la jota, como el rei, como la reina valen lo mismo
            } else if (valorCarta.equals(JOTA) || valorCarta.equals(REINA) || valorCarta.equals(REI)) {
                sumaCartas += 10;
            } else {
                sumaCartas += Integer.parseInt(valorCarta);
            }
        }
        // Si es blackjack
        if (sumaCartas == NUMERO_MAXIMO) {
            esBlackJack();
        }
        return sumaCartas;
    }

    static void esBlackJack() {
        // Subimos el dinero que el jugador recibirá por 0.5, como en el juego original
        dineroQueVaApostar += dineroQueVaApostar * 0.5;
    }
}