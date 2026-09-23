class TimeMap {
    //bacically upper bound of the timestam
    private Map<String,List<Pair<Integer,String>>> ds;

    public TimeMap() {
        ds = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        ds.computeIfAbsent(key , k -> new ArrayList<>()).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
       List<Pair<Integer,String>> values = ds.getOrDefault(key , new ArrayList<>());

       int low = 0 , high = values.size()-1;
       String result = "";

       while(low <= high){
        int mid = (low+high)/2;

        if(values.get(mid).getKey() <= timestamp){
            result = values.get(mid).getValue();
            low=mid+1;
        }
        else{
            high = mid-1;
        }       
        }
        return result;
    }

    public static class Pair<K,V>{
        private final K key;
        private final V value;

        public Pair(K key,V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }
}
