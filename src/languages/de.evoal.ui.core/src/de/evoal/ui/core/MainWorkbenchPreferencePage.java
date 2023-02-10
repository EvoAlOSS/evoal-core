package de.evoal.ui.core;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

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
		setPreferenceStore(new ScopedPreferenceStore(InstanceScope.INSTANCE, "de.evoal.ui.core.main"));
        setDescription("EvoAl related settings.");
    }

	@Override
	protected void createFieldEditors() {
		addField(new DirectoryFieldEditor("release", "&EvoAl directory:", getFieldEditorParent()));
	}
}
