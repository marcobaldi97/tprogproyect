
package uytubeLogica.publicar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para dtCanal complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtCanal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="categoria" type="{http://publicar.uytubeLogica/}dtCategoria" minOccurs="0"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="privado" type="{http://publicar.uytubeLogica/}privacidad" minOccurs="0"/&gt;
 *         &lt;element name="propietario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "dtCanal", propOrder = {
    "categoria",
    "descripcion",
    "nombre",
    "privado",
    "propietario",
    "ultimoVideo"
})
public class DtCanal {

    protected DtCategoria categoria;
    protected String descripcion;
    protected String nombre;
    @XmlSchemaType(name = "string")
    protected Privacidad privado;
    protected String propietario;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ultimoVideo;

    /**
     * Obtiene el valor de la propiedad categoria.
     * 
     * @return
     *     possible object is
     *     {@link DtCategoria }
     *     
     */
    public DtCategoria getCategoria() {
        return categoria;
    }

    /**
     * Define el valor de la propiedad categoria.
     * 
     * @param value
     *     allowed object is
     *     {@link DtCategoria }
     *     
     */
    public void setCategoria(DtCategoria value) {
        this.categoria = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
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
