/**
 * Created by Dulya on 28.04.2016.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
    private static String fileName = "D://dasha/МИЭТ!/6 семестр/Практикум по промышленному прграммированию/PromProg_lab3/text.txt";


    public static void main(String[] args)
    {
        int count = 0;
        int count_p1 = 0;
        int count_p2 = 0;
        int count_p3 = 0;
        int count_p4 = 0;
        int count_p5 = 0;
        char st='Ы';

        Pattern pattern = Pattern.compile("\\w+");
        Pattern p1 = Pattern.compile("[а-яА-ЯёЁ]{4,}"); // длиннее 3 символов
        Pattern p2 = Pattern.compile("\\b\\w*[aeiouAEIOU]\\b"); // заканчиваются на гласную
        Pattern p3 = Pattern.compile("\\b\\w*[aeiou]{2,}\\w*\\b"); // встречаются две и более гласные подряд
        Pattern p4 = Pattern.compile("\\b\\w*(\\w)(\\1)\\w*\\b"); // встречаются две одинаковые подряд буквы

        Pattern p5 = Pattern.compile("\\b[а-яА-ЯёЁ]+(ый|ой|ий|ая|яя|ое|ее|ые|ие|ого|его|ому|" +
                "ему|ую|юю|им|ым|ом|ем|ых|их|ыми|ими)\\b"); // встречаются две одинаковые подряд буквы

        BufferedReader in;
        try
        {
            in = new BufferedReader(new FileReader(fileName));

            String s;
            while ((s = in.readLine()) != null)
            {
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) count++;

                Matcher matcher1 = p1.matcher(s);
                while (matcher1.find()) count_p1++;

                Matcher matcher2 = p2.matcher(s);
                while (matcher2.find()) count_p2++;

                Matcher matcher3 = p3.matcher(s);
                while (matcher3.find()) count_p3++;

                Matcher matcher4 = p4.matcher(s);
                while (matcher4.find()) count_p4++;

                Matcher matcher5 = p5.matcher(s);
                while (matcher5.find()) count_p5++;
            }


        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("Количество слов: " + count);

        System.out.println("Количество слов длиннее 3 символов: " + count_p1);

        System.out.println("Количество слов, закачивающихся на гласную: " + count_p2);

        System.out.println("Количество слов в которых встречаются две и более гласные подряд: " + count_p3);

        System.out.println("Количество слов, в котором встречаются две одинаковые подряд буквы: " + count_p4);

        System.out.println("Количество прилагательных: " + count_p5);
        System.out.println((int)st);

    }

}
