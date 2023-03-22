package encryptPDF;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
 
class PdfEncryption {
    public static void main(String[] args)
        throws IOException
    {
    	String pathArquivo = args[0];
    	JOptionPane.showMessageDialog(null, pathArquivo,"alert" , JOptionPane.ERROR_MESSAGE);
		String senha = args[1];
		JOptionPane.showMessageDialog(null, senha,"alert" , JOptionPane.ERROR_MESSAGE);
		encriptar(pathArquivo, senha);
    }
	public static void encriptar(String pathArquivo, String senha) throws IOException {
		// step 1. Loading the pdf file
        File f = new File(pathArquivo);
        PDDocument pdd = PDDocument.load(f);
 
        // step 2.Creating instance of AccessPermission
        // class
        AccessPermission ap = new AccessPermission();
 
        // step 3. Creating instance of
        // StandardProtectionPolicy
        StandardProtectionPolicy stpp
            = new StandardProtectionPolicy(senha, senha, ap);
 
        // step 4. Setting the length of Encryption key
        stpp.setEncryptionKeyLength(128);
 
        // step 5. Setting the permission
        stpp.setPermissions(ap);
 
        // step 6. Protecting the PDF file
        pdd.protect(stpp);
 
        // step 7. Saving and closing the the PDF Document
        pdd.save(pathArquivo);
        pdd.close();
 
        System.out.println("PDF Encrypted successfully...");
    }
}
