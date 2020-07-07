public class Main {
    public static void main(String[] args) {
        // Создать программу, которая переворачивает вводимые строки (читает справа налево)
        String testString = "Hello World";

        char[] charArr = new char[testString.length()];
        for(int i = 0; i < charArr.length; i++)
            charArr[i] = testString.charAt(charArr.length - i - 1);

        testString = new String(charArr);
        System.out.println(testString);





    }
}
