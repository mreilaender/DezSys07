//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.12.12 um 02:05:53 PM CET 
//


package at.geyerritter.dezsys07.soa;

import at.geyerritter.dezsys07.DataRecord;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataRecord" type="{http://at/geyerritter/dezsys07/soa}dataRecord"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dataRecord"
})
@XmlRootElement(name = "getDataRecordResponse")
public class GetDataRecordResponse {

    @XmlElement(required = true)
    protected DataRecord dataRecord;

    /**
     * Ruft den Wert der dataRecord-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DataRecord }
     *     
     */
    public DataRecord getDataRecord() {
        return dataRecord;
    }

    /**
     * Legt den Wert der dataRecord-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DataRecord }
     *     
     */
    public void setDataRecord(DataRecord value) {
        this.dataRecord = value;
    }

}
