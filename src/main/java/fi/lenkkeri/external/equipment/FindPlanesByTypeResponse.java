
package fi.lenkkeri.external.equipment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for findPlanesByTypeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="findPlanesByTypeResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="planeData" type="{http://equipment.external.lenkkeri.fi/}planeData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findPlanesByTypeResponse", propOrder = {
    "planeData"
})
public class FindPlanesByTypeResponse {

    protected List<PlaneData> planeData;

    /**
     * Gets the value of the planeData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planeData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlaneData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlaneData }
     * 
     * 
     */
    public List<PlaneData> getPlaneData() {
        if (planeData == null) {
            planeData = new ArrayList<PlaneData>();
        }
        return this.planeData;
    }

}
