import java.util.Scanner;

public class UI {
	public static void main(String[] args) {
		try {
			printMenuChoices();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void printMenuChoices() throws Exception {
		HashTable T = new HashTable();

		Scanner reader = new Scanner(System.in);
		boolean isRunning = true; // boolean that is true to keep prompting user options, until user exits and isRunning becomes false
		int usrInput = 0;
		Scanner reader2 = new Scanner(System.in);
			while (isRunning == true) {
				menuChoices();

usrInput = reader.nextInt(); // reads user option

			if (usrInput == 1) {
				System.out.print("Enter the Name of the Person:-");
				
				String s  = reader2.nextLine();
				T.chainedHashInsert(new Person(s));
				
				System.out.println("Press 7 for user-menu");
			}
			else if (usrInput == 2) {
				System.out.println("Enter the person names to add a friend:");
				Scanner sc = new Scanner(System.in);
					String s=	sc.nextLine();
				Person t = T.search(s);
				if(t!=null) {
					System.out.println("Enter the friend's name:");
					String s2 = sc.nextLine();
					Person t2 = T.search(s2);
					t.addFriend(t2);
					t2.addFriend(t);
				}else {
					System.out.println("Invalid Input enter a new Name or insert a new Person." );
					menuChoices();
					continue;
				}
				
			}
			else if (usrInput == 3) {
				System.out.println("Enter the account name to remove a friend from:");
				Scanner sc = new Scanner(System.in);
				String s=	sc.nextLine();
			Person t = T.search(s);
			if(t!= null) {
				System.out.println("Enter the account name to remove the person:");
				String s1=	sc.nextLine();
			t.delete(s1);
			Person t1 = T.search(s1);
			if(t1!= null) {
				t1.delete(t.getName());
			}
			}else {
				System.out.println("Invalid Input enter a new Name or insert a new Person." );
				continue;
			}
				}
			else if (usrInput == 4) {
				System.out.println("Enter your account name to get all friends:");

				Scanner sc = new Scanner(System.in);
				String s=	sc.nextLine();
			Person t = T.search(s);
			if(t==null) {
				System.out.println("Invalid Input enter a new Name or insert a new Person." );
				continue;
			}
				t.printFriends();
				}
			else if (usrInput == 5) {
				System.out.println("Enter the user account name to get all friends:");
				
				Scanner sc = new Scanner(System.in);
				String s=	sc.nextLine();
			Person t = T.search(s);
			if(t!= null) t.printFriends();
			else {
				System.out.println("User not found.");
			}
			}

			else if (usrInput == 6) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the first person name to check:");
				String s=	sc.nextLine();
				Person t = T.search(s);
				if(t!=null) {
					System.out.println("Enter the second person name to check:");
					String name=	sc.nextLine();
					boolean f = t.checkFriends(name);
					if(f) System.out.println("Yes!. Both are friends. :-)");
					else System.out.println("NO");
				}else {
					System.out.println("User not found.");
				}
					}
			
			else if (usrInput == 7) {
				T.printList();
					}
			else if (usrInput == 8) {
			menuChoices();
			}
			else if (usrInput == 9) {
				isRunning = false; // ends loop of user menu options
			}

		}

		reader.close(); // close the Scanner
	}
	
	public static void menuChoices() {
		System.out.println("-----ENTER ONE OF THE BELOW COMMANDS-----");
		System.out.println();
		System.out.println("1.) Create a new Person");
		System.out.println("2.) Record a new Friend for a person");
		System.out.println("3.) Remove a person from the friend's List");
		System.out.println("4.) List friends in my Account Name.");
		System.out.println("5.) List friends of a person's name.");
		System.out.println("6.) Enter two people to search if they are friends or not.");
		System.out.println("7.) Print all the users in the DB.");
		System.out.println("8.) Show User Dialog");
		System.out.println("9.) Exit Program");
		
		
		System.out.println();
		System.out.print("ENTER CHOICE (1-8): ");
	}
}
