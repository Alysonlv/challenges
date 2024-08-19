package corp.alv.challenges.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
public class Pair<K, V> {
    private K key;
    private V value;
}
