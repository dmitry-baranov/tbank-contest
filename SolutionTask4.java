import java.util.Scanner;

/*
 * # Задача 4
Герман немного устал. Вот бы кто-нибудь сделал за него домашнее задание...

Задача, которую необходимо решить Герману, звучит следующим образом. 
Дана последовательность a1, a2,..., an и числа х, у, z.

Разрешается произвольное количество (в том числе ноль) раз выполнить 
следующую операцию: выбрать произвольное i (1 ≤ i ≤ n) и увеличить ai на единицу.

Необходимо, чтобы **хотя бы один** элемент из последовательности делился на x, 
хотя бы один элемент делился на y и хотя бы один элемент делился на z. 
Разрешается, чтобы для разных значений из набора (х, у, z) подходил один и 
тот же элемент из последовательности.

Помогите Герману отдохнуть перед сессией и найдите минимальное количество операций, 
которое необходимо выполнить, чтобы условие стало выполнено.

#### Формат входных данных
Первая строка содержит числа n (1 ≤ n ≤ 2 х 10^5), x, y и z (1 ≤ x, y, z ≤ 10^6).

Вторая строка содержит числа а1, а2,..., an (1 ≤ ai ≤ 10^18).

#### Формат выходных данных
Выведите одно число — минимальное количество операций, которое надо выполнить, 
чтобы для каждого из чисел x, y, z был хотя бы один элемент в последовательности, кратный данному числу.

#### Комментарий к примеру
В примере можно дважды увеличить a4 и один раз увеличить a5. Тогда на 10 будет 
делиться а4, на 20 будет делиться a5, на 30 будет делиться a4.

### Примеры данных
#### Ввод
    6 10 20 30
    8 17 5 28 39 13
#### Вывод
    3
 */
public class SolutionTask4 {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = scanner.nextInt();
            }
            int result = minOperationsForGerman(arr, x, y, z);
            System.out.println(result);
        }
    }

    private static int minOperationsForGerman(int[] arr, int x, int y, int z){
        int minOperationsForX = Integer.MAX_VALUE;
        int minOperationsForY = Integer.MAX_VALUE;
        int minOperationsForZ = Integer.MAX_VALUE;

        for(int i = 0; i<arr.length; i++){
            minOperationsForX = Math.min(minOperationsForX, (x - (arr[i] % x)) % x);
            minOperationsForX = Math.min(minOperationsForY, (y - (arr[i] % y)) % y);
            minOperationsForX = Math.min(minOperationsForZ, (z - (arr[i] % z)) % z);
        }
        return minOperationsForX + minOperationsForY + minOperationsForZ;
    }
}