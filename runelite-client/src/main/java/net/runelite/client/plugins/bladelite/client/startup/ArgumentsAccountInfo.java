package net.runelite.client.plugins.bladelite.client.startup;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import lombok.Getter;
import lombok.Setter;

import net.runelite.client.plugins.bladelite.client.Account;

import javax.inject.Inject;

public class ArgumentsAccountInfo
{
    @Getter
    Account currentAccount;
    /**
    The args are set in runelite.java
    */
    @Setter
    static String[] args;

    @Inject
    ArgumentsAccountInfo(){
    }

    public void setInfo() {
        final OptionParser parser = new OptionParser();
        parser.accepts("username","the username of an account").withRequiredArg();
        parser.accepts("password","the password of an account").withRequiredArg();
        OptionSet optionset = parser.parse(args);
        currentAccount = new Account();
        currentAccount.setPassword((String) optionset.valueOf("password"));
        currentAccount.setUsername((String) optionset.valueOf("username"));
    }
}
