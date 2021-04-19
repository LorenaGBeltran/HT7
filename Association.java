package net.codejava;
import java.util.Map;

/**
 * @author loren
 *
 */
public class Association<K,V> 
extends java.lang.Object
implements Map.Entry<K,V>, Comparable<Association> {

K key;
V value;

public Association(K key, V value) {
this.key = key;
this.value = value;
}

@Override
public K getKey() {
return key;
}

@Override
public V getValue() {
return value;
}

@Override
public V setValue(V value) {
return this.value = value;
}

@Override
public int compareTo(Association o) {
return key.toString().compareToIgnoreCase(o.key.toString());
}

}
