import java.io.File;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;

import org.apache.lucene.index.IndexWriter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class Main {

    public static void main(String[] args) {
        String file = "C:\\IRCrawler'\\filestoIndex\\will_play_text.xml";
        File f = new File(file);
        try {
            Directory directory = new RAMDirectory();
            Analyzer analyzer = new SimpleAnalyzer();
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
            iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);
            NodeList nList = doc.getElementsByTagName("table");
            for (int temp = 0; temp<nList.getLength();temp++) {
                Element element = (Element) nList;
                Node nodeList = nList.item(temp).getAttributes("bill");
                System.out.println(nodeList);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
