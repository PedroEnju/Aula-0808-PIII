package br.com.pedroenju.model;

/**
 *
 * @author Pedro Enju
 */
public class Calculadora {

    public Double calcular(Double num1, String operation, Double num2) {
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0)
                    return 0D;
                return num1 / num2;
            case "MOD":
                return num1 % num2;
            case "POT":
                return Math.pow(num1, num2);
            default:
                return 0D;
        }
        
    }

}
