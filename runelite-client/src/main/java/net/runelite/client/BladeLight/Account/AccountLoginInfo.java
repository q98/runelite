package net.runelite.client.BladeLight.Account;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;

public class AccountLoginInfo {
    @Getter
    @Setter
    String username;

    @Getter
    @Setter
    String password;
    /*
    The args are set in runelite.java
    */
    @Setter
    static String[] args;

    @Inject
    AccountLoginInfo(){
    }

    public void setInfo() {
        final OptionParser parser = new OptionParser();
        parser.accepts("username","the username of an account").withRequiredArg();
        parser.accepts("password","the password of an account").withRequiredArg();
        OptionSet t = parser.parse(args);
        setUsername((String) t.valueOf("username"));
        setPassword((String) t.valueOf("password"));
    }
}
