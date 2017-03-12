
package fi.lenkkeri.external.equipment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fi.lenkkeri.external.equipment package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindPlaneBySN_QNAME = new QName("http://equipment.external.lenkkeri.fi/", "findPlaneBySN");
    private final static QName _FindPlaneBySNResponse_QNAME = new QName("http://equipment.external.lenkkeri.fi/", "findPlaneBySNResponse");
    private final static QName _FindPlanesByType_QNAME = new QName("http://equipment.external.lenkkeri.fi/", "findPlanesByType");
    private final static QName _FindPlanesByTypeResponse_QNAME = new QName("http://equipment.external.lenkkeri.fi/", "findPlanesByTypeResponse");
    private final static QName _ListAllPlanes_QNAME = new QName("http://equipment.external.lenkkeri.fi/", "listAllPlanes");
    private final static QName _ListAllPlanesResponse_QNAME = new QName("http://equipment.external.lenkkeri.fi/", "listAllPlanesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fi.lenkkeri.external.equipment
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindPlaneBySN }
     * 
     */
    public FindPlaneBySN createFindPlaneBySN() {
        return new FindPlaneBySN();
    }

    /**
     * Create an instance of {@link FindPlaneBySNResponse }
     * 
     */
    public FindPlaneBySNResponse createFindPlaneBySNResponse() {
        return new FindPlaneBySNResponse();
    }

    /**
     * Create an instance of {@link FindPlanesByType }
     * 
     */
    public FindPlanesByType createFindPlanesByType() {
        return new FindPlanesByType();
    }

    /**
     * Create an instance of {@link FindPlanesByTypeResponse }
     * 
     */
    public FindPlanesByTypeResponse createFindPlanesByTypeResponse() {
        return new FindPlanesByTypeResponse();
    }

    /**
     * Create an instance of {@link ListAllPlanes }
     * 
     */
    public ListAllPlanes createListAllPlanes() {
        return new ListAllPlanes();
    }

    /**
     * Create an instance of {@link ListAllPlanesResponse }
     * 
     */
    public ListAllPlanesResponse createListAllPlanesResponse() {
        return new ListAllPlanesResponse();
    }

    /**
     * Create an instance of {@link PlaneData }
     * 
     */
    public PlaneData createPlaneData() {
        return new PlaneData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPlaneBySN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://equipment.external.lenkkeri.fi/", name = "findPlaneBySN")
    public JAXBElement<FindPlaneBySN> createFindPlaneBySN(FindPlaneBySN value) {
        return new JAXBElement<FindPlaneBySN>(_FindPlaneBySN_QNAME, FindPlaneBySN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPlaneBySNResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://equipment.external.lenkkeri.fi/", name = "findPlaneBySNResponse")
    public JAXBElement<FindPlaneBySNResponse> createFindPlaneBySNResponse(FindPlaneBySNResponse value) {
        return new JAXBElement<FindPlaneBySNResponse>(_FindPlaneBySNResponse_QNAME, FindPlaneBySNResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPlanesByType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://equipment.external.lenkkeri.fi/", name = "findPlanesByType")
    public JAXBElement<FindPlanesByType> createFindPlanesByType(FindPlanesByType value) {
        return new JAXBElement<FindPlanesByType>(_FindPlanesByType_QNAME, FindPlanesByType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindPlanesByTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://equipment.external.lenkkeri.fi/", name = "findPlanesByTypeResponse")
    public JAXBElement<FindPlanesByTypeResponse> createFindPlanesByTypeResponse(FindPlanesByTypeResponse value) {
        return new JAXBElement<FindPlanesByTypeResponse>(_FindPlanesByTypeResponse_QNAME, FindPlanesByTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllPlanes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://equipment.external.lenkkeri.fi/", name = "listAllPlanes")
    public JAXBElement<ListAllPlanes> createListAllPlanes(ListAllPlanes value) {
        return new JAXBElement<ListAllPlanes>(_ListAllPlanes_QNAME, ListAllPlanes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAllPlanesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://equipment.external.lenkkeri.fi/", name = "listAllPlanesResponse")
    public JAXBElement<ListAllPlanesResponse> createListAllPlanesResponse(ListAllPlanesResponse value) {
        return new JAXBElement<ListAllPlanesResponse>(_ListAllPlanesResponse_QNAME, ListAllPlanesResponse.class, null, value);
    }

}
