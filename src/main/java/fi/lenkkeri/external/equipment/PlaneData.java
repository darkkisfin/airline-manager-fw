
package fi.lenkkeri.external.equipment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for planeData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="planeData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="serialNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nickname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="manufactured" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="acquired" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="lastMaintenance" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="crewRequired" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="seatCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="fuelCapacity" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="nominalRange" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *         &lt;element name="maximumRange" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "planeData", propOrder = {
    "serialNumber",
    "nickname",
    "type",
    "manufactured",
    "acquired",
    "lastMaintenance",
    "length",
    "width",
    "weight",
    "crewRequired",
    "seatCount",
    "fuelCapacity",
    "nominalRange",
    "maximumRange"
})
public class PlaneData {

    protected String serialNumber;
    protected String nickname;
    protected String type;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar manufactured;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar acquired;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastMaintenance;
    protected Double length;
    protected Double width;
    protected Double weight;
    protected Long crewRequired;
    protected Long seatCount;
    protected Double fuelCapacity;
    protected Double nominalRange;
    protected Double maximumRange;

    /**
     * Gets the value of the serialNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNumber(String value) {
        this.serialNumber = value;
    }

    /**
     * Gets the value of the nickname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the value of the nickname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickname(String value) {
        this.nickname = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the manufactured property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getManufactured() {
        return manufactured;
    }

    /**
     * Sets the value of the manufactured property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setManufactured(XMLGregorianCalendar value) {
        this.manufactured = value;
    }

    /**
     * Gets the value of the acquired property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAcquired() {
        return acquired;
    }

    /**
     * Sets the value of the acquired property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAcquired(XMLGregorianCalendar value) {
        this.acquired = value;
    }

    /**
     * Gets the value of the lastMaintenance property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastMaintenance() {
        return lastMaintenance;
    }

    /**
     * Sets the value of the lastMaintenance property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastMaintenance(XMLGregorianCalendar value) {
        this.lastMaintenance = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLength(Double value) {
        this.length = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWidth(Double value) {
        this.width = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWeight(Double value) {
        this.weight = value;
    }

    /**
     * Gets the value of the crewRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCrewRequired() {
        return crewRequired;
    }

    /**
     * Sets the value of the crewRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCrewRequired(Long value) {
        this.crewRequired = value;
    }

    /**
     * Gets the value of the seatCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSeatCount() {
        return seatCount;
    }

    /**
     * Sets the value of the seatCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSeatCount(Long value) {
        this.seatCount = value;
    }

    /**
     * Gets the value of the fuelCapacity property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFuelCapacity() {
        return fuelCapacity;
    }

    /**
     * Sets the value of the fuelCapacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFuelCapacity(Double value) {
        this.fuelCapacity = value;
    }

    /**
     * Gets the value of the nominalRange property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getNominalRange() {
        return nominalRange;
    }

    /**
     * Sets the value of the nominalRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setNominalRange(Double value) {
        this.nominalRange = value;
    }

    /**
     * Gets the value of the maximumRange property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMaximumRange() {
        return maximumRange;
    }

    /**
     * Sets the value of the maximumRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaximumRange(Double value) {
        this.maximumRange = value;
    }

}
