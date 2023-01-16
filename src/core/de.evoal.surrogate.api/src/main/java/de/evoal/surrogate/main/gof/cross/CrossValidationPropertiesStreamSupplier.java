package de.evoal.surrogate.main.gof.cross;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.stream.PropertiesStreamSupplier;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 * A stream supplier that leaves out a part of the training data.
 */
@Slf4j
public class CrossValidationPropertiesStreamSupplier implements PropertiesStreamSupplier {

    /**
     * Numbers of partitions to generate.
     */
    private final int k;

    /**
     * Partition to leave out.
     */
    @Setter
    private int partition;

    /**
     * The training data to split.
     */
    private final PropertiesStreamSupplier trainingData;

    private final long trainingDataCount;

    CrossValidationPropertiesStreamSupplier(final PropertiesStreamSupplier trainingData, final int k) {
        this.trainingData = trainingData;
        this.k = k;
        this.trainingDataCount = trainingData.get().count();
    }

    @Override
    public Stream<Properties> get() {
        final long partitionRest = trainingDataCount % k;

        // calculate each partition size
        final long partitionSizes[] = new long[k];
        for(int i = 0; i < k; ++i) {
            partitionSizes[i] = trainingDataCount / k + (i < partitionRest ? 1 : 0);
        }

        // calculate counts
        final long before = Arrays.stream(partitionSizes)
                                  .limit(partition - 1)
                                  .sum();
        final long skip = partitionSizes[partition - 1];

        log.info("Streaming partition #{}. Properties before: {}. Properties to skip: {}.", partition, before, skip);

        final AtomicLong counter = new AtomicLong(0);

        return trainingData.get()
                           .filter(p -> {
                                long c = counter.incrementAndGet();

                                return c <= before || c > before + skip;
                            });
    }

    public PropertiesStreamSupplier getValidationStream() {
        return new PropertiesStreamSupplier() {
            @Override
            public Stream<Properties> get() {
                final long partitionRest = trainingDataCount % k;

                // calculate each partition size
                final long partitionSizes[] = new long[k];
                for(int i = 0; i < k; ++i) {
                    partitionSizes[i] = trainingDataCount / k + (i < partitionRest ? 1 : 0);
                }

                // calculate counts
                final long before = Arrays.stream(partitionSizes)
                        .limit(partition - 1)
                        .sum();
                final long count = partitionSizes[partition - 1];


                log.info("Streaming validation partition #{}. Properties before: {}. Properties to stream: {}.", partition, before, count);

                final AtomicLong counter = new AtomicLong(0);

                return trainingData.get()
                        .filter(p -> {
                            long c = counter.incrementAndGet();

                            return c > before || c <= before + count;
                        });
            }
        };
    }
}
