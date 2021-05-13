package net.runelite.client.BladeLight.Login;

import net.runelite.api.Client;
import net.runelite.client.BladeLight.Account.AccountLoginInfo;

import javax.inject.Inject;
/*
This class is an extension of runelite. It is used in the LoginScreenPlugin.java.
*/
public class LoginHelper {
    @Inject
    Client client;

    @Inject
    AccountLoginInfo accountLoginInfo;

    public void login(){
        accountLoginInfo.setInfo();
        this.client.setUsername(accountLoginInfo.getUsername());
        this.client.setPassword(accountLoginInfo.getPassword());
    }
}
