package Terminado;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;


public class ipcalculator {

    static String mascaraIntroducida;
    static String preguntaMascara;
    static int primerByte;
    static int segundoByte;
    static int tercerByte;
    static int cuartoByte;

    static int primerByteBinario;
    static int segundoByteBinario;
    static int tercerByteBinario;
    static int cuartoByteBinario;

    static int mascaraIntroducidaNumero;

    static String mascara8;

    static double bucle0;
    static double bucle2;

    static String mascaraBinarioEntera;
    static String mascaraBinarioEnteraFea;

    static String[] listaMascara = {"ERROR Array Lista Mascara", "128.0.0.0", "192.0.0.0", "224.0.0.0", "240.0.0.0", "248.0.0.0", "252.0.0.0", "254.0.0.0", "255.0.0.0", "255.128.0.0", "255.192.0.0", "255.224.0.0", "255.240.0.0", "255.248.0.0", "255.252.0.0", "255.254.0.0", "255.255.0.0", "255.255.128.0", "255.255.192.0", "255.255.224.0", "255.255.240.0", "255.255.248.0", "255.255.252.0", "255.255.254.0", "255.255.255.0", "255.255.255.128", "255.255.255.192", "255.255.255.224", "255.255.255.240", "255.255.255.248", "255.255.255.252", "255.255.255.254", "255.255.255.255"};
    
    static String mascaraIntroducidaSave = mascaraIntroducida;

    static DecimalFormat formatoNumeros() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        return new DecimalFormat("###,###.##", symbols);
    }

    public static void main(String[] args) {
        String ip; 
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Introduce una dirección IP: ");
            ip = scanner.nextLine();
            // Valida la IP
            if (!ip.matches("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b")) {
                System.out.println("Has introducido una IP no válida, vuelve a intentarlo.");
                return;
            }
            // Separa la cadena str
        String[] parts = ip.split("\\.");
        String separadorPrimerByte = parts[0];
        String separadorSegundoByte = parts[1];
        String separadorTercerByte = parts[2];
        String separadorCuartoByte = parts[3];
        // Convierte los str en int
            primerByte = Integer.parseInt(separadorPrimerByte);
            segundoByte = Integer.parseInt(separadorSegundoByte);
            tercerByte = Integer.parseInt(separadorTercerByte);
            cuartoByte = Integer.parseInt(separadorCuartoByte);
            System.out.println("¿Quieres introducir una mascara (En caso de poner 'N' la máscara será la por defecto según la clase de la IP)? (S/N): ");
            preguntaMascara = scanner.nextLine();
            String preguntaMascaraUpper = preguntaMascara.toUpperCase();
            switch (preguntaMascaraUpper) {
                case "S":
                    System.out.println("Introduce la máscara con formato /'x': ");
                    mascaraIntroducida = scanner.nextLine();
                    mascaraIntroducidaSave = mascaraIntroducida;
                    mascaraIntroducidaNumero = Integer.parseInt(mascaraIntroducida.replace("/",""));
                    mascaraIntroducida = listaMascara[mascaraIntroducidaNumero];
                    break;
                case "N":
                    if (primerByte <= 127 && primerByte >= 1) {
                        mascaraIntroducida = listaMascara[8];
                    } else if (primerByte >= 128 && primerByte <= 191) {
                        mascaraIntroducida = listaMascara[16];
                    } else if (primerByte >= 192 && primerByte <= 255) {
                        mascaraIntroducida = listaMascara[24];
                    } break;
                default:
                    System.out.println("Introdujiste algo mal");
                    return;
            }
        }
        // Espacio entre las respuestas del usuario y el programa
        System.out.println("");
        //Bucles
        bucle0 = 0;
        bucle2 = 0;
        for (int i = 0; i < mascaraIntroducida.length(); i++) {
            if (mascaraIntroducida.charAt(i) == '0') {
                bucle0++;
            } else if (mascaraIntroducida.charAt(i) == '2') {
                bucle2++;
            }
        }
        // Variable para indicar que todo ha salido bien y que se muestre la info de la ip
        boolean esCorrectaLaIP = false;
        // Variable para las clases
        char clase = ' ';
        // Clases
        if (primerByte <= 126 && primerByte >= 1) {
            clase = 'A';
            esCorrectaLaIP = true;
        } else if (primerByte == 127) {
            System.out.println("Loopback: " + ip);
        } else if (primerByte >= 128 && primerByte <= 191) {
            clase = 'B';
            esCorrectaLaIP = true;
        } else if (primerByte >= 192 && primerByte <= 223) {
            clase = 'C';
            esCorrectaLaIP = true;
        } else if (primerByte >= 224 && primerByte <= 239) {
            System.out.println("Clase D: " + ip);
        } else if (primerByte >= 240 && primerByte <= 255 && cuartoByte <=254) {
            System.out.println("Clase E: " + ip);
        } else {
            System.out.println("Has introducido una ip no válida, vuelve a intentarlo.");
        }
        if (esCorrectaLaIP) {
            System.out.println("Clase " + clase + ": " + ip);
            System.out.println("Mascara: " + mascaraIntroducida);
            ipPrivadaPublica();
            ipBinario();
            mascaraBinario();
            bucleHostRedesMaximos();
            parteDeRed();
        }
    }
    static void bucleHostRedesMaximos() {
        int numeroRedes = 0;
        int numeroHost = 0;
        for (int hostMaximo = 0; hostMaximo < mascaraBinarioEnteraFea.length(); hostMaximo++) {
            if (mascaraBinarioEnteraFea.charAt(hostMaximo) == '1') {
                numeroRedes++;
            } else if (mascaraBinarioEnteraFea.charAt(hostMaximo) == '0') {
                numeroHost++;
            }
        }
        double elevadoNumeroRedes;
        if (mascaraIntroducidaNumero <= 8) {
            elevadoNumeroRedes = Math.pow(2, numeroRedes - 1);
            DecimalFormat formatea = formatoNumeros();
            System.out.println("Numero de redes maximas: " + formatea.format(elevadoNumeroRedes));
        } else if (mascaraIntroducidaNumero > 8 && mascaraIntroducidaNumero <= 16) {
            elevadoNumeroRedes = Math.pow(2, numeroRedes - 2);
            DecimalFormat formatea = formatoNumeros();
            System.out.println("Numero de redes maximas: " + formatea.format(elevadoNumeroRedes));
        } else {
            elevadoNumeroRedes = Math.pow(2, numeroRedes - 3);
            DecimalFormat formatea = formatoNumeros();
            System.out.println("Numero de redes maximas: " + formatea.format(elevadoNumeroRedes));
        }
        
        double elevadoNumeroHost = Math.pow(2, numeroHost);
        DecimalFormat formateaa = formatoNumeros();
        System.out.println("Numero de host maximos: " + formateaa.format(elevadoNumeroHost));
    }
    static void parteDeRed() {
        if (bucle2 == 1) {
            System.out.println("Parte de red: " + primerByte);
            System.out.println("Parte de host: " + segundoByte + "." + tercerByte + "." + cuartoByte);
            System.out.println("Rango primer host: " + primerByte + ".0.0.1 - Ultimo Host: " + primerByte + ".255.255.254");
            System.out.println("Broadcast: " + primerByte + ".255.255.255");
        } else if (bucle2 == 2) {
            System.out.println("Parte de red: " + primerByte + "." + segundoByte);
            System.out.println("Parte de host: " + tercerByte + "." + cuartoByte);
            System.out.println("Rango primer host: " + primerByte + "." + segundoByte + ".0.1 - Ultimo Host: " + primerByte + "." +segundoByte + ".255.254");
            System.out.println("Broadcast: " + primerByte + "." + segundoByte + ".255.255");
        } else {
            System.out.println("Parte de red: " + primerByte + "." + segundoByte + "." + tercerByte);
            System.out.println("Parte de host: " + cuartoByte);
            System.out.println("Rango primer host: " + primerByte + "." + segundoByte + "." + tercerByte+ ".1 - Ultimo Host: " + primerByte + "." + segundoByte + "." + tercerByte + ".254");
            System.out.println("Broadcast: " + primerByte + "." +segundoByte + "." + tercerByte + ".255"); 
        }
    }
    static String bucleMascaraBinario(String mascara) {
        if (bucle2 == 1) {
            return mascaraIntroducidaSave;
        } else if (bucle2 == 2) {
            return mascaraIntroducidaSave;
        } else {
            return mascaraIntroducidaSave;
        }
    }
    static void mascaraBinario() {
        // Mascara
        String[] binario = mascaraIntroducida.split("\\.");
        String separadorPrimerByteBinario = binario[0];
        String separadorSegundoByteBinario = binario[1];
        String separadorTercerByteBinario = binario[2];
        String separadorCuartoByteBinario = binario[3];

        primerByteBinario = Integer.parseInt(separadorPrimerByteBinario);
        segundoByteBinario = Integer.parseInt(separadorSegundoByteBinario);
        tercerByteBinario = Integer.parseInt(separadorTercerByteBinario);
        cuartoByteBinario = Integer.parseInt(separadorCuartoByteBinario);

        // La mascara en binario separada y con un formato que a los 0 les hace tener 8 cifras 
        String primerByteBinarioConversor = String.format("%8s", Integer.toBinaryString(primerByteBinario)).replace(' ', '0');
        String segundoByteBinarioConversor = String.format("%8s", Integer.toBinaryString(segundoByteBinario)).replace(' ', '0');
        String tercerByteBinarioConversor = String.format("%8s", Integer.toBinaryString(tercerByteBinario)).replace(' ', '0');
        String cuartoByteBinarioConversor = String.format("%8s", Integer.toBinaryString(cuartoByteBinario)).replace(' ', '0');
        // La mascara en binario pero toda unida
        mascaraBinarioEnteraFea = primerByteBinarioConversor + segundoByteBinarioConversor + tercerByteBinarioConversor + cuartoByteBinarioConversor;
        // La mascara en binario pero toda unida separada por puntos
        mascaraBinarioEntera = primerByteBinarioConversor + "." + segundoByteBinarioConversor + "." + tercerByteBinarioConversor + "." + cuartoByteBinarioConversor;

        // La línea final
        System.out.println("Mascara en binario " + mascaraIntroducidaSave + ": " + mascaraBinarioEntera);
    }
    static void ipBinario() {
        String primerIpByteBinario = String.format("%8s", Integer.toBinaryString(primerByte)).replace(' ', '0');
        String segundoIpByteBinario = String.format("%8s", Integer.toBinaryString(segundoByte)).replace(' ', '0');
        String tercerIpByteBinario = String.format("%8s", Integer.toBinaryString(tercerByte)).replace(' ', '0');
        String cuartoIpByteBinario = String.format("%8s", Integer.toBinaryString(cuartoByte)).replace(' ', '0');

        System.out.println("Ip en binario: " + primerIpByteBinario + "." + segundoIpByteBinario + "." + tercerIpByteBinario + "." + cuartoIpByteBinario);
    }
    static void ipPrivadaPublica() {
        if (primerByte == 10) {
            System.out.println("La ip es Privada");
        } else if (primerByte == 172 && segundoByte >= 16 && segundoByte <= 31) {
            System.out.println("La ip es Privada");
        } else if (primerByte == 192) {
            System.out.println("La ip es Privada");
        }
        else {
            System.out.println("La ip NO es Privada");
        }
    }
}