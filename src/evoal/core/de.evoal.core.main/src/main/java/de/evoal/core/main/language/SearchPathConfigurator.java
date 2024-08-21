package de.evoal.core.main.language;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.languages.model.utils.scoping.ClasspathGlobalScopeProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.File;

@ApplicationScoped
public class SearchPathConfigurator {
    @Inject
    private Blackboard board;

    public void configure(final @Observes BlackboardEntry entry) {
        if (!entry.isSame(CoreBlackboardEntries.SEARCH_PATH)) {
            return;
        }

        final String searchPath = board.get(CoreBlackboardEntries.SEARCH_PATH);
        final String [] searchPathEntries = searchPath.split(File.pathSeparator);

        for(final String path : searchPathEntries) {
            ClasspathGlobalScopeProvider.addSearchPath(path);
        }
    }
}
