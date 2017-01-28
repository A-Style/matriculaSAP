/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.secundario;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author GF
 */
public class Encriptado {
      
        
    public String Encriptado_md5(String des){
    String md5=null;
    String desencriptado=DigestUtils.md5Hex(des);    
    md5=desencriptado;
    return md5;
    }
    
}
