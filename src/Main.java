//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import org.example.fraction.SimpleFraction;

public class Main {
    public static void main(String[] args) {
        SimpleFraction simpleFraction = new SimpleFraction(-5, 2);
        System.out.println(simpleFraction);
        System.out.printf("Числитель = %d\n", simpleFraction.getNumerator());
        System.out.printf("Знаменатель = %d\n", simpleFraction.getDenominator());
        simpleFraction.changeSign();
        System.out.println("Дробь после изменения знака: " + simpleFraction);

        System.out.println("Сложение с другой дробью");
        System.out.println("Статический метод:");
        SimpleFraction sf = new SimpleFraction(3, -7);
        System.out.println(simpleFraction + " + " + sf + " = " + SimpleFraction.plus(simpleFraction, sf));
        System.out.println("Нестатический метод:");
        System.out.println(simpleFraction + " + " + sf + " = " + simpleFraction.plus(sf));
        System.out.println("Вычитание:");
        System.out.println(simpleFraction + " - " + sf + " = " + simpleFraction.minus(sf));
        System.out.println("Умножение:");
        System.out.println(simpleFraction + " * " + sf + " = " + simpleFraction.multiply(sf));
        System.out.println("Деление:");
        System.out.println(simpleFraction + " : " + sf + " = " + simpleFraction.divide(sf));
        sf = simpleFraction.divide(sf);

        System.out.println("Получение дробной части");
        System.out.println(sf + " = " + sf.getFullPart() + " " + sf);

        System.out.println("Сокращение дроби");
        SimpleFraction fraction = new SimpleFraction(54, 24);
        System.out.print(fraction + " = ");
        fraction.fractionReduction();
        System.out.println(fraction);
    }
}