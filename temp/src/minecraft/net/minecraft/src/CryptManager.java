// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.*;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.*;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.io.CipherInputStream;
import org.bouncycastle.crypto.io.CipherOutputStream;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class CryptManager
{

    public static final Charset field_75898_a = Charset.forName("ISO_8859_1");

    public static SecretKey func_75890_a()
    {
        CipherKeyGenerator cipherkeygenerator = new CipherKeyGenerator();
        cipherkeygenerator.init(new KeyGenerationParameters(new SecureRandom(), 128));
        return new SecretKeySpec(cipherkeygenerator.generateKey(), "AES");
    }

    public static KeyPair func_75891_b()
    {
        try
        {
            KeyPairGenerator keypairgenerator = KeyPairGenerator.getInstance("RSA");
            keypairgenerator.initialize(1024);
            return keypairgenerator.generateKeyPair();
        }
        catch(NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
        }
        System.err.println("Key pair generation failed!");
        return null;
    }

    public static byte[] func_75895_a(String p_75895_0_, PublicKey p_75895_1_, SecretKey p_75895_2_)
    {
        try
        {
            return func_75893_a("SHA-1", new byte[][] {
                p_75895_0_.getBytes("ISO_8859_1"), p_75895_2_.getEncoded(), p_75895_1_.getEncoded()
            });
        }
        catch(UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
        }
        return null;
    }

    private static byte[] func_75893_a(String p_75893_0_, byte p_75893_1_[][])
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance(p_75893_0_);
            byte abyte0[][] = p_75893_1_;
            int i = abyte0.length;
            for(int j = 0; j < i; j++)
            {
                byte abyte1[] = abyte0[j];
                messagedigest.update(abyte1);
            }

            return messagedigest.digest();
        }
        catch(NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
        }
        return null;
    }

    public static PublicKey func_75896_a(byte p_75896_0_[])
    {
        try
        {
            X509EncodedKeySpec x509encodedkeyspec = new X509EncodedKeySpec(p_75896_0_);
            KeyFactory keyfactory = KeyFactory.getInstance("RSA");
            return keyfactory.generatePublic(x509encodedkeyspec);
        }
        catch(NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
        }
        catch(InvalidKeySpecException invalidkeyspecexception)
        {
            invalidkeyspecexception.printStackTrace();
        }
        System.err.println("Public key reconstitute failed!");
        return null;
    }

    public static SecretKey func_75887_a(PrivateKey p_75887_0_, byte p_75887_1_[])
    {
        return new SecretKeySpec(func_75889_b(p_75887_0_, p_75887_1_), "AES");
    }

    public static byte[] func_75894_a(Key p_75894_0_, byte p_75894_1_[])
    {
        return func_75885_a(1, p_75894_0_, p_75894_1_);
    }

    public static byte[] func_75889_b(Key p_75889_0_, byte p_75889_1_[])
    {
        return func_75885_a(2, p_75889_0_, p_75889_1_);
    }

    private static byte[] func_75885_a(int p_75885_0_, Key p_75885_1_, byte p_75885_2_[])
    {
        try
        {
            return func_75886_a(p_75885_0_, p_75885_1_.getAlgorithm(), p_75885_1_).doFinal(p_75885_2_);
        }
        catch(IllegalBlockSizeException illegalblocksizeexception)
        {
            illegalblocksizeexception.printStackTrace();
        }
        catch(BadPaddingException badpaddingexception)
        {
            badpaddingexception.printStackTrace();
        }
        System.err.println("Cipher data failed!");
        return null;
    }

    private static Cipher func_75886_a(int p_75886_0_, String p_75886_1_, Key p_75886_2_)
    {
        try
        {
            Cipher cipher = Cipher.getInstance(p_75886_1_);
            cipher.init(p_75886_0_, p_75886_2_);
            return cipher;
        }
        catch(InvalidKeyException invalidkeyexception)
        {
            invalidkeyexception.printStackTrace();
        }
        catch(NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
        }
        catch(NoSuchPaddingException nosuchpaddingexception)
        {
            nosuchpaddingexception.printStackTrace();
        }
        System.err.println("Cipher creation failed!");
        return null;
    }

    private static BufferedBlockCipher func_75892_a(boolean p_75892_0_, Key p_75892_1_)
    {
        BufferedBlockCipher bufferedblockcipher = new BufferedBlockCipher(new CFBBlockCipher(new AESFastEngine(), 8));
        bufferedblockcipher.init(p_75892_0_, new ParametersWithIV(new KeyParameter(p_75892_1_.getEncoded()), p_75892_1_.getEncoded(), 0, 16));
        return bufferedblockcipher;
    }

    public static OutputStream func_75897_a(SecretKey p_75897_0_, OutputStream p_75897_1_)
    {
        return new CipherOutputStream(p_75897_1_, func_75892_a(true, p_75897_0_));
    }

    public static InputStream func_75888_a(SecretKey p_75888_0_, InputStream p_75888_1_)
    {
        return new CipherInputStream(p_75888_1_, func_75892_a(false, p_75888_0_));
    }

    static 
    {
        Security.addProvider(new BouncyCastleProvider());
    }
}
