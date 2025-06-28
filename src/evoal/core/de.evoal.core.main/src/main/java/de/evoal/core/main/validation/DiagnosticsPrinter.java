package de.evoal.core.main.validation;

import de.evoal.core.api.validation.model.Diagnostics;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class DiagnosticsPrinter {
    public void receive(@Observes final Diagnostics diag) {
        AnsiConsole.err()
                .print(Ansi.ansi().fg(Ansi.Color.WHITE).a("["));

        switch(diag.level()) {
            case Error:
                AnsiConsole.err()
                        .print(Ansi.ansi().fgRed().a(" ERROR "));
                break;
            case Warning:
                AnsiConsole.err()
                        .print(Ansi.ansi().fgYellow().a("WARNING"));
                break;
            case Info:
                AnsiConsole.err()
                        .print(Ansi.ansi().fgYellow().a(" INFO  "));
                break;
        }
        AnsiConsole.err()
                .print(Ansi.ansi().fg(Ansi.Color.WHITE).a("] "));
        AnsiConsole.err()
                .print(Ansi.ansi().fg(Ansi.Color.YELLOW).a(diag.context()));
        AnsiConsole.err()
                .print(Ansi.ansi().reset());
        System.err.println(": " +  diag.message());
    }
}
