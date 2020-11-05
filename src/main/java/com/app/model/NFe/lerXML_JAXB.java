package com.app.model.NFe;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.app.model.NFe.TNFe.InfNFe;
import com.app.model.NFe.TNFe.InfNFe.Ide;  

  
public class lerXML_JAXB {    
  
	public static List<TNFe> initNFE() {
		TNfeProc wNfe = TNfeProc();
		List<TNFe> ddd = new ArrayList<TNFe>();
		try {

			File f = new File("F:/worspace/Importados");
			File[] arquivos = f.listFiles(); // retorna um array de Files
			String[] nomes = f.list(); // retorna o nome dos arquivos em Strings
			int total = 1;
			int totalGeral = arquivos.length + 1;
			info("| Total registos........: " + totalGeral);
			for (File fs : arquivos) {
//    	  //enjoy't
				System.out.println();
				String xml = lerXML(fs.getAbsolutePath());
				wNfe = getNFe(xml);
				if (wNfe != null) {
					
					Ide ide = new Ide();
					ide.setCUF(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setCNF(wNfe.getNFe().getInfNFe().getIde().getCNF());
		            ide.setNatOp(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setMod(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setSerie(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setNNF(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setDhEmi(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setDhSaiEnt(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setTpNF(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setIdDest(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setCMunFG(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setTpImp(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setTpEmis(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setCDV(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setTpAmb(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setFinNFe(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setIndFinal(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setIndPres(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setProcEmi(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setVerProc(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setDhCont(wNfe.getNFe().getInfNFe().getIde().getCUF());
		            ide.setXJust(wNfe.getNFe().getInfNFe().getIde().getCUF());
					InfNFe info = new InfNFe();
					info.setIde(ide);
					TNFe nota = new TNFe();
					//nota.setHjid(Integer.parseInt(wNfe.getNFe().getInfNFe().getIde().getNNF()));
					nota.setInfNFe(info);
					info("| Destinatario[CNPJ]........: " + wNfe.getNFe().getInfNFe().getDest().getCNPJ());
					info("| Destinatario[CNPJ]........: " + wNfe.getNFe().getInfNFe().getDest().getCNPJ());
					info("| Destinatario[Nome]........: " + wNfe.getNFe().getInfNFe().getDest().getXNome());
					info("| Emitente[CNPJ]............: " + wNfe.getNFe().getInfNFe().getEmit().getCNPJ());
					info("| Emitente[Nome]............: " + wNfe.getNFe().getInfNFe().getEmit().getXNome());

					System.out.println(wNfe.getNFe().getInfNFe().getDet().size());
					for (int i = 0; i < wNfe.getNFe().getInfNFe().getDet().size(); i++) {
						info("| Item[Nome]............: "
								+ wNfe.getNFe().getInfNFe().getDet().get(i).getProd().getXProd());
					}
					ddd.add(nota);
					
					info("| Importando Registros............: " + total+"/" +totalGeral);
					total++;
				}
			}

//          String xml = lerXML("C:/31181003316661000119550020006011071006655250.xml");  
//          TNfeProc wNfe = getNFe(xml);  
//          if (wNfe != null) {    
//              info("| Destinatario[CNPJ]........: " + wNfe.getNFe().getInfNFe().getDest().getCNPJ());    
//              info("| Destinatario[Nome]........: " + wNfe.getNFe().getInfNFe().getDest().getXNome());  
//              info("| Emitente[CNPJ]............: " + wNfe.getNFe().getInfNFe().getEmit().getCNPJ());    
//              info("| Emitente[Nome]............: " + wNfe.getNFe().getInfNFe().getEmit().getXNome());  
//                
//              System.out.println(wNfe.getNFe().getInfNFe().getDet().size());  
//              for(int i=0; i < wNfe.getNFe().getInfNFe().getDet().size(); i++){  
//                  info("| Item[Nome]............: " + wNfe.getNFe().getInfNFe().getDet().get(i).getProd().getXProd());      
//              }  
//                    
//          }  

		} catch (Exception e) {
			error(e.toString());
		}
		return ddd;
	}    
      
    
  private static TNfeProc TNfeProc() {
		// TODO Auto-generated method stub
		return null;
	}


@SuppressWarnings("unchecked")    
  public static TNfeProc getNFe(String xml) throws Exception{        
      try {        
          JAXBContext context = JAXBContext.newInstance(TNfeProc.class);        
          Unmarshaller unmarshaller = context.createUnmarshaller();        
          TNfeProc nfe = unmarshaller.unmarshal(new StreamSource(new StringReader(xml)), TNfeProc.class).getValue();        
          return nfe;  
      } catch (JAXBException ex) {        
          throw new Exception(ex.toString());        
      }        
  }        
    
  private static String lerXML(String fileXML) throws IOException {    
      String linha = "";    
      StringBuilder xml = new StringBuilder();    
  
      BufferedReader in = new BufferedReader(new InputStreamReader(    
              new FileInputStream(fileXML)));    
      while ((linha = in.readLine()) != null) {    
          xml.append(linha);    
      }    
      in.close();    
  
      return xml.toString();    
  }    
  

  
  private static void info(String log) {    
      System.out.println("INFO: " + log);    
  }    
  
  private static void error(String log) {    
      System.out.println("ERROR: " + log);    
  }    
      
}
