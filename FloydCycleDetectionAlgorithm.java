import java.util.Scanner;
/*program to find if length of cycle in a linked list
differnts approaches
1. Use a hash map to store the address of the node and the number of times it has occured. 
    - Time complexity O(n)
    - Space complexity O(n)
2. Use flag for each node
    - Time complexity O(n)
    - Space complexity O(n)*extra space to store flag atribute in node
3. Floyd's cycle detection algorithm(tortoise hare algo):
    Uses two pointers one slow pointer and other fast pointer (x2) when both the pointer point to same address the cycle is detected.
    - Time complexity O(n)
    - Space complexity O(1)

*/

//Floyd algorithm
class Node
{
    int data;
    Node next;
    Node(int n)
    {
        next=null;
        data=n;
    }
}
class FloydCycleDetectionAlgorithm
{
    static int countLength(Node loop_head)
    {
        int r=1;
        Node h=loop_head.next;
        while(h!=loop_head)
        {
            h=h.next;
            r++;
        }
        return r;
    }
    static int countLoop (Node head)
    {
        Node slow_pointer=head, fast_pointer=head;
        while(slow_pointer!=null && fast_pointer!=null && fast_pointer.next!=null)
        {
            slow_pointer=slow_pointer.next;
            fast_pointer=fast_pointer.next.next;
            if(slow_pointer==fast_pointer)
                return countLength(slow_pointer);
        }
        return -1;
    }
    public static void main(String args[])
    {
        /*Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the number of nodes in linked list");*/
        Node head = new Node(1);  
        head.next = new Node(2);  
        head.next.next = new Node(3);  
        head.next.next.next = new Node(4);  
        head.next.next.next.next = new Node(5);  

        /* Create a loop for testing */
        head.next.next.next.next.next = head.next; 
        if(head!=null){
            int n=countLoop(head);
            if(n==-1)
                System.out.println("No loop");
            else
                System.out.println("The length of loop is "+n);
        }
        else
        {
            System.out.println("Head not found");
        }
        
    }
}