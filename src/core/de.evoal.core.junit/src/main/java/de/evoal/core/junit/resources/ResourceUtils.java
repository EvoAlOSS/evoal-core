package de.evoal.core.junit.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.nio.file.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public final class ResourceUtils {
    private static final Logger log = LoggerFactory.getLogger(ResourceUtils.class);
    public static void unpack(final ClassLoader loader, final File destination, final String ... files) throws IOException {
        for(final String base : files) {
            log.info("Searching for file {}.", base);
            final Enumeration<URL> resources = loader.getResources(base);
            while(resources.hasMoreElements()) {
                final URL resource = resources.nextElement();

                final Path outputPath = Path.of(destination.toString(), base);
                final Set<PosixFilePermission> permissions = new HashSet<>();
                permissions.add(PosixFilePermission.OWNER_READ);
                permissions.add(PosixFilePermission.OWNER_WRITE);
                permissions.add(PosixFilePermission.OWNER_EXECUTE);

                try {
                    Files.createDirectory(outputPath.getParent(), PosixFilePermissions.asFileAttribute(permissions));
                } catch(final FileAlreadyExistsException e) {
                    // ignore
                }

                log.info("Copying to {}", outputPath);

                try(final InputStream iStream = resource.openStream()) {
                    Files.copy(iStream, outputPath, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }
}
