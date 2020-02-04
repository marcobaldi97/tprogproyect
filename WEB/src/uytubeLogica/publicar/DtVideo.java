
package uytubeLogica.publicar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtVideo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtVideo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="categoria" type="{http://publicar.uytubeLogica/}dtCategoria" minOccurs="0"/&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="duracionSS" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="fechaPublicacion" type="{http://publicar.uytubeLogica/}dtFecha" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="privacidad" type="{http://publicar.uytubeLogica/}privacidad" minOccurs="0"/&gt;
 *         &lt;element name="propietario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="iDVideo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtVideo", propOrder = {
    "categoria",
    "descripcion",
    "duracionSS",
    "fechaPublicacion",
    "nombre",
    "privacidad",
    "propietario",
    "url",
    "idVideo"
})
public class DtVideo {

    protected DtCategoria categoria;
    protected String descripcion;
    protected int duracionSS;
    protected DtFecha fechaPublicacion;
    protected String nombre;
    @XmlSchemaType(name = "string")
    protected Privacidad privacidad;
    protected String propietario;
    protected String url;
    @XmlElement(name = "iDVideo")
    protected Integer idVideo;

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
     * Obtiene el valor de la propiedad duracionSS.
     * 
     */
    public int getDuracionSS() {
        return duracionSS;
    }

    /**
     * Define el valor de la propiedad duracionSS.
     * 
     */
    public void setDuracionSS(int value) {
        this.duracionSS = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPublicacion.
     * 
     * @return
     *     possible object is
     *     {@link DtFecha }
     *     
     */
    public DtFecha getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Define el valor de la propiedad fechaPublicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link DtFecha }
     *     
     */
    public void setFechaPublicacion(DtFecha value) {
        this.fechaPublicacion = value;
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
     * Obtiene el valor de la propiedad privacidad.
     * 
     * @return
     *     possible object is
     *     {@link Privacidad }
     *     
     */
    public Privacidad getPrivacidad() {
        return privacidad;
    }

    /**
     * Define el valor de la propiedad privacidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Privacidad }
     *     
     */
    public void setPrivacidad(Privacidad value) {
        this.privacidad = value;
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
     * Obtiene el valor de la propiedad url.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Define el valor de la propiedad url.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Obtiene el valor de la propiedad idVideo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDVideo() {
        return idVideo;
    }

    /**
     * Define el valor de la propiedad idVideo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDVideo(Integer value) {
        this.idVideo = value;
    }

}
