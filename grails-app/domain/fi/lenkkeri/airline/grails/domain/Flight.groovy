package fi.lenkkeri.airline.grails.domain

class Flight {

    String pilotId //man!
    String pilotName //man!

    String copilotId //man!
    String copilotName //man!

    City origin //man!
    City destination //man!

    String airplaneId //man!
    String airplaneNickname //man!


    static constraints = {
        copilotId nullable: true //man!
        copilotName nullable: true //man!
    }
}
