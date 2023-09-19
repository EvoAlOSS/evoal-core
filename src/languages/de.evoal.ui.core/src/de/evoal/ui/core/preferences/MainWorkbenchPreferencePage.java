package de.evoal.ui.core.preferences;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.evoal.ui.core.Activator;

public class MainWorkbenchPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public MainWorkbenchPreferencePage() {
	}

	public MainWorkbenchPreferencePage(final int style) {
		super(style);
	}

	public MainWorkbenchPreferencePage(final String title, final int style) {
		super(title, style);
	}

	public MainWorkbenchPreferencePage(final String title, final ImageDescriptor image, final int style) {
		super(title, image, style);
	}

	@Override
	public void init(final IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
        setDescription("EvoAl related settings.");
    }

	@Override
	protected void createFieldEditors() {
		addField(new DirectoryFieldEditor(Preferences.EVOAL_HOME, "EvoAl &Home Directory:", getFieldEditorParent()));
		addField(new ComboFieldEditor(Preferences.LOG_LEVEL, "EvoAl &Log Level", new String[][] {{"Errors", "ERROR"}, {"Warnings", "WARN"}, {"Informations", "INFO"},  {"Debugging", "DEBUG"}}, getFieldEditorParent()));
	}
}
