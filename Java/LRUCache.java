The problem can be solved with a hashtable that keeps track of the keys and its values in the double linked list.
One interesting property about double linked list is that the node can remove itself without other reference.
In addition, it takes constant time to add and remove nodes from the head or tail.

One particularity about the double linked list that implemented is that we create a pseudo head and tail to mark the boundary, 
so that we don't need to check the NULL node during the update.
This makes the code more concise and clean, and also it is good for the performance as well.

Voila, here is the code.
public class LRUCache 
{
    class DLinkedNode
    {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }
    int capacity;
    
    HashMap<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    int count =0;
    DLinkedNode head;
    DLinkedNode tail;
    public void moveToHead(DLinkedNode node)
    {
        this.remove(node);
        this.addNode(node);
    }
    
    public void addNode(DLinkedNode node)
    {
        
        head.post.pre = node;
        node.post = head.post;
        head.post = node;
        node.pre = head;
        
    }
    
    public void remove(DLinkedNode node)
    {
        if(node == null)
            return;
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;
        pre.post = post;
        post.pre = pre;
    }
    
    public DLinkedNode popTail()
    {
        
        DLinkedNode res = tail.pre;
        this.remove(res);
        return res;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;    
        head = new DLinkedNode();
        tail = new DLinkedNode();
        
        head.pre = null;
        head.post = tail;
        tail.pre = head;
        tail.post = null;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node==null)
            return -1;
        this.moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        
        DLinkedNode node = cache.get(key);
        //node.key = key;
        
        if(node==null)
        {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            count++;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            
            if(count>capacity)
            {
                
                
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                count--;
                
            }
        }
        else
        {
            node.value = value;   
            this.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
