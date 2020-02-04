
package uytubeLogica.publicar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtVideoHistorial complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtVideoHistorial"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantidadVisita" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ultimaVisita" type="{http://publicar.uytubeLogica/}dtFecha" minOccurs="0"/&gt;
 *         &lt;element name="video" type="{http://publicar.uytubeLogica/}dtVideo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtVideoHistorial", propOrder = {
    "cantidadVisita",
    "ultimaVisita",
    "video"
})
public class DtVideoHistorial {

    protected Integer cantidadVisita;
	protected DtFecha ultimaVisita;
    protected DtVideo video;

    /**
     * Obtiene el valor de la propiedad cantidadVisita.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantidadVisita() {
        return cantidadVisita;
    }

	/**
     * Define el valor de la propiedad cantidadVisita.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantidadVisita(Integer value) {
        this.cantidadVisita = value;
    }

	/**
     * Obtiene el valor de la propiedad ultimaVisita.
     * 
     * @return
     *     possible object is
     *     {@link DtFecha }
     *     
     */
    public DtFecha getUltimaVisita() {
        return ultimaVisita;
    }

    /**
     * Define el valor de la propiedad ultimaVisita.
     * 
     * @param value
     *     allowed object is
     *     {@link DtFecha }
     *     
     */
    public void setUltimaVisita(DtFecha value) {
        this.ultimaVisita = value;
    }

    /**
     * Obtiene el valor de la propiedad video.
     * 
     * @return
     *     possible object is
     *     {@link DtVideo }
     *     
     */
    public DtVideo getVideo() {
        return video;
    }

    /**
     * Define el valor de la propiedad video.
     * 
     * @param value
     *     allowed object is
     *     {@link DtVideo }
     *     
     */
    public void setVideo(DtVideo value) {
        this.video = value;
    }

}
