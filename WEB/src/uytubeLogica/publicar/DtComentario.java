
package uytubeLogica.publicar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtComentario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtComentario"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="esPadre" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="fecha" type="{http://publicar.uytubeLogica/}dtFecha" minOccurs="0"/&gt;
 *         &lt;element name="fotoDuenio" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="idComentario" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="nickUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="respuestas" type="{http://publicar.uytubeLogica/}dtComentario" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="texto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtComentario", propOrder = {
    "esPadre",
    "fecha",
    "fotoDuenio",
    "idComentario",
    "nickUsuario",
    "respuestas",
    "texto"
})
public class DtComentario {

    protected boolean esPadre;
    protected DtFecha fecha;
    protected byte[] fotoDuenio;
    protected Integer idComentario;
    protected String nickUsuario;
    @XmlElement(nillable = true)
    protected List<DtComentario> respuestas;
    protected String texto;

    /**
     * Obtiene el valor de la propiedad esPadre.
     * 
     */
    public boolean isEsPadre() {
        return esPadre;
    }

    /**
     * Define el valor de la propiedad esPadre.
     * 
     */
    public void setEsPadre(boolean value) {
        this.esPadre = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link DtFecha }
     *     
     */
    public DtFecha getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link DtFecha }
     *     
     */
    public void setFecha(DtFecha value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad fotoDuenio.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFotoDuenio() {
        return fotoDuenio;
    }

    /**
     * Define el valor de la propiedad fotoDuenio.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFotoDuenio(byte[] value) {
        this.fotoDuenio = value;
    }

    /**
     * Obtiene el valor de la propiedad idComentario.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdComentario() {
        return idComentario;
    }

    /**
     * Define el valor de la propiedad idComentario.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdComentario(Integer value) {
        this.idComentario = value;
    }

    /**
     * Obtiene el valor de la propiedad nickUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickUsuario() {
        return nickUsuario;
    }

    /**
     * Define el valor de la propiedad nickUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickUsuario(String value) {
        this.nickUsuario = value;
    }

    /**
     * Gets the value of the respuestas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the respuestas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRespuestas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtComentario }
     * 
     * 
     */
    public List<DtComentario> getRespuestas() {
        if (respuestas == null) {
            respuestas = new ArrayList<DtComentario>();
        }
        return this.respuestas;
    }

    /**
     * Obtiene el valor de la propiedad texto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Define el valor de la propiedad texto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTexto(String value) {
        this.texto = value;
    }

}
