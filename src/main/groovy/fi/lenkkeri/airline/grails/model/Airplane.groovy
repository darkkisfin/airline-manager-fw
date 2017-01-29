package fi.lenkkeri.airline.grails.model

import groovy.transform.ToString

/**
 * Created by darkkis on 15.1.2017.
 */
@ToString
class Airplane {
    String serialNumber //man!
    String nickname //man!
    String type //man!
    Date manufactured //man!
    Date acquired //man!
    Date lastMaintenance //man!
    Double length //man!
    Double width //man!
    Double weight //man!
    Long crewRequired //man!
    Long seatCount //man!
    Double fuelCapacity //man!
    Double nominalRange //man!
    Double maximumRange //man!
}
