package de.evoal.ui.core.builtin;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

import de.evoal.languages.model.utils.builtin.BuiltinProvider;

public class ReleaseBuiltinProvider implements BuiltinProvider {
	@Override
	public Collection<URI> findBuiltins(final String basename) {
		final IPreferenceStore store = new ScopedPreferenceStore(InstanceScope.INSTANCE, "de.evoal.ui.core.main");
		final String evoalRelease = store.getString("release");
		final PathMatcher jarMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*.jar");
		final List<URI> result = new LinkedList<>();

		try {
			Files.walkFileTree(Paths.get(evoalRelease), new SimpleFileVisitor<Path>() {
		        @Override
		        public FileVisitResult visitFile(final Path path, final BasicFileAttributes attrs) throws IOException {
		            if(jarMatcher.matches(path)) {
		            	findBuiltins(path, basename, result);
		            }
		            
		            return FileVisitResult.CONTINUE;
		        }
		    });
		} catch(final IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	private void findBuiltins(final Path jarFile, final String basename, final List<URI> result) {
		final String completeBase = "META-INF/definitions/" + basename;
		
		try(final ZipFile file = new JarFile(jarFile.toFile())) {
			final Enumeration<? extends ZipEntry> entries = file.entries();
			
			while(entries.hasMoreElements()) {
				final ZipEntry entry = entries.nextElement();
				final String name = entry.getName();

				if(name.startsWith(completeBase) && name.endsWith(".dl")) {
					final FileSystem zipFS = FileSystems.newFileSystem(jarFile);
					final Path fileInZip = zipFS.getPath(name);

					result.add(fileInZip.toUri());
				}
			}
		} catch(final IOException e) {
			e.printStackTrace();
		}
	}

}
