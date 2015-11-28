package sk.cassomedia.eldermonitor.datastoring;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import sk.cassomedia.eldermonitor.datastoring.task.AlertTime;
import sk.cassomedia.eldermonitor.datastoring.task.Task;

/**
 * Created by tomas on 11/28/2015.
 */
public class XMLParser {
    private File xmlFile;
    private ArrayList<Task> tasks;


    public XMLParser(String path, ArrayList<Task> tasks) throws IOException, ParserConfigurationException, TransformerException {
        this.tasks = tasks;
        if (!xmlFile.exists()) {
            xmlFile.createNewFile();
        }
        createXML();
        //editXML();
    }

    private void createXML() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc;
        Element rootElement;

        doc = docBuilder.newDocument();
        rootElement = doc.createElement("timetable");
        doc.appendChild(rootElement);

        int id = 1;
        for (Task currentTask : tasks) {

            //task element
            Element taskElement = doc.createElement("task");
            taskElement.setAttribute("id", String.valueOf(id));
            rootElement.appendChild(taskElement);

            //category element
            Element categoryElement = doc.createElement("cat");
            categoryElement.appendChild(doc.createTextNode(String.valueOf(currentTask.getCategory())));
            taskElement.appendChild(categoryElement);

            //day element
            String dayString = "";
            Element dayElement = doc.createElement("day");
            StringBuilder builder = new StringBuilder();
            for (int i : currentTask.getDays()) {
                builder.append(i);
            }
            dayElement.appendChild(doc.createTextNode(builder.toString()));
            taskElement.appendChild(dayElement);

            //time element
            Element timeElement = doc.createElement("time");
            taskElement.appendChild(timeElement);
            for (AlertTime alertTime : currentTask.getTimes()) {
                builder = new StringBuilder();
                Element alertElement = doc.createElement("alert");
                builder.append(alertTime.getHour());
                builder.append("|");
                builder.append(alertTime.getMinutes());
                alertElement.appendChild(doc.createTextNode(builder.toString()));
                timeElement.appendChild(alertElement);
            }

            //termination element
            Element termElement = doc.createElement("term");
            taskElement.appendChild(termElement);
            if (currentTask.getTermination() == null) {
                termElement.appendChild(doc.createTextNode("none"));
            } else {
                //date
                Element terDateElement = doc.createElement("date");
                builder = new StringBuilder();
                builder.append(String.valueOf(currentTask.getTermination().getDay()));
                builder.append("|");
                builder.append(String.valueOf(currentTask.getTermination().getMonth()));
                builder.append("|");
                builder.append(String.valueOf(currentTask.getTermination().getYear()));
                terDateElement.appendChild(doc.createTextNode(builder.toString()));
                termElement.appendChild(terDateElement);

                //time
                Element terTimeElement = doc.createElement("time");
                builder = new StringBuilder();
                builder.append(String.valueOf(currentTask.getTermination().getHour()));
                builder.append("|");
                builder.append(String.valueOf(currentTask.getTermination().getMinutes()));
                terTimeElement.appendChild(doc.createTextNode(builder.toString()));
                termElement.appendChild(terTimeElement);
            }

            id++;
        }

        //writing in the file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(xmlFile);
        transformer.transform(source, result);
    }
}