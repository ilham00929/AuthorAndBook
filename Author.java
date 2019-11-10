/**
 * CS 152 Lab 7 - Author
 * 2019/4/14
 * Ilham Babajanov
 */

public class Author {


    private String givenName, surname;
    private int birthYear, deathYear;

    /**
     * Creates a new Author with a name, but birth and death years not set.
     * @param givenName
     * @param surname
     */
    public Author(String givenName, String surname){
        this.givenName = givenName;
        this.surname = surname;
        this.birthYear = AuthorBookConstants.UNKNOWN_YEAR;
        this.deathYear = AuthorBookConstants.UNKNOWN_YEAR;
    }

    /**
     * Returns an int representing the author’s year of birth.
     * @return year of author's birth.
     */
    public int getBirthYear() {
        return this.birthYear;
    }

    /**
     * Returns an int representing the author’s year of death.
     * @return year of author's death.
     */
    public int getDeathYear() {
        return this.deathYear;
    }

    /**
     * Sets the author’s year of birth. It must be a valid year.
     * If it's an invalid year, prints an error message to the user and leaves
     * previous value unchanged.
     * @param birth
     */
    public void setLifespan(int birth) {
        if (birth > -2000 && birth != 0 && birth < 2024) {
            this.birthYear = birth;
        } else {
            System.out.println("Invalid birth year.");
        }
    }

    /**
     * Sets both the author’s year of birth and death. Both must be valid
     * years, and the year of death must be after the year of birth. Prints
     * an error message to the user if either one of birth or
     * death years is invalid.
     * @param birth
     * @param death
     */
    public void setLifespan(int birth, int death) {
        if (birth < death) {
            if (birth > -2000 && birth != 0 && birth < 2024) {
                this.birthYear = birth;
            } else {
                System.out.println("Invalid birth year.");
            }
            if (death > -2000 && death != 0 && death < 2024) {
                this.deathYear = death;
            } else {
                System.out.println("Invalid death year.");
            }
        } else {
            System.out.println("Invalid birth or death year.");
        }
    }

    /**
     * If two authors have the same given names and surnames it returns true,
     * otherwise it returns false.
     * @param other
     * @return true or false.
     */
    public boolean hasSameName(Author other) {

        if (this.givenName.length() == 1 || other.givenName.length() == 1) {
            if (this.givenName.charAt(0) == other.givenName.charAt(0) &&
                this.surname.equals(other.surname)) {
                return true;
            } else {
                return false;
            }
        } else if (other.givenName.length() != 1) {
            if (this.givenName.equals(other.givenName) &&
                this.surname.equals(other.surname)) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    /**
     * Returns a string representation of the author, of the form:
     * Barnes, Julian("surname, givenName")
     * @return a String representation of the author
     */
    public String toString() {
        return (this.surname + ", " + this.givenName);
    }

    /**
     * Returns a string for the author, of the form:
     * Heaney, Seamus
     * If the year of birth (but not death) is set it returns:
     * Heaney, Seamus (b. 1939)
     * If both the years of birth and death have been set, it returns:
     * Heaney, Seamus (1939-2013)
     * @return a String for the author.
     */
    public String infoString() {
        if (isEmptyBirth() && isEmptyDeath()) {
            return toString();
        } else if (isEmptyDeath()) {
            return (toString() + " (b. " + birthYear +")");
        }else {
            return (toString() + " (" + birthYear + "-" + deathYear+ ")" );
        }
    }

    /**
     * Helper method. Checks if the birth year is empty or not.
     * In this case, checks if birth year is equal to
     * UNKNOWN_YEAR in AuthorBookConstants. Returns boolean value.
     * @return true or false.
     */
    private boolean isEmptyBirth() {
        if (this.birthYear == AuthorBookConstants.UNKNOWN_YEAR) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Helper method. Checks if the death year is empty or not.
     * In this case, checks if death year is equal to
     * UNKNOWN_YEAR in AuthorBookConstants. Returns boolean value.
     * @return true or false.
     */
    private boolean isEmptyDeath() {
        if (this.deathYear == AuthorBookConstants.UNKNOWN_YEAR) {
            return true;
        } else {
            return false;
        }
    }

}
