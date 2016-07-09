package util;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tsvetelin Tsonev <tsvetelin.tsonev@yahoo.co.uk>
 */
public class Properties {

    private Map<String, String> map;

    public Properties(String filePath) {
        map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            mapFile(br, map);
        } catch (FileNotFoundException ex) {
//            Logger logger = LogManager.getLogger(Properties.class.getName());
//            logger.log(Level.ERROR, ex.getMessage());
        } catch (IOException ex) {
//            Logger logger = LogManager.getLogger(Properties.class.getName());
//            logger.log(Level.ERROR, ex.getMessage());
        }
    }

    public Properties(InputStream is) {
        map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            mapFile(br, map);
        } catch (FileNotFoundException ex) {
//            Logger logger = LogManager.getLogger(Properties.class.getName());
//            logger.log(Level.ERROR, ex.getMessage());
        } catch (IOException ex) {
//            Logger logger = LogManager.getLogger(Properties.class.getName());
//            logger.log(Level.ERROR, ex.getMessage());
        }
    }
    
    public String get(String property) {
        return map.get(property);
    }

    public Map<String, String> getAllProperties() {
        return map;
    }

    private void mapFile(BufferedReader br, Map<String, String> map) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String s[] = line.split("=");
            map.put(s[0].trim(), s[1].trim());
        }
    }
}
