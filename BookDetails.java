package bookstore;

public class BookDetails 
{
	private String bookname;
private double cost;
private String author;
private String booktype;
private int bookid;
private int numunits;

public String getBookName() {
	return bookname;
}
public void setBookName(String bookname) {
	this.bookname = bookname;
}
public double getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public int getNumunits() {
	return numunits;
}
public void setNumunits(int numunits) {
	this.numunits = numunits;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getBooktype() {
	return booktype;
}
public void setBooktype(String booktype) {
	this.booktype = booktype;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String toString() {
	return("Book[name="+ bookname +",cost="+cost+",num of units="+numunits+",bookid="+bookid
			+",Author="+author+",booktype="+booktype+
			",toString()="+super.toString()+"]");

}

}
