package backingbeans;

import java.io.InputStream;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import util.Properties;

/**
 *
 * @author Tsvetelin Tsonev <tsvetelin.tsonev@yahoo.co.uk>
 */
@ManagedBean
@RequestScoped
public class IndexBean {

    Properties translations;

    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean() {

    }

    @PostConstruct
    public void init() {
            ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            InputStream is = ctx.getResourceAsStream("/WEB-INF/languages/en.properties");
            translations = new Properties(is);
    }

    public Map<String, String> getTranslations() {
        return translations.getAllProperties();
    }

    public void setTranslations(Properties translation) {
        this.translations = translation;
    }

    
    
}
