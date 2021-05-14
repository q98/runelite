package net.runelite.client.plugins.bladelite.client.accountswitcher;

import com.google.inject.Inject;
import net.runelite.client.plugins.bladelite.client.Account;

public class AccountSwitchController {
    @Inject
    AccountManager accountManager;

    AccountSwitchController(){

    }

    public Account switchTo(int number){
        accountManager.loadAccounts();
        return accountManager.getAccount(number);
    }

    public Account nextAccount(){
        accountManager.loadAccounts();
        return accountManager.nextAccount();
    }

    public Account previousAccount(){
        accountManager.loadAccounts();
        return accountManager.previousAccount();
    }
}
