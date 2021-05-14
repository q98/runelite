package net.runelite.client.plugins.bladelite.client.accountswitcher;

import net.runelite.client.plugins.bladelite.client.Account;

import java.util.ArrayList;

public interface fileReader {
    public ArrayList<Account> readFile(String location, String fileName);
}
