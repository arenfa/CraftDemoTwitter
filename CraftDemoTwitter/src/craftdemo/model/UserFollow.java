//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.21 at 03:47:55 PM PDT 
//



package craftdemo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserFollow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserFollow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Follow" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserFollow", propOrder = {
    "userId",
    "follow"
})
public class UserFollow {

    @XmlElement(name = "UserId")
    protected long userId;
    @XmlElement(name = "Follow", defaultValue = "false")
    protected boolean follow;

    /**
     * Gets the value of the userId property.
     * 
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(long value) {
        this.userId = value;
    }

    /**
     * Gets the value of the follow property.
     * 
     */
    public boolean isFollow() {
        return follow;
    }

    /**
     * Sets the value of the follow property.
     * 
     */
    public void setFollow(boolean value) {
        this.follow = value;
    }

}