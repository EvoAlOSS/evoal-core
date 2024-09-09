package de.evoal.core.junit.resources;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.nio.file.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.attribute.*;
import java.util.*;

@Slf4j
public final class ResourceUtils {
    private static final boolean isPosix = FileSystems.getDefault()
                                                      .supportedFileAttributeViews()
                                                      .contains("posix");

    public static void unpack(final ClassLoader loader, final File destination, final String ... files) throws IOException {
        for(final String base : files) {
            log.info("Searching for file {}.", base);
            final Enumeration<URL> resources = loader.getResources(base);
            while(resources.hasMoreElements()) {
                final URL resource = resources.nextElement();

                final Path outputPath = Path.of(destination.toString(), base);

                try {
                    FileAttribute<?> attributes = createFileAttributes();
                    Files.createDirectory(outputPath.getParent(), attributes);
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

    private static FileAttribute<?> createFileAttributes() {
        return isPosix ? createPosixFileAttributes() : createACLFileAttributes();
    }

    private static FileAttribute<?> createACLFileAttributes() {
        return new FileAttribute<List<AclEntry>>() {

            @Override
            public List<AclEntry> value() {
                // lookup user principal
                FileSystem fileSystem = FileSystems.getDefault();
                UserPrincipalLookupService userPrincipalLookupService = fileSystem.getUserPrincipalLookupService();
                UserPrincipal userPrincipal = null;
                try {
                    String username = System.getProperty("user.name");
                    userPrincipal = userPrincipalLookupService.lookupPrincipalByName(username);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                // select ACL flags
                Set<AclEntryFlag> flags = EnumSet.of(AclEntryFlag.FILE_INHERIT, AclEntryFlag.DIRECTORY_INHERIT);

                // select ACL permission
                Set<AclEntryPermission> permissions = EnumSet.of(AclEntryPermission.READ_DATA, AclEntryPermission.WRITE_DATA, AclEntryPermission.EXECUTE);

                // build ACL entry
                AclEntry.Builder builder = AclEntry.newBuilder();
                builder.setFlags(flags);
                builder.setPermissions(permissions);
                builder.setPrincipal(userPrincipal);
                builder.setType(AclEntryType.DENY);

                AclEntry entry = builder.build();
                List<AclEntry> aclEntryList = new ArrayList<>();
                aclEntryList.add(entry);

                return aclEntryList;
            }

            @Override
            public String name() {
                return "acl:acl";
            }
        };
    }

    private static FileAttribute<?> createPosixFileAttributes() {
        final Set<PosixFilePermission> permissions = new HashSet<>();
        permissions.add(PosixFilePermission.OWNER_READ);
        permissions.add(PosixFilePermission.OWNER_WRITE);
        permissions.add(PosixFilePermission.OWNER_EXECUTE);

        return PosixFilePermissions.asFileAttribute(permissions);
    }
}
