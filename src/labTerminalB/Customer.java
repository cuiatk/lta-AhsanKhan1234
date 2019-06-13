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
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			//determine amounts for each line
			switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (each.getDaysRented() > 2)
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (each.getDaysRented() > 3)
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}
			// add frequent renter points
			frequentRenterPoints ++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&&
					each.getDaysRented() > 1) frequentRenterPoints ++;
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+ "\t" +
					String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) +
				"\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
		+
		" frequent renter points";
		return result;
	}
}
