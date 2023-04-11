package de.evoal.languages.model.utils.scoping;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.eclipse.xtext.util.Strings;

public class WildcardEnabledLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
	
	@Override
	protected ImportNormalizer createImportedNamespaceResolver(final String namespace, boolean ignoreCase) {
		if (Strings.isEmpty(namespace))
			return null;
		QualifiedName importedNamespace = getQualifiedNameConverter().toQualifiedName(namespace);
		if (importedNamespace == null || importedNamespace.isEmpty()) {
			return null;
		}

		// enable wildcard imports by default
		return doCreateImportNormalizer(importedNamespace, true, ignoreCase);
	}
}
