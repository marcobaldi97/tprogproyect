
package uytubeLogica.publicar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dtListaReproduccion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtListaReproduccion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="categoriasLDR" type="{http://publicar.uytubeLogica/}dtCategoria" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="privado" type="{http://publicar.uytubeLogica/}privacidad" minOccurs="0"/&gt;
 *         &lt;element name="propietario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoL" type="{http://publicar.uytubeLogica/}tipoLista" minOccurs="0"/&gt;
 *         &lt;element name="ultimoVideo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtListaReproduccion", propOrder = {
    "categoriasLDR",
    "nombre",
    "privado",
    "propietario",
    "tipoL",
    "ultimoVideo"
})
public class DtListaReproduccion {

    @XmlElement(nillable = true)
    protected List<DtCategoria> categoriasLDR;
    protected String nombre;
    @XmlSchemaType(name = "string")
    protected Privacidad privado;
    protected String propietario;
    @XmlSchemaType(name = "string")
    protected TipoLista tipoL;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ultimoVideo;

    /**
     * Gets the value of the categoriasLDR property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categoriasLDR property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategoriasLDR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtCategoria }
     * 
     * 
     */
    public List<DtCategoria> getCategoriasLDR() {
        if (categoriasLDR == null) {
            categoriasLDR = new ArrayList<DtCategoria>();
        }
        return this.categoriasLDR;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad privado.
     * 
     * @return
     *     possible object is
     *     {@link Privacidad }
     *     
     */
    public Privacidad getPrivado() {
        return privado;
    }

    /**
     * Define el valor de la propiedad privado.
     * 
     * @param value
     *     allowed object is
     *     {@link Privacidad }
     *     
     */
    public void setPrivado(Privacidad value) {
        this.privado = value;
    }

    /**
     * Obtiene el valor de la propiedad propietario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * Define el valor de la propiedad propietario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropietario(String value) {
        this.propietario = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoL.
     * 
     * @return
     *     possible object is
     *     {@link TipoLista }
     *     
     */
    public TipoLista getTipoL() {
        return tipoL;
    }

    /**
     * Define el valor de la propiedad tipoL.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoLista }
     *     
     */
    public void setTipoL(TipoLista value) {
        this.tipoL = value;
    }

    /**
     * Obtiene el valor de la propiedad ultimoVideo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUltimoVideo() {
        return ultimoVideo;
    }

    /**
     * Define el valor de la propiedad ultimoVideo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUltimoVideo(XMLGregorianCalendar value) {
        this.ultimoVideo = value;
    }

}
