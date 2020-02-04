
package uytubeLogica.publicar;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para privacidad.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="privacidad"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PRIVADO"/&gt;
 *     &lt;enumeration value="PUBLICO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "privacidad")
@XmlEnum
public enum Privacidad {

    PRIVADO,
    PUBLICO;

    public String value() {
        return name();
    }

    public static Privacidad fromValue(String v) {
        return valueOf(v);
    }

}
