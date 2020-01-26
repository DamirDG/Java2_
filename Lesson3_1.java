package Lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Lesson3_1 {


    public static void main (String[] args){
        String word = "Везде Везде Везде Толстой старается схватить стихийное Везде бессознательное начало человеческой жизни бессознательное начало человеческой жизни Уже с чисто технической точки зрения размерами своего";
        String exampl;
        int count = 0;
        HashSet<String> hashSet = new HashSet<String>();
        String[] result = word.split(" ");
        HashMap<String, String> hm = new HashMap<>();
        HashMap<String, String> hmm = new HashMap<>();
//

        //Задание 1.1. Находим уникальные слова в тексте.
        for (int i = 0; i < result.length; i++) {
            hashSet.add(result[i]);

            //System.out.println(result[i]);
        }
        Iterator<String> itr = hashSet.iterator();
        while (itr.hasNext()) {
            itr.next();
            //System.out.println(itr.next().toString());
        }

        //Задание 2.1. Считаем сколько раз встречается каждое слово.
        for (int i = 0; i < result.length; i++) {
            hm.put(Integer.toString(i), result[i]);
        }

        String[] s = hashSet.toArray(new String[hashSet.size()]);

        for (int i = 0; i < s.length; i++) {
            hmm.put(Integer.toString(i), s[i]);
            //System.out.println(hm);
        }

        for (Map.Entry<String, String> o : hmm.entrySet()) {
            exampl = o.getValue();
            for (Map.Entry<String, String> p : hm.entrySet()) {
                if (exampl.equals(p.getValue())) {
                    count = count + 1;
                }
                }
            System.out.println("Слово " + o.getValue() + " встречается " + count + " раз");
            count = 0;
            }
        }
    }
