package net.runelite.client.plugins.bladelite.client.accountswitcher;

import com.google.inject.Inject;
import net.runelite.client.plugins.bladelite.client.Account;

import java.util.ArrayList;

public class TextAccountInfo implements fileReader{

    @Inject
    TextAccountInfo(){

    }
    @Override
    public ArrayList<Account> readFile(String location, String fileName) {
        ArrayList<Account> accountArrayList = new ArrayList<>();
        Account first = new Account();
        first.setUsername("Mystic blade");
        first.setPassword("1235");
        Account first1 = new Account();
        first1.setUsername("Iconic blade");
        first1.setPassword("1235678910");
        Account first2 = new Account();
        first2.setUsername("Erotic blade");
        first2.setPassword("1235678918959879348785974870");

        accountArrayList.add(first);
        accountArrayList.add(first1);
        accountArrayList.add(first2);
        return accountArrayList;
    }


}
