package unillanos.foodtainer.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encriptador {

    private static final String ALGORITMO = "Blowfish";
    private static final String CLAVE_SECRETA = "claveSecreta123";

    private SecretKey clave;

    public Encriptador() {
        clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(), ALGORITMO);
    }

    public String encriptar(String texto) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cifrador = Cipher.getInstance(ALGORITMO);
        cifrador.init(Cipher.ENCRYPT_MODE, clave);
        byte[] textoEncriptado = cifrador.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(textoEncriptado);
    }

    public String desencriptar(String textoEncriptado) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cifrador = Cipher.getInstance(ALGORITMO);
        cifrador.init(Cipher.DECRYPT_MODE, clave);
        byte[] textoDesencriptado = cifrador.doFinal(Base64.getDecoder().decode(textoEncriptado));
        return new String(textoDesencriptado);
    }
}

