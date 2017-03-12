package fi.lenkkeri.airline.grails.domain

class City {

    String cityName //man!
    String countryName //man!
    String airfieldName //man!

    boolean hidden //man!

    static constraints = {
    }

    public String toString()
    {
        return "$countryName, $cityName, $airfieldName"
    }
}
