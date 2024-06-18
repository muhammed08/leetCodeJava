import java.util.ArrayList;

// Combine a list of sorted linked list into a single
// sorted linkedlist
public class SortLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<ListNode> heap = new ArrayList<>();

        for(ListNode node: lists){
            while(node != null){
                heap.add(node);
                node = node.next;
            }
        }

        System.out.println("Size of heap : "+ heap.size());

        for (int i=heap.size()/2 -1; i>=0;i--){
            heapify(heap, i);
        }
        printHeap(heap);

        ListNode current = extractMin(heap);
        ListNode head = current;
        while(current != null){
            ListNode nextNode = extractMin(heap);
            current.next = nextNode;
            current = nextNode;
        }

        return head;

    }

    public ListNode extractMin(ArrayList<ListNode> list){
        if (list.size() == 0){
            return null;
        } else if (list.size() == 1) {
            ListNode node = list.get(0);
            list.remove(0);
            return node;
        } else {
            ListNode node = list.get(0);
            list.set(0, list.get(list.size()-1));
            list.remove(list.size()-1);
            heapify(list, 0);
            return node;
        }
    }

    public void heapify(ArrayList<ListNode> list, int root) {
        int left = root*2+1;
        int right = root*2 +2;
        int largest =root;
        if (left < list.size() && list.get(largest).val > list.get(left).val) {
            largest = left;
        }
        if (right < list.size() && list.get(largest).val > list.get(right).val) {
            largest = right;
        }

        if (root != largest){
            ListNode node = list.get(largest);
            list.set(largest, list.get(root));
            list.set(root, node);
            heapify(list, largest);
        }
    }

    public void printHeap(ArrayList<ListNode> list) {
        for(ListNode node: list){
            System.out.print(node.val + " ");
        }
        System.out.println();

    }

    public static void main(String[] args){
         SortLinkedList list = new SortLinkedList();
         ListNode node = new ListNode(5, null);
        ListNode node1 = new ListNode(4, node);
        ListNode node2 = new ListNode(1, node1);

        ListNode node3 = new ListNode(4, null);
        ListNode node4 = new ListNode(3, node3);
        ListNode node5 = new ListNode(1, node4);

        ListNode node6 = new ListNode(6, null);
        ListNode node7 = new ListNode(2, node6);

        ListNode[] array = {node2, node5, node7};
        ListNode head = list.mergeKLists(array);

        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
