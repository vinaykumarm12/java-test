package bookstore;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("press 1 to add new book" + "\n press 2 to display all books"
				+ "\n press 3 to search book" + "\n press 4 to delete book"+ "\n press 5 to update book"+"\n press 6 to exit");
		while (true) {
			System.out.println("please enter the option");
			int option = scan.nextInt();
			switch (option) {
			case 1:
				System.out.println("enter book name");
				String name = scan.next();
				System.out.println("enter the cost");
				double c=scan.nextDouble();
				System.out.println("enter the num of books");
				int num=scan.nextInt();
				System.out.println("enter author name");
				String auth = scan.next();
				System.out.println("enter bookype");
				String type = scan.next();
				BookInterface obj=new BookImplementation();
				obj.addbook(name, c, num, auth, type);
				break;
				
			case 2:
				BookInterface obj1 = new BookImplementation();				
				Set<BookDetails> pr=new HashSet<BookDetails>();
				pr=obj1.displaybook();
				for (BookDetails temp : pr) {
			        System.out.println(temp);
				}
				break;
				
			case 3:
				System.out.println(" enter book id to search");
				int name1 = scan.nextInt();
				BookInterface obj3 = new BookImplementation();
				obj3.searchbook(name1);				
				break;
				
			case 4:
				System.out.println("enter the book id to delete");
				int id=scan.nextInt();
				BookInterface obj4 = new BookImplementation();
				obj4.deletebook(id);;
				System.out.println("product deleted succesfully");
				break;
				
			case 5:
				System.out.println("enter the book id to update");
				int pid=scan.nextInt();
				System.out.println("enter the number of items to be updated");
				int unit=scan.nextInt();
				BookInterface obj5 = new BookImplementation();
				obj5.updatebook(pid, unit);
				break;
				
			case 6:
				System.exit(0);
			}
	}
	}
}
