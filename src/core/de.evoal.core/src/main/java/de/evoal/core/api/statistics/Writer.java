package de.evoal.core.api.statistics;

/**
 * Base interface for all statistics writer.
 */
public interface Writer {

    /**
     * Writes a record.
     *
     * @param data An array containing all the data of the record (in the order specified).
     * @throws WriterException Will be thrown if there is some problem while writing.
     */
    void addRecord(final Object[] data) throws WriterException;

    /**
     * Closes the writer.
     */
    void close();

    /**
     * Flushes the contents to the disk.
     */
    void flush();
}
