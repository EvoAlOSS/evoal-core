package de.evoal.core.main.provenance;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.JsonNodeFactory;
import tools.jackson.databind.node.ObjectNode;

import de.evoal.core.api.provenance.RunRecord;
import de.evoal.core.main.credits.InstalledJars;
import de.evoal.core.main.credits.InstalledJars.InstalledJar;

/**
 * Writes the provenance of an execution ({@link RunRecord}) into its folder:
 * <ul>
 *   <li>{@value #ENVIRONMENT}: EvoAl's version and build identity, the application and its
 *     arguments, the seed, start and end, Java, the operating system, the {@code EVOAL_*}
 *     environment variables and every jar of the installation with its module, version and
 *     SHA-256;</li>
 *   <li>{@value #FILES}: every configuration, input and output file with its role, size and
 *     SHA-256;</li>
 *   <li>{@value #CONFIGURATION}: copies of the configuration files.</li>
 * </ul>
 * Paths are relative to the execution folder (the working directory) and the jars relative to
 *   the installation, so the record holds no absolute paths, which could contain a user name.
 *   For the same reason, the user and host name and {@code EVOAL_HOME} are not recorded.
 */
@Slf4j
public final class RunRecordWriter {
    /**
     * The file with the build identity, written by the build into core.main.
     */
    public static final String BUILD_PROPERTIES = "/META-INF/evoal/build.properties";

    /**
     * The folder with the copies of the configuration files.
     */
    public static final String CONFIGURATION = "configuration";

    /**
     * The file with the environment.
     */
    public static final String ENVIRONMENT = "environment.json";

    /**
     * The environment variables that are not recorded: the installation folder is an absolute path.
     */
    private static final List<String> EXCLUDED_VARIABLES = List.of("EVOAL_HOME");

    /**
     * The sub-folder of {@value #CONFIGURATION} for configuration files outside the execution folder.
     */
    private static final String EXTERNAL = "external";

    /**
     * The file with the used files.
     */
    public static final String FILES = "files.json";

    private static final JsonNodeFactory NODES = JsonNodeFactory.instance;

    private RunRecordWriter() {
    }

    /**
     * Writes the record into its folder; does nothing if the application named no folder.
     *
     * @param record The record.
     * @param application The name of the application ({@code core:main}).
     * @param arguments The command line arguments of EvoAl.
     * @param seed The seed of the execution, {@code null} if none was chosen.
     */
    public static void write(final @NonNull RunRecord record, final String application, final @NonNull List<String> arguments,
                             final String seed) {
        if(record.folder().isEmpty()) {
            return;
        }

        final Path folder = record.folder().get();
        final Path executionFolder = Path.of("").toAbsolutePath();

        try {
            Files.createDirectories(folder);
            final JsonMapper mapper = JsonMapper.builder().build();

            final ObjectNode environment = environment(record, application, arguments, seed, System.getenv(), InstalledJars.coreFolder().getParent(),
                                                       InstalledJars.bootLayerJars());
            mapper.writerWithDefaultPrettyPrinter().writeValue(folder.resolve(ENVIRONMENT).toFile(), environment);

            final ArrayNode files = files(record.files(), executionFolder);
            mapper.writerWithDefaultPrettyPrinter().writeValue(folder.resolve(FILES).toFile(), files);

            copyConfiguration(record.configurationFiles(), executionFolder, folder.resolve(CONFIGURATION));

            log.info("Wrote the provenance of the execution to '{}'.", executionFolder.relativize(folder));
        } catch(final IOException | UncheckedIOException e) {
            log.error("Failed to write the provenance of the execution to '{}'.", folder, e);
        }
    }

    /**
     * Copies the configuration files into the folder, keeping their paths relative to the
     *   execution folder; a file outside it goes to {@value #EXTERNAL} under its name.
     */
    static void copyConfiguration(final List<Path> configurationFiles, final Path executionFolder, final Path target) throws IOException {
        for(final Path file : configurationFiles) {
            if(!Files.isRegularFile(file)) {
                continue;
            }

            final Path copy = target.resolve(copyPath(file, executionFolder));
            Files.createDirectories(copy.getParent());
            Files.copy(file, copy, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    /**
     * @return The path of the copy of a configuration file below {@value #CONFIGURATION}.
     */
    static Path copyPath(final Path file, final Path executionFolder) {
        if(file.startsWith(executionFolder)) {
            return executionFolder.relativize(file);
        }

        return Path.of(EXTERNAL).resolve(file.getFileName());
    }

    /**
     * @return The environment of the execution.
     */
    static ObjectNode environment(final RunRecord record, final String application, final List<String> arguments, final String seed,
                                  final Map<String, String> variables, final Path installation, final List<InstalledJar> jars) {
        final ObjectNode root = NODES.objectNode();

        final ObjectNode evoal = root.putObject("evoal");
        final Properties build = buildProperties();
        evoal.put("version", InstalledJars.class.getModule().getDescriptor() == null
                             ? null
                             : InstalledJars.class.getModule().getDescriptor().rawVersion().orElse(null));
        evoal.put("commit", build.getProperty("git.commit.id"));
        evoal.put("commitTime", build.getProperty("git.commit.time"));
        final String dirty = build.getProperty("git.dirty");
        if(dirty == null) {
            evoal.putNull("dirty");
        } else {
            evoal.put("dirty", Boolean.parseBoolean(dirty));
        }

        root.put("application", application);
        final ArrayNode argumentsNode = root.putArray("arguments");
        arguments.forEach(argumentsNode::add);
        root.put("seed", seed);
        root.put("start", record.start().toString());
        root.put("end", record.now().toString());

        final ObjectNode java = root.putObject("java");
        java.put("version", System.getProperty("java.version"));
        java.put("vendor", System.getProperty("java.vendor"));
        java.put("vm", System.getProperty("java.vm.name"));
        java.put("vmVersion", System.getProperty("java.vm.version"));

        final ObjectNode os = root.putObject("os");
        os.put("name", System.getProperty("os.name"));
        os.put("version", System.getProperty("os.version"));
        os.put("architecture", System.getProperty("os.arch"));

        final ObjectNode environment = root.putObject("environment");
        new TreeMap<>(variables).forEach((name, value) -> {
            if(name.startsWith("EVOAL_") && !EXCLUDED_VARIABLES.contains(name)) {
                environment.put(name, value);
            }
        });

        final ArrayNode modules = root.putArray("modules");
        for(final InstalledJar jar : jars) {
            final ObjectNode module = modules.addObject();
            module.put("file", relative(jar.file(), installation));
            module.put("module", jar.module());
            module.put("version", jar.version().orElse(null));
            module.put("sha256", sha256(jar.file()));
        }

        return root;
    }

    /**
     * @return The files with role, size and SHA-256; a file that does not exist (any more) has
     *   neither size nor hash.
     */
    static ArrayNode files(final Map<Path, RunRecord.Role> files, final Path executionFolder) {
        final ArrayNode array = NODES.arrayNode();

        files.forEach((file, role) -> {
            final ObjectNode node = array.addObject();
            node.put("path", relative(file, executionFolder));
            node.put("role", role.name().toLowerCase());

            if(Files.isRegularFile(file)) {
                try {
                    node.put("size", Files.size(file));
                } catch(final IOException e) {
                    throw new UncheckedIOException(e);
                }
                node.put("sha256", sha256(file));
            } else {
                node.putNull("size");
                node.putNull("sha256");
            }
        });

        return array;
    }

    /**
     * @return The path relative to the base folder, with {@code /} as separator.
     */
    static String relative(final Path file, final Path base) {
        return base.toAbsolutePath()
                   .normalize()
                   .relativize(file.toAbsolutePath().normalize())
                   .toString()
                   .replace('\\', '/');
    }

    /**
     * @return The SHA-256 of the file as lower-case hex.
     */
    static String sha256(final Path file) {
        try(InputStream input = new DigestInputStream(Files.newInputStream(file), MessageDigest.getInstance("SHA-256"))) {
            final byte [] buffer = new byte[1 << 16];
            while(input.read(buffer) >= 0) {
                // the digest stream hashes what is read
            }

            return HexFormat.of().formatHex(((DigestInputStream)input).getMessageDigest().digest());
        } catch(final IOException e) {
            throw new UncheckedIOException("Cannot hash " + file, e);
        } catch(final NoSuchAlgorithmException e) {
            throw new IllegalStateException("The Java runtime has no SHA-256.", e);
        }
    }

    /**
     * @return The build identity ({@value #BUILD_PROPERTIES}), empty if the build wrote none.
     */
    private static Properties buildProperties() {
        final Properties properties = new Properties();

        try(InputStream input = RunRecordWriter.class.getResourceAsStream(BUILD_PROPERTIES)) {
            if(input != null) {
                properties.load(input);
            }
        } catch(final IOException e) {
            log.warn("Cannot read the build identity {}.", BUILD_PROPERTIES, e);
        }

        return properties;
    }
}
