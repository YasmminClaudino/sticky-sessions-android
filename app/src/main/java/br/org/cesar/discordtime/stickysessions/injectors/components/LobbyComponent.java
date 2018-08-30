package br.org.cesar.discordtime.stickysessions.injectors.components;

import br.org.cesar.discordtime.stickysessions.injectors.modules.ContextModule;
import br.org.cesar.discordtime.stickysessions.injectors.modules.LobbyPresenterModule;
import br.org.cesar.discordtime.stickysessions.injectors.modules.RouterModule;
import br.org.cesar.discordtime.stickysessions.injectors.modules.ServerModule;
import br.org.cesar.discordtime.stickysessions.injectors.modules.SessionModule;
import br.org.cesar.discordtime.stickysessions.injectors.modules.ThreadModule;
import br.org.cesar.discordtime.stickysessions.injectors.modules.ViewStarterModule;
import br.org.cesar.discordtime.stickysessions.ui.lobby.LobbyActivity;
import dagger.Component;

@Component(
        modules = {
                LobbyPresenterModule.class,
                SessionModule.class,
                ThreadModule.class,
                ContextModule.class,
                RouterModule.class,
                ViewStarterModule.class,
                ServerModule.class
        }
)
public interface LobbyComponent {
    void inject(LobbyActivity lobbyActivity);

}
