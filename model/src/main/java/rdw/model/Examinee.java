package rdw.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="ExamineeAttribute">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="context" use="required" type="{}Context" />
 *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="contextDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ExamineeRelationship">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="context" use="required" type="{}Context" />
 *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="entityKey" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
 *                 &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *                 &lt;attribute name="contextDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *       &lt;attribute name="key" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "examineeAttributeOrExamineeRelationship"
})
public class Examinee {

    @XmlElements({
        @XmlElement(name = "ExamineeAttribute", type = ExamineeAttribute.class),
        @XmlElement(name = "ExamineeRelationship", type = ExamineeRelationship.class)
    })
    protected List<Object> examineeAttributeOrExamineeRelationship;
    @XmlAttribute(name = "key")
    protected Long key;

    /**
     * Gets the value of the examineeAttributeOrExamineeRelationship property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the examineeAttributeOrExamineeRelationship property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExamineeAttributeOrExamineeRelationship().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExamineeAttribute }
     * {@link ExamineeRelationship }
     *
     *
     */
    public List<Object> getExamineeAttributeOrExamineeRelationship() {
        if (examineeAttributeOrExamineeRelationship == null) {
            examineeAttributeOrExamineeRelationship = new ArrayList<Object>();
        }
        return this.examineeAttributeOrExamineeRelationship;
    }

    /**
     * Gets the value of the key property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setKey(Long value) {
        this.key = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="context" use="required" type="{}Context" />
     *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="contextDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ExamineeAttribute {

        @XmlAttribute(name = "context", required = true)
        protected Context context;
        @XmlAttribute(name = "name", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String name;
        @XmlAttribute(name = "value")
        @XmlSchemaType(name = "anySimpleType")
        protected String value;
        @XmlAttribute(name = "contextDate", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar contextDate;

        /**
         * Gets the value of the context property.
         *
         * @return
         *     possible object is
         *     {@link Context }
         *
         */
        public Context getContext() {
            return context;
        }

        /**
         * Sets the value of the context property.
         *
         * @param value
         *     allowed object is
         *     {@link Context }
         *
         */
        public void setContext(Context value) {
            this.context = value;
        }

        /**
         * Gets the value of the name property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the value property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the contextDate property.
         *
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public XMLGregorianCalendar getContextDate() {
            return contextDate;
        }

        /**
         * Sets the value of the contextDate property.
         *
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public void setContextDate(XMLGregorianCalendar value) {
            this.contextDate = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="context" use="required" type="{}Context" />
     *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="entityKey" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
     *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *       &lt;attribute name="contextDate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ExamineeRelationship {

        @XmlAttribute(name = "context", required = true)
        protected Context context;
        @XmlAttribute(name = "name", required = true)
        @XmlSchemaType(name = "anySimpleType")
        protected String name;
        @XmlAttribute(name = "entityKey")
        @XmlSchemaType(name = "unsignedLong")
        protected BigInteger entityKey;
        @XmlAttribute(name = "value")
        @XmlSchemaType(name = "anySimpleType")
        protected String value;
        @XmlAttribute(name = "contextDate", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar contextDate;

        /**
         * Gets the value of the context property.
         *
         * @return
         *     possible object is
         *     {@link Context }
         *
         */
        public Context getContext() {
            return context;
        }

        /**
         * Sets the value of the context property.
         *
         * @param value
         *     allowed object is
         *     {@link Context }
         *
         */
        public void setContext(Context value) {
            this.context = value;
        }

        /**
         * Gets the value of the name property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the entityKey property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getEntityKey() {
            return entityKey;
        }

        /**
         * Sets the value of the entityKey property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setEntityKey(BigInteger value) {
            this.entityKey = value;
        }

        /**
         * Gets the value of the value property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the contextDate property.
         *
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public XMLGregorianCalendar getContextDate() {
            return contextDate;
        }

        /**
         * Sets the value of the contextDate property.
         *
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public void setContextDate(XMLGregorianCalendar value) {
            this.contextDate = value;
        }

    }

    // ************************************************************************
    // ************************************************************************
    // ************************************************************************
    // ************************************************************************
    // These setters support CSV parsing

    public void setStateAbbreviation(final String value) {
        setRelationship("StateAbbreviation", value);
    }

    public void setDistrictId(final String value) {
        setRelationship("DistrictId", value);
    }

    public void setDistrictName(final String value) {
        setRelationship("DistrictName", value);
    }

    public void setSchoolId(final String value) {
        setRelationship("SchoolId", value);
    }

    public void setSchoolName(final String value) {
        setRelationship("SchoolName", value);
    }

    public void setStudentIdentifier(final String value) {
        setAttribute("StudentIdentifier", value);
    }

    public void setAlternateSSID(final String value) {
        setAttribute("AlternateSSID", value);
    }

    public void setFirstName(final String value) {
        setAttribute("FirstName", value);
    }

    public void setMiddleName(final String value) {
        setAttribute("MiddleName", value);
    }

    public void setLastOrSurname(final String value) {
        setAttribute("LastOrSurname", value);
    }

    public void setSex(final String value) {
        setAttribute("Sex", value);
    }

    public void setBirthdate(final String value) {
        setAttribute("Birthdate", value);
    }

    public void setGradeLevelWhenAssessed(final String value) {
        setAttribute("GradeLevelWhenAssessed", value);
    }

    public void setHispanicOrLatinoEthnicity(final String value) {
        setAttribute("HispanicOrLatinoEthnicity", value);
    }

    public void setAmericanIndianOrAlaskaNative(final String value) {
        setAttribute("AmericanIndianOrAlaskaNative", value);
    }

    public void setAsian(final String value) {
        setAttribute("Asian", value);
    }

    public void setBlackOrAfricanAmerican(final String value) {
        setAttribute("BlackOrAfricanAmerican", value);
    }

    public void setNativeHawaiianOrOtherPacificIslander(final String value) {
        setAttribute("NativeHawaiianOrOtherPacificIslander", value);
    }

    public void setWhite(final String value) {
        setAttribute("White", value);
    }

    public void setDemographicRaceTwoOrMoreRaces(final String value) {
        setAttribute("DemographicRaceTwoOrMoreRaces", value);
    }

    public void setIdeaIndicator(final String value) {
        setAttribute("IDEAIndicator", value);
    }

    public void setLepStatus(final String value) {
        setAttribute("LEPStatus", value);
    }

    public void setSection504Status(final String value) {
        setAttribute("Section504Status", value);
    }

    public void setEconomicDisadvantageStatus(final String value) {
        setAttribute("EconomicDisadvantageStatus", value);
    }

    public void setMigrantStatus(final String value) {
        setAttribute("MigrantStatus", value);
    }

    private void setRelationship(final String name, final String value) {
        if (value == null || value.isEmpty()) return;

        final ExamineeRelationship relationship = findOrCreateRelationship(name);
        relationship.setContext(Context.FINAL);
        relationship.setValue(value);
        // TODO - context date, entity key
    }

    private void setAttribute(final String name, final String value) {
        if (value == null || value.isEmpty()) return;

        final ExamineeAttribute attribute = findOrCreateAttribute(name);
        attribute.setContext(Context.FINAL);
        attribute.setValue(value);
        // TODO - context date
    }

    public void setStudentGroupName(final String value) {
        if (value == null || value.isEmpty()) return;

        // this one is different since it can have multiple occurrences
        final ExamineeAttribute attribute = new ExamineeAttribute();
        attribute.setName("StudentGroupName");
        attribute.setContext(Context.FINAL);
        attribute.setValue(value);
        // TODO - context date
    }

    private ExamineeRelationship findOrCreateRelationship(final String name) {
        final List<Object> objects = getExamineeAttributeOrExamineeRelationship();
        for (final Object object : objects) {
            if (object instanceof ExamineeRelationship && name.equalsIgnoreCase(((ExamineeRelationship)object).getName())) {
                return (ExamineeRelationship) object;
            }
        }
        final ExamineeRelationship relationship = new ExamineeRelationship();
        relationship.setName(name);
        objects.add(relationship);
        return relationship;
    }

    private ExamineeAttribute findOrCreateAttribute(final String name) {
        final List<Object> objects = getExamineeAttributeOrExamineeRelationship();
        for (final Object object : objects) {
            if (object instanceof ExamineeAttribute && name.equalsIgnoreCase(((ExamineeAttribute)object).getName())) {
                return (ExamineeAttribute) object;
            }
        }
        final ExamineeAttribute attribute = new ExamineeAttribute();
        attribute.setName(name);
        objects.add(attribute);
        return attribute;
    }

    // ************************************************************************
    // ************************************************************************
    // ************************************************************************
    // ************************************************************************

}
