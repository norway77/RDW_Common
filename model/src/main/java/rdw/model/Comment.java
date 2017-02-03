package rdw.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="context" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="itemPosition" type="{}NullableUInt" />
 *       &lt;attribute name="date" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
public class Comment {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "context", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String context;
    @XmlAttribute(name = "itemPosition")
    protected String itemPosition;
    @XmlAttribute(name = "date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;

    /**
     * Gets the value of the content property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the context property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContext() {
        return context;
    }

    /**
     * Sets the value of the context property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContext(String value) {
        this.context = value;
    }

    /**
     * Gets the value of the itemPosition property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getItemPosition() {
        return itemPosition;
    }

    /**
     * Sets the value of the itemPosition property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setItemPosition(String value) {
        this.itemPosition = value;
    }

    /**
     * Gets the value of the date property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

}
