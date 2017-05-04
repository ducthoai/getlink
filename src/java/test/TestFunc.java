/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import com.butchjgo.VerifyUtils;
import java.security.*;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.codec.digest.*;
/**
 *
 * @author root
 */
public class TestFunc {
    public static void main(String[] args) {
        String s = "https://www.fshare.vn/file/7QTMCKKT63MOs";
        String en = Md5Crypt.apr1Crypt(s.getBytes());
        String en2 = Sha2Crypt.sha256Crypt(s.getBytes());
        
        System.out.println(DigestUtils.md5Hex(s));
    }
}
