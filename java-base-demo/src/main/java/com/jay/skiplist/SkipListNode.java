package com.jay.skiplist;

/**
 * 跳跃表的节点，包括key-value和上下左右4个指针
 * @author xiang.wei
 * @date 2020/8/2 3:34 PM
 */
public class SkipListNode<T> {
    private int key;
    private T value;
    /**
     * 上下左右 四个指针
     */
    public SkipListNode<T> up,down,left, right;

    /**
     * 负无穷
     */
    public static final int HEAD_KEY = Integer.MIN_VALUE;
    /**
     * 正无穷
     */
    public static final int TAIL_KEY = Integer.MAX_VALUE;

    public SkipListNode(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SkipListNode<?>)) {
            return false;
        }
        SkipListNode<T> ent;
        try {
            ent = (SkipListNode<T>) obj;
        } catch (Exception e) {
            return false;
        }
        return (ent.getKey() == key) && (ent.getValue() == value);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
