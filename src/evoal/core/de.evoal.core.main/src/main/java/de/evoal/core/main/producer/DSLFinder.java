package de.evoal.core.main.producer;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApplicationScoped
public class DSLFinder {
    public record DSLInfo(String module, String name, InputStream stream) {
    }

    public List<DSLInfo> find(final String name) {
        return ModuleLayer.boot()
                          .modules()
                          .stream()
                          .map(m -> {
                              String moduleName = m.getName();
                              try (final InputStream is = m.getResourceAsStream(name)) {
                                  if (is == null) {
                                      return null;
                                  }
                                  return new DSLInfo(moduleName, name, is);
                              } catch (IOException e) {
                                  return null;
                              }
                          })
                          .filter(Objects::nonNull)
                          .collect(Collectors.toList());
    }
}
