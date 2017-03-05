package airline.manager.fw

import fi.lenkkeri.airline.grails.domain.City

class BootStrap {

    def init = { servletContext ->
        City ekaCity = [cityName:"A-Kaupunki", countryName:"A-Maa", airfieldName:"A-Lentokenttä 1"]
        ekaCity.save(flush:true)

        City tokaCity = [cityName:"B-Kaupunki", countryName:"A-Maa", airfieldName:"A-Lentokenttä 2"]
        tokaCity.save(flush:true)

        City kolmasCity = [cityName:"C-Kaupunki", countryName:"B-Maa", airfieldName:"B-Lentokenttä 1"]
        kolmasCity.save(flush:true)

        City neljasCity = [cityName:"D-Kaupunki", countryName:"C-Maa", airfieldName:"C-Lentokenttä 1"]
        neljasCity.save(flush:true)
    }
    def destroy = {
    }
}
