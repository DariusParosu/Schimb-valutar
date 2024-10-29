import java.text.DecimalFormat;

public class Main {

    public Main(float nrBani, String monedaDePlecare, String monedaRezultanta) {
        float schimbValutar = aflaSchimbulValutar(monedaDePlecare, monedaRezultanta);

        float rezultatConversie = conversiaBanilor(nrBani, schimbValutar);

        GUI.AfisareRezultat(rezultatConversie, monedaRezultanta);
    }

    public static void main(String[] args) {
        new GUI();
    }

    public static float aflaSchimbulValutar(String monedaDePlecare, String monedaRezultanta) {
        final float leiInDolari = 0.22F;
        final float leiInEuro = 0.20F;
        final float leiInLireSterline = 0.17F;
        final float dolariInLei = 4.61F;
        final float dolariInEuro = 0.93F;
        final float dolariInLireSterline = 0.77F;
        final float euroInLei = 4.97F;
        final float euroInDolari = 1.08F;
        final float euroInLireSterline = 0.83F;
        final float lireSterlineInLei = 5.99F;
        final float lireSterlineInDolari = 1.30F;
        final float lireSterlineInEuro = 1.20F;
        final int aceeasiMoneda = 1;
        float schimbValutarFinal = 0;

        schimbValutarFinal = switch (monedaDePlecare.toUpperCase()) {
            case "RON" -> switch (monedaRezultanta.toUpperCase()) {
                case "RON" -> aceeasiMoneda;
                case "USD" -> leiInDolari;
                case "EUR" -> leiInEuro;
                case "GBP" -> leiInLireSterline;
                default -> schimbValutarFinal;
            };
            case "USD" -> switch (monedaRezultanta.toUpperCase()) {
                case "RON" -> dolariInLei;
                case "USD" -> aceeasiMoneda;
                case "EUR" -> dolariInEuro;
                case "GBP" -> dolariInLireSterline;
                default -> schimbValutarFinal;
            };
            case "EUR" -> switch (monedaRezultanta.toUpperCase()) {
                case "RON" -> euroInLei;
                case "USD" -> euroInDolari;
                case "EUR" -> aceeasiMoneda;
                case "GBP" -> euroInLireSterline;
                default -> schimbValutarFinal;
            };
            case "GBP" -> switch (monedaRezultanta.toUpperCase()) {
                case "RON" -> lireSterlineInLei;
                case "USD" -> lireSterlineInDolari;
                case "EUR" -> lireSterlineInEuro;
                case "GBP" -> aceeasiMoneda;
                default -> schimbValutarFinal;
            };
            default -> 0;
        };

        return schimbValutarFinal;
    }

    public static float conversiaBanilor(float nrBani, float schimbValutar) {
        return Float.parseFloat(new DecimalFormat("0.00").format(nrBani * schimbValutar));
    }
}