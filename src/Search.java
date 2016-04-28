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
        int count_p1 = 0;
        int count_p2 = 0;
        int count_p3 = 0;

        Pattern p1 = Pattern.compile("\\b[а-яА-ЯёЁ]+(ый|ой|ий|ая|яя|ое|ее|ые|ие|ого|его|ому|" +
        "ему|ую|юю|им|ым|ом|ем|ых|их|ыми|ими)\\b"); // прилагательные

        Pattern p2 = Pattern.compile("\\b[а-яА-ЯёЁ]+(у|ю|ешь|ёшь|ет|ёт|ем|ём|ете|ёте|ут|ют|" +
                "ишь|ит|им|ите|ат|ят)\\b"); // глаголы

        Pattern p3 = Pattern.compile("\\b(в|за|на)[а-яА-ЯёЁ]+(о)\\b"); // наречия
        Pattern p4 = Pattern.compile("\\b(до|из|с)[а-яА-ЯёЁ]+(а)\\b"); // наречия

        BufferedReader in;
        try
        {
            in = new BufferedReader(new FileReader(fileName));

            String s;
            while ((s = in.readLine()) != null)
            {

                Matcher matcher1 = p1.matcher(s);
                while (matcher1.find()) count_p1++;

                Matcher matcher2 = p2.matcher(s);
                while (matcher2.find()) count_p2++;

                Matcher matcher3 = p3.matcher(s);
                while (matcher3.find()) count_p3++;

                Matcher matcher4 = p4.matcher(s);
                while (matcher4.find()) count_p3++;
            }


        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("Количество прилагательных: " + count_p1);

        System.out.println("Количество глаголов: " + count_p2);

        System.out.println("Количество наречий: " + count_p3);

    }

}
