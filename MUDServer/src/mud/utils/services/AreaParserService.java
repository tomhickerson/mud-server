package mud.utils.services;

import mud.misc.Zone;
import mud.objects.Room;
import mud.utils.xml.AreaHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class AreaParserService {
    private Zone areaZone = null;

    public AreaParserService() {
        // instantiate here
    }

    public Zone parseXml(String fileName) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            AreaHandler handler = new AreaHandler();
            saxParser.parse(new File(fileName), handler);

            List<Room> areList = handler.getAreaList();
            areaZone = handler.getAreaZone();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        // this can return null, so watch out
        return areaZone;
    }


}
