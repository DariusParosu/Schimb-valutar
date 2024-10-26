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

        float schimbValutar = aflaDiferenta(monedaDePlecare, monedaRezultanta);

        if (schimbValutar == 0) {
            System.exit(0);
        }

            float rezultatConversie = conversiaBanilor(monedaDePlecare, schimbValutar);

        System.out.println("Numarul de " + monedaRezultanta.toUpperCase() + " este: " + rezultatConversie);
    }

    public static float aflaDiferenta(String monedaDePlecare, String monedaRezultanta) {
        final float schimbValutarLeiDolari = 0.22F;
        final float schimbValutarLeiEuro = 0.20F;
        final float schimbValutarLeiLireSterline = 0.17F;
        final float schimbValutarDolariLei = 4.60F;
        final float schimbValutarDolariEuro = 0.93F;
        final float schimbValutarDolariLireSterline = 0.77F;
        final float schimbValutarEuroLei = 4.97F;
        final float schimbValutarEuroDolari = 1.08F;
        final float schimbValutarEuroLireSterline = 0.83F;
        final float schimbValutarLireSterlineLei = 5.97F;
        final float schimbValutarLireSterlineDolari = 1.30F;
        final float schimbValutarLireSterlineEuro = 1.20F;
        float schimbValutarFinal = 0;

        switch (monedaDePlecare.toUpperCase()) {
            case "RON":
                switch (monedaRezultanta.toUpperCase()) {
                    case "RON":
                        System.out.println("Alege alta moneda");
                        break;

                    case "USD":
                        schimbValutarFinal = schimbValutarLeiDolari;
                        break;

                    case "EUR":
                        schimbValutarFinal = schimbValutarLeiEuro;
                        break;

                    case "GBP":
                        schimbValutarFinal = schimbValutarLeiLireSterline;
                        break;

                    default:
                        System.out.println("Moneda " + monedaRezultanta + " nu a fost gasita");
                        break;

                }
                break;

            case "USD":
                switch (monedaRezultanta.toUpperCase()) {
                    case "RON":
                        schimbValutarFinal = schimbValutarDolariLei;
                        break;

                    case "USD":
                        System.out.println("Alege alta moneda");
                        break;

                    case "EUR":
                        schimbValutarFinal = schimbValutarDolariEuro;
                        break;

                    case "GBP":
                        schimbValutarFinal = schimbValutarDolariLireSterline;
                        break;

                    default:
                        System.out.println("Moneda " + monedaRezultanta + " nu a fost gasita");
                        break;

                }
                break;

            case "EUR":
                switch (monedaRezultanta.toUpperCase()) {
                    case "RON":
                        schimbValutarFinal = schimbValutarEuroLei;
                        break;

                    case "USD":
                        schimbValutarFinal = schimbValutarEuroDolari;
                        break;

                    case "EUR":
                        System.out.println("Alege alta moneda");
                        break;

                    case "GBP":
                        schimbValutarFinal = schimbValutarEuroLireSterline;
                        break;

                    default:
                        System.out.println("Moneda " + monedaRezultanta + " nu a fost gasita");
                        break;

                }
                break;

            case "GBP":
                switch (monedaRezultanta.toUpperCase()) {
                    case "RON":
                        schimbValutarFinal = schimbValutarLireSterlineLei;
                        break;

                    case "USD":
                        schimbValutarFinal = schimbValutarLireSterlineDolari;
                        break;

                    case "EUR":
                        schimbValutarFinal = schimbValutarLireSterlineEuro;
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