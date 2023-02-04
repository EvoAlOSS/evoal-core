package de.evoal.languages.model.eal.dsl.utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

public class EvoalReleaseBuiltinDSLProvider implements BuiltinMapProvider {
	public static String evoalReleaseFolder = "/Users/berber/Downloads/evoal";

	private String basepath = "";
	
	private String extension = "";

	private void collectModules(final File folder, final List<File> files) {
        final File [] allFiles = folder.listFiles();

        if(allFiles != null) {
            for(final File file : allFiles) {
                if (file.isFile() && file.getName().endsWith(".jar")) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    collectModules(file, files);
                }
            }
        }
	}

	@Override
	public Stream<BuiltinDSLInfo> get() {
		final List<File> modules = new LinkedList<>();

		collectModules(new File(evoalReleaseFolder), modules);
		
		final List<BuiltinDSLInfo> dslFiles = new LinkedList<>();

		for(final File module : modules) {
    	   try (final JarFile moduleJare = new JarFile(module)) {
    		   final Iterator<JarEntry> iterator = moduleJare.entries().asIterator();
    		   while(iterator.hasNext()) {
    			   final JarEntry entry = iterator.next();
    			   
    			   if(entry.getName().startsWith(basepath) && entry.getName().endsWith(extension)) {
    				   dslFiles.add(new BuiltinDSLInfo(module, entry.getName()));
    			   }
    		   }
    	   } catch(final IOException e) {
    		   System.err.println("Failed to read module " + module);
    	   }
		}
		
		return dslFiles.stream();
	}

	@Override
	public void setBasePath(final String basepath) {
		this.basepath  = basepath;
	}

	@Override
	public void setExtension(final String extension) {
		this.extension = extension;
	}
}
