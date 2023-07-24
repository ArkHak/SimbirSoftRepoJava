package o.mysin.simbirsoftappjava.practice;

/*
Task1
    Написать простое лямбда-выражение в переменной myClosure,
    лямбда-выражение должно выводить в консоль фразу "I love Java".
    Вызвать это лямбда-выражение. Далее написать функцию, которая будет запускать
    заданное лямбда-выражение заданное количество раз. Объявить функцию так: public
    void repeatTask (int times, Runnable task). Функция должна запускать
    times раз лямбда-выражение task . Используйте эту функцию для печати "I love Java" 10 раз.
 */
public class Task1 {
    public static void main(String[] args) {
        Runnable myClosure = () -> System.out.println("I love Java");
        myClosure.run();
        repeatTask(10, myClosure);
    }

    public static void repeatTask(int times, Runnable task) {
        for (int i = 0; i < times; i++) {
            task.run();
        }
    }
}