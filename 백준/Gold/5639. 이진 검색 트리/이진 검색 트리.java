import java.io.*;

class Node {
	int key; //현재 노드 확인 key
	Node left; //자기참조,클래스가 자신의 인스턴스 변수로 자기 자신의 타입을 가짐
	Node right; // 트리나 연결리스트 같은 자료구조에서 사용.
	
	Node(int key) {
		this.key = key;
	}
	
	void insertNode(int num) {
		if(num < this.key) { //입력 num이 현재 노드 key 보다 작으면
			if(this.left==null) {
				this.left=new Node(num);
			}
			else {
				this.left.insertNode(num);
			}
		} else {
			if(this.right==null) {
				this.right=new Node(num);
			}
			else {
				this.right.insertNode(num);
			}
		}
	}
}

public class Main {
	
	private static Node root = null;	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while (true) {
			line = br.readLine();
			if (line == null || line.equals("")) {
				break;
			} else {
				int num = Integer.parseInt(line);
				if(root == null) {
					root = new Node(num);
				} else {
					root.insertNode(num);
				}
			}
		}
		printNode(root);

	}
	
	private static void printNode(Node node) {
		if(node == null) {
			return;
		}
		printNode(node.left);
		printNode(node.right);
		System.out.println(node.key);
	}
	
}

/*
 * 
 * 참고사항 : bst를 java로 구현하기, 자기참조
 * 
 * 
 * 
*/