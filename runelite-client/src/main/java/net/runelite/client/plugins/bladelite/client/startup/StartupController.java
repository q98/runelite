package net.runelite.client.plugins.bladelite.client.startup;

import net.runelite.api.Client;
import net.runelite.client.plugins.bladelite.client.Account;

import javax.inject.Inject;
/***
 * This class is an extension of runelite. It is used in the LoginScreenPlugin.java.
*/
public class StartupController {
    @Inject
    Client client;

    @Inject
    ArgumentsAccountInfo accountLoginInfo;

    public void login(){
        accountLoginInfo.setInfo();
        Account account = accountLoginInfo.getCurrentAccount();
        this.client.setUsername(account.getUsername());
        this.client.setPassword(account.getPassword());
    }
}
