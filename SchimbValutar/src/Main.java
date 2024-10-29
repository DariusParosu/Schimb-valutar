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

        switch (monedaDePlecare.toUpperCase()) {
            case "RON":
                switch (monedaRezultanta.toUpperCase()) {
                    case "RON":
                        schimbValutarFinal = aceeasiMoneda;
                        break;

                    case "USD":
                        schimbValutarFinal = leiInDolari;
                        break;

                    case "EUR":
                        schimbValutarFinal = leiInEuro;
                        break;

                    case "GBP":
                        schimbValutarFinal = leiInLireSterline;
                        break;

                }
                break;

            case "USD":
                switch (monedaRezultanta.toUpperCase()) {
                    case "RON":
                        schimbValutarFinal = dolariInLei;
                        break;

                    case "USD":
                        schimbValutarFinal = aceeasiMoneda;
                        break;

                    case "EUR":
                        schimbValutarFinal = dolariInEuro;
                        break;

                    case "GBP":
                        schimbValutarFinal = dolariInLireSterline;
                        break;

                }
                break;

            case "EUR":
                switch (monedaRezultanta.toUpperCase()) {
                    case "RON":
                        schimbValutarFinal = euroInLei;
                        break;

                    case "USD":
                        schimbValutarFinal = euroInDolari;
                        break;

                    case "EUR":
                        schimbValutarFinal = aceeasiMoneda;
                        break;

                    case "GBP":
                        schimbValutarFinal = euroInLireSterline;
                        break;

                }
                break;

            case "GBP":
                switch (monedaRezultanta.toUpperCase()) {
                    case "RON":
                        schimbValutarFinal = lireSterlineInLei;
                        break;

                    case "USD":
                        schimbValutarFinal = lireSterlineInDolari;
                        break;

                    case "EUR":
                        schimbValutarFinal = lireSterlineInEuro;
                        break;

                    case "GBP":
                        schimbValutarFinal = aceeasiMoneda;
                        break;

                }
                break;

        }

        return schimbValutarFinal;
    }

    public static float conversiaBanilor(float nrBani, float schimbValutar) {
        return Float.parseFloat(new DecimalFormat("0.00").format(nrBani * schimbValutar));
    }
}