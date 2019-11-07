package ru.mail.polis.ads.bst;

/**
 * AVL implementation of binary search tree.
 */
public class AvlBst<Key extends Comparable<Key>, Value>
        implements Bst<Key, Value> {

    private Node root;
    
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int height;

        Node(Key key, Value value, int height) {
            this.key = key;
            this.value = value;
            this.height = height;
        }
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        // на каждом шаге нет необходимости проверять целое поддерево,
        // (обеспечим логарифмическую сложность)
        if (key.compareTo(x.key) > 0) {
            // не нужно смотреть на левое поддерево
            return get(x.right, key);
        }
        if (key.compareTo(x.key) < 0) {
            // не нужно смотреть на правое поддерево
            return get(x.left, key);
        }

        return x.value;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    // логарифмическая сложность из-за поиска места вставки
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }

        if (key.compareTo(x.key) > 0) {
            x.right = put(x.right, key, value);
        }
        else if (key.compareTo(x.key) < 0) {
            x.left = put(x.left, key, value);
        }
        else x.value = value;

        setHeight(x);
        // возвращаясь назад по всему пути проверяем сбалансированность
        x = balancing(x);
        return x;
    }

    private int diff(Node x) {
        return height(x.left) - height(x.right);
    }

    // константная временная сложность: указываем с одних вершин на другие
    private Node balancing(Node x) {
        // правое вращение необходимо, когда величина левого поддерева
        // больше величины правого поддерева на 2
        if (diff(x) == 2) {
            // какое из поддеревьев левого потомка больше?
            if (diff(x.left) < 0) {
                x.left = rotateLeft(x.left);
            }
            return rotateRight(x);
        }
        // левое вращение необходимо, когда величина правого поддерева
        // больше величины левого поддерева на 2
        if (diff(x) == -2) {
            // какое из поддеревьев правого потомка больше?
            if (diff(x.right) > 0)  {
                x.right = rotateRight(x.right);
            }
            return rotateLeft(x);
        }

        return x;
    }

    private void setHeight(Node x) {
        x.height = 1 + Math.max(height(x.left), height(x.right));
    }

    private Node rotateRight(Node x) {
        Node left = x.left;

        x.left = left.right;
        left.right = x;

        setHeight(x);
        setHeight(left);

        return left;
    }

    private Node rotateLeft(Node x) {
        Node right = x.right;

        x.right = right.left;
        right.left = x;

        setHeight(x);
        setHeight(right);

        return right;
    }

    @Override
    public Value remove(Key key) {
        return remove(root, key).value;
    }

    // находим вершину, которую необходимо удалить.
    // Значение вершины меняем с максимальным значение левого поддерева
    // (максимальное значение среди минимальных),
    // или же минимальным значением правого поддерева
    // (минимальным значением среди максимальных).
    // Затем копируем это значение в удаляемую (текущую) вершину,
    // а вершину с максимумом удаляем.
    // Логарифмическая временная сложность.
    private Node remove(Node x, Key key) {
        if (x == null) {
            return null;
        }

        if (key.compareTo(x.key) > 0) {
            x.right = remove(x.right, key);
        }
        else if (key.compareTo(x.key) < 0) {
            x.left = remove(x.left, key);
        }
        else {
            x = safeRemove(x);
        }

        setHeight(x);
        // проходим по всему маршруту, по которому искали максимум,
        // и проверяем: сбалансировано ли дерево
        balancing(x);

        return x;
    }

    private Node minNode(Node x) {
        if (x.left == null) {
            return x;
        }

        return minNode(x.left);
    }

    private Node rmMin(Node x) {
        if (x.left == null) {
            return x.right;
        }

        x.left = rmMin(x.left);

        return x;
    }

    private Node safeRemove(Node x) {
        if (x.right == null) {
            return x.left;
        }
        if (x.left == null) {
            return x.right;
        }

        Node t = x;

        x = minNode(t.right);
        x.right = rmMin(t.right);
        x.left = t.left;

        return x;
    }

    @Override
    public Key min() {
        return min(root);
    }

    private Key min(Node x) {
        if (x == null) {
            // структура пустая
            return null;
        }
        if (x.left == null) {
            return x.key;
        }

        return min(x.left);
    }

    @Override
    public Value minValue() {
        // value от минимального key
        return get(min());
    }

    @Override
    public Key max() {
        throw new UnsupportedOperationException("Implement me");
    }

    @Override
    public Value maxValue() {
        throw new UnsupportedOperationException("Implement me");
    }

    @Override
    public Key floor(Key key) {
        throw new UnsupportedOperationException("Implement me");
    }

    @Override
    public Key ceil(Key key) {
        throw new UnsupportedOperationException("Implement me");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Implement me");
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node x) {
        return x == null ? 0 : x.height;
    }
}
