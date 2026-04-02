package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import org.jspecify.annotations.Nullable;

/**
 * Internal interface defining the backend operations required by cache
 * implementations. Reduces direct coupling between {@link LocalManualCache}
 * and {@link LocalCache}, improving architectural stability.
 *
 * <p>Package-private — not part of the public API.
 */
@GwtCompatible
interface CacheBackend<K, V> {

  @Nullable V getIfPresent(Object key);

  V get(K key, CacheLoader<? super K, V> loader) throws ExecutionException;

  @Nullable V put(K key, V value);

  void putAll(Map<? extends K, ? extends V> m);

  @Nullable V remove(Object key);

  void clear();

  long longSize();

  ConcurrentMap<K, V> asMap();

  void cleanUp();

  void invalidateAll(Iterable<?> keys);

  ImmutableMap<K, V> getAllPresent(Iterable<?> keys);

  ImmutableMap<K, V> getAll(Iterable<? extends K> keys) throws ExecutionException;

  V getOrLoad(K key) throws ExecutionException;

  void refresh(K key);
}