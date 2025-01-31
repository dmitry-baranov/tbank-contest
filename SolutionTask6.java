import java.util.Scanner;

/*
 * # # Задача 6
В этом году главой Флатландии является Егор. Всего во Флатландии проживает n людей, 
каждый в своем доме, і-й дом находится в целочисленной точке (xi, yi).

Егор может выделить некоторые тройки людей. Требуется лишь, чтобы каждый 
человек относился не более, чем к одной тройке. Тройка людей считается 
счастливой, если треугольник образованных их домами, является невырожденным 
(то есть три дома не находятся на одной прямой).

Помогите Егору определить, какого максимального количества счастливых троек можно добиться во Флатландии.

#### Формат входных данных
Первая строка содержит число n (3 ≤ n ≤ 300) - количество жителей во Флатландии.

і-я из следующих n строчек содержит числа хi и yi (-10^9 ≤ xi,yi ≤ 10^9) - координаты дома, 
где проживает і-й человек.

Гарантируется, что никакие два дома не находятся в одной точке.

#### Формат выходных данных
Выведите одно число — максимальное количество счастливых троек, которого можно добиться во Флатландии.

#### Комментарий к примеру
В примере можно получить две счастливые тройки. 
Например, подойдет разбиение (1, 1), (2, 2), (1,4) и (6,3), (4, 5), (4, 1).

### Примеры данных:
#### Ввод
    7
    1 1
    2 2
    1 4
    6 3
    4 5
    4 1
    3 3
#### Вывод
    2
---
 */
public class SolutionTask6 {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][2];
            for(int i = 0; i<n; i++){
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }
            int result = maxHappyTriples(arr);
            System.out.println(result);
        }
    }

    private static int maxHappyTriples(int[][] arr){
        int n = arr.length;
        boolean[] used = new boolean[n];
        int countHappyTriples = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                for(int k = 0; k<n; k++){
                    if(!used[i] && !used[j] && !used[k] && isValidHappyTriples(arr[i], arr[j] , arr[k])){
                        used[i] = used[j] = used[k] = true;
                    }
                }
            }
        }
        return countHappyTriples;
    }

    private static boolean isValidHappyTriples(int[] a, int[] b, int[] c){
        return (a[0]*(b[1] - c[1]) + b[0]*(c[1] - a[1]) + c[0]*(b[1] - a[1])) != 0;
    }
}