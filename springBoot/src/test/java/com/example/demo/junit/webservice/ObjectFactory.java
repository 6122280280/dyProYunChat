
package com.example.demo.junit.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.demo.junit.webservice package. 
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

    private final static QName _GetY_QNAME = new QName("http://bean.demo.example.com/", "getY");
    private final static QName _GetYResponse_QNAME = new QName("http://bean.demo.example.com/", "getYResponse");
    private final static QName _SetX_QNAME = new QName("http://bean.demo.example.com/", "setX");
    private final static QName _SetYResponse_QNAME = new QName("http://bean.demo.example.com/", "setYResponse");
    private final static QName _GetX_QNAME = new QName("http://bean.demo.example.com/", "getX");
    private final static QName _SetY_QNAME = new QName("http://bean.demo.example.com/", "setY");
    private final static QName _GetXResponse_QNAME = new QName("http://bean.demo.example.com/", "getXResponse");
    private final static QName _SetXResponse_QNAME = new QName("http://bean.demo.example.com/", "setXResponse");
    private final static QName _Add_QNAME = new QName("http://bean.demo.example.com/", "add");
    private final static QName _AddResponse_QNAME = new QName("http://bean.demo.example.com/", "addResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.demo.junit.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Add }
     * 
     */
    public Add createAdd() {
        return new Add();
    }

    /**
     * Create an instance of {@link GetXResponse }
     * 
     */
    public GetXResponse createGetXResponse() {
        return new GetXResponse();
    }

    /**
     * Create an instance of {@link SetXResponse }
     * 
     */
    public SetXResponse createSetXResponse() {
        return new SetXResponse();
    }

    /**
     * Create an instance of {@link GetX }
     * 
     */
    public GetX createGetX() {
        return new GetX();
    }

    /**
     * Create an instance of {@link SetY }
     * 
     */
    public SetY createSetY() {
        return new SetY();
    }

    /**
     * Create an instance of {@link GetY }
     * 
     */
    public GetY createGetY() {
        return new GetY();
    }

    /**
     * Create an instance of {@link GetYResponse }
     * 
     */
    public GetYResponse createGetYResponse() {
        return new GetYResponse();
    }

    /**
     * Create an instance of {@link SetX }
     * 
     */
    public SetX createSetX() {
        return new SetX();
    }

    /**
     * Create an instance of {@link SetYResponse }
     * 
     */
    public SetYResponse createSetYResponse() {
        return new SetYResponse();
    }

    /**
     * Create an instance of {@link AddResponse }
     * 
     */
    public AddResponse createAddResponse() {
        return new AddResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetY }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.demo.example.com/", name = "getY")
    public JAXBElement<GetY> createGetY(GetY value) {
        return new JAXBElement<GetY>(_GetY_QNAME, GetY.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetYResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.demo.example.com/", name = "getYResponse")
    public JAXBElement<GetYResponse> createGetYResponse(GetYResponse value) {
        return new JAXBElement<GetYResponse>(_GetYResponse_QNAME, GetYResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.demo.example.com/", name = "setX")
    public JAXBElement<SetX> createSetX(SetX value) {
        return new JAXBElement<SetX>(_SetX_QNAME, SetX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetYResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.demo.example.com/", name = "setYResponse")
    public JAXBElement<SetYResponse> createSetYResponse(SetYResponse value) {
        return new JAXBElement<SetYResponse>(_SetYResponse_QNAME, SetYResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetX }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.demo.example.com/", name = "getX")
    public JAXBElement<GetX> createGetX(GetX value) {
        return new JAXBElement<GetX>(_GetX_QNAME, GetX.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetY }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.demo.example.com/", name = "setY")
    public JAXBElement<SetY> createSetY(SetY value) {
        return new JAXBElement<SetY>(_SetY_QNAME, SetY.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetXResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.demo.example.com/", name = "getXResponse")
    public JAXBElement<GetXResponse> createGetXResponse(GetXResponse value) {
        return new JAXBElement<GetXResponse>(_GetXResponse_QNAME, GetXResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetXResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.demo.example.com/", name = "setXResponse")
    public JAXBElement<SetXResponse> createSetXResponse(SetXResponse value) {
        return new JAXBElement<SetXResponse>(_SetXResponse_QNAME, SetXResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Add }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.demo.example.com/", name = "add")
    public JAXBElement<Add> createAdd(Add value) {
        return new JAXBElement<Add>(_Add_QNAME, Add.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bean.demo.example.com/", name = "addResponse")
    public JAXBElement<AddResponse> createAddResponse(AddResponse value) {
        return new JAXBElement<AddResponse>(_AddResponse_QNAME, AddResponse.class, null, value);
    }

}
