package com.company;

import java.util.HashMap;
import java.util.Iterator;

public class Solution {
    public Solution(String [] sentences) {
        this.sentences = sentences;
    }
    private String [] sentences;
    private HashMap<String, Integer> wordsMap;

    private void countWords() {
        String [] currLine;
        String tmp;
        this.wordsMap= new HashMap<String, Integer>();
        for (int i = 0; i < this.sentences.length; i++) {
            currLine = this.sentences[i].split(" ");
            for (int j = 0; j < currLine.length; j++) {
                tmp = currLine[j].replaceAll(",$", "");
                this.wordsMap.putIfAbsent(tmp, 0);
                this.wordsMap.put(tmp, this.wordsMap.get(tmp) + 1);
            }
        }
    }

    public void dispSolution() {
        String [] toDisp;
        this.countWords();
        int maxValue = 0;
        String maxString = new String();
        Iterator it;
        HashMap.Entry el;
        for (int i = 0; i < 3; i++) {
            it = this.wordsMap.entrySet().iterator();
            while (it.hasNext()) {
                el = (HashMap.Entry) it.next();
                if ((int) el.getValue() > maxValue) {
                    maxValue = (int) el.getValue();
                    maxString = (String) el.getKey();
                }
            }
            System.out.println(i + 1 + ". " + maxString + ": " + maxValue);
            this.wordsMap.put(maxString, 0);
            maxValue = 0;
        }
    }
}
