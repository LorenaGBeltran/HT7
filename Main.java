/**
 * @author loren
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
//http://www.cs.williams.edu/JavaStructures/doc/structure5/structure5/Association.html
//https://stackoverflow.com/questions/52641366/how-to-make-an-object-of-association-comparable-by-only-one-generic-parameter-ty
public class Main{
	//E-Reference:
    // https://www.mkyong.com/java8/java-8-stream-read-a-file-line-by-line/
    //https://www.mkyong.com/java8/java-8-foreach-examples/
	
	public static String leerArchivo(String nombre) {
		File archivo = null;
		FileReader fr = null;
	    BufferedReader br = null;
	    String codigo = "";

	    try {
	    	// Apertura del fichero y creacion de BufferedReader para poder
	        // hacer una lectura comoda (disponer del metodo readLine()).
	        archivo = new File (nombre);
	        fr = new FileReader (archivo);
	        br = new BufferedReader(fr);

	        // Lectura del fichero
	        String linea;
	        while((linea=br.readLine())!=null) {
	        	codigo = codigo + linea + "0";
	        }
	        System.out.println(codigo);
	    }
	    
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    finally{
	    	// En el finally cerramos el fichero, para asegurarnos
	        // que se cierra tanto si todo va bien como si salta 
	        // una excepcion.
	    	try{                    
	    		if( null != fr ){   
	    			fr.close();     
	    		}                  
	    	}catch (Exception e2){
	    		e2.printStackTrace();
	    	}
	    }
		return codigo;
	}
    public static ArrayList<String> readDictionary() {
    	Scanner readLine = new Scanner(System.in);
		System.out.println("Ingrese la dirección en la que está el diccionario:");
		String respuesta= readLine.nextLine();
        String path = "./Dictionary.txt";
        ArrayList<String> words = new ArrayList<>();

        try (Stream<String> fileStream = Files.lines(Paths.get(path))) {
            fileStream.forEach(item -> {
                words.add(item.toUpperCase());
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    public static String readText() {
        String path = "./Text.txt";
        String words =  "";
        ArrayList<String> text = new ArrayList<>();

        try (Stream<String> fileStream = Files.lines(Paths.get(path))) {
            fileStream.forEach(item -> {
                text.add(item.toUpperCase());
            });


        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < text.size(); i++) {
            words += text.get(i) + " ";
        }
        return words;
    }

	public static void main(String[] args) {
		ArrayList<Association> dictionary = new ArrayList<Association>();
		String key=""; 
		String[] value;
		Scanner readLine = new Scanner(System.in);
		System.out.println("ingrese el nombre del archivo del diccionario");
		String archivo= readLine.nextLine(); 
		String codigo=leerArchivo(archivo);
		String[] cositas= codigo.split("0"); 
		ArrayList<String> words = new ArrayList<String>(); 
		for (String element: cositas) {
			words.add(element);
		}
		for(int i=0; i< words.size(); i++) {
			String tempword= words.get(i);
			tempword= tempword.replace("(", "");
			tempword= tempword.replace(")", "");
			tempword= tempword.replace(" ", "");
			value= tempword.split(",");
			for(String element: value) {
				
				 key=key+ element.toLowerCase();
			}
			dictionary.add(new Association(key,value ));
			key=""; 
		}
		BinarySearchTree bTree = new BinarySearchTree<>();
        for (int i = 0; i < dictionary.size(); i++) {
            bTree.add(dictionary.get(i));
        }
        ArrayList<Association<String, String[]>> inOrder = new ArrayList<Association<String, String[]>>();
        
        //=============In order traversing===============
        bTree.traverseInOrder(bTree.getRoot(),inOrder);
        for(Association<String, String[]> element: inOrder ) {
        	System.out.println(element.getValue()[0]+"-"+element.getValue()[1]+"-"+element.getValue()[2]);
        }
        //===============================================
        System.out.println("ingrese el nombre del archivo con lo que desea traducir: ");
        String archivo2= readLine.nextLine(); 
		String codigo2=leerArchivo(archivo2);
		String[] cositas2= codigo2.split("0"); 
		ArrayList<String> translate= new ArrayList<String>(); 
        System.out.println("Ingrese la opción que desee: ");
        System.out.println("1) Traducir a Francés ");
        System.out.println("2) Traducir a Inglés ");
        System.out.println("3) Traducir a Español ");
        String ans2= readLine.nextLine();
        boolean bool=true;
        for(String superelement: cositas2) {
        	String rep=""; 
        	String[] transword= superelement.split(" ");
	        while(bool) {
	        	int val=0; 
	        	boolean bool2= true; 
	        	switch(ans2) {
	        	case("1"):
	        		val=2;
	        		bool=false;
	        		bool2= true; 
	        		for (String element: transword) {
	        			for(Association<String, String[]> element2: dictionary) {
	        				if(element2.getKey().contains(element)) {
	        					rep= rep+" "+element2.getValue()[val]+" ";
	        					bool2=false;
	        					break; 
	        				}else {
	        					bool2=true;
	        				}
	        				
	        				
	        			}
	        			if(bool2) {
	    					rep= rep+" *"+element+"* ";
	    					
	    				}
	        		}
	        		System.out.println(rep); 
	        		break;
	        	case("2"):
	        		val=0; 
	        		bool=false;
	        		 bool2= true; 
	        		 for (String element: transword) {
		        			for(Association<String, String[]> element2: dictionary) {
		        				if(element2.getKey().contains(element)) {
		        					rep= rep+" "+element2.getValue()[val]+" ";
		        					bool2=false;
		        					break; 
		        				}else {
		        					bool2=true;
		        				}
		        				
		        				
		        			}
		        			if(bool2) {
		    					rep= rep+" *"+element+"* ";
		    					
		    				}
		        		}
		        		System.out.println(rep); 
	        		break;
	        	case("3"):
	        		val=1; 
	        		bool=false;
	        		 bool2= true; 
	        		 for (String element: transword) {
		        			for(Association<String, String[]> element2: dictionary) {
		        				if(element2.getKey().contains(element)) {
		        					rep= rep+" "+element2.getValue()[val]+" ";
		        					bool2=false;
		        					break; 
		        				}else {
		        					bool2=true;
		        				}
		        				
		        				
		        			}
		        			if(bool2) {
		    					rep= rep+" *"+element+"* ";
		    					
		    				}
		        		}
		        		System.out.println(rep); 
	        		break;
	        	default:
	        		bool=true; 
	        		System.out.println("Por favor ingrese una opción correcta (1, 2 o 3)");
	        	}
	        }
	        bool=true; 
        }
        
        
        
        readLine.close();
	}
	
	
}

