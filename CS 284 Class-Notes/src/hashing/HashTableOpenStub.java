package hashing;

import java.util.Arrays;

public class HashTableOpenStub<K, V> implements KWHashMap<K, V> {
	private Entry<K, V>[] table;
	private static final int START_CAPACITY = 101;
	private double LOAD_THRESHOLD = 0.75;
	private int numKeys;
	private int numDeletes;
	private final Entry<K, V> DELETED = new Entry<K, V>(null, null);

	@SuppressWarnings("unchecked")
	public HashTableOpenStub() {
		table = new Entry[START_CAPACITY];
	}

	public class Entry<Key, Val> {
		private Key key;
		private Val value;

		public Entry(Key key, Val value) {
			this.key = key;
			this.value = value;
		}

		public Key getKey() {
			return key;
		}

		public Val getValue() {
			return value;
		}

		public Val setValue(Val val) {
			Val oldVal = value;
			value = val;
			return oldVal;
		}

		public String toString() {
			return "{K:" + key + "; V:" + value + "}";
		}

	}

	// given a key, returns the index in the table
	// if entry for key does not exist, returns the position it should be inserted
	private int find(Object key) {
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index += table.length;
		}
		while((table[index] != null) && (!key.equals(table[index].key))) {
			index ++;
			if(index >= table.length) {
				index = 0;
			}
		}
		return index;
		
	}

	// given a key, returns the value associated with it in the table
	// if key is not found, return null
	public V get(Object key) {
		int index = find(key);
		if (table[index] != null) {
			return table[index].value;
		}
		else {
			return null;
		}
	}

	// given a key and a value, insert into the table.
	// rehash if needed
	// return the value for the old entry. if there was no old entry, return null
	// update numkeys
	public V put(K key, V value) {
		int index = find(key);
		if (table[index] == null) {
			table[index] = new Entry<K,V>(key,value);
			numKeys++;
			
			double loadFactor = (double) (numKeys + numDeletes/ table.length);
			if (loadFactor > LOAD_THRESHOLD) {
				rehash();
			}
			return null;
		}
		V oldVal = table[index].value;
		table[index].value = value;
		return oldVal;
	}

	// reinsert values into table of size (2 * oldTable.length + 1)
	// use put
	@SuppressWarnings("unchecked")
	private void rehash() {
		Entry <K,V> [] oldTable  = table;
		table = new Entry[2*oldTable.length+1];
		numKeys = 0;
		numDeletes = 0;
		for (int i = 0; i < oldTable.length; i++) {
			if ((oldTable[i] != null) && (oldTable[i] != DELETED)) {
				put(oldTable[i].key, oldTable[i].value);
			}
		}
	}

	// given a key, delete the entry with the key
	// if the entry does not exist, return null
	// otherwise, replace entry with DELETED, return the old value, and update
	// numdeletes/numkeys
	public V remove(Object key) {
		int index = find(key);
		if (table[index]== null) {
			return null;
		}
		else {
			V oldVal = table[index].value;
			table[index] = DELETED;
			numDeletes++;
			numKeys--;
			return oldVal;
		}
	}

	public int size() {
		return numKeys;
	}

	public boolean isEmpty() {
		return numKeys == 0;
	}

	public String toString() {
		return Arrays.deepToString(table);
	}

}

