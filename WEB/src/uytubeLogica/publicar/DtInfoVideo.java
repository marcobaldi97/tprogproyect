
package uytubeLogica.publicar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtInfoVideo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtInfoVideo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="comentarios" type="{http://publicar.uytubeLogica/}dtComentario" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="infoVideo" type="{http://publicar.uytubeLogica/}dtVideo" minOccurs="0"/&gt;
 *         &lt;element name="usuariosGusta" type="{http://publicar.uytubeLogica/}dtUsuario" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usuariosNoGusta" type="{http://publicar.uytubeLogica/}dtUsuario" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtInfoVideo", propOrder = {
    "comentarios",
    "infoVideo",
    "usuariosGusta",
    "usuariosNoGusta"
})
public class DtInfoVideo {

    @XmlElement(nillable = true)
    protected List<DtComentario> comentarios;
    protected DtVideo infoVideo;
    @XmlElement(nillable = true)
    protected List<DtUsuario> usuariosGusta;
    @XmlElement(nillable = true)
    protected List<DtUsuario> usuariosNoGusta;

    /**
     * Gets the value of the comentarios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comentarios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComentarios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtComentario }
     * 
     * 
     */
    public List<DtComentario> getComentarios() {
        if (comentarios == null) {
            comentarios = new ArrayList<DtComentario>();
        }
        return this.comentarios;
    }

    /**
     * Obtiene el valor de la propiedad infoVideo.
     * 
     * @return
     *     possible object is
     *     {@link DtVideo }
     *     
     */
    public DtVideo getInfoVideo() {
        return infoVideo;
    }

    /**
     * Define el valor de la propiedad infoVideo.
     * 
     * @param value
     *     allowed object is
     *     {@link DtVideo }
     *     
     */
    public void setInfoVideo(DtVideo value) {
        this.infoVideo = value;
    }

    /**
     * Gets the value of the usuariosGusta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usuariosGusta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsuariosGusta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtUsuario }
     * 
     * 
     */
    public List<DtUsuario> getUsuariosGusta() {
        if (usuariosGusta == null) {
            usuariosGusta = new ArrayList<DtUsuario>();
        }
        return this.usuariosGusta;
    }

    /**
     * Gets the value of the usuariosNoGusta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usuariosNoGusta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsuariosNoGusta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtUsuario }
     * 
     * 
     */
    public List<DtUsuario> getUsuariosNoGusta() {
        if (usuariosNoGusta == null) {
            usuariosNoGusta = new ArrayList<DtUsuario>();
        }
        return this.usuariosNoGusta;
    }

}
