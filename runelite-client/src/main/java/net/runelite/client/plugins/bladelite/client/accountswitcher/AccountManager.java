package net.runelite.client.plugins.bladelite.client.accountswitcher;

import com.google.inject.Inject;
import net.runelite.client.plugins.bladelite.client.Account;

import java.util.ArrayList;

public class AccountManager {
    @Inject
    TextAccountInfo textAccountInfo;
    ArrayList<Account> accountList = new ArrayList<>();
    int currentAccountIndex =0;
    @Inject
    AccountManager(){

    }
    public void loadAccounts() {
        String fileLocation= "";
        String fileName="";
        accountList=textAccountInfo.readFile(fileLocation,fileName);
    }

    public Account getAccount(int index) {
        currentAccountIndex =index;
        return accountList.get(index);
    }

    public Account nextAccount() {
        if(currentAccountIndex<accountList.size()-1) {
            currentAccountIndex += 1;
        }
        return accountList.get(currentAccountIndex);
    }
    public Account previousAccount() {
        if(currentAccountIndex>0) {
            currentAccountIndex -= 1;
        }
        return accountList.get(currentAccountIndex);
    }
}
