package leetCode;

public class mergeKLists {

    //采用遍历的办法，效率不高，但是能够通过
    public ListNode MergeKLists(ListNode[] lists) {
        ListNode head = null;
        if(lists!=null && lists.length>0){
            int n = lists.length;
            ListNode[] p = new ListNode[n];
            ListNode cur = null;
            int minValue = Integer.MAX_VALUE;
            int index = 0;
            boolean isAllNull = true;
            //初始化
            for (int i = 0; i < n; i++) {
                p[i] = lists[i];
                //判断是否全部为空
                isAllNull = isAllNull && p[i]==null;
            }

            while (!isAllNull) {
                isAllNull = true;
                index = -1;
                minValue = Integer.MAX_VALUE;
                for (int i = 0; i <n; i++) {
                     //判断是否全部为空
                    isAllNull = isAllNull && p[i]==null;
                    if(p[i]==null)continue;
                    
                    if(p[i].val<minValue){
                        index = i;
                        minValue = p[i].val;
                    }
                }    
                if (index!=-1) {
                    if (head==null) {
                        head = p[index];
                        cur =head;
                    }else{
                        cur.next = p[index];
                        cur = cur.next;
                    }
                    p[index] = p[index].next;
                }
            }

        }
        return head;
    }

    ListNode[] lists;
    //分支方法
    public ListNode MergeKLists2(ListNode[] lists) {
        this.lists = lists;
        if(lists!=null && lists.length>0) return dfs(0,lists.length-1);
        return null;
    }

    public ListNode dfs(int left,int right){
        if (left==right)  return lists[left];

        int mid = (left+right)/2;
        ListNode leftList= dfs(left,mid);
        ListNode rightList= dfs(mid+1,right);
        return MergeTwoLists(leftList,rightList);
    }

    //合并两条链表
    public ListNode MergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2==null) {
            return null;
        }
        ListNode p1 =l1;
        ListNode p2 =l2;
        ListNode head = null;
        ListNode p3 =null;
        while (p1!=null || p2!=null) {
            int v1 = p1==null?Integer.MAX_VALUE:p1.val;
            int v2 = p2==null?Integer.MAX_VALUE:p2.val;
            
            if(head==null){
                if (v1<v2) {
                    head = p1;
                    p1=p1.next;
                }else{
                    head=p2;
                    p2=p2.next;
                }
                p3 = head;
            }else{
                if (v1<v2) {
                    p3.next = p1;
                    p1=p1.next;
                }else{
                    p3.next=p2;
                    p2=p2.next;
                }
                p3 = p3.next;
            }

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(2);
        p1.next = new ListNode(4);
        p1.next.next = new ListNode(5);
        p2.next = new ListNode(3);
        p2.next.next = new ListNode(4);
        p3.next = new ListNode(6);
        ListNode[] lists = {p1,p2,p3};
        mergeKLists m = new mergeKLists();
        ListNode p = m.MergeKLists2(lists);
        while (p!=null) {
            System.out.println(p.val);
            p=p.next;
        }

    }
}