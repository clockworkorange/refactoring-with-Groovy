package es.refactoring.tema1

class Customer
{
    private String name;
    private List rentals = [];

    public String statement() {
        def totalAmount = 0
        def frequentRenterPoints = 0
        String result = "Rental Record for ${name} \n"

        rentals.each { each ->
            double thisAmount = 0;
            //determine amounts for each line
            switch (each.movie.priceCode) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.daysRented > 2)
                        15
                    thisAmount += (each.daysRented - 2) * 1.5;
                    break
                case Movie.NEW_RELEASE:
                    thisAmount += each.daysRented * 3;
                    break
                case Movie.CHILDRENS:
                    thisAmount += 1.5
                    if (each.daysRented > 3)
                        thisAmount += (each.daysRented - 3) * 1.5
                    break
            }
            // add frequent renter points
            frequentRenterPoints ++
            // add bonus for a two day new release rental
            if ((each.movie.priceCode == Movie.NEW_RELEASE) && each.daysRented > 1)
                frequentRenterPoints ++
            //show figures  for this rental
            result += "\t  ${each.movie.title} \t + ${thisAmount} \n"
            totalAmount += thisAmount
        }
        //add footer lines
        result += "Amount owed is ${totalAmount} \n"
        result += "You earned ${requentRenterPoints} +  frequent renter points"
        return result
    }
}
