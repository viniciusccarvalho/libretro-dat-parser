//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.11.02 at 09:01:03 AM EDT 
//


package com.logiqx.dat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "romcenter")
public class Romcenter {

    @XmlAttribute(name = "plugin")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String plugin;
    @XmlAttribute(name = "rommode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String rommode;
    @XmlAttribute(name = "biosmode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String biosmode;
    @XmlAttribute(name = "samplemode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String samplemode;
    @XmlAttribute(name = "lockrommode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String lockrommode;
    @XmlAttribute(name = "lockbiosmode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String lockbiosmode;
    @XmlAttribute(name = "locksamplemode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String locksamplemode;

    /**
     * Gets the value of the plugin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlugin() {
        return plugin;
    }

    /**
     * Sets the value of the plugin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlugin(String value) {
        this.plugin = value;
    }

    /**
     * Gets the value of the rommode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRommode() {
        if (rommode == null) {
            return "split";
        } else {
            return rommode;
        }
    }

    /**
     * Sets the value of the rommode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRommode(String value) {
        this.rommode = value;
    }

    /**
     * Gets the value of the biosmode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBiosmode() {
        if (biosmode == null) {
            return "split";
        } else {
            return biosmode;
        }
    }

    /**
     * Sets the value of the biosmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBiosmode(String value) {
        this.biosmode = value;
    }

    /**
     * Gets the value of the samplemode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSamplemode() {
        if (samplemode == null) {
            return "merged";
        } else {
            return samplemode;
        }
    }

    /**
     * Sets the value of the samplemode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSamplemode(String value) {
        this.samplemode = value;
    }

    /**
     * Gets the value of the lockrommode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLockrommode() {
        if (lockrommode == null) {
            return "no";
        } else {
            return lockrommode;
        }
    }

    /**
     * Sets the value of the lockrommode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLockrommode(String value) {
        this.lockrommode = value;
    }

    /**
     * Gets the value of the lockbiosmode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLockbiosmode() {
        if (lockbiosmode == null) {
            return "no";
        } else {
            return lockbiosmode;
        }
    }

    /**
     * Sets the value of the lockbiosmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLockbiosmode(String value) {
        this.lockbiosmode = value;
    }

    /**
     * Gets the value of the locksamplemode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocksamplemode() {
        if (locksamplemode == null) {
            return "no";
        } else {
            return locksamplemode;
        }
    }

    /**
     * Sets the value of the locksamplemode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocksamplemode(String value) {
        this.locksamplemode = value;
    }

}
