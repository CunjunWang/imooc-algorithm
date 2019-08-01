package com.cunjunwang.algorithm.advanceddatastructure.map;

/**
 * Created by CunjunWang on 2019-08-01.
 */
public interface Map<K, V> {

    /**
     * map中键的数量
     *
     * @return 键的数量
     */
    int getSize();

    /**
     * map是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 添加元素
     *
     * @param key   键
     * @param value 值
     */
    void add(K key, V value);

    /**
     * 删除键为key的元素
     *
     * @param key 键
     * @return 删除的元素值
     */
    V remove(K key);

    /**
     * 是够包含键为Key的元素
     *
     * @param key 键
     * @return 是否包含
     */
    boolean contains(K key);

    /**
     * 根据键获取值
     *
     * @param key 键
     * @return 值
     */
    V get(K key);

    /**
     * 根据键设置值
     *
     * @param key   键
     * @param value 值
     */
    void set(K key, V value);

}
