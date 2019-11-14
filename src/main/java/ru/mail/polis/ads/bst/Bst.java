package ru.mail.polis.ads.bst;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Binary search tree with ordered operations support.
 */
public interface Bst<Key extends Comparable<Key>, Value> {
    @Nullable Value get(@NotNull Key key);

    void put(@NotNull Key key, @NotNull Value value);

    @Nullable Value remove(@NotNull Key key);

    @Nullable Key min();

    @Nullable Value minValue();

    @Nullable Key max();

    @Nullable Value maxValue();

    @Nullable Key floor(@NotNull Key key);

    @Nullable Key ceil(@NotNull Key key);

    int size();

    int height();
}
