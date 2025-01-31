import java.util.Arrays;
import java.util.Scanner;

/*
 * ## Задача 3
Чтобы набрать форму к лету, Виктория решила бегать каждый день. 
До лета осталось всего n дней — именно на протяжении этого срока она и будет бегать. 
Ее личный тренер уже составил ей расписание: в і-й день Виктория должна пробежать ai километров.

Виктория считает і-й (3 ≤ і ≤ n) день хорошим, если в этот день она 
пробежит не меньше, чем в первый день, и не больше, чем во второй день. 
Расписание же ей понравится, если хотя бы m дней будут хоршими. 
В расписании можно делать корректировки: произвольное ai (1 ≤ i ≤ n) можно увеличить 
или уменьшить на 1 километр. Разрешается корректировать один и тот же день несколько раз.

Какое минимальное корректировок необходимо внести в расписание, чтобы оно понравилось Виктории?

#### Формат входных данных
Первая строка содержит числа n (3 ≤ n ≤ 2 × 10^5) и m (1 ≤ m ≤ n - 2) - количество 
дней до лета и количество хороших дней, которое необходимо Виктории, чтобы ей понравилось расписание.

Следующая строка содержит числа а1, а2,..., an (1 ≤ ai ≤ 10^9), где ai — количество 
километров, которое должна пробежать Виктория согласно начальному расписанию.

#### Формат выходных данных
Выведите одно число — минимальное количество корректировок, которое необходимо 
внести в расписание, чтобы оно понравилось Виктории.

#### Комментарий к примеру
В примере можно дважды уменьшить a3 на единицу, чтобы расписание понравилось Виктории.

### Примеры данных
#### Ввод
    3 1
    3 4 6
#### Вывод
    2
---
 */
public class SolutionTask3 {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            int daysCount = scanner.nextInt();
            int goodDays = scanner.nextInt();
            int[] distances = new int[daysCount];
            for(int i = 0; i<daysCount; i++){
                distances[i] = scanner.nextInt();
            }
            int result = howMuchCorrectionsNeedsVictoria (distances, goodDays);
            System.out.println(result);
        }
    }

    private static int howMuchCorrectionsNeedsVictoria(int[] distances, int goodDays){
        int daysCount = distances.length;
        int correctionsCount = 0;
        int[] countOfChangesForTheDay = new int[daysCount - 2];
        for(int i = 0; i<daysCount - 2; i++){
            if(distances[0] > distances[i+2] || distances[1] < distances[i+2]){
            int firstDifference = Math.abs(distances[0] - distances[i+2]);
            int secondDifference = Math.abs(distances[i+2] - distances[1]);
                countOfChangesForTheDay[i] = firstDifference < secondDifference 
                ? firstDifference : secondDifference;
            }
        }
        Arrays.sort(countOfChangesForTheDay);
        int iterator = 0;
        while(goodDays > 0 && iterator < countOfChangesForTheDay.length){
            correctionsCount += countOfChangesForTheDay[iterator];
            goodDays--;
            iterator++;
        }
        return correctionsCount;
    }
}