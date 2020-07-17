import java.util.Random;

public class Main {

    public static void main(String[] args) {
/*
        1. Создать и запустить программу для построения двоичного дерева.
        В цикле построить двадцать деревьев с глубиной в 6 уровней.
        Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
        Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
        2. Проанализировать, какой процент созданных деревьев являются несбалансированными.

 */
        Random r = new Random();
        float sum = 0;
        Tree[] trees = new Tree[20];
        
        for (int i = 0; i < trees.length; i++) {
            trees[i] = new Tree();
            for (int j = 0; j < 6; j++) {
                trees[i].insert(new Cat((int) (r.nextFloat() * 200) - 100, "Cat"));
            }
            boolean isBalanced = trees[i].isBalanced();
            sum += isBalanced ? 1 : 0;
            System.out.println();
            System.out.println(trees[i].toString());
            System.out.println("isBalanced " + isBalanced);
        }

        System.out.println("Процент сбалансированных массивов: " + sum*100/trees.length);
    }
}
