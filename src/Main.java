import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;


public class Main {

    public static void main(String[] args) {
        String file = "/Users/anandmeherkotra/IdeaProjects/Information_Retreival/filestoIndex/will_play_text.xml";
        File f = new File(file);
        System.out.println(f.canRead());
        try {
            Directory directory = new RAMDirectory();
            Analyzer analyzer = new SimpleAnalyzer();
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
            iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            IndexWriter writer = new IndexWriter(directory,iwc);
            // create DOM parser
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//database/table"; // Enter the base tag and the child which you would like to parse

            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
            System.out.println(nodeList.item(45));
            System.out.println("--------------------------------------");

            for (int temp = 0; temp<nodeList.getLength();temp++) {
                Node node = nodeList.item(temp);


                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
