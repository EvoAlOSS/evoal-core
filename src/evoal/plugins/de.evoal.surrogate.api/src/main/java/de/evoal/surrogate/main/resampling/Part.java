package de.evoal.surrogate.main.resampling;

import lombok.NonNull;

/**
 * One part of a resampling scheme: the rows to learn from and the rows to assess, as indices
 *   into the training data. A row may occur several times in {@code training} (bootstrap).
 *
 * @param training The indices of the rows to learn from.
 * @param heldOut The indices of the rows to assess.
 */
public record Part(int @NonNull [] training, int @NonNull [] heldOut) {
}
