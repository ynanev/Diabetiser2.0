package backingbeans;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Tsvetelin Tsonev <tsvetelin.tsonev@yahoo.co.uk>
 */
@ManagedBean
@RequestScoped
public class IndexBean {

    String translation;
    Properties props;

    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean() {

    }

    @PostConstruct
    public void init() {
        try {
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            InputStream is = ctx.getResourceAsStream("/WEB-INF/languages/en.properties");
            props = new Properties();
            props.load(is);
            translation = props.getProperty("test");
        } catch (IOException ex) {
            Logger.getLogger(IndexBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

}
