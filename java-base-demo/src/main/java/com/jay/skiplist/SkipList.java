package com.jay.skiplist;

import java.util.Random;

/**
 * @author xiang.wei
 * @date 2020/8/2 3:51 PM
 */
public class SkipList<T> {
    private SkipListNode<T> head, tail;
    /**
     * 节点总数
     */
    private int nodes;
    /**
     * 层高
     */
    private int listLevel;
    /**
     * 随机函数
     */
    private Random random;
    /**
     * 向上提升一个的概率
     */
    private static final double PROBABILITY = 0.5;

    public SkipList() {
        random = new Random();
        clear();
    }

    public void clear() {
        head = new SkipListNode<T>(SkipListNode.HEAD_KEY, null);
        tail = new SkipListNode<T>(SkipListNode.TAIL_KEY, null);
        // TODO: 2020/8/2

        listLevel = 0;
        nodes = 0;
    }

    public boolean isEmpty() {
        return nodes == 0;
    }

    public int size() {
        return nodes;
    }

    /**
     * 在最下面一层，找到要插入的位置前面的那个key
     * @param key
     * @return
     */
    private SkipListNode<T> findNode(int key) {
        SkipListNode<T> p = head;
        while (true) {
            while (p.right.getKey() != SkipListNode.TAIL_KEY
                    && p.right.getKey() <= key) {
                p = p.right;
            }
            if (p.down != null) {
                p = p.down;
            } else {
                break;
            }
        }
        return p;
    }

    /**
     * 查询是否存储key,存在则返回该节点，否则返回null
     * @param key
     * @return
     */
    public SkipListNode<T> search(int key) {
        SkipListNode<T> p = findNode(key);
        if (key == p.getKey()) {
            return p;
        } else {
            return null;
        }
    }

    public void put(int k, T v) {
        SkipListNode<T> p = findNode(k);
        //如果key值相同，替换原来的value即可结束
        if (k == p.getKey()) {
            p.setValue(v);
            return;
        }
    }
}
