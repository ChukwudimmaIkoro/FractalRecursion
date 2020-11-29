package largeinteger;

import largeinteger.LLNode;

public class LargeInteger {
	
  private LLNode<Integer> head; 
  private int size; 

  public int size() { 
	  
    return size; 
  }
  
  public LLNode<Integer> getList() { 
	  
    return head; 
  }

  public LargeInteger() {
	  
    head = null; 
    size = 0;
  }

  public LargeInteger(String input) { 	
	  
	  for (int i = 0; i < input.length(); i++) {
		  
		  head = new LLNode<Integer>(input.charAt(i)-'0', head);
		  
		  size++;
		  }
  }
 
  public LargeInteger divide10() {
	  
	if (head == null)
		
		return null;
	  
	if (size <= 1) {
		
		this.head.data = 0;

		return this;
	}
	  
	else {
		
	
	this.head = head.link;
	
	size--;
	
	return this;
  }
  }

  
  public LargeInteger multiply10() {
	  
	  if (this.head == null) {
			
			return null;
	  }
	  
	  if (this.head.data.equals(0)) {
		  
		  return this;
	  }

	  else {
		  
	  LLNode<Integer> newNode = new LLNode<Integer>(0, head);
	
	  this.head = newNode;
	  
	  size++;

      return this;
	  }
  }

  
  public LargeInteger add(LargeInteger that) {
	  
	  LLNode<Integer> topNode = this.head;
	  LLNode<Integer> bottomNode = that.head;
	  
	  int carry = 0;
	  int value = 0;
	  int a = 0;
	  int b = 0;
	  String result = "";
	  
	  while (topNode != null || bottomNode != null) {
		  
		  if (topNode == null) {
			  
			  a = 0;
		  }
		  
		  else {
			  
			  a = topNode.data;
		  }
		  
		  if (bottomNode == null) {
			  
			  b = 0;
		  }
		  
		  else {
			  
			  b = bottomNode.data;
		  }
		  
		  int sum = a + b;
		  
		  value = (carry + sum) % 10;
		  carry = (carry + sum) / 10;
		  result = value + result;
		  
		  if (topNode == null) {
			  
			  topNode = null;
		  }
		  
		  else {
			  
			  topNode = topNode.link;
		  }
		  
		  if (bottomNode == null) {
			  
			  bottomNode = null;
		  }
		  
		  else {
			  
			  bottomNode = bottomNode.link;
		  }
	  }
	  
	  if (carry > 0) {
		  
		  result = carry + result;
	  }
	  
	  LargeInteger sum = new LargeInteger(result);
	  	
      return sum;
  }

  
  public LargeInteger multiply(int x) {
	  
	  if (x == 0) {
		  
		  return new LargeInteger("0");
	  }
	  
	  else {
		  
		  LargeInteger a = new LargeInteger(this.toString());
		  LargeInteger b = new LargeInteger("0");
		  
		  while (x > 0) {
			  
			  b = b.add(a);
			  
			  x--;
		  }
		  return b;
	  }

  }


  private String toString(LLNode<Integer> node) {
	  	
	  if (this.head == null) {
		  
		  return "";		  
	  }
	  
	  if (node == null) {
		  
		  return "";	  
	  }
	  
	  return toString(node.link) + Integer.toString(node.data);
	 
  }


  public String toString() {
    return toString(head);
  }

  public static LargeInteger factorial(int n) {
    if (n == 0) {
      return new LargeInteger("1");
    }
    return factorial(n - 1).multiply(n);
  }

  public static LargeInteger pow(int x, int y) {
    if (y == 0) {
      return new LargeInteger("1");
    }
    return pow(x, y - 1).multiply(x);
  }
}
