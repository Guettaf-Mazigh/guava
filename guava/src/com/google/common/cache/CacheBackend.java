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
public interface CacheBackend<K, V> {

  public @Nullable V getIfPresent(Object key);

  public V get(K key, CacheLoader<? super K, V> loader) throws ExecutionException;

  public @Nullable V put(K key, V value);

  public void putAll(Map<? extends K, ? extends V> m);

  public @Nullable V remove(Object key);

  public void clear();

  public long longSize();

  public ConcurrentMap<K, V> asMap();

  public void cleanUp();

  public void invalidateAll(Iterable<?> keys);

  public ImmutableMap<K, V> getAllPresent(Iterable<?> keys);

  public ImmutableMap<K, V> getAll(Iterable<? extends K> keys) throws ExecutionException;

  public V getOrLoad(K key) throws ExecutionException;

  public void refresh(K key);
}