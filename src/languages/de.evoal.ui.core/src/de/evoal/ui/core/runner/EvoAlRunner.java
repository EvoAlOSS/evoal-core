package de.evoal.ui.core.runner;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.preference.IPreferenceStore;

import de.evoal.ui.core.Activator;
import de.evoal.ui.core.preferences.Preferences;

/**
 * Runs EvoAl commands using the deployed scripts.
 */
public class EvoAlRunner {
	
	/**
	 * The actual command to execute.
	 */
	private String command;

	/**
	 * Location for the log files.
	 */
	private File logFolder;
	
	/**
	 * Logger instance
	 */
	private ILog logger = Activator.getDefault().getLog();

	/**
	 * Prefix of the log file.
	 */
	private String logPrefix;

	/**
	 * Execution path of EvoAl.
	 */
	private File executionFolder = new File(System.getProperty("user.home"));
	
	/**
	 * Parameters to pass to EvoAl.
	 */
	private String[] parameters;

	public boolean run(final IProgressMonitor monitor) {
		logger.info("Running '" + command + "' in '" + executionFolder + "'");

		final ProcessBuilder builder = new ProcessBuilder();
		builder.directory(executionFolder);
		
		if(logFolder != null) {
			// enable logging
			builder.environment().put("EVOAL_LOGGING", "DEBUG");
			
			builder.redirectOutput(Redirect.to(new File(logFolder, logPrefix + "-stdout.log")));
			builder.redirectError(Redirect.to(new File(logFolder, logPrefix + "-stderr.log")));
		}
		
		// create parameter list
		final List<String> parameters = new LinkedList<>();
		parameters.add(quote(absoluteCommand()));
		
		Arrays.stream(this.parameters)
			  .forEach(p -> parameters.add(quote(p)));
		
		if (isWindows()) {
		    builder.command("cmd.exe", "/c", String.join(" ", parameters));
		} else {
			String shell = System.getenv("SHELL");
			if(shell == null) {
				shell = "bash";
				logger.warn("Could not find shell in environment. Falling back to bash.");
			}

			logger.info("Using shell '" + shell + "' for executing EvoAl.");
		    builder.command(shell, "-c", String.join(" ", parameters));
		}
		
		try {
			final Process process = builder.start();
			return process.waitFor() == 0;
		} catch (final IOException | InterruptedException e) {
			logger.error("Failed to run EvoAl as a subprocess.", e);
			return false;
		}
		
	}
	
	private String absoluteCommand() {
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();		
		final String evoalHome = store.getString(Preferences.EVOAL_HOME);
		
		return new File(new File(evoalHome, "bin"), command).getAbsolutePath();
	}
	
	public void setCommand(final String command) {
		this.command = command;
	}

	public void setExecutionFolder(final File executionFolder) {
		this.executionFolder = executionFolder;
	}
	

	public void setParameters(final String[] parameters) {
		this.parameters = parameters;
	}
	
	public void activateLogging(final File logFolder, final String logPrefix) {
		this.logFolder = logFolder;
		this.logPrefix = logPrefix;
	}

	private boolean isWindows() {
		return System.getProperty("os.name")
					 .toLowerCase()
					 .startsWith("windows");
	}
	
	private String quote(final String string) {
		return "\"" + string + "\"";
	}
}
