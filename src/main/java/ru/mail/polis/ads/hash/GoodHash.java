package ru.mail.polis.ads.hash;

import java.util.Objects;

/**
 * Made by БорискинМА
 * inspired by lectures and https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
 * 01.12.19
 * gr. Java-10, Технополис
 * IntelliJ IDEA Ultimate 2019.2 (JetBrains Product Pack for Students)
 * Реализация HashTable с разрешением коллизий методом цепочек.
 */

public class GoodHash <K, V> implements HashTable<K, V> {

    private static final int CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private int capacity = 16;

    private int counter = 0;

    private HashNode<K, V>[] hashTable;

    private int size;

    static class HashNode<K, V> {
        final int hash;

        final K key;
        V value;

        HashNode<K, V> next;

        HashNode(K key, V value, int hash) {
            this.key = key;
            this.value = value;

            this.hash = hash;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (obj instanceof HashNode) {
                return Objects.equals(this.key, ((HashNode) obj).key) &&
                        Objects.equals(this.value, ((HashNode) obj).value);
            }

            return false;
        }
    }

    public GoodHash() {
        this.hashTable = new HashNode[CAPACITY];
    }

    // имплементация хэш-функции для нахождения индекса по ключу
    private static int hash(Object key) {
        int h;

        return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }

    @Override
    public V get(K key) {
        // голова цепочки по ключу
        int bucketIndex = hash(key);
        int box = bucketIndex % hashTable.length;

        HashNode<K, V> head = hashTable[box];

        // ключ в цепочке
        while (head != null) {
            if (head.hash == bucketIndex && key.equals(head.key)) {
                return head.value;
            }

            head = head.next;
        }

        // ключ не найден
        return null;
    }

    @Override
    public void put(K key, V value) {
        put(new HashNode<K, V>(key, value, hash(key)));
    }

    private void put(HashNode<K, V> x) {
        int box = x.hash % hashTable.length;

        HashNode<K, V> node = hashTable[box];

        if (node == null) {
            hashTable[box] = x;

            size++;

            counter++;
        }
        else {
            HashNode<K, V> tail = node;

            do {
                if (x.key.equals(node.key)) {
                    node.value = x.value;
                    return;
                }

                tail = node;
                node = node.next;

            } while (node != null); // может быть, ключ уже здесь?

            tail.next = x;

            // добавляем ключ в цепочку
            size++;
        }

        // Если load factor превышает порог, то увеличиваем вдвое размер таблицы
        if (capacity * LOAD_FACTOR < counter) {
            capacity *= 2;

            counter = 0;

            HashNode<K, V>[] temp = hashTable;

            hashTable = new HashNode[capacity];

            for (HashNode<K, V> headNode : temp) {

                while (headNode != null) {
                    HashNode<K, V> next = headNode.next;

                    put(headNode);

                    headNode = next;
                }

            }
        }
    }

    @Override
    public V remove(K key) {
        // находим индекс по заданному ключу
        int bucketIndex = hash(key);

        int box = bucketIndex % hashTable.length;
        // голова цепочки
        HashNode<K, V> head = hashTable[box];
        // ищем ключ вего цепочке
        HashNode<K, V> prev = null;

        while (head != null) {

            if (key.equals(head.key)) {
                size--;

                if (prev == null) {
                    hashTable[box] = head.next;

                    if (hashTable[box] == null) {
                        counter--;
                    }

                    return head.value;
                }
                else {
                    // иначе удаляем ключ
                    prev.next = head.next;

                    return head.value;
                }
            }
            // продолжаем движение по цепочке
            prev = head;
            head = head.next;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
