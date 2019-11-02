package ru.mail.polis.ads.bst;

/**
 * Binary search tree with ordered operations support.
 */
public interface Bst<Key extends Comparable<Key>, Value> {
    Value get(Key key);

    void put(Key key, Value value);

    Value remove(Key key);

    Key min();

    Value minValue();

    Key max();

    Value maxValue();

    Key floor(Key key);

    Key ceil(Key key);
    
    int size();
    
    int height();
}
