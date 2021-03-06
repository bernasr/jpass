package jpass.util;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import jpass.util.ClipboardUtils.EmptyClipboardContent;

public class ClipboardUtilsTest {
	
	
	/**
	 * setClipboardContent
	 * 
	 * input string 
	 * 
	 * null | vazia | caracteres válidos | caracteres inválidos
	 * 
	 */
	@Test
	public void shouldHandleNullString() {
		String testString = null;
		Toolkit.getDefaultToolkit();
		try {
			ClipboardUtils.setClipboardContent(testString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).isDataFlavorSupported(DataFlavor.stringFlavor));

	}
	
	@Test
	public void shouldHandleEmptyString() {
		String testString = "";
		Toolkit.getDefaultToolkit();
		try {
			ClipboardUtils.setClipboardContent(testString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).isDataFlavorSupported(DataFlavor.stringFlavor));

	}
	
	@Test
	public void shouldHandleNonEmpty() {
		String testString = "esta string devia funcionar";
		Toolkit.getDefaultToolkit();
		try {
			ClipboardUtils.setClipboardContent(testString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Assert.assertEquals(Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor), testString);
		} catch (HeadlessException | UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}
	
	
	/**
	 * clear clipboard content
	 * ha coisas no clipboard | nao ha coisas no clipboard 
	 *
	 */
	
	@Test
	public void shouldHandleEmptyClipboard() {
		try {
			ClipboardUtils.clearClipboardContent();;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).isDataFlavorSupported(DataFlavor.stringFlavor));

	}
	
	@Test
	public void shouldHandleNonEmptyClipboard() {
		try {
			StringSelection selection = new StringSelection("string de teste");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
			ClipboardUtils.clearClipboardContent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertFalse(Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).isDataFlavorSupported(DataFlavor.stringFlavor));

	}
	
	/**
	 * getClipboardContent
	 * 
	 * clipboard vazia = clipboard n string | clipboard com string
	 *
	 */
	
	@Test
	public void shouldHandleEmptyOrNonStringClipboard() {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new EmptyClipboardContent(), new EmptyClipboardContent());
		String conteudo = ClipboardUtils.getClipboardContent();
		Assert.assertEquals(conteudo, null);

	}
	
	public void shouldHandleStringInClipboard() {
		StringSelection selection = new StringSelection("string de teste");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
        String conteudo = ClipboardUtils.getClipboardContent();
		Assert.assertEquals(conteudo, "string de teste");

	}
	
}
