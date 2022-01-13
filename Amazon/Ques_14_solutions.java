// { Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static int minTime(Node root, int target) 
    {
        HashMap<Node,Node> parent=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        Node tNode=null;
        while(!q.isEmpty())
        {
            Node temp=q.poll();
            if(temp.data==target)
            tNode=temp;
            if(temp.left!=null)
            {
                parent.put(temp.left,temp);
                q.add(temp.left);
            }
            
            if(temp.right!=null)
            {
                parent.put(temp.right,temp);
                q.add(temp.right);
            }
        }
        
        int cnt=0;
        q.add(tNode);
        HashSet<Integer> vis=new HashSet<>();
        vis.add(tNode.data);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                Node temp=q.poll();
               if(parent.containsKey(temp) && !vis.contains(parent.get(temp).data))
               {
                   q.add(parent.get(temp));
                   vis.add(parent.get(temp).data);
               }
               if(temp.left!=null && !vis.contains(temp.left.data))
               {
                   q.add(temp.left);
                    vis.add(temp.left.data);   
               }
               if(temp.right!=null && !vis.contains(temp.right.data))
               {
                   q.add(temp.right);
                   vis.add(temp.right.data);
               }
            }
            cnt++;
        }
        
        return cnt-1;
    }
}