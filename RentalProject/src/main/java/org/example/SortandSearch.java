package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SortandSearch<T extends Item>
{
    public void sortbyTitle(ArrayList<T> item)
    {
        String []sortbytitle=new String[item.size()];
        for (int i=0;i<=item.size()-1;i++)
            sortbytitle[i]=item.get(i).Title;

        Arrays.sort(sortbytitle);
        for (int j=0;j<=sortbytitle.length-1;j++)
        {
            for (T items:item)
                if (items.getTitle().equalsIgnoreCase(sortbytitle[j])==true)
                    System.out.println(items);
        }

    }
    public void sortbyAuthor(ArrayList<T>item)
    {
        String []sortbyauthor=new String[item.size()];
        for (int i=0;i<=item.size()-1;i++)
            sortbyauthor[i]=item.get(i).Author;

        Arrays.sort(sortbyauthor);
        for (int j=0;j<=sortbyauthor.length-1;j++)
        {
            for (T items:item)
                if (items.getAuthor().equalsIgnoreCase(sortbyauthor[j])==true)
                    System.out.println(items);
        }
    }
    public ArrayList<T> search(ArrayList<T>search,String word)
    {
        ArrayList<T> test=new ArrayList<>();
        boolean search2=true;
        int length=word.length();
        String wordchar;
        String titlechar;
        for(int j=0;j<=search.size()-1;j++) {
            search2 = true;
            int length2 = search.get(j).getTitle().length();
            for (int i = 0; i <= length - 1 && i <= length2 - 1; i++) {
                 wordchar=String.valueOf(word.charAt(i));
                 titlechar=String.valueOf(search.get(j).getTitle().charAt(i));
                if (wordchar.equalsIgnoreCase(titlechar)!=true) {
                    search2 = false;
                }

            }
            if (search2 == true) {
                test.add(search.get(j));
            }
        }

        if(search2==false)
        {
            String wordchar1;
            String authorchar;
            int length2;
            for(int j=0;j<=search.size()-1;j++) {
                search2 = true;
                 length2 = search.get(j).getAuthor().length();
                for (int i = 0; i <= length - 1 && i <= length2 - 1; i++) {
                     wordchar1=String.valueOf(word.charAt(i));
                     authorchar=String.valueOf(search.get(j).getAuthor().charAt(i));
                    if (wordchar1.equalsIgnoreCase(authorchar)!=true) {
                        search2 = false;

                    }

                }
                if (search2 == true) {
                    test.add(search.get(j));
                }
            }
            return test;
        }
        return test;
    }
}


