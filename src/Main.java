public class Main {

    /*
    1 Описать простейшие алгоритмы
    11 Возведение в степень (*используя чётность степени)
    12 Поиск минимального элемента в массиве
    13 Нахождение среднего арифметического массива
    2 Подсчитать сложность описанных алгоритмов
    3 Какие правила подсчёта применялись, оставьте комментарии в коде
    */
    public static void main(String[] args) {
        System.out.println("Возведение в степень 3^4 = " + pow(3, 4));
        System.out.println("Минимальный элемент в массиве {4, 5, 9, 1} = " + getMin(new int[]{4, 5, 9, 1}));
        System.out.println("Среднее арифметическое массива {4, 5, 9, 1} = " + getMid(new int[]{4, 5, 9, 1}));
    }


    /*
    Возведение в степень
    Сложность O(n) - линейная
    Линейная, потому что количество итераций растёт линейно в зависимости от степени
    */
    public static int pow(int x, int n) {
        int result = x;
        for (int i = 1; i < n; i++) {
            result *= x;
        }
        return result;
    }


    /*
    Поиск минимального элемента в массиве
    Сложность O(n)
    Потому что чем больше массив тем больше итераций
    */
    public static int getMin(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] < result)
                result = array[i];
        }
        return result;
    }


    /*
    Нахождение среднего арифметического массива
    Сложность O(n)
    -//-
    */
    public static float getMid(int[] array) {
        float result = array[0];
        for (int i = 1; i < array.length; i++) {
            result += array[i];
        }
        return result/array.length;
    }
}
