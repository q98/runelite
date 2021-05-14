package net.runelite.client.plugins.bladelite;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.bladelite.client.Account;
import net.runelite.client.plugins.bladelite.client.accountswitcher.AccountSwitchController;
import net.runelite.client.plugins.bladelite.client.startup.StartupController;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.awt.event.KeyEvent;
@PluginDescriptor(
        name = "Login test",
        description = "Provides various enhancements for login screen"
)
@Slf4j
public class LoginPlugin  extends Plugin implements KeyListener
{
    @Inject
    StartupController startupController;

    @Inject
    AccountSwitchController accountSwitchController;
    boolean hasLoggedIn=false;

    @Inject
    private KeyManager keyManager;

    @Inject
    Client client;

    String keysPressed="";

    private boolean enableInput = false;

    @Override
    protected void startUp() throws Exception {
        keyManager.registerKeyListener(this);
    }

    @Override
    protected void shutDown() throws Exception {
        keyManager.unregisterKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(enableInput &&e.getKeyCode() != KeyEvent.VK_V) {
            keysPressed += (e.getKeyCode() - 48);
        }

        if(e.getKeyCode() == KeyEvent.VK_V) {
            enableInput=!enableInput;
        }
        if(!enableInput&&keysPressed.length()>0){
            int index=Integer.parseInt(keysPressed);
            keysPressed="";
            Account account = accountSwitchController.switchTo(index);
            this.client.setUsername(account.getUsername());
            this.client.setPassword(account.getPassword());
        }
        if(e.getKeyCode()==37){
           Account account = accountSwitchController.previousAccount();
            this.client.setUsername(account.getUsername());
            this.client.setPassword(account.getPassword());
        }
        if(e.getKeyCode()==39){
            Account account = accountSwitchController.nextAccount();
            this.client.setUsername(account.getUsername());
            this.client.setPassword(account.getPassword());
        }
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event) {
        if (event.getGameState() == GameState.LOGIN_SCREEN&&!hasLoggedIn) {
            hasLoggedIn=true;
            startupController.login();
        }
    }

    @Override
    public boolean isEnabledOnLoginScreen() {
        return true;
    }
}
