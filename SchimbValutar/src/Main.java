import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Moneda de plecare( RON, USD, EUR, GBP): ");
        Scanner mDP = new Scanner(System.in);
        String monedaDePlecare = mDP.nextLine();

        System.out.println("Moneda rezultanta( RON, USD, EUR, GBP): ");
        Scanner mR = new Scanner(System.in);
        String monedaRezultanta = mR.nextLine();

        float schimbValutar = aflaSchimbulValutar(monedaDePlecare, monedaRezultanta);

        if (schimbValutar == 0) {
            System.exit(0);
        }

        float rezultatConversie = conversiaBanilor(monedaDePlecare, schimbValutar);

        System.out.println("Numarul de " + monedaRezultanta.toUpperCase() + " este: " + rezultatConversie);
    }

    public static float aflaSchimbulValutar(String monedaDePlecare, String monedaRezultanta) {
        final float LeiInDolari = 0.22F;
        final float LeiInEuro = 0.20F;
        final float LeiInLireSterline = 0.17F;
        final float DolariInLei = 4.60F;
        final float DolariInEuro = 0.93F;
        final float DolariInLireSterline = 0.77F;
        final float EuroInLei = 4.97F;
        final float EuroInDolari = 1.08F;
        final float EuroInLireSterline = 0.83F;
        final float LireSterlineInLei = 5.97F;
        final float LireSterlineInDolari = 1.30F;
        final float LireSterlineInEuro = 1.20F;
        float schimbValutarFinal = 0;

        switch (monedaDePlecare.toUpperCase()) {
            case "RON":
                switch (monedaRezultanta.toUpperCase()) {
                    case "RON":
                        System.out.println("Alege alta moneda");
                        break;

                    case "USD":
                        schimbValutarFinal = LeiInDolari;
                        break;

                    case "EUR":
                        schimbValutarFinal = LeiInEuro;
                        break;

                    case "GBP":
                        schimbValutarFinal = LeiInLireSterline;
                        break;

                    default:
                        System.out.println("Moneda " + monedaRezultanta + " nu a fost gasita");
                        break;

                }
                break;

            case "USD":
                switch (monedaRezultanta.toUpperCase()) {
                    case "RON":
                        schimbValutarFinal = DolariInLei;
                        break;

                    case "USD":
                        System.out.println("Alege alta moneda");
                        break;

                    case "EUR":
                        schimbValutarFinal = DolariInEuro;
                        break;

                    case "GBP":
                        schimbValutarFinal = DolariInLireSterline;
                        break;

                    default:
                        System.out.println("Moneda " + monedaRezultanta + " nu a fost gasita");
                        break;

                }
                break;

            case "EUR":
                switch (monedaRezultanta.toUpperCase()) {
                    case "RON":
                        schimbValutarFinal = EuroInLei;
                        break;

                    case "USD":
                        schimbValutarFinal = EuroInDolari;
                        break;

                    case "EUR":
                        System.out.println("Alege alta moneda");
                        break;

                    case "GBP":
                        schimbValutarFinal = EuroInLireSterline;
                        break;

                    default:
                        System.out.println("Moneda " + monedaRezultanta + " nu a fost gasita");
                        break;

                }
                break;

            case "GBP":
                switch (monedaRezultanta.toUpperCase()) {
                    case "RON":
                        schimbValutarFinal = LireSterlineInLei;
                        break;

                    case "USD":
                        schimbValutarFinal = LireSterlineInDolari;
                        break;

                    case "EUR":
                        schimbValutarFinal = LireSterlineInEuro;
                        break;

                    case "GBP":
                        System.out.println("Alege alta moneda");
                        break;

                    default:
                        System.out.println("Moneda " + monedaRezultanta + " nu a fost gasita");
                        break;

                }
                break;

            default:
                System.out.println("Moneda " + monedaDePlecare + " nu a fost gasita");
                break;

        }

        return schimbValutarFinal;
    }

    public static float conversiaBanilor(String monedaDePlecare, float schimbValutar) {
        System.out.println("Introdu numarul de " + monedaDePlecare.toUpperCase() + ": ");
        Scanner nB = new Scanner(System.in);
        float nrBani = nB.nextFloat();
        return Float.parseFloat(new DecimalFormat("0.00").format(nrBani * schimbValutar));
    }
}