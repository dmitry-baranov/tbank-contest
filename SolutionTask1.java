import java.util.Scanner;

/*
 * ## Задача 1

Недавно маленький Антон научился читать некоторые буквы! 
Точнее, он научился читать буквы R, S и М. 
Кроме того, набор из трех букв R, S, M ему кажется правильным, если в нем символ R находится раньше, 
чем символ M.

Определите, является ли строка s правильной по мнению Антона.

**Формат входных данных**

Дана строка s из трех символов, содержащая один символ R, один символ S и один символ M.

**Формат выходных данных**


Выведите Yes, если символ R находится в строке s раньше, чем символ M. В противном случае No.
 

### Примеры данных
### Пример 1
#### Ввод
    SMR
#### Вывод
    No

### Пример 2
#### Ввод
    RSM
#### Вывод
    Yes

---
 */
public class SolutionTask1 {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            if(isValidString(input)){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean isValidString(String string){
        char[] charArr = string.toCharArray();
        if(charArr[0] == 'R'){
            return true;
        } else if(charArr[0] == 'M'){
            return false;
        } else if(charArr[1] == 'R'){
            return true;
        }
        return false;
    }
}