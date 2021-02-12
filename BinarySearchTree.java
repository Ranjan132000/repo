import java.util.Scanner;
 
 class BSTNode
 {
     BSTNode left, right;
     int data;
 
     public BSTNode()
     {
         left = null;
         right = null;
         data = 0;
     }

     public BSTNode(int n)
     {
         left = null;
         right = null;
         data = n;
     }

     public void setLeft(BSTNode n)
     {
         left = n;
     }
 
     public void setRight(BSTNode n)
     {
         right = n;
     }

     public BSTNode getLeft()
     {
         return left;
     }
 
     public BSTNode getRight()
     {
         return right;
     }

     public void setData(int d)
     {
         data = d;
     }
 
     public int getData()
     {
         return data;
     }     
 }

 class BST
 {
     private BSTNode root;
 
    
     public BST()
     {
         root = null;
     }

     public boolean isEmpty()
     {
         return root == null;
     }
   
     public void insert(int data)
     {
         root = insert(root, data);
     }
   
     private BSTNode insert(BSTNode node, int data)
     {
         if (node == null)
             node = new BSTNode(data);
         else
         {
             if (data <= node.getData())
                 node.left = insert(node.left, data);
             else
                 node.right = insert(node.right, data);
         }
         return node;
     }
   
   
     public int countNodes()
     {
         return countNodes(root);
     }

     private int countNodes(BSTNode r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.getLeft());
             l += countNodes(r.getRight());
             return l;
         }
     }
 
     public boolean search(int val)
     {
         return search(root, val);
     }

     private boolean search(BSTNode r, int val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.getData();
             if (val < rval)
                 r = r.getLeft();
             else if (val > rval)
                 r = r.getRight();
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(BSTNode r)
     {
         if (r != null)
         {
             inorder(r.getLeft());
             System.out.print(r.getData() +" ");
             inorder(r.getRight());
         }
     }
    
       
 }
 
 public class BinarySearchTree
 {
     public static void main(String[] args)
    {                 
        Scanner scan = new Scanner(System.in);
        BST bst = new BST(); 
        System.out.println("Binary Search Tree Test\n");          
        char ch;
        do    
        {
            System.out.println("\nBinary Search Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. check empty"); 
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                bst.insert( scan.nextInt() );                     
                break;                          
            case 2 :                          
                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ bst.search( scan.nextInt() ));
                break;                                          
            case 3 :  
                System.out.println("Empty status = "+ bst.isEmpty());
                break;            
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            
            System.out.print("\nSorted Order : ");
            bst.inorder();
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
 }