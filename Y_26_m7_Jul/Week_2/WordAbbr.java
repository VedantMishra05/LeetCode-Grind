/*
LeetCode 288. Unique Word Abbreviation
Problem Statement
An abbreviation of a word follows these rules:
If the word has 2 or fewer characters, its abbreviation is the word itself.
Otherwise, the abbreviation consists of:
the first character,
the number of characters between the first and last character,
the last character.
For example:
"dog" → "d1g"
"international" → "i11l"
"it" → "it"
Implement the ValidWordAbbr class:
ValidWordAbbr(String[] dictionary)
Initializes the object with an array of strings dictionary.
boolean isUnique(String word)
Returns true if either:
No word in the dictionary has the same abbreviation as word, or
Every dictionary word that has the same abbreviation is exactly equal to word.
Otherwise, returns false.
*/

package Y_26_m7_Jul.Week_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordAbbr {

    private static Map<String, Set<String>> map;

    public static void ValidWordAbbr(String[] dict) {
        map = new HashMap<>();
        for(String word: dict) {
            String abbr = getAbbr(word);

            map.putIfAbsent(abbr, new HashSet<>());
            map.get(abbr).add(word);
        }
    }

    public static boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if(!map.containsKey(abbr)) return true;

        Set<String> words = map.get(abbr);

        return words.size() == 1 && words.contains(word);
    }

    public static String getAbbr(String word) {
        if(word.length() <= 2) return word;
        return "" + word.charAt(0)
                + (word.length() - 2)
                + word.charAt(word.length() - 1);
    }
}
