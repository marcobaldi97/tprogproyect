
package uytubeLogica.publicar;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoLista.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoLista"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PORDEFECTO"/&gt;
 *     &lt;enumeration value="PARTICULAR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "tipoLista")
@XmlEnum
public enum TipoLista {

    PORDEFECTO,
    PARTICULAR;

    public String value() {
        return name();
    }

    public static TipoLista fromValue(String v) {
        return valueOf(v);
    }

}
