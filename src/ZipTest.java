/**
   @version 1.30 17 Aug 1998
   @author Cay Horstmann
*/

 import java.awt.*;
 import java.awt.event.*;
 import java.io.*;
 import java.util.*;
 import java.util.zip.*;
 import javax.swing.*;
 import javax.swing.filechooser.FileFilter;
 
 public class ZipTest
 {  
    public static void main(String[] args)
    {  
       RamkaZipTest ramka = new RamkaZipTest();
       ramka.setTitle("ZipTest");
       ramka.setSize(300, 400);
       ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ramka.show();
    }
 }
 
 /**
    Ramka, zawieraj¹ca: obszar tekstowy (wyœwietlaj¹cy zawartoœæ pliku),
    listê kombinowan¹, (pozwalaj¹c¹ na wybór plików w tym archiwum),
    oraz menu (pozwalaj¹ce wczytaæ nowe archiwum).
 */
 class RamkaZipTest extends JFrame
 {
    public RamkaZipTest()
    {
       // do³¹cz menu i dodaj do niego elementy Otwórz i Zamknij
       JMenuBar pasekMenu = new JMenuBar();
       JMenu menu = new JMenu("Plik");
 
       JMenuItem elemOtworz = new JMenuItem("Otwórz");
       menu.add(elemOtworz);
       elemOtworz.addActionListener(new Otwarcie());
 
       JMenuItem elemZamknij = new JMenuItem("Zamknij");
       menu.add(elemZamknij);
       elemZamknij.addActionListener(new 
          ActionListener()
          {
             public void actionPerformed(ActionEvent zdarzenie)
             {
                System.exit(0);
             }
          });
 
      pasekMenu.add(menu);
      setJMenuBar(pasekMenu);
 
      // do³¹cz obszar tekstowy i listê kombinowan¹
      tekstPliku = new JTextArea();
      listaPlikow = new JComboBox();
      listaPlikow.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent zdarzenie)
            {
               ladujZip((String)listaPlikow.getSelectedItem());
            }
         });

      Container powZawartosci = getContentPane();
      powZawartosci.add(listaPlikow, BorderLayout.SOUTH);
      powZawartosci.add(tekstPliku, BorderLayout.CENTER);
   }

   /**
      Klasa s³uchacza, dla elementu Plik/Otwórz
   */
   private class Otwarcie implements ActionListener
   {
      public void actionPerformed(ActionEvent zd)
      {
         // zapytaj u¿ytkownika o plik zip
         JFileChooser wybor = new JFileChooser();
         wybor.setCurrentDirectory(new File("."));
         FiltrRozszerzenia filtr = new FiltrRozszerzenia();
         filtr.dodajRozszerzenie(".zip");
         filtr.dodajRozszerzenie(".jar");
         filtr.zmienOpis("Archiwa ZIP");
         wybor.setFileFilter(filtr);
         int r = wybor.showOpenDialog(RamkaZipTest.this);
         if (r == JFileChooser.APPROVE_OPTION)
         {  
            nazwazip = wybor.getSelectedFile().getPath();
            przegladajZip();
         }  
      }
   }

   /**
      Przegl¹da zawartoœæ archiwum ZIP i zape³nia
      listê kombinowan¹.
   */
   public void przegladajZip()
   {  
       listaPlikow.removeAllItems();
       try
       {  
          ZipInputStream zwe = new ZipInputStream(new
             FileInputStream(nazwazip));
          ZipEntry komorka;
          while ((komorka = zwe.getNextEntry()) != null)
          {  
             listaPlikow.addItem(komorka.getName());
             zwe.closeEntry();
          }
          zwe.close();
       }
       catch (IOException w)
       {  
          w.printStackTrace(); 
       }
   }
 
    /**
       £aduje plik z archiwum do obszaru tekstowego
       @param nazwa nazwa pliku w archiwum
    */
    public void ladujZip(String nazwa)
    {  
       try
       {  
          ZipInputStream zwe = new ZipInputStream(new
             FileInputStream(nazwazip));
          ZipEntry komorka;
          tekstPliku.setText("");

          // znajdŸ komórkê archiwum o odpowiedniej nazwie
          while ((komorka = zwe.getNextEntry()) != null)
          {  
             if (komorka.getName().equals(nazwa))
             {  
                // wczytaj komórkê do obszaru tekstowego
                BufferedReader we = new BufferedReader(new
                   InputStreamReader(zwe));
                String linia;
                while ((linia = we.readLine()) != null)
                {
                   tekstPliku.append(linia);
                   tekstPliku.append("\n");
                }
             }
             zwe.closeEntry();
          }
          zwe.close();
       }
       catch (IOException w)
       {  
          w.printStackTrace(); 
       }
    }
 
    private JComboBox listaPlikow;
    private JTextArea tekstPliku;
    private String nazwazip;
 }
 
 /**
    Filtr, porównuj¹cy pliki z podanym zbiorem rozszerzeñ
    Tego samego u¿yliœmy w programie TestOknaPliku w rozdziale 9.
 */
 class FiltrRozszerzenia extends FileFilter
 {
    /**
       Dodaje rozszerzenie, od tej chwili bêdzie rozpoznawane przez filtr plików
       @param rozszerzenie rozszerzenie pliku (np. ".txt", lub "txt")
    */
    public void dodajRozszerzenie(String rozszerzenie)
    {
       if (!rozszerzenie.startsWith("."))
          rozszerzenie = "." + rozszerzenie;
       rozszerzenia.add(rozszerzenie.toLowerCase());     
    }
 
    /**
       Tworzy opis dla plików, rozpoznawanych przez dany 
       filtr plików.
       @param aOpis opis plików, rozpoznawanych przez filtr
    */
    public void zmienOpis(String aOpis)
    {
       opis = aOpis;
    }

    /**
       Zwraca opis plików, rozpoznawanych przez dany 
       filtr plików.
       @return opis plików, rozpoznawanych przez filtr
    */
    public String getDescription()
    {
       return opis; 
    }
 
    public boolean accept(File p)
    {
       if (p.isDirectory()) return true;
       String nazwa = p.getName().toLowerCase();

       // sprawdza, czy nazwa pliku koñczy siê którymœ z podanych rozszerzeñ
       for (int i = 0; i < rozszerzenia.size(); i++)
          if (nazwa.endsWith((String)rozszerzenia.get(i))) 
             return true;
       return false;
    }
    
    private String opis = "";
    private ArrayList rozszerzenia = new ArrayList();
 }
