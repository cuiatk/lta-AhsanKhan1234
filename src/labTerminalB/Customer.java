package labTerminalB;

import java.util.Enumeration;
import java.util.Vector;



public class Customer {
		private String _name;
		private Vector<Rental> _rentals = new Vector<Rental>();
		public Customer (String name){
			_name = name;
		};
		public void addRental(Rental arg) {
			_rentals.addElement(arg);
		}
		public String getName (){
			return _name;
		};
		
		/*
		 * TODO 4		20 Marks
		 * Identify the bad smells in the statement method and refactor the code
		 * In case you add a new method also provide specifications for new method
		 * after refactoring all test cases must still be passed
		 * Commit after each change and include a meaningful message about the change you made
		 * e.g. Method Move methodName();
		 * 
		 */
		
		/**
		 * TODO 3		10 Marks
		 * @return the statement method returns the total Amount and frequent rentals points if movie is NEW_RELEASE.
		 * Total Amount is determined for all the three movies i.e REGULAR,NEW_RELEASE,CHILDRENS.
		 * if movie is REGULAR then add 2 to amount if daysRented greater than 2 then add  (each.getDaysRented() - 2) * 1.5 to amount.
		 * if movie is CHILDRENS then add 1.5 to amount if daysRented greater than 3 then add  (each.getDaysRented() - 3) * 1.5.
		 * statement also computes frequent renter points, which vary depending on whether the film is a new release.
		 * if movie is NEW_RELEASE and days for which the movie is rented is greater than 1 then add 1 frequent point to 'this amount' and then 'this amount' to 'total amount'
		 * 
         */
		
		public String statement() {
			Enumeration rentals = _rentals.elements();
			String result = "Rental Record for " + getName() + "\n";
			while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+ "\t" +
			String.valueOf(each.getCharge()) + "\n";
			}
			//add footer lines
			result += "Amount owed is " +
			String.valueOf(getTotalCharge()) + "\n";
			result += "You earned " +
			String.valueOf(getTotalFrequentRenterPoints()) +
			" frequent renter points";
			return result;
			}
			
		private double getTotalCharge() {
		double result=0;
		Enumeration<Rental>rentals=_rentals.elements();
		while(rentals.hasMoreElements()){
			Rental each=(Rental)rentals.nextElement();
			result+=each.getCharge();
			
		}
		return result;
		}
			private int getTotalFrequentRenterPoints(){
			int result = 0;
			Enumeration rentals = _rentals.elements();
			while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints();
			}
			return result;
			}
	}
